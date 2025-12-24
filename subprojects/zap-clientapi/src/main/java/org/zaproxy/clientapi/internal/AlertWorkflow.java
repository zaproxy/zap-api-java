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

import java.io.File;
import java.util.List;
import java.util.Map;
import org.zaproxy.clientapi.core.Alert;
import org.zaproxy.clientapi.core.AlertsFile;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import org.zaproxy.clientapi.service.AlertService;

public final class AlertWorkflow {

    private AlertWorkflow() {
        // utility class
    }

    public static void checkAlerts(
            ClientApi api,
            AlertService alertService,
            List<Alert> ignoreAlerts,
            List<Alert> requireAlerts)
            throws ClientApiException {

        Map<String, List<Alert>> results =
                alertService.checkAlerts(ignoreAlerts, requireAlerts, api.alert);

        alertService.verifyAlerts(results.get("requireAlerts"), results.get("reportAlerts"));
    }

    public static void checkAlerts(
            ClientApi api,
            AlertService alertService,
            List<Alert> ignoreAlerts,
            List<Alert> requireAlerts,
            File outputFile)
            throws ClientApiException {

        Map<String, List<Alert>> results =
                alertService.checkAlerts(ignoreAlerts, requireAlerts, api.alert);

        try {
            AlertsFile.saveAlertsToFile(
                    results.get("requireAlerts"),
                    results.get("reportAlerts"),
                    results.get("ignoredAlerts"),
                    outputFile);
        } catch (Exception e) {
            throw new ClientApiException("Failed to save the alerts.", e);
        }

        int alertsFound = results.get("reportAlerts").size();
        int alertsMissing = results.get("requireAlerts").size();

        if (alertsFound > 0 || alertsMissing > 0) {
            throw new ClientApiException(
                    "Check Alerts Failed! Found=" + alertsFound + ", Missing=" + alertsMissing);
        }
    }
}
