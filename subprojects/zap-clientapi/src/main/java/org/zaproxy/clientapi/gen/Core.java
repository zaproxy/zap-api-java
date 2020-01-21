/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2017 The ZAP Development Team
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
package org.zaproxy.clientapi.gen;

import java.util.HashMap;
import java.util.Map;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

/** This file was automatically generated. */
@SuppressWarnings("javadoc")
public class Core extends org.zaproxy.clientapi.gen.deprecated.CoreDeprecated {

    private final ClientApi api;

    public Core(ClientApi api) {
        super(api);
        this.api = api;
    }

    /** Gets the name of the hosts accessed through/by ZAP */
    public ApiResponse hosts() throws ClientApiException {
        return api.callApi("core", "view", "hosts", null);
    }

    /** Gets the sites accessed through/by ZAP (scheme and domain) */
    public ApiResponse sites() throws ClientApiException {
        return api.callApi("core", "view", "sites", null);
    }

    /** Gets the URLs accessed through/by ZAP, optionally filtering by (base) URL. */
    public ApiResponse urls(String baseurl) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        return api.callApi("core", "view", "urls", map);
    }

    /** Gets the child nodes underneath the specified URL in the Sites tree */
    public ApiResponse childNodes(String url) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (url != null) {
            map.put("url", url);
        }
        return api.callApi("core", "view", "childNodes", map);
    }

    /**
     * Gets the HTTP message with the given ID. Returns the ID, request/response headers and bodies,
     * cookies, note, type, RTT, and timestamp.
     */
    public ApiResponse message(String id) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return api.callApi("core", "view", "message", map);
    }

    /**
     * Gets the HTTP messages sent by ZAP, request and response, optionally filtered by URL and
     * paginated with 'start' position and 'count' of messages
     */
    public ApiResponse messages(String baseurl, String start, String count)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApi("core", "view", "messages", map);
    }

    /** Gets the HTTP messages with the given IDs. */
    public ApiResponse messagesById(String ids) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("ids", ids);
        return api.callApi("core", "view", "messagesById", map);
    }

    /** Gets the number of messages, optionally filtering by URL */
    public ApiResponse numberOfMessages(String baseurl) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        return api.callApi("core", "view", "numberOfMessages", map);
    }

    /** Gets the mode */
    public ApiResponse mode() throws ClientApiException {
        return api.callApi("core", "view", "mode", null);
    }

    /** Gets ZAP version */
    public ApiResponse version() throws ClientApiException {
        return api.callApi("core", "view", "version", null);
    }

    /** Gets the regular expressions, applied to URLs, to exclude from the local proxies. */
    public ApiResponse excludedFromProxy() throws ClientApiException {
        return api.callApi("core", "view", "excludedFromProxy", null);
    }

    public ApiResponse homeDirectory() throws ClientApiException {
        return api.callApi("core", "view", "homeDirectory", null);
    }

    /** Gets the location of the current session file */
    public ApiResponse sessionLocation() throws ClientApiException {
        return api.callApi("core", "view", "sessionLocation", null);
    }

    /**
     * Gets all the domains that are excluded from the outgoing proxy. For each domain the following
     * are shown: the index, the value (domain), if enabled, and if specified as a regex.
     */
    public ApiResponse proxyChainExcludedDomains() throws ClientApiException {
        return api.callApi("core", "view", "proxyChainExcludedDomains", null);
    }

    /**
     * Use view proxyChainExcludedDomains instead.
     *
     * @deprecated
     */
    @Deprecated
    public ApiResponse optionProxyChainSkipName() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyChainSkipName", null);
    }

    /**
     * Use view proxyChainExcludedDomains instead.
     *
     * @deprecated
     */
    @Deprecated
    public ApiResponse optionProxyExcludedDomains() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyExcludedDomains", null);
    }

    /**
     * Use view proxyChainExcludedDomains instead.
     *
     * @deprecated
     */
    @Deprecated
    public ApiResponse optionProxyExcludedDomainsEnabled() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyExcludedDomainsEnabled", null);
    }

    /** Gets the path to ZAP's home directory. */
    public ApiResponse zapHomePath() throws ClientApiException {
        return api.callApi("core", "view", "zapHomePath", null);
    }

    /** Gets the maximum number of alert instances to include in a report. */
    public ApiResponse optionMaximumAlertInstances() throws ClientApiException {
        return api.callApi("core", "view", "optionMaximumAlertInstances", null);
    }

    /** Gets whether or not related alerts will be merged in any reports generated. */
    public ApiResponse optionMergeRelatedAlerts() throws ClientApiException {
        return api.callApi("core", "view", "optionMergeRelatedAlerts", null);
    }

    /** Gets the path to the file with alert overrides. */
    public ApiResponse optionAlertOverridesFilePath() throws ClientApiException {
        return api.callApi("core", "view", "optionAlertOverridesFilePath", null);
    }

    /**
     * Gets the alert with the given ID, the corresponding HTTP message can be obtained with the
     * 'messageId' field and 'message' API method
     *
     * @deprecated Use the API endpoint with the same name in the 'alert' component instead.
     */
    @Deprecated
    public ApiResponse alert(String id) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return api.callApi("core", "view", "alert", map);
    }

    /**
     * Gets the alerts raised by ZAP, optionally filtering by URL or riskId, and paginating with
     * 'start' position and 'count' of alerts
     *
     * @deprecated Use the API endpoint with the same name in the 'alert' component instead.
     */
    @Deprecated
    public ApiResponse alerts(String baseurl, String start, String count, String riskid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        if (riskid != null) {
            map.put("riskId", riskid);
        }
        return api.callApi("core", "view", "alerts", map);
    }

    /**
     * Gets number of alerts grouped by each risk level, optionally filtering by URL
     *
     * @deprecated Use the API endpoint with the same name in the 'alert' component instead.
     */
    @Deprecated
    public ApiResponse alertsSummary(String baseurl) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        return api.callApi("core", "view", "alertsSummary", map);
    }

    /**
     * Gets the number of alerts, optionally filtering by URL or riskId
     *
     * @deprecated Use the API endpoint with the same name in the 'alert' component instead.
     */
    @Deprecated
    public ApiResponse numberOfAlerts(String baseurl, String riskid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (riskid != null) {
            map.put("riskId", riskid);
        }
        return api.callApi("core", "view", "numberOfAlerts", map);
    }

    /**
     * Gets the user agent that ZAP should use when creating HTTP messages (for example, spider
     * messages or CONNECT requests to outgoing proxy).
     */
    public ApiResponse optionDefaultUserAgent() throws ClientApiException {
        return api.callApi("core", "view", "optionDefaultUserAgent", null);
    }

    /** Gets the TTL (in seconds) of successful DNS queries. */
    public ApiResponse optionDnsTtlSuccessfulQueries() throws ClientApiException {
        return api.callApi("core", "view", "optionDnsTtlSuccessfulQueries", null);
    }

    public ApiResponse optionHttpState() throws ClientApiException {
        return api.callApi("core", "view", "optionHttpState", null);
    }

    public ApiResponse optionProxyChainName() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyChainName", null);
    }

    public ApiResponse optionProxyChainPassword() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyChainPassword", null);
    }

    public ApiResponse optionProxyChainPort() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyChainPort", null);
    }

    public ApiResponse optionProxyChainRealm() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyChainRealm", null);
    }

    public ApiResponse optionProxyChainUserName() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyChainUserName", null);
    }

    /** Gets the connection time out, in seconds. */
    public ApiResponse optionTimeoutInSecs() throws ClientApiException {
        return api.callApi("core", "view", "optionTimeoutInSecs", null);
    }

    public ApiResponse optionHttpStateEnabled() throws ClientApiException {
        return api.callApi("core", "view", "optionHttpStateEnabled", null);
    }

    public ApiResponse optionProxyChainPrompt() throws ClientApiException {
        return api.callApi("core", "view", "optionProxyChainPrompt", null);
    }

    public ApiResponse optionSingleCookieRequestHeader() throws ClientApiException {
        return api.callApi("core", "view", "optionSingleCookieRequestHeader", null);
    }

    public ApiResponse optionUseProxyChain() throws ClientApiException {
        return api.callApi("core", "view", "optionUseProxyChain", null);
    }

    public ApiResponse optionUseProxyChainAuth() throws ClientApiException {
        return api.callApi("core", "view", "optionUseProxyChainAuth", null);
    }

    /**
     * Convenient and simple action to access a URL, optionally following redirections. Returns the
     * request sent and response received and followed redirections, if any. Other actions are
     * available which offer more control on what is sent, like, 'sendRequest' or 'sendHarRequest'.
     */
    public ApiResponse accessUrl(String url, String followredirects) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        if (followredirects != null) {
            map.put("followRedirects", followredirects);
        }
        return api.callApi("core", "action", "accessUrl", map);
    }

    /** Shuts down ZAP */
    public ApiResponse shutdown() throws ClientApiException {
        return api.callApi("core", "action", "shutdown", null);
    }

    /**
     * Creates a new session, optionally overwriting existing files. If a relative path is specified
     * it will be resolved against the "session" directory in ZAP "home" dir.
     */
    public ApiResponse newSession(String name, String overwrite) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (name != null) {
            map.put("name", name);
        }
        if (overwrite != null) {
            map.put("overwrite", overwrite);
        }
        return api.callApi("core", "action", "newSession", map);
    }

    /**
     * Loads the session with the given name. If a relative path is specified it will be resolved
     * against the "session" directory in ZAP "home" dir.
     */
    public ApiResponse loadSession(String name) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return api.callApi("core", "action", "loadSession", map);
    }

    /** Saves the session. */
    public ApiResponse saveSession(String name, String overwrite) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        if (overwrite != null) {
            map.put("overwrite", overwrite);
        }
        return api.callApi("core", "action", "saveSession", map);
    }

    /**
     * Snapshots the session, optionally with the given name, and overwriting existing files. If no
     * name is specified the name of the current session with a timestamp appended is used. If a
     * relative path is specified it will be resolved against the "session" directory in ZAP "home"
     * dir.
     */
    public ApiResponse snapshotSession(String name, String overwrite) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (name != null) {
            map.put("name", name);
        }
        if (overwrite != null) {
            map.put("overwrite", overwrite);
        }
        return api.callApi("core", "action", "snapshotSession", map);
    }

    /** Clears the regexes of URLs excluded from the local proxies. */
    public ApiResponse clearExcludedFromProxy() throws ClientApiException {
        return api.callApi("core", "action", "clearExcludedFromProxy", null);
    }

    /** Adds a regex of URLs that should be excluded from the local proxies. */
    public ApiResponse excludeFromProxy(String regex) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("regex", regex);
        return api.callApi("core", "action", "excludeFromProxy", map);
    }

    public ApiResponse setHomeDirectory(String dir) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("dir", dir);
        return api.callApi("core", "action", "setHomeDirectory", map);
    }

    /** Sets the mode, which may be one of [safe, protect, standard, attack] */
    public ApiResponse setMode(String mode) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("mode", mode);
        return api.callApi("core", "action", "setMode", map);
    }

    /** Generates a new Root CA certificate for the local proxies. */
    public ApiResponse generateRootCA() throws ClientApiException {
        return api.callApi("core", "action", "generateRootCA", null);
    }

    /**
     * Sends the HTTP request, optionally following redirections. Returns the request sent and
     * response received and followed redirections, if any. The Mode is enforced when sending the
     * request (and following redirections), custom manual requests are not allowed in 'Safe' mode
     * nor in 'Protected' mode if out of scope.
     */
    public ApiResponse sendRequest(String request, String followredirects)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("request", request);
        if (followredirects != null) {
            map.put("followRedirects", followredirects);
        }
        return api.callApi("core", "action", "sendRequest", map);
    }

    public ApiResponse runGarbageCollection() throws ClientApiException {
        return api.callApi("core", "action", "runGarbageCollection", null);
    }

    /**
     * Deletes the site node found in the Sites Tree on the basis of the URL, HTTP method, and post
     * data (if applicable and specified).
     */
    public ApiResponse deleteSiteNode(String url, String method, String postdata)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        if (method != null) {
            map.put("method", method);
        }
        if (postdata != null) {
            map.put("postData", postdata);
        }
        return api.callApi("core", "action", "deleteSiteNode", map);
    }

    /**
     * Adds a domain to be excluded from the outgoing proxy, using the specified value. Optionally
     * sets if the new entry is enabled (default, true) and whether or not the new value is
     * specified as a regex (default, false).
     */
    public ApiResponse addProxyChainExcludedDomain(String value, String isregex, String isenabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("value", value);
        if (isregex != null) {
            map.put("isRegex", isregex);
        }
        if (isenabled != null) {
            map.put("isEnabled", isenabled);
        }
        return api.callApi("core", "action", "addProxyChainExcludedDomain", map);
    }

    /**
     * Modifies a domain excluded from the outgoing proxy. Allows to modify the value, if enabled or
     * if a regex. The domain is selected with its index, which can be obtained with the view
     * proxyChainExcludedDomains.
     */
    public ApiResponse modifyProxyChainExcludedDomain(
            String idx, String value, String isregex, String isenabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("idx", idx);
        if (value != null) {
            map.put("value", value);
        }
        if (isregex != null) {
            map.put("isRegex", isregex);
        }
        if (isenabled != null) {
            map.put("isEnabled", isenabled);
        }
        return api.callApi("core", "action", "modifyProxyChainExcludedDomain", map);
    }

    /**
     * Removes a domain excluded from the outgoing proxy, with the given index. The index can be
     * obtained with the view proxyChainExcludedDomains.
     */
    public ApiResponse removeProxyChainExcludedDomain(String idx) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("idx", idx);
        return api.callApi("core", "action", "removeProxyChainExcludedDomain", map);
    }

    /** Enables all domains excluded from the outgoing proxy. */
    public ApiResponse enableAllProxyChainExcludedDomains() throws ClientApiException {
        return api.callApi("core", "action", "enableAllProxyChainExcludedDomains", null);
    }

    /** Disables all domains excluded from the outgoing proxy. */
    public ApiResponse disableAllProxyChainExcludedDomains() throws ClientApiException {
        return api.callApi("core", "action", "disableAllProxyChainExcludedDomains", null);
    }

    /**
     * Sets the maximum number of alert instances to include in a report. A value of zero is treated
     * as unlimited.
     */
    public ApiResponse setOptionMaximumAlertInstances(String numberofinstances)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("numberOfInstances", numberofinstances);
        return api.callApi("core", "action", "setOptionMaximumAlertInstances", map);
    }

    /** Sets whether or not related alerts will be merged in any reports generated. */
    public ApiResponse setOptionMergeRelatedAlerts(String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("enabled", enabled);
        return api.callApi("core", "action", "setOptionMergeRelatedAlerts", map);
    }

    /** Sets (or clears, if empty) the path to the file with alert overrides. */
    public ApiResponse setOptionAlertOverridesFilePath(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (filepath != null) {
            map.put("filePath", filepath);
        }
        return api.callApi("core", "action", "setOptionAlertOverridesFilePath", map);
    }

    /**
     * Enables use of a PKCS12 client certificate for the certificate with the given file system
     * path, password, and optional index.
     */
    public ApiResponse enablePKCS12ClientCertificate(String filepath, String password, String index)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        map.put("password", password);
        if (index != null) {
            map.put("index", index);
        }
        return api.callApi("core", "action", "enablePKCS12ClientCertificate", map);
    }

    /** Disables the option for use of client certificates. */
    public ApiResponse disableClientCertificate() throws ClientApiException {
        return api.callApi("core", "action", "disableClientCertificate", null);
    }

    /**
     * Deletes all alerts of the current session.
     *
     * @deprecated Use the API endpoint with the same name in the 'alert' component instead.
     */
    @Deprecated
    public ApiResponse deleteAllAlerts() throws ClientApiException {
        return api.callApi("core", "action", "deleteAllAlerts", null);
    }

    /**
     * Deletes the alert with the given ID.
     *
     * @deprecated Use the API endpoint with the same name in the 'alert' component instead.
     */
    @Deprecated
    public ApiResponse deleteAlert(String id) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return api.callApi("core", "action", "deleteAlert", map);
    }

    /**
     * Sets the user agent that ZAP should use when creating HTTP messages (for example, spider
     * messages or CONNECT requests to outgoing proxy).
     */
    public ApiResponse setOptionDefaultUserAgent(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("core", "action", "setOptionDefaultUserAgent", map);
    }

    public ApiResponse setOptionProxyChainName(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("core", "action", "setOptionProxyChainName", map);
    }

    public ApiResponse setOptionProxyChainPassword(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("core", "action", "setOptionProxyChainPassword", map);
    }

    public ApiResponse setOptionProxyChainRealm(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("core", "action", "setOptionProxyChainRealm", map);
    }

    /**
     * Use actions [add|modify|remove]ProxyChainExcludedDomain instead.
     *
     * @deprecated Option no longer in effective use.
     */
    @Deprecated
    public ApiResponse setOptionProxyChainSkipName(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("core", "action", "setOptionProxyChainSkipName", map);
    }

    public ApiResponse setOptionProxyChainUserName(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("core", "action", "setOptionProxyChainUserName", map);
    }

    /** Sets the TTL (in seconds) of successful DNS queries (applies after ZAP restart). */
    public ApiResponse setOptionDnsTtlSuccessfulQueries(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("core", "action", "setOptionDnsTtlSuccessfulQueries", map);
    }

    public ApiResponse setOptionHttpStateEnabled(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("core", "action", "setOptionHttpStateEnabled", map);
    }

    public ApiResponse setOptionProxyChainPort(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("core", "action", "setOptionProxyChainPort", map);
    }

    public ApiResponse setOptionProxyChainPrompt(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("core", "action", "setOptionProxyChainPrompt", map);
    }

    public ApiResponse setOptionSingleCookieRequestHeader(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("core", "action", "setOptionSingleCookieRequestHeader", map);
    }

    /** Sets the connection time out, in seconds. */
    public ApiResponse setOptionTimeoutInSecs(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("core", "action", "setOptionTimeoutInSecs", map);
    }

    /**
     * Sets whether or not the outgoing proxy should be used. The address/hostname of the outgoing
     * proxy must be set to enable this option.
     */
    public ApiResponse setOptionUseProxyChain(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("core", "action", "setOptionUseProxyChain", map);
    }

    public ApiResponse setOptionUseProxyChainAuth(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("core", "action", "setOptionUseProxyChainAuth", map);
    }

    public byte[] proxypac() throws ClientApiException {
        return api.callApiOther("core", "other", "proxy.pac", null);
    }

    /** Gets the Root CA certificate used by the local proxies. */
    public byte[] rootcert() throws ClientApiException {
        return api.callApiOther("core", "other", "rootcert", null);
    }

    public byte[] setproxy(String proxy) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("proxy", proxy);
        return api.callApiOther("core", "other", "setproxy", map);
    }

    /** Generates a report in XML format */
    public byte[] xmlreport() throws ClientApiException {
        return api.callApiOther("core", "other", "xmlreport", null);
    }

    /** Generates a report in HTML format */
    public byte[] htmlreport() throws ClientApiException {
        return api.callApiOther("core", "other", "htmlreport", null);
    }

    /** Generates a report in JSON format */
    public byte[] jsonreport() throws ClientApiException {
        return api.callApiOther("core", "other", "jsonreport", null);
    }

    /** Generates a report in Markdown format */
    public byte[] mdreport() throws ClientApiException {
        return api.callApiOther("core", "other", "mdreport", null);
    }

    /** Gets the message with the given ID in HAR format */
    public byte[] messageHar(String id) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return api.callApiOther("core", "other", "messageHar", map);
    }

    /**
     * Gets the HTTP messages sent through/by ZAP, in HAR format, optionally filtered by URL and
     * paginated with 'start' position and 'count' of messages
     */
    public byte[] messagesHar(String baseurl, String start, String count)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApiOther("core", "other", "messagesHar", map);
    }

    /** Gets the HTTP messages with the given IDs, in HAR format. */
    public byte[] messagesHarById(String ids) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("ids", ids);
        return api.callApiOther("core", "other", "messagesHarById", map);
    }

    /**
     * Sends the first HAR request entry, optionally following redirections. Returns, in HAR format,
     * the request sent and response received and followed redirections, if any. The Mode is
     * enforced when sending the request (and following redirections), custom manual requests are
     * not allowed in 'Safe' mode nor in 'Protected' mode if out of scope.
     */
    public byte[] sendHarRequest(String request, String followredirects) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("request", request);
        if (followredirects != null) {
            map.put("followRedirects", followredirects);
        }
        return api.callApiOther("core", "other", "sendHarRequest", map);
    }
}
