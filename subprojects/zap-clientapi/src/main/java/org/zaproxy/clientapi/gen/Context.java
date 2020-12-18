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
public class Context extends org.zaproxy.clientapi.gen.deprecated.ContextDeprecated {

    private final ClientApi api;

    public Context(ClientApi api) {
        super(api);
        this.api = api;
    }

    /** List context names of current session */
    public ApiResponse contextList() throws ClientApiException {
        return api.callApi("context", "view", "contextList", null);
    }

    /** List excluded regexs for context */
    public ApiResponse excludeRegexs(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "view", "excludeRegexs", map);
    }

    /** List included regexs for context */
    public ApiResponse includeRegexs(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "view", "includeRegexs", map);
    }

    /** List the information about the named context */
    public ApiResponse context(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "view", "context", map);
    }

    /** Lists the names of all built in technologies */
    public ApiResponse technologyList() throws ClientApiException {
        return api.callApi("context", "view", "technologyList", null);
    }

    /** Lists the names of all technologies included in a context */
    public ApiResponse includedTechnologyList(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "view", "includedTechnologyList", map);
    }

    /** Lists the names of all technologies excluded from a context */
    public ApiResponse excludedTechnologyList(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "view", "excludedTechnologyList", map);
    }

    /** Lists the URLs accessed through/by ZAP, that belong to the context with the given name. */
    public ApiResponse urls(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "view", "urls", map);
    }

    /** Add exclude regex to context */
    public ApiResponse excludeFromContext(String contextname, String regex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("regex", regex);
        return api.callApi("context", "action", "excludeFromContext", map);
    }

    /** Add include regex to context */
    public ApiResponse includeInContext(String contextname, String regex)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("regex", regex);
        return api.callApi("context", "action", "includeInContext", map);
    }

    /** Set the regexs to include and exclude for a context, both supplied as JSON string arrays */
    public ApiResponse setContextRegexs(String contextname, String incregexs, String excregexs)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("incRegexs", incregexs);
        map.put("excRegexs", excregexs);
        return api.callApi("context", "action", "setContextRegexs", map);
    }

    /**
     * Set the checking strategy for a context - this defines how ZAP checks that a request is
     * authenticated
     */
    public ApiResponse setContextCheckingStrategy(
            String contextname,
            String checkingstrategy,
            String pollurl,
            String polldata,
            String pollheaders,
            String pollfrequency,
            String pollfrequencyunits)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("checkingStrategy", checkingstrategy);
        if (pollurl != null) {
            map.put("pollUrl", pollurl);
        }
        if (polldata != null) {
            map.put("pollData", polldata);
        }
        if (pollheaders != null) {
            map.put("pollHeaders", pollheaders);
        }
        if (pollfrequency != null) {
            map.put("pollFrequency", pollfrequency);
        }
        if (pollfrequencyunits != null) {
            map.put("pollFrequencyUnits", pollfrequencyunits);
        }
        return api.callApi("context", "action", "setContextCheckingStrategy", map);
    }

    /** Creates a new context with the given name in the current session */
    public ApiResponse newContext(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "action", "newContext", map);
    }

    /** Removes a context in the current session */
    public ApiResponse removeContext(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "action", "removeContext", map);
    }

    /**
     * Exports the context with the given name to a file. If a relative file path is specified it
     * will be resolved against the "contexts" directory in ZAP "home" dir.
     */
    public ApiResponse exportContext(String contextname, String contextfile)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("contextFile", contextfile);
        return api.callApi("context", "action", "exportContext", map);
    }

    /**
     * Imports a context from a file. If a relative file path is specified it will be resolved
     * against the "contexts" directory in ZAP "home" dir.
     */
    public ApiResponse importContext(String contextfile) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextFile", contextfile);
        return api.callApi("context", "action", "importContext", map);
    }

    /** Includes technologies with the given names, separated by a comma, to a context */
    public ApiResponse includeContextTechnologies(String contextname, String technologynames)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("technologyNames", technologynames);
        return api.callApi("context", "action", "includeContextTechnologies", map);
    }

    /** Includes all built in technologies in to a context */
    public ApiResponse includeAllContextTechnologies(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "action", "includeAllContextTechnologies", map);
    }

    /** Excludes technologies with the given names, separated by a comma, from a context */
    public ApiResponse excludeContextTechnologies(String contextname, String technologynames)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("technologyNames", technologynames);
        return api.callApi("context", "action", "excludeContextTechnologies", map);
    }

    /** Excludes all built in technologies from a context */
    public ApiResponse excludeAllContextTechnologies(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("context", "action", "excludeAllContextTechnologies", map);
    }

    /** Sets a context to in scope (contexts are in scope by default) */
    public ApiResponse setContextInScope(String contextname, String booleaninscope)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("booleanInScope", booleaninscope);
        return api.callApi("context", "action", "setContextInScope", map);
    }
}
