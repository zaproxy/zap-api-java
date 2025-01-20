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
public class Oast {

    private final ClientApi api;

    public Oast(ClientApi api) {
        this.api = api;
    }

    /**
     * Gets the service used with the active scanner, if any.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getActiveScanService() throws ClientApiException {
        return api.callApi("oast", "view", "getActiveScanService", null);
    }

    /**
     * Gets all of the services.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getServices() throws ClientApiException {
        return api.callApi("oast", "view", "getServices", null);
    }

    /**
     * Gets the BOAST options.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getBoastOptions() throws ClientApiException {
        return api.callApi("oast", "view", "getBoastOptions", null);
    }

    /**
     * Gets the Callback options.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getCallbackOptions() throws ClientApiException {
        return api.callApi("oast", "view", "getCallbackOptions", null);
    }

    /**
     * Gets the Interactsh options.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getInteractshOptions() throws ClientApiException {
        return api.callApi("oast", "view", "getInteractshOptions", null);
    }

    /**
     * Gets the number of days the OAST records will be kept for.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getDaysToKeepRecords() throws ClientApiException {
        return api.callApi("oast", "view", "getDaysToKeepRecords", null);
    }

    /**
     * Sets the service used with the active scanner.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setActiveScanService(String name) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return api.callApi("oast", "action", "setActiveScanService", map);
    }

    /**
     * Sets the BOAST options.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setBoastOptions(String server, String pollinsecs) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("server", server);
        map.put("pollInSecs", pollinsecs);
        return api.callApi("oast", "action", "setBoastOptions", map);
    }

    /**
     * Sets the Callback options.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setCallbackOptions(String localaddress, String remoteaddress, String port)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("localAddress", localaddress);
        map.put("remoteAddress", remoteaddress);
        map.put("port", port);
        return api.callApi("oast", "action", "setCallbackOptions", map);
    }

    /**
     * Sets the Interactsh options.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setInteractshOptions(String server, String pollinsecs, String authtoken)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("server", server);
        map.put("pollInSecs", pollinsecs);
        map.put("authToken", authtoken);
        return api.callApi("oast", "action", "setInteractshOptions", map);
    }

    /**
     * Sets the number of days the OAST records will be kept for.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setDaysToKeepRecords(String days) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("days", days);
        return api.callApi("oast", "action", "setDaysToKeepRecords", map);
    }
}
