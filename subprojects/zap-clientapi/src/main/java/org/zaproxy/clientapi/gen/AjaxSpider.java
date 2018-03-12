/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2016 The ZAP Development Team
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
public class AjaxSpider extends org.zaproxy.clientapi.gen.deprecated.AjaxSpiderDeprecated {

    private final ClientApi api;

    public AjaxSpider(ClientApi api) {
        super(api);
        this.api = api;
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse status() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "status", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse results(String start, String count) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApi("ajaxSpider", "view", "results", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse numberOfResults() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "numberOfResults", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse fullResults() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "fullResults", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionBrowserId() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionBrowserId", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionEventWait() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionEventWait", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionMaxCrawlDepth() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionMaxCrawlDepth", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionMaxCrawlStates() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionMaxCrawlStates", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionMaxDuration() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionMaxDuration", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionNumberOfBrowsers() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionNumberOfBrowsers", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionReloadWait() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionReloadWait", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionClickDefaultElems() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionClickDefaultElems", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionClickElemsOnce() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionClickElemsOnce", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionRandomInputs() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionRandomInputs", null);
    }

    /**
     * Runs the spider against the given URL and/or context, optionally, spidering everything in
     * scope. The parameter 'contextName' can be used to constrain the scan to a Context, the option
     * 'in scope' is ignored if a context was also specified. The parameter 'subtreeOnly' allows to
     * restrict the spider under a site's subtree (using the specified 'url').
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scan(String url, String inscope, String contextname, String subtreeonly)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (url != null) {
            map.put("url", url);
        }
        if (inscope != null) {
            map.put("inScope", inscope);
        }
        if (contextname != null) {
            map.put("contextName", contextname);
        }
        if (subtreeonly != null) {
            map.put("subtreeOnly", subtreeonly);
        }
        return api.callApi("ajaxSpider", "action", "scan", map);
    }

    /**
     * Runs the spider from the perspective of a User, obtained using the given context name and
     * user name. The parameter 'url' allows to specify the starting point for the spider, otherwise
     * it's used an existing URL from the context (if any). The parameter 'subtreeOnly' allows to
     * restrict the spider under a site's subtree (using the specified 'url').
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scanAsUser(
            String contextname, String username, String url, String subtreeonly)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("userName", username);
        if (url != null) {
            map.put("url", url);
        }
        if (subtreeonly != null) {
            map.put("subtreeOnly", subtreeonly);
        }
        return api.callApi("ajaxSpider", "action", "scanAsUser", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse stop() throws ClientApiException {
        return api.callApi("ajaxSpider", "action", "stop", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionBrowserId(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("ajaxSpider", "action", "setOptionBrowserId", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionClickDefaultElems(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionClickDefaultElems", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionClickElemsOnce(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionClickElemsOnce", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionEventWait(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionEventWait", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionMaxCrawlDepth(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxCrawlDepth", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionMaxCrawlStates(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxCrawlStates", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionMaxDuration(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxDuration", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionNumberOfBrowsers(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionNumberOfBrowsers", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionRandomInputs(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionRandomInputs", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionReloadWait(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionReloadWait", map);
    }
}
