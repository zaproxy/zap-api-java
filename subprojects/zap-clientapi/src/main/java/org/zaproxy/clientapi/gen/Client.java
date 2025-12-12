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
public class Client {

    private final ClientApi api;

    public Client(ClientApi api) {
        this.api = api;
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse reportObject(String objectjson) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("objectJson", objectjson);
        return api.callApi("client", "action", "reportObject", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse reportEvent(String eventjson) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("eventJson", eventjson);
        return api.callApi("client", "action", "reportEvent", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse reportZestStatement(String statementjson) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("statementJson", statementjson);
        return api.callApi("client", "action", "reportZestStatement", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse reportZestScript(String scriptjson) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("scriptJson", scriptjson);
        return api.callApi("client", "action", "reportZestScript", map);
    }

    /**
     * Exports the Client Map to a file.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse exportClientMap(String pathyaml) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("pathYaml", pathyaml);
        return api.callApi("client", "action", "exportClientMap", map);
    }
}
