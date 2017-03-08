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
public class Spider extends org.zaproxy.clientapi.gen.deprecated.SpiderDeprecated {

	private final ClientApi api;

	public Spider(ClientApi api) {
		super(api);
		this.api = api;
	}

	public ApiResponse status(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanid != null) {
			map.put("scanId", scanid);
		}
		return api.callApi("spider", "view", "status", map);
	}

	public ApiResponse results(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanid != null) {
			map.put("scanId", scanid);
		}
		return api.callApi("spider", "view", "results", map);
	}

	public ApiResponse fullResults(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("spider", "view", "fullResults", map);
	}

	public ApiResponse scans() throws ClientApiException {
		return api.callApi("spider", "view", "scans", null);
	}

	public ApiResponse excludedFromScan() throws ClientApiException {
		return api.callApi("spider", "view", "excludedFromScan", null);
	}

	public ApiResponse optionDomainsAlwaysInScope() throws ClientApiException {
		return api.callApi("spider", "view", "optionDomainsAlwaysInScope", null);
	}

	public ApiResponse optionDomainsAlwaysInScopeEnabled() throws ClientApiException {
		return api.callApi("spider", "view", "optionDomainsAlwaysInScopeEnabled", null);
	}

	public ApiResponse optionHandleParameters() throws ClientApiException {
		return api.callApi("spider", "view", "optionHandleParameters", null);
	}

	public ApiResponse optionMaxDepth() throws ClientApiException {
		return api.callApi("spider", "view", "optionMaxDepth", null);
	}

	public ApiResponse optionMaxDuration() throws ClientApiException {
		return api.callApi("spider", "view", "optionMaxDuration", null);
	}

	public ApiResponse optionMaxScansInUI() throws ClientApiException {
		return api.callApi("spider", "view", "optionMaxScansInUI", null);
	}

	public ApiResponse optionRequestWaitTime() throws ClientApiException {
		return api.callApi("spider", "view", "optionRequestWaitTime", null);
	}

	public ApiResponse optionScope() throws ClientApiException {
		return api.callApi("spider", "view", "optionScope", null);
	}

	public ApiResponse optionScopeText() throws ClientApiException {
		return api.callApi("spider", "view", "optionScopeText", null);
	}

	public ApiResponse optionSkipURLString() throws ClientApiException {
		return api.callApi("spider", "view", "optionSkipURLString", null);
	}

	public ApiResponse optionThreadCount() throws ClientApiException {
		return api.callApi("spider", "view", "optionThreadCount", null);
	}

	public ApiResponse optionUserAgent() throws ClientApiException {
		return api.callApi("spider", "view", "optionUserAgent", null);
	}

	public ApiResponse optionHandleODataParametersVisited() throws ClientApiException {
		return api.callApi("spider", "view", "optionHandleODataParametersVisited", null);
	}

	public ApiResponse optionParseComments() throws ClientApiException {
		return api.callApi("spider", "view", "optionParseComments", null);
	}

	public ApiResponse optionParseGit() throws ClientApiException {
		return api.callApi("spider", "view", "optionParseGit", null);
	}

	public ApiResponse optionParseRobotsTxt() throws ClientApiException {
		return api.callApi("spider", "view", "optionParseRobotsTxt", null);
	}

	public ApiResponse optionParseSVNEntries() throws ClientApiException {
		return api.callApi("spider", "view", "optionParseSVNEntries", null);
	}

	public ApiResponse optionParseSitemapXml() throws ClientApiException {
		return api.callApi("spider", "view", "optionParseSitemapXml", null);
	}

	public ApiResponse optionPostForm() throws ClientApiException {
		return api.callApi("spider", "view", "optionPostForm", null);
	}

	public ApiResponse optionProcessForm() throws ClientApiException {
		return api.callApi("spider", "view", "optionProcessForm", null);
	}

	/**
	 * Sets whether or not the 'Referer' header should be sent while spidering
	 */
	public ApiResponse optionSendRefererHeader() throws ClientApiException {
		return api.callApi("spider", "view", "optionSendRefererHeader", null);
	}

	public ApiResponse optionShowAdvancedDialog() throws ClientApiException {
		return api.callApi("spider", "view", "optionShowAdvancedDialog", null);
	}

	/**
	 * Runs the spider against the given URL (or context). Optionally, the 'maxChildren' parameter can be set to limit the number of children scanned, the 'recurse' parameter can be used to prevent the spider from seeding recursively, the parameter 'contextName' can be used to constrain the scan to a Context and the parameter 'subtreeOnly' allows to restrict the spider under a site's subtree (using the specified 'url').
	 */
	public ApiResponse scan(String url, String maxchildren, String recurse, String contextname, String subtreeonly) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (url != null) {
			map.put("url", url);
		}
		if (maxchildren != null) {
			map.put("maxChildren", maxchildren);
		}
		if (recurse != null) {
			map.put("recurse", recurse);
		}
		if (contextname != null) {
			map.put("contextName", contextname);
		}
		if (subtreeonly != null) {
			map.put("subtreeOnly", subtreeonly);
		}
		return api.callApi("spider", "action", "scan", map);
	}

	/**
	 * Runs the spider from the perspective of a User, obtained using the given Context ID and User ID. See 'scan' action for more details.
	 */
	public ApiResponse scanAsUser(String contextid, String userid, String url, String maxchildren, String recurse, String subtreeonly) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("contextId", contextid);
		map.put("userId", userid);
		if (url != null) {
			map.put("url", url);
		}
		if (maxchildren != null) {
			map.put("maxChildren", maxchildren);
		}
		if (recurse != null) {
			map.put("recurse", recurse);
		}
		if (subtreeonly != null) {
			map.put("subtreeOnly", subtreeonly);
		}
		return api.callApi("spider", "action", "scanAsUser", map);
	}

	public ApiResponse pause(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("spider", "action", "pause", map);
	}

	public ApiResponse resume(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("spider", "action", "resume", map);
	}

	public ApiResponse stop(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanid != null) {
			map.put("scanId", scanid);
		}
		return api.callApi("spider", "action", "stop", map);
	}

	public ApiResponse removeScan(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("spider", "action", "removeScan", map);
	}

	public ApiResponse pauseAllScans() throws ClientApiException {
		return api.callApi("spider", "action", "pauseAllScans", null);
	}

	public ApiResponse resumeAllScans() throws ClientApiException {
		return api.callApi("spider", "action", "resumeAllScans", null);
	}

	public ApiResponse stopAllScans() throws ClientApiException {
		return api.callApi("spider", "action", "stopAllScans", null);
	}

	public ApiResponse removeAllScans() throws ClientApiException {
		return api.callApi("spider", "action", "removeAllScans", null);
	}

	public ApiResponse clearExcludedFromScan() throws ClientApiException {
		return api.callApi("spider", "action", "clearExcludedFromScan", null);
	}

	public ApiResponse excludeFromScan(String regex) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("regex", regex);
		return api.callApi("spider", "action", "excludeFromScan", map);
	}

	public ApiResponse setOptionHandleParameters(String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("String", string);
		return api.callApi("spider", "action", "setOptionHandleParameters", map);
	}

	public ApiResponse setOptionScopeString(String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("String", string);
		return api.callApi("spider", "action", "setOptionScopeString", map);
	}

	public ApiResponse setOptionSkipURLString(String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("String", string);
		return api.callApi("spider", "action", "setOptionSkipURLString", map);
	}

	public ApiResponse setOptionUserAgent(String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("String", string);
		return api.callApi("spider", "action", "setOptionUserAgent", map);
	}

	public ApiResponse setOptionHandleODataParametersVisited(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionHandleODataParametersVisited", map);
	}

	public ApiResponse setOptionMaxDepth(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("spider", "action", "setOptionMaxDepth", map);
	}

	public ApiResponse setOptionMaxDuration(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("spider", "action", "setOptionMaxDuration", map);
	}

	public ApiResponse setOptionMaxScansInUI(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("spider", "action", "setOptionMaxScansInUI", map);
	}

	public ApiResponse setOptionParseComments(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionParseComments", map);
	}

	public ApiResponse setOptionParseGit(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionParseGit", map);
	}

	public ApiResponse setOptionParseRobotsTxt(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionParseRobotsTxt", map);
	}

	public ApiResponse setOptionParseSVNEntries(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionParseSVNEntries", map);
	}

	public ApiResponse setOptionParseSitemapXml(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionParseSitemapXml", map);
	}

	public ApiResponse setOptionPostForm(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionPostForm", map);
	}

	public ApiResponse setOptionProcessForm(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionProcessForm", map);
	}

	public ApiResponse setOptionRequestWaitTime(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("spider", "action", "setOptionRequestWaitTime", map);
	}

	public ApiResponse setOptionSendRefererHeader(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionSendRefererHeader", map);
	}

	public ApiResponse setOptionShowAdvancedDialog(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("spider", "action", "setOptionShowAdvancedDialog", map);
	}

	public ApiResponse setOptionThreadCount(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("spider", "action", "setOptionThreadCount", map);
	}

}
