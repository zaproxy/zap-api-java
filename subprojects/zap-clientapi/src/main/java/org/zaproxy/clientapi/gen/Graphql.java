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
public class Graphql {

    private final ClientApi api;

    public Graphql(ClientApi api) {
        this.api = api;
    }

    /**
     * Returns how arguments are currently specified.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionArgsType() throws ClientApiException {
        return api.callApi("graphql", "view", "optionArgsType", null);
    }

    /**
     * Returns the current maximum arguments generation depth.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxArgsDepth() throws ClientApiException {
        return api.callApi("graphql", "view", "optionMaxArgsDepth", null);
    }

    /**
     * Returns the current maximum query generation depth.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxQueryDepth() throws ClientApiException {
        return api.callApi("graphql", "view", "optionMaxQueryDepth", null);
    }

    /**
     * Returns whether or not optional arguments are currently specified.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionOptionalArgsEnabled() throws ClientApiException {
        return api.callApi("graphql", "view", "optionOptionalArgsEnabled", null);
    }

    /**
     * Returns the current level for which a single query is generated.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionQuerySplitType() throws ClientApiException {
        return api.callApi("graphql", "view", "optionQuerySplitType", null);
    }

    /**
     * Returns the current request method.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionRequestMethod() throws ClientApiException {
        return api.callApi("graphql", "view", "optionRequestMethod", null);
    }

    /**
     * Imports a GraphQL Schema from a File.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importFile(String endurl, String file) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("endurl", endurl);
        map.put("file", file);
        return api.callApi("graphql", "action", "importFile", map);
    }

    /**
     * Imports a GraphQL Schema from a URL.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importUrl(String endurl, String url) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("endurl", endurl);
        if (url != null) {
            map.put("url", url);
        }
        return api.callApi("graphql", "action", "importUrl", map);
    }

    /**
     * Sets how arguments are specified.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionArgsType(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("graphql", "action", "setOptionArgsType", map);
    }

    /**
     * Sets the level for which a single query is generated.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionQuerySplitType(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("graphql", "action", "setOptionQuerySplitType", map);
    }

    /**
     * Sets the request method.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionRequestMethod(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("graphql", "action", "setOptionRequestMethod", map);
    }

    /**
     * Sets the maximum arguments generation depth.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxArgsDepth(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("graphql", "action", "setOptionMaxArgsDepth", map);
    }

    /**
     * Sets the maximum query generation depth.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxQueryDepth(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("graphql", "action", "setOptionMaxQueryDepth", map);
    }

    /**
     * Sets whether or not Optional Arguments should be specified.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionOptionalArgsEnabled(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("graphql", "action", "setOptionOptionalArgsEnabled", map);
    }
}
