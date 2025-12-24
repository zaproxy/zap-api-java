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

import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

public final class ScanWorkflow {

    private ScanWorkflow() {
        // utility class
    }

    public static void activeScanSiteInScope(ClientApi api, String url) throws Exception {
        api.ascan.scan(url, "true", "true", "", "", "");
        waitForScanCompletion(api);
    }

    private static void waitForScanCompletion(ClientApi api) throws ClientApiException {
        int progress = 0;
        while (progress < 100) {
            progress = Integer.parseInt(((ApiResponseElement) api.ascan.status("")).getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
