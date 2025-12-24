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

import static org.zaproxy.clientapi.internal.FilesWorkflow.readAllBytes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.zaproxy.clientapi.gen.*;
import org.zaproxy.clientapi.impl.DefaultAlertService;
import org.zaproxy.clientapi.internal.AlertWorkflow;
import org.zaproxy.clientapi.internal.ContextWorkflow;
import org.zaproxy.clientapi.internal.ScanWorkflow;
import org.zaproxy.clientapi.service.AlertService;

@SuppressWarnings("this-escape")
public class ClientApi {

    private static final int DEFAULT_CONNECTION_POOLING_IN_MS = 1000;

    private Proxy proxy;

    @SuppressWarnings("UnusedVariable")
    private boolean debug = false;

    @SuppressWarnings("UnusedVariable")
    private PrintStream debugStream = System.out;

    private String zapAddress;
    private int zapPort;
    private String apiKey;

    private DocumentBuilderFactory docBuilderFactory;

    /* =======================
     * Generated API endpoints
     * ======================= */

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
    public Client client = new Client(this);
    public ClientSpider clientSpider = new ClientSpider(this);
    public Context context = new Context(this);
    public Core core = new Core(this);
    public Exim exim = new Exim(this);

    @SuppressWarnings("removal")
    public Exportreport exportreport = new Exportreport(this);

    public ForcedUser forcedUser = new ForcedUser(this);
    public Graphql graphql = new Graphql(this);
    public HttpSessions httpSessions = new HttpSessions(this);

    @SuppressWarnings("removal")
    public ImportLogFiles logImportFiles = new ImportLogFiles(this);

    @SuppressWarnings("removal")
    public Importurls importurls = new Importurls(this);

    @SuppressWarnings("removal")
    public LocalProxies localProxies = new LocalProxies(this);

    public Network network = new Network(this);
    public Oast oast = new Oast(this);
    public Openapi openapi = new Openapi(this);
    public Params params = new Params(this);
    public Pnh pnh = new Pnh(this);
    public Postman postman = new Postman(this);
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

    /* =======================
     * Internal services
     * ======================= */

    private final AlertService alertService;

    /* =======================
     * Constructors
     * ======================= */

    public ClientApi(String zapAddress, int zapPort) {
        this(zapAddress, zapPort, null, false);
    }

    public ClientApi(String zapAddress, int zapPort, String apiKey) {
        this(zapAddress, zapPort, apiKey, false);
    }

    public ClientApi(String zapAddress, int zapPort, boolean debug) {
        this(zapAddress, zapPort, null, debug);
    }

