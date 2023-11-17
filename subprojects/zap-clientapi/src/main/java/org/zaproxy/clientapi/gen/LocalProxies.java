/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2019 The ZAP Development Team
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

/**
 * This file was automatically generated.
 *
 * @deprecated Use {@link Network} instead.
 */
@SuppressWarnings("javadoc")
@Deprecated(since = "1.11.0", forRemoval = true)
public class LocalProxies {

    private final ClientApi api;

    public LocalProxies(ClientApi api) {
        this.api = api;
    }

    /** Gets all of the additional proxies that have been configured. */
    public ApiResponse additionalProxies() throws ClientApiException {
        return api.callApi("localProxies", "view", "additionalProxies", null);
    }

    /** Adds an new proxy using the details supplied. */
    public ApiResponse addAdditionalProxy(
            String address,
            String port,
            String behindnat,
            String alwaysdecodezip,
            String removeunsupportedencodings)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("address", address);
        map.put("port", port);
        if (behindnat != null) {
            map.put("behindNat", behindnat);
        }
        if (alwaysdecodezip != null) {
            map.put("alwaysDecodeZip", alwaysdecodezip);
        }
        if (removeunsupportedencodings != null) {
            map.put("removeUnsupportedEncodings", removeunsupportedencodings);
        }
        return api.callApi("localProxies", "action", "addAdditionalProxy", map);
    }

    /** Removes the additional proxy with the specified address and port. */
    public ApiResponse removeAdditionalProxy(String address, String port)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("address", address);
        map.put("port", port);
        return api.callApi("localProxies", "action", "removeAdditionalProxy", map);
    }
}
