/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2017 The ZAP Development Team
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
public class Break extends org.zaproxy.clientapi.gen.deprecated.BreakDeprecated {

    private final ClientApi api;

    public Break(ClientApi api) {
        super(api);
        this.api = api;
    }

    /** Returns True if ZAP will break on both requests and responses */
    public ApiResponse isBreakAll() throws ClientApiException {
        return api.callApi("break", "view", "isBreakAll", null);
    }

    /** Returns True if ZAP will break on requests */
    public ApiResponse isBreakRequest() throws ClientApiException {
        return api.callApi("break", "view", "isBreakRequest", null);
    }

    /** Returns True if ZAP will break on responses */
    public ApiResponse isBreakResponse() throws ClientApiException {
        return api.callApi("break", "view", "isBreakResponse", null);
    }

    /** Returns the HTTP message currently intercepted (if any) */
    public ApiResponse httpMessage() throws ClientApiException {
        return api.callApi("break", "view", "httpMessage", null);
    }

    /**
     * Controls the global break functionality. The type may be one of: http-all, http-request or
     * http-response. The state may be true (for turning break on for the specified type) or false
     * (for turning break off). Scope is not currently used.
     */
    public ApiResponse brk(String type, String state, String scope) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("state", state);
        if (scope != null) {
            map.put("scope", scope);
        }
        return api.callApi("break", "action", "break", map);
    }

    /** Overwrites the currently intercepted message with the data provided */
    public ApiResponse setHttpMessage(String httpheader, String httpbody)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("httpHeader", httpheader);
        if (httpbody != null) {
            map.put("httpBody", httpbody);
        }
        return api.callApi("break", "action", "setHttpMessage", map);
    }

    /**
     * Submits the currently intercepted message and unsets the global request/response break points
     */
    public ApiResponse cont() throws ClientApiException {
        return api.callApi("break", "action", "continue", null);
    }

    /**
     * Submits the currently intercepted message, the next request or response will automatically be
     * intercepted
     */
    public ApiResponse step() throws ClientApiException {
        return api.callApi("break", "action", "step", null);
    }

    /** Drops the currently intercepted message */
    public ApiResponse drop() throws ClientApiException {
        return api.callApi("break", "action", "drop", null);
    }

    /**
     * Adds a custom HTTP breakpont. The string is the string to match. Location may be one of: url,
     * request_header, request_body, response_header or response_body. Match may be: contains or
     * regex. Inverse (match) may be true or false. Lastly, ignorecase (when matching the string)
     * may be true or false.
     */
    public ApiResponse addHttpBreakpoint(
            String string, String location, String match, String inverse, String ignorecase)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("string", string);
        map.put("location", location);
        map.put("match", match);
        map.put("inverse", inverse);
        map.put("ignorecase", ignorecase);
        return api.callApi("break", "action", "addHttpBreakpoint", map);
    }

    /** Removes the specified break point */
    public ApiResponse removeHttpBreakpoint(
            String string, String location, String match, String inverse, String ignorecase)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("string", string);
        map.put("location", location);
        map.put("match", match);
        map.put("inverse", inverse);
        map.put("ignorecase", ignorecase);
        return api.callApi("break", "action", "removeHttpBreakpoint", map);
    }
}
