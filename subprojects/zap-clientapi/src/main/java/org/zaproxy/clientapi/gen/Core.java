/* Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2016 the ZAP development team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
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


/**
 * This file was automatically generated.
 */
@SuppressWarnings("javadoc")
public class Core extends org.zaproxy.clientapi.gen.deprecated.CoreDeprecated {

	private final ClientApi api;

	public Core(ClientApi api) {
		super(api);
		this.api = api;
	}

	/**
	 * Gets the alert with the given ID, the corresponding HTTP message can be obtained with the 'messageId' field and 'message' API method
	 */
	public ApiResponse alert(String id) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		return api.callApi("core", "view", "alert", map);
	}

	/**
	 * Gets the alerts raised by ZAP, optionally filtering by URL and paginating with 'start' position and 'count' of alerts
	 */
	public ApiResponse alerts(String baseurl, String start, String count) throws ClientApiException {
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
		return api.callApi("core", "view", "alerts", map);
	}

	/**
	 * Gets the number of alerts, optionally filtering by URL
	 */
	public ApiResponse numberOfAlerts(String baseurl) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (baseurl != null) {
			map.put("baseurl", baseurl);
		}
		return api.callApi("core", "view", "numberOfAlerts", map);
	}

	/**
	 * Gets the name of the hosts accessed through/by ZAP
	 */
	public ApiResponse hosts() throws ClientApiException {
		return api.callApi("core", "view", "hosts", null);
	}

	/**
	 * Gets the sites accessed through/by ZAP (scheme and domain)
	 */
	public ApiResponse sites() throws ClientApiException {
		return api.callApi("core", "view", "sites", null);
	}

	/**
	 * Gets the URLs accessed through/by ZAP
	 */
	public ApiResponse urls() throws ClientApiException {
		return api.callApi("core", "view", "urls", null);
	}

	/**
	 * Gets the HTTP message with the given ID. Returns the ID, request/response headers and bodies, cookies and note.
	 */
	public ApiResponse message(String id) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		return api.callApi("core", "view", "message", map);
	}

	/**
	 * Gets the HTTP messages sent by ZAP, request and response, optionally filtered by URL and paginated with 'start' position and 'count' of messages
	 */
	public ApiResponse messages(String baseurl, String start, String count) throws ClientApiException {
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

	/**
	 * Gets the number of messages, optionally filtering by URL
	 */
	public ApiResponse numberOfMessages(String baseurl) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (baseurl != null) {
			map.put("baseurl", baseurl);
		}
		return api.callApi("core", "view", "numberOfMessages", map);
	}

	/**
	 * Gets the mode
	 */
	public ApiResponse mode() throws ClientApiException {
		return api.callApi("core", "view", "mode", null);
	}

	/**
	 * Gets ZAP version
	 */
	public ApiResponse version() throws ClientApiException {
		return api.callApi("core", "view", "version", null);
	}

	/**
	 * Gets the regular expressions, applied to URLs, to exclude from the Proxy
	 */
	public ApiResponse excludedFromProxy() throws ClientApiException {
		return api.callApi("core", "view", "excludedFromProxy", null);
	}

	public ApiResponse homeDirectory() throws ClientApiException {
		return api.callApi("core", "view", "homeDirectory", null);
	}

	public ApiResponse optionDefaultUserAgent() throws ClientApiException {
		return api.callApi("core", "view", "optionDefaultUserAgent", null);
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

	public ApiResponse optionProxyChainSkipName() throws ClientApiException {
		return api.callApi("core", "view", "optionProxyChainSkipName", null);
	}

	public ApiResponse optionProxyChainUserName() throws ClientApiException {
		return api.callApi("core", "view", "optionProxyChainUserName", null);
	}

	public ApiResponse optionProxyExcludedDomains() throws ClientApiException {
		return api.callApi("core", "view", "optionProxyExcludedDomains", null);
	}

	public ApiResponse optionProxyExcludedDomainsEnabled() throws ClientApiException {
		return api.callApi("core", "view", "optionProxyExcludedDomainsEnabled", null);
	}

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
	 * Convenient and simple action to access a URL, optionally following redirections. Returns the request sent and response received and followed redirections, if any. Other actions are available which offer more control on what is sent, like, 'sendRequest' or 'sendHarRequest'.
	 */
	public ApiResponse accessUrl(String url, String followredirects) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("url", url);
		if (followredirects != null) {
			map.put("followRedirects", followredirects);
		}
		return api.callApi("core", "action", "accessUrl", map);
	}

	/**
	 * Shuts down ZAP
	 */
	public ApiResponse shutdown() throws ClientApiException {
		return api.callApi("core", "action", "shutdown", null);
	}

	/**
	 * Creates a new session, optionally overwriting existing files. If a relative path is specified it will be resolved against the "session" directory in ZAP "home" dir.
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
	 * Loads the session with the given name. If a relative path is specified it will be resolved against the "session" directory in ZAP "home" dir.
	 */
	public ApiResponse loadSession(String name) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		return api.callApi("core", "action", "loadSession", map);
	}

	/**
	 * Saves the session with the name supplied, optionally overwriting existing files. If a relative path is specified it will be resolved against the "session" directory in ZAP "home" dir.
	 */
	public ApiResponse saveSession(String name, String overwrite) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		if (overwrite != null) {
			map.put("overwrite", overwrite);
		}
		return api.callApi("core", "action", "saveSession", map);
	}

	public ApiResponse snapshotSession() throws ClientApiException {
		return api.callApi("core", "action", "snapshotSession", null);
	}

	public ApiResponse clearExcludedFromProxy() throws ClientApiException {
		return api.callApi("core", "action", "clearExcludedFromProxy", null);
	}

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

	/**
	 * Sets the mode, which may be one of [safe, protect, standard, attack]
	 */
	public ApiResponse setMode(String mode) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("mode", mode);
		return api.callApi("core", "action", "setMode", map);
	}

	public ApiResponse generateRootCA() throws ClientApiException {
		return api.callApi("core", "action", "generateRootCA", null);
	}

	/**
	 * Sends the HTTP request, optionally following redirections. Returns the request sent and response received and followed redirections, if any.
	 */
	public ApiResponse sendRequest(String request, String followredirects) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("request", request);
		if (followredirects != null) {
			map.put("followRedirects", followredirects);
		}
		return api.callApi("core", "action", "sendRequest", map);
	}

	public ApiResponse deleteAllAlerts() throws ClientApiException {
		return api.callApi("core", "action", "deleteAllAlerts", null);
	}

	public ApiResponse runGarbageCollection() throws ClientApiException {
		return api.callApi("core", "action", "runGarbageCollection", null);
	}

	/**
	 * Deletes the site node found in the Sites Tree on the basis of the URL, HTTP method, and post data (if applicable and specified). 
	 */
	public ApiResponse deleteSiteNode(String url, String method, String postdata) throws ClientApiException {
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

	public ApiResponse setOptionTimeoutInSecs(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("core", "action", "setOptionTimeoutInSecs", map);
	}

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

	public byte[] rootcert() throws ClientApiException {
		return api.callApiOther("core", "other", "rootcert", null);
	}

	public byte[] setproxy(String proxy) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("proxy", proxy);
		return api.callApiOther("core", "other", "setproxy", map);
	}

	/**
	 * Generates a report in XML format
	 */
	public byte[] xmlreport() throws ClientApiException {
		return api.callApiOther("core", "other", "xmlreport", null);
	}

	/**
	 * Generates a report in HTML format
	 */
	public byte[] htmlreport() throws ClientApiException {
		return api.callApiOther("core", "other", "htmlreport", null);
	}

	/**
	 * Gets the message with the given ID in HAR format
	 */
	public byte[] messageHar(String id) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		return api.callApiOther("core", "other", "messageHar", map);
	}

	/**
	 * Gets the HTTP messages sent through/by ZAP, in HAR format, optionally filtered by URL and paginated with 'start' position and 'count' of messages
	 */
	public byte[] messagesHar(String baseurl, String start, String count) throws ClientApiException {
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

	/**
	 * Sends the first HAR request entry, optionally following redirections. Returns, in HAR format, the request sent and response received and followed redirections, if any.
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
