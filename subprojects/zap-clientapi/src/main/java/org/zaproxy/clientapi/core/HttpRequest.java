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
package org.zaproxy.clientapi.core;

/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * Licensed under the Apache License, Version 2.0
 */

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple immutable HTTP request representation used internally by the Client API.
 *
 * <p>This class intentionally contains no networking logic.
 */
public final class HttpRequest {

    public static final String GET_METHOD = "GET";

    private final String method;
    private final URL requestUri;
    private final Map<String, String> headers;
    private final String body;

    public HttpRequest(String method, URL requestUri, String body) {
        this.method = method;
        this.requestUri = requestUri;
        this.body = body;
        this.headers = new HashMap<>();
    }

    public String getMethod() {
        return method;
    }

    public URL getRequestUri() {
        return requestUri;
    }

    public String getBody() {
        return body;
    }

    /**
     * Adds or replaces a request header.
     *
     * @param name header name
     * @param value header value
     */
    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    /**
     * Returns an unmodifiable view of the request headers.
     *
     * @return headers map
     */
    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }
}
