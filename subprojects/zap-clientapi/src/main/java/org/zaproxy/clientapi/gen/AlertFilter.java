/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2016 The ZAP Development Team
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
public class AlertFilter {

    private final ClientApi api;

    public AlertFilter(ClientApi api) {
        this.api = api;
    }

    /**
     * Lists the alert filters of the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse alertFilterList(String contextid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        return api.callApi("alertFilter", "view", "alertFilterList", map);
    }

    /**
     * Lists the global alert filters.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse globalAlertFilterList() throws ClientApiException {
        return api.callApi("alertFilter", "view", "globalAlertFilterList", null);
    }
    /**
     * Adds a new alert filter for the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled)
            throws ClientApiException {
        return addAlertFilter(
                contextid,
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * Adds a new alert filter for the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("ruleId", ruleid);
        map.put("newLevel", newlevel);
        if (url != null) {
            map.put("url", url);
        }
        if (urlisregex != null) {
            map.put("urlIsRegex", urlisregex);
        }
        if (parameter != null) {
            map.put("parameter", parameter);
        }
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        if (parameterisregex != null) {
            map.put("parameterIsRegex", parameterisregex);
        }
        if (attack != null) {
            map.put("attack", attack);
        }
        if (attackisregex != null) {
            map.put("attackIsRegex", attackisregex);
        }
        if (evidence != null) {
            map.put("evidence", evidence);
        }
        if (evidenceisregex != null) {
            map.put("evidenceIsRegex", evidenceisregex);
        }
        return api.callApi("alertFilter", "action", "addAlertFilter", map);
    }

    /**
     * Removes an alert filter from the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled)
            throws ClientApiException {
        return removeAlertFilter(
                contextid,
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * Removes an alert filter from the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("ruleId", ruleid);
        map.put("newLevel", newlevel);
        if (url != null) {
            map.put("url", url);
        }
        if (urlisregex != null) {
            map.put("urlIsRegex", urlisregex);
        }
        if (parameter != null) {
            map.put("parameter", parameter);
        }
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        if (parameterisregex != null) {
            map.put("parameterIsRegex", parameterisregex);
        }
        if (attack != null) {
            map.put("attack", attack);
        }
        if (attackisregex != null) {
            map.put("attackIsRegex", attackisregex);
        }
        if (evidence != null) {
            map.put("evidence", evidence);
        }
        if (evidenceisregex != null) {
            map.put("evidenceIsRegex", evidenceisregex);
        }
        return api.callApi("alertFilter", "action", "removeAlertFilter", map);
    }

    /**
     * Adds a new global alert filter.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addGlobalAlertFilter(
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("ruleId", ruleid);
        map.put("newLevel", newlevel);
        if (url != null) {
            map.put("url", url);
        }
        if (urlisregex != null) {
            map.put("urlIsRegex", urlisregex);
        }
        if (parameter != null) {
            map.put("parameter", parameter);
        }
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        if (parameterisregex != null) {
            map.put("parameterIsRegex", parameterisregex);
        }
        if (attack != null) {
            map.put("attack", attack);
        }
        if (attackisregex != null) {
            map.put("attackIsRegex", attackisregex);
        }
        if (evidence != null) {
            map.put("evidence", evidence);
        }
        if (evidenceisregex != null) {
            map.put("evidenceIsRegex", evidenceisregex);
        }
        return api.callApi("alertFilter", "action", "addGlobalAlertFilter", map);
    }

    /**
     * Removes a global alert filter.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeGlobalAlertFilter(
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("ruleId", ruleid);
        map.put("newLevel", newlevel);
        if (url != null) {
            map.put("url", url);
        }
        if (urlisregex != null) {
            map.put("urlIsRegex", urlisregex);
        }
        if (parameter != null) {
            map.put("parameter", parameter);
        }
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        if (parameterisregex != null) {
            map.put("parameterIsRegex", parameterisregex);
        }
        if (attack != null) {
            map.put("attack", attack);
        }
        if (attackisregex != null) {
            map.put("attackIsRegex", attackisregex);
        }
        if (evidence != null) {
            map.put("evidence", evidence);
        }
        if (evidenceisregex != null) {
            map.put("evidenceIsRegex", evidenceisregex);
        }
        return api.callApi("alertFilter", "action", "removeGlobalAlertFilter", map);
    }
}
