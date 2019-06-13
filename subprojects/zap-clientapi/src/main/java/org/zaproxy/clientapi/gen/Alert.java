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
public class Alert {

    private final ClientApi api;

    public Alert(ClientApi api) {
        this.api = api;
    }

    /**
     * Gets the alert with the given ID, the corresponding HTTP message can be obtained with the
     * 'messageId' field and 'message' API method
     */
    public ApiResponse alert(String id) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return api.callApi("alert", "view", "alert", map);
    }

    /**
     * Gets the alerts raised by ZAP, optionally filtering by URL or riskId, and paginating with
     * 'start' position and 'count' of alerts
     */
    public ApiResponse alerts(String baseurl, String start, String count, String riskid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        if (riskid != null) {
            map.put("riskId", riskid);
        }
        return api.callApi("alert", "view", "alerts", map);
    }

    /** Gets number of alerts grouped by each risk level, optionally filtering by URL */
    public ApiResponse alertsSummary(String baseurl) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        return api.callApi("alert", "view", "alertsSummary", map);
    }

    /** Gets the number of alerts, optionally filtering by URL or riskId */
    public ApiResponse numberOfAlerts(String baseurl, String riskid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (riskid != null) {
            map.put("riskId", riskid);
        }
        return api.callApi("alert", "view", "numberOfAlerts", map);
    }

    /**
     * Gets a summary of the alerts, optionally filtered by a 'url'. If 'recurse' is true then all
     * alerts that apply to urls that start with the specified 'url' will be returned, otherwise
     * only those on exactly the same 'url' (ignoring url parameters)
     */
    public ApiResponse alertsByRisk(String url, String recurse) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (url != null) {
            map.put("url", url);
        }
        if (recurse != null) {
            map.put("recurse", recurse);
        }
        return api.callApi("alert", "view", "alertsByRisk", map);
    }

    /** Gets a count of the alerts, optionally filtered as per alertsPerRisk */
    public ApiResponse alertCountsByRisk(String url, String recurse) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (url != null) {
            map.put("url", url);
        }
        if (recurse != null) {
            map.put("recurse", recurse);
        }
        return api.callApi("alert", "view", "alertCountsByRisk", map);
    }

    /** Deletes all alerts of the current session. */
    public ApiResponse deleteAllAlerts() throws ClientApiException {
        return api.callApi("alert", "action", "deleteAllAlerts", null);
    }

    /** Deletes the alert with the given ID. */
    public ApiResponse deleteAlert(String id) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return api.callApi("alert", "action", "deleteAlert", map);
    }
}
