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
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2011 The ZAP Development Team
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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Builds HTTP requests for the ZAP API.
 *
 * <p>This class is responsible only for request construction (URL, query parameters, body,
 * headers).
 *
 * <p>No networking or I/O is performed here.
 */
final class ZapRequestBuilder {

    private static final String ZAP_API_HOST = "http://zap/";

    private ZapRequestBuilder() {
        // utility class
    }

    static HttpRequest buildZapRequest(
            String requestMethod,
            String format,
            String component,
            String type,
            String method,
            Map<String, String> params,
            String apiKey)
            throws MalformedURLException, URISyntaxException {

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder
                .append(ZAP_API_HOST)
                .append(format)
                .append('/')
                .append(component)
                .append('/')
                .append(type)
                .append('/')
                .append(method)
                .append('/');

        String body = null;

        if (params != null && !params.isEmpty()) {
            if (HttpRequest.GET_METHOD.equals(requestMethod)) {
                urlBuilder.append('?');
                appendParams(params, urlBuilder);
            } else {
                body = appendParams(params, new StringBuilder()).toString();
            }
        }

        HttpRequest request =
                new HttpRequest(requestMethod, createUrl(urlBuilder.toString()), body);

        if (apiKey != null && !apiKey.isEmpty()) {
            request.addHeader("X-ZAP-API-Key", apiKey);
        }

        return request;
    }

    private static URL createUrl(String value) throws MalformedURLException, URISyntaxException {
        return new URI(value).toURL();
    }

    private static StringBuilder appendParams(Map<String, String> params, StringBuilder sb) {

        for (Map.Entry<String, String> p : params.entrySet()) {
            sb.append(encode(p.getKey())).append('=');
            if (p.getValue() != null) {
                sb.append(encode(p.getValue()));
            }
            sb.append('&');
        }
        return sb;
    }

    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}
