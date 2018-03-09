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
public class AjaxSpiderDeprecated {

    private final ClientApi api;

    public AjaxSpiderDeprecated(ClientApi api) {
        this.api = api;
    }

    /**
     * This component is optional and therefore the API will only work if it is installed.
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse scan(String apikey, String url, String inscope) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        if (url != null) {
            map.put("url", url);
        }
        if (inscope != null) {
            map.put("inScope", inscope);
        }
        return api.callApi("ajaxSpider", "action", "scan", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse stop(String apikey) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        return api.callApi("ajaxSpider", "action", "stop", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionBrowserId(String apikey, String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("String", string);
        return api.callApi("ajaxSpider", "action", "setOptionBrowserId", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionClickDefaultElems(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionClickDefaultElems", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionClickElemsOnce(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionClickElemsOnce", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionEventWait(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionEventWait", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxCrawlDepth(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxCrawlDepth", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxCrawlStates(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxCrawlStates", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionMaxDuration(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxDuration", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionNumberOfBrowsers(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionNumberOfBrowsers", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionRandomInputs(String apikey, boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionRandomInputs", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     * 
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public ApiResponse setOptionReloadWait(String apikey, int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionReloadWait", map);
    }
}
