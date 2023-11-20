/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2023 The ZAP Development Team
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
public class Custompayloads {

    private final ClientApi api;

    public Custompayloads(ClientApi api) {
        this.api = api;
    }

    /**
     * Lists all available categories.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse customPayloadsCategories() throws ClientApiException {
        return api.callApi("custompayloads", "view", "customPayloadsCategories", null);
    }

    /**
     * Lists all the payloads currently loaded (category, payload, enabled state). Optionally
     * filtered by category.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse customPayloads(String category) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (category != null) {
            map.put("category", category);
        }
        return api.callApi("custompayloads", "view", "customPayloads", map);
    }

    /**
     * Disables payloads for a given category.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse disableCustomPayloads(String category) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (category != null) {
            map.put("category", category);
        }
        return api.callApi("custompayloads", "action", "disableCustomPayloads", map);
    }

    /**
     * Enables payloads for a given category.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse enableCustomPayloads(String category) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (category != null) {
            map.put("category", category);
        }
        return api.callApi("custompayloads", "action", "enableCustomPayloads", map);
    }

    /**
     * Removes a payload.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeCustomPayload(String category, String payload)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("category", category);
        if (payload != null) {
            map.put("payload", payload);
        }
        return api.callApi("custompayloads", "action", "removeCustomPayload", map);
    }

    /**
     * Adds a new payload.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addCustomPayload(String category, String payload) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("category", category);
        if (payload != null) {
            map.put("payload", payload);
        }
        return api.callApi("custompayloads", "action", "addCustomPayload", map);
    }

    /**
     * Enables a given payload.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse enableCustomPayload(String category, String payload)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("category", category);
        if (payload != null) {
            map.put("payload", payload);
        }
        return api.callApi("custompayloads", "action", "enableCustomPayload", map);
    }

    /**
     * Disables a given payload.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse disableCustomPayload(String category, String payload)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("category", category);
        if (payload != null) {
            map.put("payload", payload);
        }
        return api.callApi("custompayloads", "action", "disableCustomPayload", map);
    }
}
