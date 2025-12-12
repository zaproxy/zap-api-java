/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2025 The ZAP Development Team
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
public class ClientSpider {

    private final ClientApi api;

    public ClientSpider(ClientApi api) {
        this.api = api;
    }

    /**
     * Gets the status of a client spider scan.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse status(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("scanId", scanid);
        return api.callApi("clientSpider", "view", "status", map);
    }

    /**
     * Starts a client spider scan.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scan(
            String browser,
            String url,
            String contextname,
            String username,
            String subtreeonly,
            String maxcrawldepth,
            String pageloadtime,
            String numberofbrowsers,
            String scopecheck)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (browser != null) {
            map.put("browser", browser);
        }
        if (url != null) {
            map.put("url", url);
        }
        if (contextname != null) {
            map.put("contextName", contextname);
        }
        if (username != null) {
            map.put("userName", username);
        }
        if (subtreeonly != null) {
            map.put("subtreeOnly", subtreeonly);
        }
        if (maxcrawldepth != null) {
            map.put("maxCrawlDepth", maxcrawldepth);
        }
        if (pageloadtime != null) {
            map.put("pageLoadTime", pageloadtime);
        }
        if (numberofbrowsers != null) {
            map.put("numberOfBrowsers", numberofbrowsers);
        }
        if (scopecheck != null) {
            map.put("scopeCheck", scopecheck);
        }
        return api.callApi("clientSpider", "action", "scan", map);
    }

    /**
     * Stops a client spider scan.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse stop(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("scanId", scanid);
        return api.callApi("clientSpider", "action", "stop", map);
    }
}
