/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2011 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.clientapi.core;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.zaproxy.clientapi.gen.AccessControl;
import org.zaproxy.clientapi.gen.Acsrf;
import org.zaproxy.clientapi.gen.AjaxSpider;
import org.zaproxy.clientapi.gen.AlertFilter;
import org.zaproxy.clientapi.gen.Ascan;
import org.zaproxy.clientapi.gen.Authentication;
import org.zaproxy.clientapi.gen.Authorization;
import org.zaproxy.clientapi.gen.Automation;
import org.zaproxy.clientapi.gen.Autoupdate;
import org.zaproxy.clientapi.gen.Break;
import org.zaproxy.clientapi.gen.Context;
import org.zaproxy.clientapi.gen.Core;
import org.zaproxy.clientapi.gen.Exportreport;
import org.zaproxy.clientapi.gen.ForcedUser;
import org.zaproxy.clientapi.gen.HttpSessions;
import org.zaproxy.clientapi.gen.ImportLogFiles;
import org.zaproxy.clientapi.gen.Importurls;
import org.zaproxy.clientapi.gen.LocalProxies;
import org.zaproxy.clientapi.gen.Openapi;
import org.zaproxy.clientapi.gen.Params;
import org.zaproxy.clientapi.gen.Pnh;
import org.zaproxy.clientapi.gen.Pscan;
import org.zaproxy.clientapi.gen.Replacer;
import org.zaproxy.clientapi.gen.Reports;
import org.zaproxy.clientapi.gen.Retest;
import org.zaproxy.clientapi.gen.Reveal;
import org.zaproxy.clientapi.gen.Revisit;
import org.zaproxy.clientapi.gen.RuleConfig;
import org.zaproxy.clientapi.gen.Script;
import org.zaproxy.clientapi.gen.Search;
import org.zaproxy.clientapi.gen.Selenium;
import org.zaproxy.clientapi.gen.SessionManagement;
import org.zaproxy.clientapi.gen.Soap;
import org.zaproxy.clientapi.gen.Spider;
import org.zaproxy.clientapi.gen.Stats;
import org.zaproxy.clientapi.gen.Users;
import org.zaproxy.clientapi.gen.Wappalyzer;
import org.zaproxy.clientapi.gen.Websocket;

public class ClientApi {

    private static final int DEFAULT_CONNECTION_POOLING_IN_MS = 1000;

    private static final String ZAP_API_KEY_HEADER = "X-ZAP-API-Key";
    private static final String ZAP_API_KEY_PARAM = "apikey";

