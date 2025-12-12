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
public class Postman {

    private final ClientApi api;

    public Postman(ClientApi api) {
        this.api = api;
    }

    /**
     * Imports a Postman collection from a file.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importFile(String file) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("file", file);
        return api.callApi("postman", "action", "importFile", map);
    }

    /**
     * Imports a Postman collection from a URL.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importUrl(String url) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        return api.callApi("postman", "action", "importUrl", map);
    }
}
