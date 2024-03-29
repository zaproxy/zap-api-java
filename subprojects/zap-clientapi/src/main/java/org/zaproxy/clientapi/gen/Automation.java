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
public class Automation {

    private final ClientApi api;

    public Automation(ClientApi api) {
        this.api = api;
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse planProgress(String planid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("planId", planid);
        return api.callApi("automation", "view", "planProgress", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse runPlan(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("automation", "action", "runPlan", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse endDelayJob() throws ClientApiException {
        return api.callApi("automation", "action", "endDelayJob", null);
    }
}