    private Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8090));
    private boolean debug = false;
    private PrintStream debugStream = System.out;

    private final String zapAddress;
    private final int zapPort;

    private final String apiKey;

    private DocumentBuilderFactory docBuilderFactory;

    // Note that any new API implementations added have to be added here manually
    public AccessControl accessControl = new AccessControl(this);
    public Acsrf acsrf = new Acsrf(this);
    public AjaxSpider ajaxSpider = new AjaxSpider(this);
    public AlertFilter alertFilter = new AlertFilter(this);
    public org.zaproxy.clientapi.gen.Alert alert = new org.zaproxy.clientapi.gen.Alert(this);
    public Ascan ascan = new Ascan(this);
    public Authentication authentication = new Authentication(this);
    public Authorization authorization = new Authorization(this);
    public Automation automation = new Automation(this);
    public Autoupdate autoupdate = new Autoupdate(this);
    public Break brk = new Break(this);
    public Context context = new Context(this);
    public Core core = new Core(this);
    public Exportreport exportreport = new Exportreport(this);
    public ForcedUser forcedUser = new ForcedUser(this);
    public HttpSessions httpSessions = new HttpSessions(this);
    public ImportLogFiles logImportFiles = new ImportLogFiles(this);
    public Importurls importurls = new Importurls(this);
    public LocalProxies localProxies = new LocalProxies(this);
    public Openapi openapi = new Openapi(this);
    public Params params = new Params(this);
    public Pnh pnh = new Pnh(this);
    public Pscan pscan = new Pscan(this);
    public Replacer replacer = new Replacer(this);
    public Reports reports = new Reports(this);
    public Retest retest = new Retest(this);
    public Reveal reveal = new Reveal(this);
    public Revisit revisit = new Revisit(this);
    public RuleConfig ruleConfig = new RuleConfig(this);
    public Search search = new Search(this);
    public Script script = new Script(this);
    public Selenium selenium = new Selenium(this);
    public SessionManagement sessionManagement = new SessionManagement(this);
    public Soap soap = new Soap(this);
    public Spider spider = new Spider(this);
    public Stats stats = new Stats(this);
    public Users users = new Users(this);
    public Wappalyzer wappalyzer = new Wappalyzer(this);
    public Websocket websocket = new Websocket(this);

    public ClientApi(String zapAddress, int zapPort) {
        this(zapAddress, zapPort, false);
    }

    /**
     * Constructs a {@code ClientApi} with the given ZAP address/port and with the given API key, to
     * be sent with all API requests.
     *
     * @param zapAddress ZAP's address
     * @param zapPort ZAP's listening port
     * @param apiKey the ZAP API key, might be {@code null} or empty in which case is not used/sent.
     * @since 1.1.0
     */
    public ClientApi(String zapAddress, int zapPort, String apiKey) {
        this(zapAddress, zapPort, apiKey, false);
    }

    public ClientApi(String zapAddress, int zapPort, boolean debug) {
        this(zapAddress, zapPort, null, debug);
    }

    /**
     * Constructs a {@code ClientApi} with the given ZAP address/port and with the given API key, to
     * be sent with all API requests. Also, sets whether or not client API debug information should
     * be written to the {@link #setDebugStream(PrintStream) debug stream} (by default the standard
     * output stream).
     *
     * @param zapAddress ZAP's address
     * @param zapPort ZAP's listening port
     * @param apiKey the ZAP API key, might be {@code null} or empty in which case is not used/sent.
     * @param debug {@code true} if debug information should be written to debug stream, {@code
     *     false} otherwise.
     * @since 1.1.0
     */
    public ClientApi(String zapAddress, int zapPort, String apiKey, boolean debug) {
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(zapAddress, zapPort));
        this.debug = debug;
        this.zapAddress = zapAddress;
        this.zapPort = zapPort;
        this.apiKey = apiKey;
    }

    public void setDebugStream(PrintStream debugStream) {
        this.debugStream = debugStream;
    }

    public void accessUrl(String url) throws ClientApiException {
        accessUrlViaProxy(proxy, url);
    }

    private int statusToInt(ApiResponse response) {
        return Integer.parseInt(((ApiResponseElement) response).getValue());
    }

    public void checkAlerts(List<Alert> ignoreAlerts, List<Alert> requireAlerts)
            throws ClientApiException {
        HashMap<String, List<Alert>> results = checkForAlerts(ignoreAlerts, requireAlerts);
        verifyAlerts(results.get("requireAlerts"), results.get("reportAlerts"));
    }

    private void verifyAlerts(List<Alert> requireAlerts, List<Alert> reportAlerts)
            throws ClientApiException {
        StringBuilder sb = new StringBuilder();
        if (reportAlerts.size() > 0) {
            sb.append("Found ").append(reportAlerts.size()).append(" alerts\n");
            for (Alert alert : reportAlerts) {
                sb.append('\t');
                sb.append(alert.toString());
                sb.append('\n');
            }
        }
        if (requireAlerts != null && requireAlerts.size() > 0) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Not found ").append(requireAlerts.size()).append(" alerts\n");
            for (Alert alert : requireAlerts) {
                sb.append('\t');
                sb.append(alert.toString());
                sb.append('\n');
            }
        }
        if (sb.length() > 0) {
            if (debug) {
                debugStream.println("Failed: " + sb.toString());
            }
            throw new ClientApiException(sb.toString());
        }
    }

    public void checkAlerts(List<Alert> ignoreAlerts, List<Alert> requireAlerts, File outputFile)
            throws ClientApiException {
        HashMap<String, List<Alert>> results = checkForAlerts(ignoreAlerts, requireAlerts);
        int alertsFound = results.get("reportAlerts").size();
        int alertsNotFound = results.get("requireAlerts").size();
        int alertsIgnored = results.get("ignoredAlerts").size();
        String resultsString =
                String.format(
                        "Alerts Found: %d, Alerts required but not found: %d, Alerts ignored: %d",
                        alertsFound, alertsNotFound, alertsIgnored);
        try {
            AlertsFile.saveAlertsToFile(
                    results.get("requireAlerts"),
                    results.get("reportAlerts"),
                    results.get("ignoredAlerts"),
                    outputFile);
        } catch (Exception e) {
            throw new ClientApiException("Failed to save the alerts:", e);
        }
        if (alertsFound > 0 || alertsNotFound > 0) {
            throw new ClientApiException("Check Alerts Failed!\n" + resultsString);
        } else {
            if (debug) {
                debugStream.println("Check Alerts Passed!\n" + resultsString);
            }
        }
    }

    public List<Alert> getAlerts(String baseUrl, int start, int count) throws ClientApiException {
        List<Alert> alerts = new ArrayList<Alert>();
        ApiResponse response =
                alert.alerts(baseUrl, String.valueOf(start), String.valueOf(count), null);
        if (response != null && response instanceof ApiResponseList) {
            ApiResponseList alertList = (ApiResponseList) response;
            for (ApiResponse resp : alertList.getItems()) {
                alerts.add(new Alert((ApiResponseSet) resp));
            }
        }
        return alerts;
    }

    private HashMap<String, List<Alert>> checkForAlerts(
            List<Alert> ignoreAlerts, List<Alert> requireAlerts) throws ClientApiException {
        List<Alert> reportAlerts = new ArrayList<>();
        List<Alert> ignoredAlerts = new ArrayList<>();
        List<Alert> alerts = getAlerts(null, -1, -1);
        for (Alert alert : alerts) {
            boolean ignore = false;
            if (ignoreAlerts != null) {
                for (Alert ignoreAlert : ignoreAlerts) {
                    if (alert.matches(ignoreAlert)) {
                        if (debug) {
                            debugStream.println("Ignoring alert " + ignoreAlert);
                        }
                        ignoredAlerts.add(alert);
                        ignore = true;
                        break;
                    }
                }
            }
            if (!ignore) {
                reportAlerts.add(alert);
            }
            if (requireAlerts != null) {
                for (Alert requireAlert : requireAlerts) {
                    if (alert.matches(requireAlert)) {
                        if (debug) {
                            debugStream.println("Found alert " + alert);
                        }
                        requireAlerts.remove(requireAlert);
                        // Remove it from the not-ignored list as well
                        reportAlerts.remove(alert);
                        break;
                    }
                }
            }
        }
        HashMap<String, List<Alert>> results = new HashMap<>();
        results.put("reportAlerts", reportAlerts);
        results.put("requireAlerts", requireAlerts);
        results.put("ignoredAlerts", ignoredAlerts);
        return results;
    }

    private void accessUrlViaProxy(Proxy proxy, String apiurl) throws ClientApiException {
        try {
            URL url = new URL(apiurl);
            if (debug) {
                debugStream.println("Open URL: " + apiurl);
            }
            HttpURLConnection uc = (HttpURLConnection) url.openConnection(proxy);
            uc.connect();

            try (BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8))) {
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    if (debug) {
                        debugStream.println(inputLine);
                    }
                }

            } catch (IOException e) {
                // Ignore
                if (debug) {
                    debugStream.println("Ignoring exception " + e);
                }
            }
        } catch (Exception e) {
            throw new ClientApiException(e);
        }
    }

    public ApiResponse callApi(
            String component, String type, String method, Map<String, String> params)
            throws ClientApiException {
        Document dom = this.callApiDom(component, type, method, params);
        return ApiResponseFactory.getResponse(dom.getFirstChild());
    }

    private Document callApiDom(
            String component, String type, String method, Map<String, String> params)
            throws ClientApiException {
        try {
            HttpRequest request = buildZapRequest("xml", component, type, method, params);
            if (debug) {
                debugStream.println("Open URL: " + request.getRequestUri());
            }
            DocumentBuilder db = getDocumentBuilderFactory().newDocumentBuilder();
            // parse using builder to get DOM representation of the XML file
            return db.parse(getConnectionInputStream(request));
        } catch (Exception e) {
            throw new ClientApiException(e);
        }
    }

    /**
     * Gets the {@code DocumentBuilderFactory} instance with XML External Entity (XXE) processing
     * disabled.
     *
     * @return the {@code DocumentBuilderFactory} instance with XXE processing disabled.
     * @throws ParserConfigurationException if an error occurred while disabling XXE processing.
     * @see DocumentBuilderFactory
     */
    private DocumentBuilderFactory getDocumentBuilderFactory() throws ParserConfigurationException {
        if (docBuilderFactory == null) {
            // Disable XXE processing, not required by default.
            // https://www.owasp.org/index.php/XML_External_Entity_%28XXE%29_Processing
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setExpandEntityReferences(false);
            docBuilderFactory = factory;
        }
        return docBuilderFactory;
    }

    private InputStream getConnectionInputStream(HttpRequest request) throws IOException {
        HttpURLConnection uc = (HttpURLConnection) request.getRequestUri().openConnection(proxy);
        uc.setUseCaches(false);
        for (Entry<String, String> header : request.getHeaders().entrySet()) {
            uc.setRequestProperty(header.getKey(), header.getValue());
        }
        uc.connect();
        if (uc.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            return uc.getErrorStream();
        }
        return uc.getInputStream();
    }

    public byte[] callApiOther(
            String component, String type, String method, Map<String, String> params)
            throws ClientApiException {
        try {
            HttpRequest request = buildZapRequest("other", component, type, method, params);
            if (debug) {
                debugStream.println("Open URL: " + request.getRequestUri());
            }
            InputStream in = getConnectionInputStream(request);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[8 * 1024];
            try {
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } finally {
                out.close();
                in.close();
            }
            return out.toByteArray();

        } catch (Exception e) {
            throw new ClientApiException(e);
        }
    }

    /**
     * Builds a request for the ZAP API with the given data.
     *
     * <p>As the API client proxies through ZAP the built API requests use a specific domain, {@code
     * zap}, to ensure that they are always handled by ZAP (and not forward).
     *
     * @param format the desired format of the API response (e.g. XML, JSON, other).
     * @param component the API component (e.g. core, spider).
     * @param type the type of the API endpoint (e.g. action, view).
     * @param method the name of the endpoint.
     * @param params the parameters for the endpoint.
     * @return the API request.
     * @throws MalformedURLException if an error occurred while building the URL.
     */
    private HttpRequest buildZapRequest(
            String format, String component, String type, String method, Map<String, String> params)
            throws MalformedURLException {
        StringBuilder sb = new StringBuilder();
        sb.append("http://zap/");
        sb.append(format);
        sb.append('/');
        sb.append(component);
        sb.append('/');
        sb.append(type);
        sb.append('/');
        sb.append(method);
        sb.append('/');
        if (params != null) {
            if (apiKey != null && !apiKey.isEmpty()) {
                params.put(ZAP_API_KEY_PARAM, apiKey);
            }

            sb.append('?');
            for (Map.Entry<String, String> p : params.entrySet()) {
                sb.append(encodeQueryParam(p.getKey()));
                sb.append('=');
                if (p.getValue() != null) {
                    sb.append(encodeQueryParam(p.getValue()));
                }
                sb.append('&');
            }
        } else if (apiKey != null && !apiKey.isEmpty()) {
            // Send the API key even if there are no parameters,
            // older ZAP versions might need it as (query) parameter.
            sb.append('?');
            sb.append(encodeQueryParam(ZAP_API_KEY_PARAM));
            sb.append('=');
            sb.append(encodeQueryParam(apiKey));
        }

        HttpRequest request = new HttpRequest(new URL(sb.toString()));
        if (apiKey != null && !apiKey.isEmpty()) {
            request.addHeader(ZAP_API_KEY_HEADER, apiKey);
        }
        return request;
    }

    private static String encodeQueryParam(String param) {
        try {
            return URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException ignore) {
            // UTF-8 is a standard charset.
        }
        return param;
    }

    /**
     * Adds the given regular expression to the exclusion list of the given context.
     *
     * @param apiKey the API key, might be {@code null}.
     * @param contextName the name of the context.
     * @param regex the regular expression to add.
     * @throws Exception if an error occurred while calling the API.
     * @deprecated (1.1.0) Use {@link Context#excludeFromContext(String, String)} instead.
     * @see #context
     */
    @Deprecated
    public void addExcludeFromContext(String apiKey, String contextName, String regex)
            throws Exception {
        context.excludeFromContext(apiKey, contextName, regex);
    }

    /**
     * Adds the given regular expression to the inclusion list of the given context.
     *
     * @param apiKey the API key, might be {@code null}.
     * @param contextName the name of the context.
     * @param regex the regular expression to add.
     * @throws Exception if an error occurred while calling the API.
     * @deprecated (1.1.0) Use {@link Context#includeInContext(String, String)} instead.
     * @see #context
     */
    @Deprecated
    public void addIncludeInContext(String apiKey, String contextName, String regex)
            throws Exception {
        context.includeInContext(apiKey, contextName, regex);
    }

    /**
     * Includes just one of the nodes that match the given regular expression in the context with
     * the given name.
     *
     * <p>Nodes that do not match the regular expression are excluded.
     *
     * @param apiKey the API key, might be {@code null}.
     * @param contextName the name of the context.
     * @param regex the regular expression to match the node/URL.
     * @throws Exception if an error occurred while calling the API.
     * @deprecated (1.1.0) Use {@link #includeOneMatchingNodeInContext(String, String)} instead.
     */
    @Deprecated
    public void includeOneMatchingNodeInContext(String apiKey, String contextName, String regex)
            throws Exception {
        List<String> sessionUrls = getSessionUrls();
        boolean foundOneMatch = false;
        for (String sessionUrl : sessionUrls) {
            if (sessionUrl.matches(regex)) {
                if (foundOneMatch) {
                    addExcludeFromContext(apiKey, contextName, sessionUrl);
                } else {
                    foundOneMatch = true;
                }
            }
        }
        if (!foundOneMatch) {
            throw new Exception(
                    "Unexpected result: No url found in site tree matching regex " + regex);
        }
    }

    /**
     * Includes just one of the nodes that match the given regular expression in the context with
     * the given name.
     *
     * <p>Nodes that do not match the regular expression are excluded.
     *
     * @param contextName the name of the context.
     * @param regex the regular expression to match the node/URL.
     * @throws Exception if an error occurred while calling the API.
     */
    public void includeOneMatchingNodeInContext(String contextName, String regex) throws Exception {
        List<String> sessionUrls = getSessionUrls();
        boolean foundOneMatch = false;
        for (String sessionUrl : sessionUrls) {
            if (sessionUrl.matches(regex)) {
                if (foundOneMatch) {
                    context.excludeFromContext(contextName, regex);
                } else {
                    foundOneMatch = true;
                }
            }
        }
        if (!foundOneMatch) {
            throw new Exception(
                    "Unexpected result: No url found in site tree matching regex " + regex);
        }
    }

    private List<String> getSessionUrls() throws Exception {
        List<String> sessionUrls = new ArrayList<>();
        ApiResponse response = core.urls();
        if (response != null && response instanceof ApiResponseList) {
            ApiResponseElement urlList =
                    (ApiResponseElement) ((ApiResponseList) response).getItems().get(0);
            for (ApiResponse element : ((ApiResponseList) response).getItems()) {
                URL url = new URL(((ApiResponseElement) element).getValue());
                sessionUrls.add(url.getProtocol() + "://" + url.getHost() + url.getPath());
            }
            System.out.println(urlList);
        }
        return sessionUrls;
    }

    /**
     * Active scans the given site, that's in scope.
     *
     * <p>The method returns only after the scan has finished.
     *
     * @param apiKey the API key, might be {@code null}.
     * @param url the site to scan
     * @throws Exception if an error occurred while calling the API.
     * @deprecated (1.1.0) Use {@link #activeScanSiteInScope(String)} instead, the API key should be
     *     set using one of the {@code ClientApi} constructors.
     */
    @Deprecated
    public void activeScanSiteInScope(String apiKey, String url) throws Exception {
        ascan.scan(apiKey, url, "true", "true", "", "", "");
        waitForAScanToFinish(url);
    }

    /**
     * Active scans the given site, that's in scope.
     *
     * <p>The method returns only after the scan has finished.
     *
     * @param url the site to scan
     * @throws Exception if an error occurred while calling the API.
     * @since 1.1.0
     */
    public void activeScanSiteInScope(String url) throws Exception {
        ascan.scan(url, "true", "true", "", "", "");
        waitForAScanToFinish(url);
    }

    private void waitForAScanToFinish(String targetUrl) throws ClientApiException {
        // Poll until spider finished
        int status = 0;
        while (status < 100) {
            status = statusToInt(ascan.status(""));
            if (debug) {
                String format = "Scanning %s Progress: %d%%";
                System.out.println(String.format(format, targetUrl, status));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Ignore
            }
        }
    }

    /**
     * Convenience method to wait for ZAP to be ready to receive API calls, when started
     * programmatically.
     *
     * <p>It attempts to establish a connection to ZAP's proxy, in the given time, throwing an
     * exception if the connection is not successful. The connection attempts might be polled in one
     * second interval.
     *
     * @param timeoutInSeconds the (maximum) number of seconds to wait for ZAP to start
     * @throws ClientApiException if the timeout was reached or if the thread was interrupted while
     *     waiting
     * @see #waitForSuccessfulConnectionToZap(int, int)
     */
    public void waitForSuccessfulConnectionToZap(int timeoutInSeconds) throws ClientApiException {
        waitForSuccessfulConnectionToZap(timeoutInSeconds, DEFAULT_CONNECTION_POOLING_IN_MS);
    }

    /**
     * Convenience method to wait for ZAP to be ready to receive API calls, when started
     * programmatically.
     *
     * <p>It attempts to establish a connection to ZAP's proxy, in the given time, throwing an
     * exception if the connection is not successful. The connection attempts are done with the
     * given polling interval.
     *
     * @param timeoutInSeconds the (maximum) number of seconds to wait for ZAP to start
     * @param pollingIntervalInMs the interval, in milliseconds, for connection polling
     * @throws ClientApiException if the timeout was reached or if the thread was interrupted while
     *     waiting.
     * @throws IllegalArgumentException if the interval for connection polling is negative.
     * @see #waitForSuccessfulConnectionToZap(int)
     */
    public void waitForSuccessfulConnectionToZap(int timeoutInSeconds, int pollingIntervalInMs)
            throws ClientApiException {
        int timeoutInMs = (int) TimeUnit.SECONDS.toMillis(timeoutInSeconds);
        int connectionTimeoutInMs = timeoutInMs;
        boolean connectionSuccessful = false;
        long startTime = System.currentTimeMillis();
        do {
            try (Socket socket = new Socket()) {
                try {
                    socket.connect(
                            new InetSocketAddress(zapAddress, zapPort), connectionTimeoutInMs);
                    connectionSuccessful = true;
                } catch (SocketTimeoutException ignore) {
                    throw newTimeoutConnectionToZap(timeoutInSeconds);
                } catch (IOException ignore) {
                    // and keep trying but wait some time first...
                    try {
                        Thread.sleep(pollingIntervalInMs);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new ClientApiException(
                                "The ClientApi was interrupted while sleeping between connection polling.",
                                e);
                    }

                    long ellapsedTime = System.currentTimeMillis() - startTime;
                    if (ellapsedTime >= timeoutInMs) {
                        throw newTimeoutConnectionToZap(timeoutInSeconds);
                    }
                    connectionTimeoutInMs = (int) (timeoutInMs - ellapsedTime);
                }
            } catch (IOException ignore) {
                // the closing state doesn't matter.
            }
        } while (!connectionSuccessful);
    }

    private static ClientApiException newTimeoutConnectionToZap(int timeoutInSeconds) {
        return new ClientApiException(
                "Unable to connect to ZAP's proxy after " + timeoutInSeconds + " seconds.");
    }

    /**
     * A simple HTTP request.
     *
     * <p>Contains the request URI and headers.
     */
    private static class HttpRequest {

        private final URL requestUri;
        private final Map<String, String> headers;

        public HttpRequest(URL url) {
            this.requestUri = url;
            this.headers = new HashMap<>();
        }

        /**
         * Gets the request URI of the request.
         *
         * @return the request URI.
         */
        public URL getRequestUri() {
            return requestUri;
        }

        /**
         * Adds a header with the given name and value.
         *
         * <p>If a header with the given name already exists it is replaced with the new value.
         *
         * @param name the name of the header.
         * @param value the value of the header.
         */
        public void addHeader(String name, String value) {
            headers.put(name, value);
        }

        /**
         * Gets the headers of the HTTP request. An unmodifiable {@code Map} containing the headers
         * (the keys correspond to the header names and the values for its contents).
         *
         * @return an unmodifiable {@code Map} containing the headers.
         */
        public Map<String, String> getHeaders() {
            return Collections.unmodifiableMap(headers);
        }
    }
}
