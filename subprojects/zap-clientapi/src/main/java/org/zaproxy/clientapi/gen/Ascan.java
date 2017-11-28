/* Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2017 the ZAP development team
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
public class Ascan extends org.zaproxy.clientapi.gen.deprecated.AscanDeprecated {

	private final ClientApi api;

	public Ascan(ClientApi api) {
		super(api);
		this.api = api;
	}

	public ApiResponse status(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanid != null) {
			map.put("scanId", scanid);
		}
		return api.callApi("ascan", "view", "status", map);
	}

	public ApiResponse scanProgress(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanid != null) {
			map.put("scanId", scanid);
		}
		return api.callApi("ascan", "view", "scanProgress", map);
	}

	/**
	 * Gets the IDs of the messages sent during the scan with the given ID. A message can be obtained with 'message' core view.
	 */
	public ApiResponse messagesIds(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("ascan", "view", "messagesIds", map);
	}

	/**
	 * Gets the IDs of the alerts raised during the scan with the given ID. An alert can be obtained with 'alert' core view.
	 */
	public ApiResponse alertsIds(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("ascan", "view", "alertsIds", map);
	}

	public ApiResponse scans() throws ClientApiException {
		return api.callApi("ascan", "view", "scans", null);
	}

	public ApiResponse scanPolicyNames() throws ClientApiException {
		return api.callApi("ascan", "view", "scanPolicyNames", null);
	}

	/**
	 * Gets the regexes of URLs excluded from the active scans.
	 */
	public ApiResponse excludedFromScan() throws ClientApiException {
		return api.callApi("ascan", "view", "excludedFromScan", null);
	}

	public ApiResponse scanners(String scanpolicyname, String policyid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		if (policyid != null) {
			map.put("policyId", policyid);
		}
		return api.callApi("ascan", "view", "scanners", map);
	}

	public ApiResponse policies(String scanpolicyname, String policyid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		if (policyid != null) {
			map.put("policyId", policyid);
		}
		return api.callApi("ascan", "view", "policies", map);
	}

	public ApiResponse attackModeQueue() throws ClientApiException {
		return api.callApi("ascan", "view", "attackModeQueue", null);
	}

	/**
	 * Gets all the parameters that are excluded. For each parameter the following are shown: the name, the URL, and the parameter type.
	 */
	public ApiResponse excludedParams() throws ClientApiException {
		return api.callApi("ascan", "view", "excludedParams", null);
	}

	/**
	 * Use view excludedParams instead.
	 * @deprecated
	 */
	@Deprecated
	public ApiResponse optionExcludedParamList() throws ClientApiException {
		return api.callApi("ascan", "view", "optionExcludedParamList", null);
	}

	/**
	 * Gets all the types of excluded parameters. For each type the following are shown: the ID and the name.
	 */
	public ApiResponse excludedParamTypes() throws ClientApiException {
		return api.callApi("ascan", "view", "excludedParamTypes", null);
	}

	public ApiResponse optionAttackPolicy() throws ClientApiException {
		return api.callApi("ascan", "view", "optionAttackPolicy", null);
	}

	public ApiResponse optionDefaultPolicy() throws ClientApiException {
		return api.callApi("ascan", "view", "optionDefaultPolicy", null);
	}

	public ApiResponse optionDelayInMs() throws ClientApiException {
		return api.callApi("ascan", "view", "optionDelayInMs", null);
	}

	public ApiResponse optionHandleAntiCSRFTokens() throws ClientApiException {
		return api.callApi("ascan", "view", "optionHandleAntiCSRFTokens", null);
	}

	public ApiResponse optionHostPerScan() throws ClientApiException {
		return api.callApi("ascan", "view", "optionHostPerScan", null);
	}

	public ApiResponse optionMaxChartTimeInMins() throws ClientApiException {
		return api.callApi("ascan", "view", "optionMaxChartTimeInMins", null);
	}

	public ApiResponse optionMaxResultsToList() throws ClientApiException {
		return api.callApi("ascan", "view", "optionMaxResultsToList", null);
	}

	public ApiResponse optionMaxRuleDurationInMins() throws ClientApiException {
		return api.callApi("ascan", "view", "optionMaxRuleDurationInMins", null);
	}

	public ApiResponse optionMaxScanDurationInMins() throws ClientApiException {
		return api.callApi("ascan", "view", "optionMaxScanDurationInMins", null);
	}

	public ApiResponse optionMaxScansInUI() throws ClientApiException {
		return api.callApi("ascan", "view", "optionMaxScansInUI", null);
	}

	public ApiResponse optionTargetParamsEnabledRPC() throws ClientApiException {
		return api.callApi("ascan", "view", "optionTargetParamsEnabledRPC", null);
	}

	public ApiResponse optionTargetParamsInjectable() throws ClientApiException {
		return api.callApi("ascan", "view", "optionTargetParamsInjectable", null);
	}

	public ApiResponse optionThreadPerHost() throws ClientApiException {
		return api.callApi("ascan", "view", "optionThreadPerHost", null);
	}

	public ApiResponse optionAllowAttackOnStart() throws ClientApiException {
		return api.callApi("ascan", "view", "optionAllowAttackOnStart", null);
	}

	/**
	 * Tells whether or not the active scanner should inject the HTTP request header X-ZAP-Scan-ID, with the ID of the scanner that's sending the requests.
	 */
	public ApiResponse optionInjectPluginIdInHeader() throws ClientApiException {
		return api.callApi("ascan", "view", "optionInjectPluginIdInHeader", null);
	}

	public ApiResponse optionPromptInAttackMode() throws ClientApiException {
		return api.callApi("ascan", "view", "optionPromptInAttackMode", null);
	}

	public ApiResponse optionPromptToClearFinishedScans() throws ClientApiException {
		return api.callApi("ascan", "view", "optionPromptToClearFinishedScans", null);
	}

	public ApiResponse optionRescanInAttackMode() throws ClientApiException {
		return api.callApi("ascan", "view", "optionRescanInAttackMode", null);
	}

	/**
	 * Tells whether or not the HTTP Headers of all requests should be scanned. Not just requests that send parameters, through the query or request body.
	 */
	public ApiResponse optionScanHeadersAllRequests() throws ClientApiException {
		return api.callApi("ascan", "view", "optionScanHeadersAllRequests", null);
	}

	public ApiResponse optionShowAdvancedDialog() throws ClientApiException {
		return api.callApi("ascan", "view", "optionShowAdvancedDialog", null);
	}

	public ApiResponse scan(String url, String recurse, String inscopeonly, String scanpolicyname, String method, String postdata) throws ClientApiException {
		return scan(url, recurse, inscopeonly, scanpolicyname, method, postdata, (Integer) null);
	}
	
	/**
	 * Runs the active scanner against the given URL and/or Context. Optionally, the 'recurse' parameter can be used to scan URLs under the given URL, the parameter 'inScopeOnly' can be used to constrain the scan to URLs that are in scope (ignored if a Context is specified), the parameter 'scanPolicyName' allows to specify the scan policy (if none is given it uses the default scan policy), the parameters 'method' and 'postData' allow to select a given request in conjunction with the given URL.
	 */
	public ApiResponse scan(String url, String recurse, String inscopeonly, String scanpolicyname, String method, String postdata, Integer contextid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (url != null) {
			map.put("url", url);
		}
		if (recurse != null) {
			map.put("recurse", recurse);
		}
		if (inscopeonly != null) {
			map.put("inScopeOnly", inscopeonly);
		}
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		if (method != null) {
			map.put("method", method);
		}
		if (postdata != null) {
			map.put("postData", postdata);
		}
		if (contextid != null) {
			map.put("contextId", contextid.toString());
		}
		return api.callApi("ascan", "action", "scan", map);
	}

	/**
	 * Active Scans from the perspective of a User, obtained using the given Context ID and User ID. See 'scan' action for more details.
	 */
	public ApiResponse scanAsUser(String url, String contextid, String userid, String recurse, String scanpolicyname, String method, String postdata) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (url != null) {
			map.put("url", url);
		}
		if (contextid != null) {
			map.put("contextId", contextid);
		}
		if (userid != null) {
			map.put("userId", userid);
		}
		if (recurse != null) {
			map.put("recurse", recurse);
		}
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		if (method != null) {
			map.put("method", method);
		}
		if (postdata != null) {
			map.put("postData", postdata);
		}
		return api.callApi("ascan", "action", "scanAsUser", map);
	}

	public ApiResponse pause(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("ascan", "action", "pause", map);
	}

	public ApiResponse resume(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("ascan", "action", "resume", map);
	}

	public ApiResponse stop(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("ascan", "action", "stop", map);
	}

	public ApiResponse removeScan(String scanid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		return api.callApi("ascan", "action", "removeScan", map);
	}

	public ApiResponse pauseAllScans() throws ClientApiException {
		return api.callApi("ascan", "action", "pauseAllScans", null);
	}

	public ApiResponse resumeAllScans() throws ClientApiException {
		return api.callApi("ascan", "action", "resumeAllScans", null);
	}

	public ApiResponse stopAllScans() throws ClientApiException {
		return api.callApi("ascan", "action", "stopAllScans", null);
	}

	public ApiResponse removeAllScans() throws ClientApiException {
		return api.callApi("ascan", "action", "removeAllScans", null);
	}

	/**
	 * Clears the regexes of URLs excluded from the active scans.
	 */
	public ApiResponse clearExcludedFromScan() throws ClientApiException {
		return api.callApi("ascan", "action", "clearExcludedFromScan", null);
	}

	/**
	 * Adds a regex of URLs that should be excluded from the active scans.
	 */
	public ApiResponse excludeFromScan(String regex) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("regex", regex);
		return api.callApi("ascan", "action", "excludeFromScan", map);
	}

	public ApiResponse enableAllScanners(String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "enableAllScanners", map);
	}

	public ApiResponse disableAllScanners(String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "disableAllScanners", map);
	}

	public ApiResponse enableScanners(String ids, String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("ids", ids);
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "enableScanners", map);
	}

	public ApiResponse disableScanners(String ids, String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("ids", ids);
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "disableScanners", map);
	}

	public ApiResponse setEnabledPolicies(String ids, String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("ids", ids);
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "setEnabledPolicies", map);
	}

	public ApiResponse setPolicyAttackStrength(String id, String attackstrength, String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("attackStrength", attackstrength);
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "setPolicyAttackStrength", map);
	}

	public ApiResponse setPolicyAlertThreshold(String id, String alertthreshold, String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("alertThreshold", alertthreshold);
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "setPolicyAlertThreshold", map);
	}

	public ApiResponse setScannerAttackStrength(String id, String attackstrength, String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("attackStrength", attackstrength);
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "setScannerAttackStrength", map);
	}

	public ApiResponse setScannerAlertThreshold(String id, String alertthreshold, String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("alertThreshold", alertthreshold);
		if (scanpolicyname != null) {
			map.put("scanPolicyName", scanpolicyname);
		}
		return api.callApi("ascan", "action", "setScannerAlertThreshold", map);
	}

	public ApiResponse addScanPolicy(String scanpolicyname) throws ClientApiException {
		return addScanPolicy(scanpolicyname, null, null);
	}

	public ApiResponse addScanPolicy(String scanpolicyname, String alertthreshold, String attackstrength) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanPolicyName", scanpolicyname);
		if (alertthreshold != null) {
			map.put("alertThreshold", alertthreshold);
		}
		if (attackstrength != null) {
			map.put("attackStrength", attackstrength);
		}
		return api.callApi("ascan", "action", "addScanPolicy", map);
	}

	public ApiResponse removeScanPolicy(String scanpolicyname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanPolicyName", scanpolicyname);
		return api.callApi("ascan", "action", "removeScanPolicy", map);
	}

	public ApiResponse updateScanPolicy(String scanpolicyname, String alertthreshold, String attackstrength) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanPolicyName", scanpolicyname);
		if (alertthreshold != null) {
			map.put("alertThreshold", alertthreshold);
		}
		if (attackstrength != null) {
			map.put("attackStrength", attackstrength);
		}
		return api.callApi("ascan", "action", "updateScanPolicy", map);
	}

	/**
	 * Imports a Scan Policy using the given file system path.
	 */
	public ApiResponse importScanPolicy(String path) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("path", path);
		return api.callApi("ascan", "action", "importScanPolicy", map);
	}

	/**
	 * Adds a new parameter excluded from the scan, using the specified name. Optionally sets if the new entry applies to a specific URL (default, all URLs) and sets the ID of the type of the parameter (default, ID of any type). The type IDs can be obtained with the view excludedParamTypes. 
	 */
	public ApiResponse addExcludedParam(String name, String type, String url) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		if (type != null) {
			map.put("type", type);
		}
		if (url != null) {
			map.put("url", url);
		}
		return api.callApi("ascan", "action", "addExcludedParam", map);
	}

	/**
	 * Modifies a parameter excluded from the scan. Allows to modify the name, the URL and the type of parameter. The parameter is selected with its index, which can be obtained with the view excludedParams.
	 */
	public ApiResponse modifyExcludedParam(String idx, String name, String type, String url) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		if (name != null) {
			map.put("name", name);
		}
		if (type != null) {
			map.put("type", type);
		}
		if (url != null) {
			map.put("url", url);
		}
		return api.callApi("ascan", "action", "modifyExcludedParam", map);
	}

	/**
	 * Removes a parameter excluded from the scan, with the given index. The index can be obtained with the view excludedParams.
	 */
	public ApiResponse removeExcludedParam(String idx) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("idx", idx);
		return api.callApi("ascan", "action", "removeExcludedParam", map);
	}

	/**
	 * Skips the scanner using the given IDs of the scan and the scanner.
	 */
	public ApiResponse skipScanner(String scanid, String scannerid) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scanId", scanid);
		map.put("scannerId", scannerid);
		return api.callApi("ascan", "action", "skipScanner", map);
	}

	public ApiResponse setOptionAttackPolicy(String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("String", string);
		return api.callApi("ascan", "action", "setOptionAttackPolicy", map);
	}

	public ApiResponse setOptionDefaultPolicy(String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("String", string);
		return api.callApi("ascan", "action", "setOptionDefaultPolicy", map);
	}

	public ApiResponse setOptionAllowAttackOnStart(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionAllowAttackOnStart", map);
	}

	public ApiResponse setOptionDelayInMs(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionDelayInMs", map);
	}

	public ApiResponse setOptionHandleAntiCSRFTokens(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionHandleAntiCSRFTokens", map);
	}

	public ApiResponse setOptionHostPerScan(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionHostPerScan", map);
	}

	/**
	 * Sets whether or not the active scanner should inject the HTTP request header X-ZAP-Scan-ID, with the ID of the scanner that's sending the requests.
	 */
	public ApiResponse setOptionInjectPluginIdInHeader(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionInjectPluginIdInHeader", map);
	}

	public ApiResponse setOptionMaxChartTimeInMins(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionMaxChartTimeInMins", map);
	}

	public ApiResponse setOptionMaxResultsToList(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionMaxResultsToList", map);
	}

	public ApiResponse setOptionMaxRuleDurationInMins(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionMaxRuleDurationInMins", map);
	}

	public ApiResponse setOptionMaxScanDurationInMins(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionMaxScanDurationInMins", map);
	}

	public ApiResponse setOptionMaxScansInUI(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionMaxScansInUI", map);
	}

	public ApiResponse setOptionPromptInAttackMode(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionPromptInAttackMode", map);
	}

	public ApiResponse setOptionPromptToClearFinishedScans(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionPromptToClearFinishedScans", map);
	}

	public ApiResponse setOptionRescanInAttackMode(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionRescanInAttackMode", map);
	}

	/**
	 * Sets whether or not the HTTP Headers of all requests should be scanned. Not just requests that send parameters, through the query or request body.
	 */
	public ApiResponse setOptionScanHeadersAllRequests(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionScanHeadersAllRequests", map);
	}

	public ApiResponse setOptionShowAdvancedDialog(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("ascan", "action", "setOptionShowAdvancedDialog", map);
	}

	public ApiResponse setOptionTargetParamsEnabledRPC(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionTargetParamsEnabledRPC", map);
	}

	public ApiResponse setOptionTargetParamsInjectable(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionTargetParamsInjectable", map);
	}

	public ApiResponse setOptionThreadPerHost(int i) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Integer", Integer.toString(i));
		return api.callApi("ascan", "action", "setOptionThreadPerHost", map);
	}

}
