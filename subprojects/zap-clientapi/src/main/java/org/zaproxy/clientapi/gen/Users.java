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
public class Users extends org.zaproxy.clientapi.gen.deprecated.UsersDeprecated {

    private final ClientApi api;

    public Users(ClientApi api) {
        super(api);
        this.api = api;
    }

    /**
     * Gets a list of users that belong to the context with the given ID, or all users if none
     * provided.
     */
    public ApiResponse usersList(String contextid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (contextid != null) {
            map.put("contextId", contextid);
        }
        return api.callApi("users", "view", "usersList", map);
    }

    /**
     * Gets the data of the user with the given ID that belongs to the context with the given ID.
     */
    public ApiResponse getUserById(String contextid, String userid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        return api.callApi("users", "view", "getUserById", map);
    }

    /** Gets the configuration parameters for the credentials of the context with the given ID. */
    public ApiResponse getAuthenticationCredentialsConfigParams(String contextid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        return api.callApi("users", "view", "getAuthenticationCredentialsConfigParams", map);
    }

    /**
     * Gets the authentication credentials of the user with given ID that belongs to the context
     * with the given ID.
     */
    public ApiResponse getAuthenticationCredentials(String contextid, String userid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        return api.callApi("users", "view", "getAuthenticationCredentials", map);
    }

    /**
     * Gets the authentication state information for the user identified by the Context and User
     * Ids.
     */
    public ApiResponse getAuthenticationState(String contextid, String userid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        return api.callApi("users", "view", "getAuthenticationState", map);
    }

    /**
     * Gets the authentication session information for the user identified by the Context and User
     * Ids, e.g. cookies and realm credentials.
     */
    public ApiResponse getAuthenticationSession(String contextid, String userid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        return api.callApi("users", "view", "getAuthenticationSession", map);
    }

    /** Creates a new user with the given name for the context with the given ID. */
    public ApiResponse newUser(String contextid, String name) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("name", name);
        return api.callApi("users", "action", "newUser", map);
    }

    /** Removes the user with the given ID that belongs to the context with the given ID. */
    public ApiResponse removeUser(String contextid, String userid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        return api.callApi("users", "action", "removeUser", map);
    }

    /**
     * Sets whether or not the user, with the given ID that belongs to the context with the given
     * ID, should be enabled.
     */
    public ApiResponse setUserEnabled(String contextid, String userid, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        map.put("enabled", enabled);
        return api.callApi("users", "action", "setUserEnabled", map);
    }

    /** Renames the user with the given ID that belongs to the context with the given ID. */
    public ApiResponse setUserName(String contextid, String userid, String name)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        map.put("name", name);
        return api.callApi("users", "action", "setUserName", map);
    }

    /**
     * Sets the authentication credentials for the user with the given ID that belongs to the
     * context with the given ID.
     */
    public ApiResponse setAuthenticationCredentials(
            String contextid, String userid, String authcredentialsconfigparams)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        if (authcredentialsconfigparams != null) {
            map.put("authCredentialsConfigParams", authcredentialsconfigparams);
        }
        return api.callApi("users", "action", "setAuthenticationCredentials", map);
    }

    /**
     * Tries to authenticate as the identified user, returning the authentication request and
     * whether it appears to have succeeded.
     */
    public ApiResponse authenticateAsUser(String contextid, String userid)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        return api.callApi("users", "action", "authenticateAsUser", map);
    }

    /**
     * Tries to poll as the identified user, returning the authentication request and whether it
     * appears to have succeeded. This will only work if the polling verification strategy has been
     * configured.
     */
    public ApiResponse pollAsUser(String contextid, String userid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        return api.callApi("users", "action", "pollAsUser", map);
    }

    /**
     * Sets fields in the authentication state for the user identified by the Context and User Ids.
     */
    public ApiResponse setAuthenticationState(
            String contextid,
            String userid,
            String lastpollresult,
            String lastpolltimeinms,
            String requestssincelastpoll)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        if (lastpollresult != null) {
            map.put("lastPollResult", lastpollresult);
        }
        if (lastpolltimeinms != null) {
            map.put("lastPollTimeInMs", lastpolltimeinms);
        }
        if (requestssincelastpoll != null) {
            map.put("requestsSinceLastPoll", requestssincelastpoll);
        }
        return api.callApi("users", "action", "setAuthenticationState", map);
    }

    /** Sets the specified cookie for the user identified by the Context and User Ids. */
    public ApiResponse setCookie(
            String contextid,
            String userid,
            String domain,
            String name,
            String value,
            String path,
            String secure)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        map.put("domain", domain);
        map.put("name", name);
        map.put("value", value);
        if (path != null) {
            map.put("path", path);
        }
        if (secure != null) {
            map.put("secure", secure);
        }
        return api.callApi("users", "action", "setCookie", map);
    }
}
