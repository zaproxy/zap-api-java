/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2016 The ZAP Development Team
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
public class Selenium extends org.zaproxy.clientapi.gen.deprecated.SeleniumDeprecated {

    private final ClientApi api;

    public Selenium(ClientApi api) {
        super(api);
        this.api = api;
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionBrowserExtensions() throws ClientApiException {
        return api.callApi("selenium", "view", "optionBrowserExtensions", null);
    }

    /**
     * Returns the current path to Chrome binary
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionChromeBinaryPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionChromeBinaryPath", null);
    }

    /**
     * Returns the current path to ChromeDriver
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionChromeDriverPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionChromeDriverPath", null);
    }

    /**
     * Returns the current path to Edge binary
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionEdgeBinaryPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionEdgeBinaryPath", null);
    }

    /**
     * Returns the current path to EdgeDriver
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionEdgeDriverPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionEdgeDriverPath", null);
    }

    /**
     * Returns the current path to Firefox binary
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionFirefoxBinaryPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionFirefoxBinaryPath", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionFirefoxDefaultProfile() throws ClientApiException {
        return api.callApi("selenium", "view", "optionFirefoxDefaultProfile", null);
    }

    /**
     * Returns the current path to Firefox driver (geckodriver)
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionFirefoxDriverPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionFirefoxDriverPath", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    @Deprecated
    public ApiResponse optionIeDriverPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionIeDriverPath", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionLastDirectory() throws ClientApiException {
        return api.callApi("selenium", "view", "optionLastDirectory", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    @Deprecated
    public ApiResponse optionPhantomJsBinaryPath() throws ClientApiException {
        return api.callApi("selenium", "view", "optionPhantomJsBinaryPath", null);
    }

    /**
     * Gets the browser arguments.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getBrowserArguments(String browser) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("browser", browser);
        return api.callApi("selenium", "view", "getBrowserArguments", map);
    }

    /**
     * Sets the current path to Chrome binary
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionChromeBinaryPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionChromeBinaryPath", map);
    }

    /**
     * Sets the current path to ChromeDriver
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionChromeDriverPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionChromeDriverPath", map);
    }

    /**
     * Sets the current path to Edge binary
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionEdgeBinaryPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionEdgeBinaryPath", map);
    }

    /**
     * Sets the current path to EdgeDriver
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionEdgeDriverPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionEdgeDriverPath", map);
    }

    /**
     * Sets the current path to Firefox binary
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionFirefoxBinaryPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionFirefoxBinaryPath", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionFirefoxDefaultProfile(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionFirefoxDefaultProfile", map);
    }

    /**
     * Sets the current path to Firefox driver (geckodriver)
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionFirefoxDriverPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionFirefoxDriverPath", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    @Deprecated
    public ApiResponse setOptionIeDriverPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionIeDriverPath", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionLastDirectory(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionLastDirectory", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    @Deprecated
    public ApiResponse setOptionPhantomJsBinaryPath(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("selenium", "action", "setOptionPhantomJsBinaryPath", map);
    }

    /**
     * Adds a browser argument.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addBrowserArgument(String browser, String argument, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("browser", browser);
        map.put("argument", argument);
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        return api.callApi("selenium", "action", "addBrowserArgument", map);
    }

    /**
     * Launches a browser proxying through ZAP, for manual usage.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse launchBrowser(String browser) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("browser", browser);
        return api.callApi("selenium", "action", "launchBrowser", map);
    }

    /**
     * Removes a browser argument.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeBrowserArgument(String browser, String argument)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("browser", browser);
        map.put("argument", argument);
        return api.callApi("selenium", "action", "removeBrowserArgument", map);
    }

    /**
     * Sets whether or not a browser argument is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setBrowserArgumentEnabled(String browser, String argument, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("browser", browser);
        map.put("argument", argument);
        map.put("enabled", enabled);
        return api.callApi("selenium", "action", "setBrowserArgumentEnabled", map);
    }
}
