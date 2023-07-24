/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2022 The ZAP Development Team
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
public class ReplacerDeprecated {

    private final ClientApi api;

    public ReplacerDeprecated(ClientApi api) {
        this.api = api;
    }

    /**
     * @deprecated (1.11.0) Use the method with the url.
     */
    @Deprecated
    public ApiResponse addRule(
            String description,
            String enabled,
            String matchtype,
            String matchregex,
            String matchstring,
            String replacement,
            String initiators)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("description", description);
        map.put("enabled", enabled);
        map.put("matchType", matchtype);
        map.put("matchRegex", matchregex);
        map.put("matchString", matchstring);
        if (replacement != null) {
            map.put("replacement", replacement);
        }
        if (initiators != null) {
            map.put("initiators", initiators);
        }
        return api.callApi("replacer", "action", "addRule", map);
    }
}
