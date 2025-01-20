/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2022 The ZAP Development Team
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
public class Exim {

    private final ClientApi api;

    public Exim(ClientApi api) {
        this.api = api;
    }

    /**
     * Imports a HAR file.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importHar(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("exim", "action", "importHar", map);
    }

    /**
     * Imports URLs (one per line) from the file with the given file system path.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importUrls(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("exim", "action", "importUrls", map);
    }

    /**
     * Imports previously exported ZAP messages from the file with the given file system path.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importZapLogs(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("exim", "action", "importZapLogs", map);
    }

    /**
     * Imports ModSecurity2 logs from the file with the given file system path.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importModsec2Logs(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("exim", "action", "importModsec2Logs", map);
    }

    /**
     * Exports the Sites Tree in the Sites Tree YAML format.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse exportSitesTree(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("exim", "action", "exportSitesTree", map);
    }

    /**
     * Prunes the Sites Tree based on a file in the Sites Tree YAML format.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse pruneSitesTree(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("exim", "action", "pruneSitesTree", map);
    }

    /**
     * Gets the HTTP messages sent through/by ZAP, in HAR format, optionally filtered by URL and
     * paginated with 'start' position and 'count' of messages
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public byte[] exportHar(String baseurl, String start, String count) throws ClientApiException {
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
        return api.callApiOther("exim", "other", "exportHar", map);
    }

    /**
     * Gets the HTTP messages with the given IDs, in HAR format.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public byte[] exportHarById(String ids) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("ids", ids);
        return api.callApiOther("exim", "other", "exportHarById", map);
    }

    /**
     * Sends the first HAR request entry, optionally following redirections. Returns, in HAR format,
     * the request sent and response received and followed redirections, if any. The Mode is
     * enforced when sending the request (and following redirections), custom manual requests are
     * not allowed in 'Safe' mode nor in 'Protected' mode if out of scope.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public byte[] sendHarRequest(String request, String followredirects) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("request", request);
        if (followredirects != null) {
            map.put("followRedirects", followredirects);
        }
        return api.callApiOther("exim", "other", "sendHarRequest", map);
    }
}
