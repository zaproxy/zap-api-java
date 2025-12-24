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
package org.zaproxy.clientapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.zaproxy.clientapi.core.*;

public interface AlertService {

    Map<String, List<Alert>> checkAlerts(
            List<Alert> ignoreAlerts,
            List<Alert> requireAlerts,
            org.zaproxy.clientapi.gen.Alert alert)
            throws ClientApiException;

    void verifyAlerts(List<Alert> requireAlerts, List<Alert> reportAlerts)
            throws ClientApiException;

    static List<Alert> getAlerts(
            String baseUrl, int start, int count, org.zaproxy.clientapi.gen.Alert alert)
            throws ClientApiException {
        List<Alert> alerts = new ArrayList<>();
        ApiResponse response =
                alert.alerts(baseUrl, String.valueOf(start), String.valueOf(count), null);
        if (response instanceof ApiResponseList) {
            ApiResponseList alertList = (ApiResponseList) response;
            for (ApiResponse resp : alertList.getItems()) {
                alerts.add(new Alert((ApiResponseSet) resp));
            }
        }
        return alerts;
    }
}
