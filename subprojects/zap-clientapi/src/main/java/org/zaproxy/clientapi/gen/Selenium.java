/* Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2016 the ZAP development team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
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


/**
 * This file was automatically generated.
 */
public class Selenium {

	private final ClientApi api;

	public Selenium(ClientApi api) {
		this.api = api;
	}

	/**
	 * Returns the current path to ChromeDriver
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse optionChromeDriverPath() throws ClientApiException {
		return api.callApi("selenium", "view", "optionChromeDriverPath", null);
	}

	/**
	 * Returns the current path to Firefox binary
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse optionFirefoxBinaryPath() throws ClientApiException {
		return api.callApi("selenium", "view", "optionFirefoxBinaryPath", null);
	}

	/**
	 * Returns the current path to Firefox driver (geckodriver)
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse optionFirefoxDriverPath() throws ClientApiException {
		return api.callApi("selenium", "view", "optionFirefoxDriverPath", null);
	}

	/**
	 * Returns the current path to IEDriverServer
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse optionIeDriverPath() throws ClientApiException {
		return api.callApi("selenium", "view", "optionIeDriverPath", null);
	}

	/**
	 * Returns the current path to PhantomJS binary
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse optionPhantomJsBinaryPath() throws ClientApiException {
		return api.callApi("selenium", "view", "optionPhantomJsBinaryPath", null);
	}

	/**
	 * Sets the current path to ChromeDriver
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse setOptionChromeDriverPath(String apikey, String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (apikey != null) {
			map.put("apikey", apikey);
		}
		map.put("String", string);
		return api.callApi("selenium", "action", "setOptionChromeDriverPath", map);
	}

	/**
	 * Sets the current path to Firefox binary
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse setOptionFirefoxBinaryPath(String apikey, String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (apikey != null) {
			map.put("apikey", apikey);
		}
		map.put("String", string);
		return api.callApi("selenium", "action", "setOptionFirefoxBinaryPath", map);
	}

	/**
	 * Sets the current path to Firefox driver (geckodriver)
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse setOptionFirefoxDriverPath(String apikey, String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (apikey != null) {
			map.put("apikey", apikey);
		}
		map.put("String", string);
		return api.callApi("selenium", "action", "setOptionFirefoxDriverPath", map);
	}

	/**
	 * Sets the current path to IEDriverServer
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse setOptionIeDriverPath(String apikey, String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (apikey != null) {
			map.put("apikey", apikey);
		}
		map.put("String", string);
		return api.callApi("selenium", "action", "setOptionIeDriverPath", map);
	}

	/**
	 * Sets the current path to PhantomJS binary
	 * <p>
	 * This component is optional and therefore the API will only work if it is installed
	 */
	public ApiResponse setOptionPhantomJsBinaryPath(String apikey, String string) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		if (apikey != null) {
			map.put("apikey", apikey);
		}
		map.put("String", string);
		return api.callApi("selenium", "action", "setOptionPhantomJsBinaryPath", map);
	}

}
