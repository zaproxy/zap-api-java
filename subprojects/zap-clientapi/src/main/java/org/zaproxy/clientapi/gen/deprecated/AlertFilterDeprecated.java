/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2023 The ZAP Development Team
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

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApiException;

/** API implementation with deprecated methods, (re)moved from generated class. */
@SuppressWarnings("javadoc")
public abstract class AlertFilterDeprecated {

    /**
     * Adds a new alert filter for the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled)
            throws ClientApiException {
        return addAlertFilter(
                contextid,
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * Adds a new alert filter for the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        return addAlertFilter(
                contextid,
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                parameterisregex,
                attack,
                attackisregex,
                evidence,
                evidenceisregex,
                null);
    }

    /**
     * Adds a new alert filter for the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public abstract ApiResponse addAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex,
            String methods)
            throws ClientApiException;

    /**
     * Adds a new global alert filter.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addGlobalAlertFilter(
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        return addGlobalAlertFilter(
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                parameterisregex,
                attack,
                attackisregex,
                evidence,
                evidenceisregex,
                null);
    }

    /**
     * Adds a new global alert filter.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public abstract ApiResponse addGlobalAlertFilter(
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex,
            String methods)
            throws ClientApiException;

    /**
     * Removes an alert filter from the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled)
            throws ClientApiException {
        return removeAlertFilter(
                contextid,
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * Removes an alert filter from the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        return removeAlertFilter(
                contextid,
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                parameterisregex,
                attack,
                attackisregex,
                evidence,
                evidenceisregex,
                null);
    }

    /**
     * Removes an alert filter from the context with the given ID.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public abstract ApiResponse removeAlertFilter(
            String contextid,
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex,
            String methods)
            throws ClientApiException;

    /**
     * Removes a global alert filter.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeGlobalAlertFilter(
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex)
            throws ClientApiException {
        return removeGlobalAlertFilter(
                ruleid,
                newlevel,
                url,
                urlisregex,
                parameter,
                enabled,
                parameterisregex,
                attack,
                attackisregex,
                evidence,
                evidenceisregex,
                null);
    }

    /**
     * Removes a global alert filter.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public abstract ApiResponse removeGlobalAlertFilter(
            String ruleid,
            String newlevel,
            String url,
            String urlisregex,
            String parameter,
            String enabled,
            String parameterisregex,
            String attack,
            String attackisregex,
            String evidence,
            String evidenceisregex,
            String methods)
            throws ClientApiException;
}
