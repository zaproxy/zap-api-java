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
package org.zaproxy.clientapi.gen.deprecated;

import java.util.HashMap;
import java.util.Map;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

/**
 * API implementation with deprecated methods, (re)moved from generated class.
 */
@SuppressWarnings("javadoc")
public class AscanDeprecated {

    private final ClientApi api;

    public AscanDeprecated(ClientApi api) {
        this.api = api;
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse scan(
            String apikey,
            String url,
            String recurse,
            String inscopeonly,
            String scanpolicyname,
            String method,
            String postdata) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("url", url);
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
        return api.callApi("ascan", "action", "scan", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse scanAsUser(
            String apikey,
            String url,
            String contextid,
            String userid,
            String recurse,
            String scanpolicyname,
            String method,
            String postdata) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("url", url);
        map.put("contextId", contextid);
        map.put("userId", userid);
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

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse pause(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanId", scanid);
        return api.callApi("ascan", "action", "pause", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse resume(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanId", scanid);
        return api.callApi("ascan", "action", "resume", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse stop(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanId", scanid);
        return api.callApi("ascan", "action", "stop", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse removeScan(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanId", scanid);
        return api.callApi("ascan", "action", "removeScan", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse pauseAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("ascan", "action", "pauseAllScans", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse resumeAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("ascan", "action", "resumeAllScans", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse stopAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("ascan", "action", "stopAllScans", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse removeAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("ascan", "action", "removeAllScans", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse clearExcludedFromScan(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("ascan", "action", "clearExcludedFromScan", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse excludeFromScan(String apikey, String regex) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("regex", regex);
        return api.callApi("ascan", "action", "excludeFromScan", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse enableAllScanners(String apikey, String scanpolicyname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "enableAllScanners", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse disableAllScanners(String apikey, String scanpolicyname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "disableAllScanners", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse enableScanners(String apikey, String ids, String scanpolicyname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("ids", ids);
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "enableScanners", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse disableScanners(String apikey, String ids, String scanpolicyname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("ids", ids);
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "disableScanners", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setEnabledPolicies(String apikey, String ids, String scanpolicyname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("ids", ids);
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "setEnabledPolicies", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setPolicyAttackStrength(String apikey, String id, String attackstrength, String scanpolicyname)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("id", id);
        map.put("attackStrength", attackstrength);
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "setPolicyAttackStrength", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setPolicyAlertThreshold(String apikey, String id, String alertthreshold, String scanpolicyname)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("id", id);
        map.put("alertThreshold", alertthreshold);
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "setPolicyAlertThreshold", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setScannerAttackStrength(String apikey, String id, String attackstrength, String scanpolicyname)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("id", id);
        map.put("attackStrength", attackstrength);
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "setScannerAttackStrength", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setScannerAlertThreshold(String apikey, String id, String alertthreshold, String scanpolicyname)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("id", id);
        map.put("alertThreshold", alertthreshold);
        if (scanpolicyname != null) {
            map.put("scanPolicyName", scanpolicyname);
        }
        return api.callApi("ascan", "action", "setScannerAlertThreshold", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse addScanPolicy(String apikey, String scanpolicyname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanPolicyName", scanpolicyname);
        return api.callApi("ascan", "action", "addScanPolicy", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse removeScanPolicy(String apikey, String scanpolicyname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanPolicyName", scanpolicyname);
        return api.callApi("ascan", "action", "removeScanPolicy", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionAttackPolicy(String apikey, String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("String", string);
        return api.callApi("ascan", "action", "setOptionAttackPolicy", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionDefaultPolicy(String apikey, String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("String", string);
        return api.callApi("ascan", "action", "setOptionDefaultPolicy", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionAllowAttackOnStart(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionAllowAttackOnStart", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionDelayInMs(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionDelayInMs", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionHandleAntiCSRFTokens(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionHandleAntiCSRFTokens", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionHostPerScan(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionHostPerScan", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionInjectPluginIdInHeader(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionInjectPluginIdInHeader", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxChartTimeInMins(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionMaxChartTimeInMins", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxResultsToList(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionMaxResultsToList", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxScansInUI(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionMaxScansInUI", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionPromptInAttackMode(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionPromptInAttackMode", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionPromptToClearFinishedScans(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionPromptToClearFinishedScans", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionRescanInAttackMode(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionRescanInAttackMode", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionScanHeadersAllRequests(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionScanHeadersAllRequests", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionShowAdvancedDialog(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ascan", "action", "setOptionShowAdvancedDialog", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionTargetParamsEnabledRPC(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionTargetParamsEnabledRPC", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionTargetParamsInjectable(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionTargetParamsInjectable", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionThreadPerHost(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ascan", "action", "setOptionThreadPerHost", map);
    }

}
