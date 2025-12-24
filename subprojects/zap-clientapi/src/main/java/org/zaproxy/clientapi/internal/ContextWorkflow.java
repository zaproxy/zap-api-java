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
package org.zaproxy.clientapi.internal;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ApiResponseList;
import org.zaproxy.clientapi.core.ClientApi;

public final class ContextWorkflow {

    private ContextWorkflow() {
        // utility class
    }

    public static void includeOneMatchingNode(ClientApi api, String contextName, String regex)
            throws Exception {

        List<String> sessionUrls = getSessionUrls(api);
        boolean foundOne = false;

        for (String sessionUrl : sessionUrls) {
            if (sessionUrl.matches(regex)) {
                if (foundOne) {
                    api.context.excludeFromContext(contextName, regex);
                } else {
                    foundOne = true;
                }
            }
        }

        if (!foundOne) {
            throw new Exception("Unexpected result: No url found matching regex " + regex);
        }
    }

    private static List<String> getSessionUrls(ClientApi api) throws Exception {
        List<String> urls = new ArrayList<>();
        ApiResponse response = api.core.urls();

        if (response instanceof ApiResponseList) {
            for (ApiResponse element : ((ApiResponseList) response).getItems()) {

                String value = ((ApiResponseElement) element).getValue();
                URL url = new URL(value);
                urls.add(url.getProtocol() + "://" + url.getHost() + url.getPath());
            }
        }
        return urls;
    }
}
