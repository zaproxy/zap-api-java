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
public class SpiderDeprecated {

    private final ClientApi api;

    public SpiderDeprecated(ClientApi api) {
        this.api = api;
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse scan(
            String apikey,
            String url,
            String maxchildren,
            String recurse,
            String contextname,
            String subtreeonly) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
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
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse scanAsUser(
            String apikey,
            String contextid,
            String userid,
            String url,
            String maxchildren,
            String recurse,
            String subtreeonly) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
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

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse pause(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanId", scanid);
        return api.callApi("spider", "action", "pause", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse resume(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanId", scanid);
        return api.callApi("spider", "action", "resume", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse stop(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        if (scanid != null) {
            map.put("scanId", scanid);
        }
        return api.callApi("spider", "action", "stop", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse removeScan(String apikey, String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("scanId", scanid);
        return api.callApi("spider", "action", "removeScan", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse pauseAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("spider", "action", "pauseAllScans", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse resumeAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("spider", "action", "resumeAllScans", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse stopAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("spider", "action", "stopAllScans", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse removeAllScans(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("spider", "action", "removeAllScans", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse clearExcludedFromScan(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("spider", "action", "clearExcludedFromScan", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse excludeFromScan(String apikey, String regex) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("regex", regex);
        return api.callApi("spider", "action", "excludeFromScan", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionHandleParameters(String apikey, String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("String", string);
        return api.callApi("spider", "action", "setOptionHandleParameters", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionScopeString(String apikey, String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("String", string);
        return api.callApi("spider", "action", "setOptionScopeString", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionSkipURLString(String apikey, String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("String", string);
        return api.callApi("spider", "action", "setOptionSkipURLString", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionUserAgent(String apikey, String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("String", string);
        return api.callApi("spider", "action", "setOptionUserAgent", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionHandleODataParametersVisited(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionHandleODataParametersVisited", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxDepth(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxDepth", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxDuration(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxDuration", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxScansInUI(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxScansInUI", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionParseComments(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseComments", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionParseGit(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseGit", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionParseRobotsTxt(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseRobotsTxt", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionParseSVNEntries(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseSVNEntries", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionParseSitemapXml(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseSitemapXml", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionPostForm(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionPostForm", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionProcessForm(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionProcessForm", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionRequestWaitTime(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionRequestWaitTime", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionSendRefererHeader(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionSendRefererHeader", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionShowAdvancedDialog(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionShowAdvancedDialog", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionThreadCount(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionThreadCount", map);
    }

}
