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
package org.zaproxy.clientapi.gen.deprecated;

import java.util.HashMap;
import java.util.Map;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

/** API implementation with deprecated methods, (re)moved from generated class. */
@SuppressWarnings("javadoc")
public class ContextDeprecated {

    private final ClientApi api;

    public ContextDeprecated(ClientApi api) {
        this.api = api;
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse excludeFromContext(String apikey, String contextname, String regex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        map.put("regex", regex);
        return api.callApi("context", "action", "excludeFromContext", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse includeInContext(String apikey, String contextname, String regex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        map.put("regex", regex);
        return api.callApi("context", "action", "includeInContext", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse newContext(String apikey, String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        return api.callApi("context", "action", "newContext", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse removeContext(String apikey, String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        return api.callApi("context", "action", "removeContext", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse exportContext(String apikey, String contextname, String contextfile)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        map.put("contextFile", contextfile);
        return api.callApi("context", "action", "exportContext", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse importContext(String apikey, String contextfile) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextFile", contextfile);
        return api.callApi("context", "action", "importContext", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse includeContextTechnologies(
            String apikey, String contextname, String technologynames) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        map.put("technologyNames", technologynames);
        return api.callApi("context", "action", "includeContextTechnologies", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse includeAllContextTechnologies(String apikey, String contextname)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        return api.callApi("context", "action", "includeAllContextTechnologies", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse excludeContextTechnologies(
            String apikey, String contextname, String technologynames) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        map.put("technologyNames", technologynames);
        return api.callApi("context", "action", "excludeContextTechnologies", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse excludeAllContextTechnologies(String apikey, String contextname)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        return api.callApi("context", "action", "excludeAllContextTechnologies", map);
    }

    /**
     * @deprecated (1.1.0) Use the method without the API key and use one of the {@code ClientApi}
     *     constructors that allow to set the API key (e.g. {@link ClientApi#ClientApi(String, int,
     *     String)}).
     */
    @Deprecated
    public ApiResponse setContextInScope(String apikey, String contextname, String booleaninscope)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("contextName", contextname);
        map.put("booleanInScope", booleaninscope);
        return api.callApi("context", "action", "setContextInScope", map);
    }
}
