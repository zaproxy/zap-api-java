/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2017 The ZAP Development Team
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
public class Replacer {

    private final ClientApi api;

    public Replacer(ClientApi api) {
        this.api = api;
    }

    /**
     * Returns full details of all of the rules
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse rules() throws ClientApiException {
        return api.callApi("replacer", "view", "rules", null);
    }

    /**
     * Adds a replacer rule. For the parameters: desc is a user friendly description, enabled is
     * true or false, matchType is one of [REQ_HEADER, REQ_HEADER_STR, REQ_BODY_STR, RESP_HEADER,
     * RESP_HEADER_STR, RESP_BODY_STR], matchRegex should be true if the matchString should be
     * treated as a regex otherwise false, matchString is the string that will be matched against,
     * replacement is the replacement string, initiators may be blank (for all initiators) or a
     * comma separated list of integers as defined in <a
     * href="https://github.com/zaproxy/zaproxy/blob/develop/src/org/parosproxy/paros/network/HttpSender.java">HttpSender</a>
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
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
        map.put("replacement", replacement);
        if (initiators != null) {
            map.put("initiators", initiators);
        }
        return api.callApi("replacer", "action", "addRule", map);
    }

    /**
     * Removes the rule with the given description
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeRule(String description) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("description", description);
        return api.callApi("replacer", "action", "removeRule", map);
    }

    /**
     * Enables or disables the rule with the given description based on the bool parameter
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setEnabled(String description, String bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("description", description);
        map.put("bool", bool);
        return api.callApi("replacer", "action", "setEnabled", map);
    }
}
