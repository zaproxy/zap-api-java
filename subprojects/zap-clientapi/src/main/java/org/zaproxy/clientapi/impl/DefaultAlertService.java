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
package org.zaproxy.clientapi.impl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zaproxy.clientapi.core.*;
import org.zaproxy.clientapi.service.AlertService;

public final class DefaultAlertService implements AlertService {
    private static final boolean DEBUG = false;
    private static final PrintStream DEBUG_STREAM = System.out;

    @SuppressWarnings("UnusedVariable")
    private final org.zaproxy.clientapi.gen.Alert api;

    public DefaultAlertService(org.zaproxy.clientapi.gen.Alert api) {
        this.api = api;
    }

    @Override
    public Map<String, List<Alert>> checkAlerts(
            List<Alert> ignoreAlerts,
            List<Alert> requireAlerts,
            org.zaproxy.clientapi.gen.Alert alert)
            throws ClientApiException {
        List<Alert> reportAlerts = new ArrayList<>();
        List<Alert> ignoredAlerts = new ArrayList<>();
        List<Alert> alerts = AlertService.getAlerts(null, -1, -1, alert);
        for (Alert alertCore : alerts) {
            boolean ignore = false;
            if (ignoreAlerts != null) {
                for (Alert ignoreAlert : ignoreAlerts) {
                    if (alertCore.matches(ignoreAlert)) {
                        if (DEBUG) {
                            DEBUG_STREAM.println("Ignoring alert " + ignoreAlert);
                        }
                        ignoredAlerts.add(alertCore);
                        ignore = true;
                        break;
                    }
                }
            }
            if (!ignore) {
                reportAlerts.add(alertCore);
            }
            if (requireAlerts != null) {
                for (Alert requireAlert : requireAlerts) {
                    if (alertCore.matches(requireAlert)) {
                        if (DEBUG) {
                            DEBUG_STREAM.println("Found alert " + alert);
                        }
                        requireAlerts.remove(requireAlert);
                        // Remove it from the not-ignored list as well
                        reportAlerts.remove(alertCore);
                        break;
                    }
                }
            }
        }
        HashMap<String, List<Alert>> results = new HashMap<>();
        results.put("reportAlerts", reportAlerts);
        results.put("requireAlerts", requireAlerts);
        results.put("ignoredAlerts", ignoredAlerts);
        return results;
    }

    @Override
    public void verifyAlerts(List<Alert> requireAlerts, List<Alert> reportAlerts)
            throws ClientApiException {
        StringBuilder sb = new StringBuilder();
        if (!reportAlerts.isEmpty()) {
            sb.append("Found ").append(reportAlerts.size()).append(" alerts\n");
            for (Alert alert : reportAlerts) {
                sb.append('\t');
                sb.append(alert.toString());
                sb.append('\n');
            }
        }
        if (requireAlerts != null && !requireAlerts.isEmpty()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Not found ").append(requireAlerts.size()).append(" alerts\n");
            for (Alert alert : requireAlerts) {
                sb.append('\t');
                sb.append(alert.toString());
                sb.append('\n');
            }
        }
        if (sb.length() > 0) {
            if (DEBUG) {
                DEBUG_STREAM.println("Failed: " + sb.toString());
            }
            throw new ClientApiException(sb.toString());
        }
    }
}
