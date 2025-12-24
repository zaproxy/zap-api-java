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

import java.io.File;
import java.util.List;
import java.util.Map;
import org.zaproxy.clientapi.core.Alert;
import org.zaproxy.clientapi.core.AlertsFile;
import org.zaproxy.clientapi.core.ClientApi;

public class ClientApiTaskService {

    private final ClientApi api;
    private final Map<String, Object> params;

    public ClientApiTaskService(ClientApi api, Map<String, Object> params) {
        this.api = api;
        this.params = params;
    }

    public void stop() throws Exception {
        api.core.shutdown();
    }

    public void checkAlerts() throws Exception {
        File alertsFile = requireFile("alertsFile");
        if (params.get("outputFile") == null) {
            api.checkAlerts(
                    AlertsFile.getAlertsFromFile(alertsFile, "ignoreAlert"),
                    AlertsFile.getAlertsFromFile(alertsFile, "requireAlert"));
        } else {
            File outFile = (File) params.get("outputFile");
            api.checkAlerts(
                    AlertsFile.getAlertsFromFile(alertsFile, "ignoreAlert"),
                    AlertsFile.getAlertsFromFile(alertsFile, "requireAlert"),
                    outFile);
        }
    }

    public void showAlerts() throws Exception {
        List<Alert> alerts = AlertService.getAlerts(null, -1, -1, null);
        for (Alert alert : alerts) {
            System.out.println(alert);
        }
    }

    public void activeScanUrl() throws Exception {
        api.ascan.scan(requireString("url"), "true", "false", "", "", "");
    }

    public void activeScanSiteInScope() throws Exception {
        api.activeScanSiteInScope(requireString("url"));
    }

    public void excludeRegexFromContext() throws Exception {
        api.context.excludeFromContext(requireString("contextName"), requireString("regex"));
    }

    public void includeRegexInContext() throws Exception {
        api.context.includeInContext(requireString("contextName"), requireString("regex"));
    }

    public void includeOneMatchingNode() throws Exception {
        api.includeOneMatchingNodeInContext(requireString("contextName"), requireString("regex"));
    }

    public void saveSession() throws Exception {
        api.core.saveSession(requireString("sessionName"), "true");
    }

    public void newSession() throws Exception {
        api.core.newSession(
                params.containsKey("sessionName") ? requireString("sessionName") : "", "true");
    }

    /* -------- helpers (Java 11 safe) -------- */

    private String requireString(String key) {
        Object v = params.get(key);
        if (v == null) {
            throw new IllegalArgumentException("Missing parameter: " + key);
        }
        return v.toString();
    }

    private File requireFile(String key) {
        Object v = params.get(key);
        if (!(v instanceof File)) {
            throw new IllegalArgumentException("Missing or invalid file: " + key);
        }
        File f = (File) v;
        if (!f.exists()) {
            throw new IllegalArgumentException("File not found: " + f.getAbsolutePath());
        }
        return f;
    }
}
