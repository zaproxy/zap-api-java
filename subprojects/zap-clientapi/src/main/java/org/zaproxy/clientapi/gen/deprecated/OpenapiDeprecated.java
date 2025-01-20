/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2021 The ZAP Development Team
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

/** API implementation with deprecated methods, (re)moved from generated class. */
@SuppressWarnings("javadoc")
public class OpenapiDeprecated {

    private final ClientApi api;

    public OpenapiDeprecated(ClientApi api) {
        this.api = api;
    }

    /**
     * Imports an Open API definition from a local file.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importFile(String file) throws ClientApiException {
        return importFile(file, null);
    }

    /**
     * Imports an OpenAPI definition from a local file.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importFile(String file, String target) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("file", file);
        if (target != null) {
            map.put("target", target);
        }
        return api.callApi("openapi", "action", "importFile", map);
    }

    /**
     * Imports an OpenAPI definition from a local file.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importFile(String file, String target, String contextid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("file", file);
        if (target != null) {
            map.put("target", target);
        }
        if (contextid != null) {
            map.put("contextId", contextid);
        }
        return api.callApi("openapi", "action", "importFile", map);
    }

    /**
     * Imports an OpenAPI definition from a URL.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importUrl(String url, String hostoverride) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        if (hostoverride != null) {
            map.put("hostOverride", hostoverride);
        }
        return api.callApi("openapi", "action", "importUrl", map);
    }

    /**
     * Imports an OpenAPI definition from a URL.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importUrl(String url, String hostoverride, String contextid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        if (hostoverride != null) {
            map.put("hostOverride", hostoverride);
        }
        if (contextid != null) {
            map.put("contextId", contextid);
        }
        return api.callApi("openapi", "action", "importUrl", map);
    }
}
