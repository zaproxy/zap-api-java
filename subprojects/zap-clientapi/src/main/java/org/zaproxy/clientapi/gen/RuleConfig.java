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

/** This file was automatically generated. */
@SuppressWarnings("javadoc")
public class RuleConfig {

    private final ClientApi api;

    public RuleConfig(ClientApi api) {
        this.api = api;
    }

    /** Show the specified rule configuration */
    public ApiResponse ruleConfigValue(String key) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        return api.callApi("ruleConfig", "view", "ruleConfigValue", map);
    }

    /** Show all of the rule configurations */
    public ApiResponse allRuleConfigs() throws ClientApiException {
        return api.callApi("ruleConfig", "view", "allRuleConfigs", null);
    }

    /** Reset the specified rule configuration, which must already exist */
    public ApiResponse resetRuleConfigValue(String key) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        return api.callApi("ruleConfig", "action", "resetRuleConfigValue", map);
    }

    /** Reset all of the rule configurations */
    public ApiResponse resetAllRuleConfigValues() throws ClientApiException {
        return api.callApi("ruleConfig", "action", "resetAllRuleConfigValues", null);
    }

    /** Set the specified rule configuration, which must already exist */
    public ApiResponse setRuleConfigValue(String key, String value) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        if (value != null) {
            map.put("value", value);
        }
        return api.callApi("ruleConfig", "action", "setRuleConfigValue", map);
    }
}
