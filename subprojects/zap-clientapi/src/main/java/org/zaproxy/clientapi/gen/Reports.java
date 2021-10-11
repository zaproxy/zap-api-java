/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2021 The ZAP Development Team
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
public class Reports {

    private final ClientApi api;

    public Reports(ClientApi api) {
        this.api = api;
    }

    /**
     * View available templates.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse templates() throws ClientApiException {
        return api.callApi("reports", "view", "templates", null);
    }

    /**
     * View details of the specified template.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse templateDetails(String template) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("template", template);
        return api.callApi("reports", "view", "templateDetails", map);
    }

    /**
     * Generate a report with the supplied parameters.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse generate(
            String title,
            String template,
            String theme,
            String description,
            String contexts,
            String sites,
            String sections,
            String includedconfidences,
            String includedrisks,
            String reportfilename,
            String reportfilenamepattern,
            String reportdir,
            String display)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("template", template);
        if (theme != null) {
            map.put("theme", theme);
        }
        if (description != null) {
            map.put("description", description);
        }
        if (contexts != null) {
            map.put("contexts", contexts);
        }
        if (sites != null) {
            map.put("sites", sites);
        }
        if (sections != null) {
            map.put("sections", sections);
        }
        if (includedconfidences != null) {
            map.put("includedConfidences", includedconfidences);
        }
        if (includedrisks != null) {
            map.put("includedRisks", includedrisks);
        }
        if (reportfilename != null) {
            map.put("reportFileName", reportfilename);
        }
        if (reportfilenamepattern != null) {
            map.put("reportFileNamePattern", reportfilenamepattern);
        }
        if (reportdir != null) {
            map.put("reportDir", reportdir);
        }
        if (display != null) {
            map.put("display", display);
        }
        return api.callApi("reports", "action", "generate", map);
    }
}