    public ClientApi(String zapAddress, int zapPort, String apiKey, boolean debug) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(zapAddress, zapPort));
        this.zapAddress = zapAddress;
        this.zapPort = zapPort;
        this.apiKey = apiKey;
        this.debug = debug;
        this.alertService = new DefaultAlertService(this.alert);
    }

    public void setDebugStream(PrintStream debugStream) {
        this.debugStream = debugStream;
    }

    AlertService getAlertService() {
        return alertService;
    }

    public void checkAlerts(List<Alert> ignoreAlerts, List<Alert> requireAlerts)
            throws ClientApiException {
        AlertWorkflow.checkAlerts(this, alertService, ignoreAlerts, requireAlerts);
    }

    public void checkAlerts(List<Alert> ignoreAlerts, List<Alert> requireAlerts, File outputFile)
            throws ClientApiException {
        AlertWorkflow.checkAlerts(this, alertService, ignoreAlerts, requireAlerts, outputFile);
    }

    public void includeOneMatchingNodeInContext(String contextName, String regex) throws Exception {
        ContextWorkflow.includeOneMatchingNode(this, contextName, regex);
    }

    public void activeScanSiteInScope(String url) throws Exception {
        ScanWorkflow.activeScanSiteInScope(this, url);
    }

    public void accessUrl(String url) throws ClientApiException {
        accessUrlViaProxy(proxy, url);
    }

    private void accessUrlViaProxy(Proxy proxy, String apiurl) throws ClientApiException {
        try {
            URL url = createUrl(apiurl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection(proxy);
            uc.connect();

            try (BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8))) {
                while (in.readLine() != null) {
                    // ignore
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new ClientApiException(e);
        }
    }

    private static URL createUrl(String value) throws MalformedURLException, URISyntaxException {
        return new URI(value).toURL();
    }

    public ApiResponse callApi(
            String component, String type, String method, Map<String, String> params)
            throws ClientApiException {
        return callApi(HttpRequest.GET_METHOD, component, type, method, params);
    }

    public ApiResponse callApi(
            String requestMethod,
            String component,
            String type,
            String method,
            Map<String, String> params)
            throws ClientApiException {
        Document dom = callApiDom(requestMethod, component, type, method, params);
        return ApiResponseFactory.getResponse(dom.getFirstChild());
    }

    public byte[] callApiOther(
            String component, String type, String method, Map<String, String> params)
            throws ClientApiException {
        return callApiOther(HttpRequest.GET_METHOD, component, type, method, params);
    }

    public byte[] callApiOther(
            String requestMethod,
            String component,
            String type,
            String method,
            Map<String, String> params)
            throws ClientApiException {

        try {
            HttpRequest request =
                    ZapRequestBuilder.buildZapRequest(
                            requestMethod, "other", component, type, method, params, apiKey);

            return readAllBytes(getConnectionInputStream(request));

        } catch (Exception e) {
            throw new ClientApiException(e);
        }
    }

    public String callApiJson(
            String component, String type, String method, Map<String, String> params)
            throws ClientApiException {

        try {
            HttpRequest request =
                    ZapRequestBuilder.buildZapRequest(
                            HttpRequest.GET_METHOD,
                            "JSON",
                            component,
                            type,
                            method,
                            params,
                            apiKey);

            byte[] bytes = readAllBytes(getConnectionInputStream(request));
            return new String(bytes, StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new ClientApiException(e);
        }
    }

    private Document callApiDom(
            String requestMethod,
            String component,
            String type,
            String method,
            Map<String, String> params)
            throws ClientApiException {
        try {
            HttpRequest request =
                    ZapRequestBuilder.buildZapRequest(
                            requestMethod, "xml", component, type, method, params, apiKey);
            DocumentBuilder db = getDocumentBuilderFactory().newDocumentBuilder();
            return db.parse(getConnectionInputStream(request));
        } catch (Exception e) {
            throw new ClientApiException(e);
        }
    }

    private DocumentBuilderFactory getDocumentBuilderFactory() throws ParserConfigurationException {
        if (docBuilderFactory == null) {
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
        if (!HttpRequest.GET_METHOD.equals(request.getMethod())) {
            uc.setRequestMethod(request.getMethod());
            if (request.getBody() != null && !request.getBody().isEmpty()) {
                uc.setDoOutput(true);
                try (OutputStreamWriter os =
                        new OutputStreamWriter(uc.getOutputStream(), StandardCharsets.UTF_8)) {
                    os.write(request.getBody());
                }
            }
        }
        uc.connect();
        return uc.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST
                ? uc.getErrorStream()
                : uc.getInputStream();
    }

    public void waitForSuccessfulConnectionToZap(int timeoutInSeconds) throws ClientApiException {
        waitForSuccessfulConnectionToZap(timeoutInSeconds, DEFAULT_CONNECTION_POOLING_IN_MS);
    }

    public void waitForSuccessfulConnectionToZap(int timeoutInSeconds, int pollingIntervalInMs)
            throws ClientApiException {

        int timeoutInMs = (int) TimeUnit.SECONDS.toMillis(timeoutInSeconds);
        long start = System.currentTimeMillis();

        while (true) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(zapAddress, zapPort), timeoutInMs);
                return;
            } catch (IOException e) {
                if (System.currentTimeMillis() - start > timeoutInMs) {
                    throw new ClientApiException(
                            "Unable to connect to ZAP after " + timeoutInSeconds + " seconds.");
                }
                try {
                    Thread.sleep(pollingIntervalInMs);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new ClientApiException("Interrupted while waiting for ZAP.", ie);
                }
            }
        }
    }
}
