/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2020 The ZAP Development Team
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
public class AccessControl {

    private final ClientApi api;

    public AccessControl(ClientApi api) {
        this.api = api;
    }

    /**
     * Gets the Access Control scan progress (percentage integer) for the given context ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getScanProgress(String contextid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        return api.callApi("accessControl", "view", "getScanProgress", map);
    }

    /**
     * Gets the Access Control scan status (description string) for the given context ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getScanStatus(String contextid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        return api.callApi("accessControl", "view", "getScanStatus", map);
    }

    /**
     * Starts an Access Control scan with the given context ID and user ID. (Optional parameters:
     * user ID for Unauthenticated user, boolean identifying whether or not Alerts are raised, and
     * the Risk level for the Alerts.) [This assumes the Access Control rules were previously
     * established via ZAP gui and the necessary Context exported/imported.]
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scan(
            String contextid,
            String userid,
            String scanasunauthuser,
            String raisealert,
            String alertrisklevel)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        if (scanasunauthuser != null) {
            map.put("scanAsUnAuthUser", scanasunauthuser);
        }
        if (raisealert != null) {
            map.put("raiseAlert", raisealert);
        }
        if (alertrisklevel != null) {
            map.put("alertRiskLevel", alertrisklevel);
        }
        return api.callApi("accessControl", "action", "scan", map);
    }

    /**
     * Generates an Access Control report for the given context ID and saves it based on the
     * provided filename (path).
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse writeHTMLreport(String contextid, String filename)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("fileName", filename);
        return api.callApi("accessControl", "action", "writeHTMLreport", map);
    }
}
