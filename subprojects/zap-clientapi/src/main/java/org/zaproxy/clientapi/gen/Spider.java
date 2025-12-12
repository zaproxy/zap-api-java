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
public class Spider extends org.zaproxy.clientapi.gen.deprecated.SpiderDeprecated {

    private final ClientApi api;

    public Spider(ClientApi api) {
        super(api);
        this.api = api;
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse status(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (scanid != null) {
            map.put("scanId", scanid);
        }
        return api.callApi("spider", "view", "status", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse results(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (scanid != null) {
            map.put("scanId", scanid);
        }
        return api.callApi("spider", "view", "results", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse fullResults(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("scanId", scanid);
        return api.callApi("spider", "view", "fullResults", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse scans() throws ClientApiException {
        return api.callApi("spider", "view", "scans", null);
    }

    /**
     * Gets the regexes of URLs excluded from the spider scans.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse excludedFromScan() throws ClientApiException {
        return api.callApi("spider", "view", "excludedFromScan", null);
    }

    /**
     * Returns a list of unique URLs from the history table based on HTTP messages added by the
     * Spider.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse allUrls() throws ClientApiException {
        return api.callApi("spider", "view", "allUrls", null);
    }

    /**
     * Returns a list of the names of the nodes added to the Sites tree by the specified scan.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addedNodes(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (scanid != null) {
            map.put("scanId", scanid);
        }
        return api.callApi("spider", "view", "addedNodes", map);
    }

    /**
     * Gets all the domains that are always in scope. For each domain the following are shown: the
     * index, the value (domain), if enabled, and if specified as a regex.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse domainsAlwaysInScope() throws ClientApiException {
        return api.callApi("spider", "view", "domainsAlwaysInScope", null);
    }

    /**
     * Use view domainsAlwaysInScope instead.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     *
     * @deprecated
     */
    @Deprecated
    public ApiResponse optionDomainsAlwaysInScope() throws ClientApiException {
        return api.callApi("spider", "view", "optionDomainsAlwaysInScope", null);
    }

    /**
     * Use view domainsAlwaysInScope instead.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     *
     * @deprecated
     */
    @Deprecated
    public ApiResponse optionDomainsAlwaysInScopeEnabled() throws ClientApiException {
        return api.callApi("spider", "view", "optionDomainsAlwaysInScopeEnabled", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionHandleParameters() throws ClientApiException {
        return api.callApi("spider", "view", "optionHandleParameters", null);
    }

    /**
     * Gets the maximum number of child nodes (per node) that can be crawled, 0 means no limit.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxChildren() throws ClientApiException {
        return api.callApi("spider", "view", "optionMaxChildren", null);
    }

    /**
     * Gets the maximum depth the spider can crawl, 0 if unlimited.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxDepth() throws ClientApiException {
        return api.callApi("spider", "view", "optionMaxDepth", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionMaxDuration() throws ClientApiException {
        return api.callApi("spider", "view", "optionMaxDuration", null);
    }

    /**
     * Gets the maximum size, in bytes, that a response might have to be parsed, or 0 for unlimited.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxParseSizeBytes() throws ClientApiException {
        return api.callApi("spider", "view", "optionMaxParseSizeBytes", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionMaxScansInUI() throws ClientApiException {
        return api.callApi("spider", "view", "optionMaxScansInUI", null);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     *
     * @deprecated
     */
    @Deprecated
    public ApiResponse optionRequestWaitTime() throws ClientApiException {
        return api.callApi("spider", "view", "optionRequestWaitTime", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionSkipURLString() throws ClientApiException {
        return api.callApi("spider", "view", "optionSkipURLString", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionThreadCount() throws ClientApiException {
        return api.callApi("spider", "view", "optionThreadCount", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionUserAgent() throws ClientApiException {
        return api.callApi("spider", "view", "optionUserAgent", null);
    }

    /**
     * Gets whether or not a spider process should accept cookies while spidering.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionAcceptCookies() throws ClientApiException {
        return api.callApi("spider", "view", "optionAcceptCookies", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionHandleODataParametersVisited() throws ClientApiException {
        return api.callApi("spider", "view", "optionHandleODataParametersVisited", null);
    }

    /**
     * Gets whether or not the spider should attempt to avoid logout related paths/functionality.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionLogoutAvoidance() throws ClientApiException {
        return api.callApi("spider", "view", "optionLogoutAvoidance", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionParseComments() throws ClientApiException {
        return api.callApi("spider", "view", "optionParseComments", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionParseDsStore() throws ClientApiException {
        return api.callApi("spider", "view", "optionParseDsStore", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionParseGit() throws ClientApiException {
        return api.callApi("spider", "view", "optionParseGit", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionParseRobotsTxt() throws ClientApiException {
        return api.callApi("spider", "view", "optionParseRobotsTxt", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionParseSVNEntries() throws ClientApiException {
        return api.callApi("spider", "view", "optionParseSVNEntries", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionParseSitemapXml() throws ClientApiException {
        return api.callApi("spider", "view", "optionParseSitemapXml", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionPostForm() throws ClientApiException {
        return api.callApi("spider", "view", "optionPostForm", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionProcessForm() throws ClientApiException {
        return api.callApi("spider", "view", "optionProcessForm", null);
    }

    /**
     * Gets whether or not the 'Referer' header should be sent while spidering.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionSendRefererHeader() throws ClientApiException {
        return api.callApi("spider", "view", "optionSendRefererHeader", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionShowAdvancedDialog() throws ClientApiException {
        return api.callApi("spider", "view", "optionShowAdvancedDialog", null);
    }

    /**
     * Runs the spider against the given URL (or context). Optionally, the 'maxChildren' parameter
     * can be set to limit the number of children scanned, the 'recurse' parameter can be used to
     * prevent the spider from seeding recursively, the parameter 'contextName' can be used to
     * constrain the scan to a Context and the parameter 'subtreeOnly' allows to restrict the spider
     * under a site's subtree (using the specified 'url').
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scan(
            String url, String maxchildren, String recurse, String contextname, String subtreeonly)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (url != null) {
            map.put("url", url);
        }
        if (maxchildren != null) {
            map.put("maxChildren", maxchildren);
        }
        if (recurse != null) {
            map.put("recurse", recurse);
        }
        if (contextname != null) {
            map.put("contextName", contextname);
        }
        if (subtreeonly != null) {
            map.put("subtreeOnly", subtreeonly);
        }
        return api.callApi("spider", "action", "scan", map);
    }

    /**
     * Runs the spider from the perspective of a User, obtained using the given Context ID and User
     * ID. See 'scan' action for more details.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scanAsUser(
            String contextid,
            String userid,
            String url,
            String maxchildren,
            String recurse,
            String subtreeonly)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextId", contextid);
        map.put("userId", userid);
        if (url != null) {
            map.put("url", url);
        }
        if (maxchildren != null) {
            map.put("maxChildren", maxchildren);
        }
        if (recurse != null) {
            map.put("recurse", recurse);
        }
        if (subtreeonly != null) {
            map.put("subtreeOnly", subtreeonly);
        }
        return api.callApi("spider", "action", "scanAsUser", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse pause(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("scanId", scanid);
        return api.callApi("spider", "action", "pause", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse resume(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("scanId", scanid);
        return api.callApi("spider", "action", "resume", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse stop(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (scanid != null) {
            map.put("scanId", scanid);
        }
        return api.callApi("spider", "action", "stop", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse removeScan(String scanid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("scanId", scanid);
        return api.callApi("spider", "action", "removeScan", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse pauseAllScans() throws ClientApiException {
        return api.callApi("spider", "action", "pauseAllScans", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse resumeAllScans() throws ClientApiException {
        return api.callApi("spider", "action", "resumeAllScans", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse stopAllScans() throws ClientApiException {
        return api.callApi("spider", "action", "stopAllScans", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse removeAllScans() throws ClientApiException {
        return api.callApi("spider", "action", "removeAllScans", null);
    }

    /**
     * Clears the regexes of URLs excluded from the spider scans.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse clearExcludedFromScan() throws ClientApiException {
        return api.callApi("spider", "action", "clearExcludedFromScan", null);
    }

    /**
     * Adds a regex of URLs that should be excluded from the spider scans.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse excludeFromScan(String regex) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("regex", regex);
        return api.callApi("spider", "action", "excludeFromScan", map);
    }

    /**
     * Adds a new domain that's always in scope, using the specified value. Optionally sets if the
     * new entry is enabled (default, true) and whether or not the new value is specified as a regex
     * (default, false).
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addDomainAlwaysInScope(String value, String isregex, String isenabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("value", value);
        if (isregex != null) {
            map.put("isRegex", isregex);
        }
        if (isenabled != null) {
            map.put("isEnabled", isenabled);
        }
        return api.callApi("spider", "action", "addDomainAlwaysInScope", map);
    }

    /**
     * Modifies a domain that's always in scope. Allows to modify the value, if enabled or if a
     * regex. The domain is selected with its index, which can be obtained with the view
     * domainsAlwaysInScope.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse modifyDomainAlwaysInScope(
            String idx, String value, String isregex, String isenabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("idx", idx);
        if (value != null) {
            map.put("value", value);
        }
        if (isregex != null) {
            map.put("isRegex", isregex);
        }
        if (isenabled != null) {
            map.put("isEnabled", isenabled);
        }
        return api.callApi("spider", "action", "modifyDomainAlwaysInScope", map);
    }

    /**
     * Removes a domain that's always in scope, with the given index. The index can be obtained with
     * the view domainsAlwaysInScope.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeDomainAlwaysInScope(String idx) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("idx", idx);
        return api.callApi("spider", "action", "removeDomainAlwaysInScope", map);
    }

    /**
     * Enables all domains that are always in scope.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse enableAllDomainsAlwaysInScope() throws ClientApiException {
        return api.callApi("spider", "action", "enableAllDomainsAlwaysInScope", null);
    }

    /**
     * Disables all domains that are always in scope.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse disableAllDomainsAlwaysInScope() throws ClientApiException {
        return api.callApi("spider", "action", "disableAllDomainsAlwaysInScope", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionHandleParameters(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("spider", "action", "setOptionHandleParameters", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionSkipURLString(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("spider", "action", "setOptionSkipURLString", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionUserAgent(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("spider", "action", "setOptionUserAgent", map);
    }

    /**
     * Sets whether or not a spider process should accept cookies while spidering.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionAcceptCookies(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionAcceptCookies", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionHandleODataParametersVisited(boolean bool)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionHandleODataParametersVisited", map);
    }

    /**
     * Sets whether or not the Spider should attempt to avoid logout related paths/functionality.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionLogoutAvoidance(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionLogoutAvoidance", map);
    }

    /**
     * Sets the maximum number of child nodes (per node) that can be crawled, 0 means no limit.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxChildren(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxChildren", map);
    }

    /**
     * Sets the maximum depth the spider can crawl, 0 for unlimited depth.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxDepth(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxDepth", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionMaxDuration(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxDuration", map);
    }

    /**
     * Sets the maximum size, in bytes, that a response might have to be parsed. This allows the
     * spider to skip big responses/files.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxParseSizeBytes(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxParseSizeBytes", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionMaxScansInUI(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionMaxScansInUI", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionParseComments(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseComments", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionParseDsStore(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseDsStore", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionParseGit(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseGit", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionParseRobotsTxt(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseRobotsTxt", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionParseSVNEntries(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseSVNEntries", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionParseSitemapXml(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionParseSitemapXml", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionPostForm(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionPostForm", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionProcessForm(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionProcessForm", map);
    }

    /**
     * This component is optional and therefore the API will only work if it is installed
     *
     * @deprecated
     */
    @Deprecated
    public ApiResponse setOptionRequestWaitTime(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionRequestWaitTime", map);
    }

    /**
     * Sets whether or not the 'Referer' header should be sent while spidering.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionSendRefererHeader(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionSendRefererHeader", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionShowAdvancedDialog(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("spider", "action", "setOptionShowAdvancedDialog", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionThreadCount(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("spider", "action", "setOptionThreadCount", map);
    }
}
