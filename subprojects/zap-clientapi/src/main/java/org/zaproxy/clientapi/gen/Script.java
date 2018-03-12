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

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;


/**
 * This file was automatically generated.
 */
@SuppressWarnings("javadoc")
public class Script extends org.zaproxy.clientapi.gen.deprecated.ScriptDeprecated {

	private final ClientApi api;

	public Script(ClientApi api) {
		super(api);
		this.api = api;
	}

	/**
	 * Lists the script engines available
	 */
	public ApiResponse listEngines() throws ClientApiException {
		return api.callApi("script", "view", "listEngines", null);
	}

	/**
	 * Lists the scripts available, with its engine, name, description, type and error state.
	 */
	public ApiResponse listScripts() throws ClientApiException {
		return api.callApi("script", "view", "listScripts", null);
	}

	/**
	 * Enables the script with the given name
	 */
	public ApiResponse enable(String scriptname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scriptName", scriptname);
		return api.callApi("script", "action", "enable", map);
	}

	/**
	 * Disables the script with the given name
	 */
	public ApiResponse disable(String scriptname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scriptName", scriptname);
		return api.callApi("script", "action", "disable", map);
	}

	/**
	 * Loads a script into ZAP from the given local file, with the given name, type and engine, optionally with a description, and a charset name to read the script (the charset name is required if the script is not in UTF-8, for example, in ISO-8859-1).
	 */
	public ApiResponse load(String scriptname, String scripttype, String scriptengine, String filename, String scriptdescription, Charset charset) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scriptName", scriptname);
		map.put("scriptType", scripttype);
		map.put("scriptEngine", scriptengine);
		map.put("fileName", filename);
		if (scriptdescription != null) {
			map.put("scriptDescription", scriptdescription);
		}
		if (charset != null) {
			map.put("charset", charset.name());
		}
		return api.callApi("script", "action", "load", map);
	}

	/**
	 * Removes the script with the given name
	 */
	public ApiResponse remove(String scriptname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scriptName", scriptname);
		return api.callApi("script", "action", "remove", map);
	}

	/**
	 * Runs the stand alone script with the give name
	 */
	public ApiResponse runStandAloneScript(String scriptname) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("scriptName", scriptname);
		return api.callApi("script", "action", "runStandAloneScript", map);
	}

}
