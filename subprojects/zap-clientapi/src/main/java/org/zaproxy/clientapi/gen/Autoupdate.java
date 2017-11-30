/* Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2017 the ZAP development team
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
@SuppressWarnings("javadoc")
public class Autoupdate extends org.zaproxy.clientapi.gen.deprecated.AutoupdateDeprecated {

	private final ClientApi api;

	public Autoupdate(ClientApi api) {
		super(api);
		this.api = api;
	}

	/**
	 * Returns the latest version number
	 */
	public ApiResponse latestVersionNumber() throws ClientApiException {
		return api.callApi("autoupdate", "view", "latestVersionNumber", null);
	}

	/**
	 * Returns 'true' if ZAP is on the latest version
	 */
	public ApiResponse isLatestVersion() throws ClientApiException {
		return api.callApi("autoupdate", "view", "isLatestVersion", null);
	}

	/**
	 * Return a list of all of the installed add-ons
	 */
	public ApiResponse installedAddons() throws ClientApiException {
		return api.callApi("autoupdate", "view", "installedAddons", null);
	}

	/**
	 * Return a list of any add-ons that have been added to the Marketplace since the last check for updates
	 */
	public ApiResponse newAddons() throws ClientApiException {
		return api.callApi("autoupdate", "view", "newAddons", null);
	}

	/**
	 * Return a list of any add-ons that have been changed in the Marketplace since the last check for updates
	 */
	public ApiResponse updatedAddons() throws ClientApiException {
		return api.callApi("autoupdate", "view", "updatedAddons", null);
	}

	/**
	 * Return a list of all of the add-ons on the ZAP Marketplace (this information is read once and then cached)
	 */
	public ApiResponse marketplaceAddons() throws ClientApiException {
		return api.callApi("autoupdate", "view", "marketplaceAddons", null);
	}

	public ApiResponse optionAddonDirectories() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionAddonDirectories", null);
	}

	public ApiResponse optionDayLastChecked() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionDayLastChecked", null);
	}

	public ApiResponse optionDayLastInstallWarned() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionDayLastInstallWarned", null);
	}

	public ApiResponse optionDayLastUpdateWarned() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionDayLastUpdateWarned", null);
	}

	public ApiResponse optionDownloadDirectory() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionDownloadDirectory", null);
	}

	public ApiResponse optionCheckAddonUpdates() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionCheckAddonUpdates", null);
	}

	public ApiResponse optionCheckOnStart() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionCheckOnStart", null);
	}

	public ApiResponse optionDownloadNewRelease() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionDownloadNewRelease", null);
	}

	public ApiResponse optionInstallAddonUpdates() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionInstallAddonUpdates", null);
	}

	public ApiResponse optionInstallScannerRules() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionInstallScannerRules", null);
	}

	public ApiResponse optionReportAlphaAddons() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionReportAlphaAddons", null);
	}

	public ApiResponse optionReportBetaAddons() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionReportBetaAddons", null);
	}

	public ApiResponse optionReportReleaseAddons() throws ClientApiException {
		return api.callApi("autoupdate", "view", "optionReportReleaseAddons", null);
	}

	/**
	 * Downloads the latest release, if any 
	 */
	public ApiResponse downloadLatestRelease() throws ClientApiException {
		return api.callApi("autoupdate", "action", "downloadLatestRelease", null);
	}

	/**
	 * Installs or updates the specified add-on, returning when complete (ie not asynchronously)
	 */
	public ApiResponse installAddon(String id) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		return api.callApi("autoupdate", "action", "installAddon", map);
	}

	/**
	 * Uninstalls the specified add-on 
	 */
	public ApiResponse uninstallAddon(String id) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		return api.callApi("autoupdate", "action", "uninstallAddon", map);
	}

	public ApiResponse setOptionCheckAddonUpdates(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionCheckAddonUpdates", map);
	}

	public ApiResponse setOptionCheckOnStart(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionCheckOnStart", map);
	}

	public ApiResponse setOptionDownloadNewRelease(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionDownloadNewRelease", map);
	}

	public ApiResponse setOptionInstallAddonUpdates(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionInstallAddonUpdates", map);
	}

	public ApiResponse setOptionInstallScannerRules(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionInstallScannerRules", map);
	}

	public ApiResponse setOptionReportAlphaAddons(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionReportAlphaAddons", map);
	}

	public ApiResponse setOptionReportBetaAddons(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionReportBetaAddons", map);
	}

	public ApiResponse setOptionReportReleaseAddons(boolean bool) throws ClientApiException {
		Map<String, String> map = new HashMap<>();
		map.put("Boolean", Boolean.toString(bool));
		return api.callApi("autoupdate", "action", "setOptionReportReleaseAddons", map);
	}

}
