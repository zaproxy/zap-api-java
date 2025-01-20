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
public class AjaxSpider extends org.zaproxy.clientapi.gen.deprecated.AjaxSpiderDeprecated {

    private final ClientApi api;

    public AjaxSpider(ClientApi api) {
        super(api);
        this.api = api;
    }

    /**
     * Gets the allowed resources. The allowed resources are always fetched even if out of scope,
     * allowing to include necessary resources (e.g. scripts) from 3rd-parties.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse allowedResources() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "allowedResources", null);
    }

    /**
     * Gets the excluded elements. The excluded elements are not clicked during crawling, for
     * example, to prevent logging out.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse excludedElements(String contextname) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        return api.callApi("ajaxSpider", "view", "excludedElements", map);
    }

    /**
     * Gets the current status of the crawler. Actual values are Stopped and Running.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse status() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "status", null);
    }

    /**
     * Gets the current results of the crawler.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse results(String start, String count) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApi("ajaxSpider", "view", "results", map);
    }

    /**
     * Gets the number of resources found.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse numberOfResults() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "numberOfResults", null);
    }

    /**
     * Gets the full crawled content detected by the AJAX Spider. Returns a set of values based on
     * 'inScope' URLs, 'outOfScope' URLs, and 'errors' encountered during the last/current run of
     * the AJAX Spider.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse fullResults() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "fullResults", null);
    }

    /**
     * Gets the configured browser to use for crawling.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionBrowserId() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionBrowserId", null);
    }

    /**
     * Gets the time to wait after an event (in milliseconds). For example: the wait delay after the
     * cursor hovers over an element, in order for a menu to display, etc.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionEventWait() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionEventWait", null);
    }

    /**
     * Gets the configured value for the max crawl depth.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxCrawlDepth() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionMaxCrawlDepth", null);
    }

    /**
     * Gets the configured value for the maximum crawl states allowed.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxCrawlStates() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionMaxCrawlStates", null);
    }

    /**
     * Gets the configured max duration of the crawl, the value is in minutes.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionMaxDuration() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionMaxDuration", null);
    }

    /**
     * Gets the configured number of browsers to be used.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionNumberOfBrowsers() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionNumberOfBrowsers", null);
    }

    /**
     * Gets the configured time to wait after reloading the page, this value is in milliseconds.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionReloadWait() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionReloadWait", null);
    }

    /**
     * Gets the configured value for 'Click Default Elements Only', HTML elements such as 'a',
     * 'button', 'input', all associated with some action or links on the page.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionClickDefaultElems() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionClickDefaultElems", null);
    }

    /**
     * Gets the value configured for the AJAX Spider to know if it should click on the elements only
     * once.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionClickElemsOnce() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionClickElemsOnce", null);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse optionEnableExtensions() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionEnableExtensions", null);
    }

    /**
     * Gets if the AJAX Spider will use random values in form fields when crawling, if set to true.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse optionRandomInputs() throws ClientApiException {
        return api.callApi("ajaxSpider", "view", "optionRandomInputs", null);
    }

    /**
     * Runs the AJAX Spider against a given target.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scan(String url, String inscope, String contextname, String subtreeonly)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (url != null) {
            map.put("url", url);
        }
        if (inscope != null) {
            map.put("inScope", inscope);
        }
        if (contextname != null) {
            map.put("contextName", contextname);
        }
        if (subtreeonly != null) {
            map.put("subtreeOnly", subtreeonly);
        }
        return api.callApi("ajaxSpider", "action", "scan", map);
    }

    /**
     * Runs the AJAX Spider from the perspective of a User of the web application.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse scanAsUser(
            String contextname, String username, String url, String subtreeonly)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("userName", username);
        if (url != null) {
            map.put("url", url);
        }
        if (subtreeonly != null) {
            map.put("subtreeOnly", subtreeonly);
        }
        return api.callApi("ajaxSpider", "action", "scanAsUser", map);
    }

    /**
     * Stops the AJAX Spider.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse stop() throws ClientApiException {
        return api.callApi("ajaxSpider", "action", "stop", null);
    }

    /**
     * Adds an allowed resource.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addAllowedResource(String regex, String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("regex", regex);
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        return api.callApi("ajaxSpider", "action", "addAllowedResource", map);
    }

    /**
     * Adds an excluded element to a context.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addExcludedElement(
            String contextname,
            String description,
            String element,
            String xpath,
            String text,
            String attributename,
            String attributevalue,
            String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("description", description);
        map.put("element", element);
        if (xpath != null) {
            map.put("xpath", xpath);
        }
        if (text != null) {
            map.put("text", text);
        }
        if (attributename != null) {
            map.put("attributeName", attributename);
        }
        if (attributevalue != null) {
            map.put("attributeValue", attributevalue);
        }
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        return api.callApi("ajaxSpider", "action", "addExcludedElement", map);
    }

    /**
     * Modifies an excluded element of a context.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse modifyExcludedElement(
            String contextname,
            String description,
            String element,
            String descriptionnew,
            String xpath,
            String text,
            String attributename,
            String attributevalue,
            String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("description", description);
        map.put("element", element);
        if (descriptionnew != null) {
            map.put("descriptionNew", descriptionnew);
        }
        if (xpath != null) {
            map.put("xpath", xpath);
        }
        if (text != null) {
            map.put("text", text);
        }
        if (attributename != null) {
            map.put("attributeName", attributename);
        }
        if (attributevalue != null) {
            map.put("attributeValue", attributevalue);
        }
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        return api.callApi("ajaxSpider", "action", "modifyExcludedElement", map);
    }

    /**
     * Removes an excluded element from a context.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeExcludedElement(String contextname, String description)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("contextName", contextname);
        map.put("description", description);
        return api.callApi("ajaxSpider", "action", "removeExcludedElement", map);
    }

    /**
     * Removes an allowed resource.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeAllowedResource(String regex) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("regex", regex);
        return api.callApi("ajaxSpider", "action", "removeAllowedResource", map);
    }

    /**
     * Sets whether or not an allowed resource is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setEnabledAllowedResource(String regex, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("regex", regex);
        map.put("enabled", enabled);
        return api.callApi("ajaxSpider", "action", "setEnabledAllowedResource", map);
    }

    /**
     * Sets the configuration of the AJAX Spider to use one of the supported browsers.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionBrowserId(String string) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("String", string);
        return api.callApi("ajaxSpider", "action", "setOptionBrowserId", map);
    }

    /**
     * Sets whether or not the AJAX Spider will only click on the default HTML elements.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionClickDefaultElems(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionClickDefaultElems", map);
    }

    /**
     * When enabled, the crawler attempts to interact with each element (e.g., by clicking) only
     * once.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionClickElemsOnce(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionClickElemsOnce", map);
    }

    /** This component is optional and therefore the API will only work if it is installed */
    public ApiResponse setOptionEnableExtensions(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionEnableExtensions", map);
    }

    /**
     * Sets the time to wait after an event (in milliseconds). For example: the wait delay after the
     * cursor hovers over an element, in order for a menu to display, etc.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionEventWait(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionEventWait", map);
    }

    /**
     * Sets the maximum depth that the crawler can reach.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxCrawlDepth(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxCrawlDepth", map);
    }

    /**
     * Sets the maximum number of states that the crawler should crawl.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxCrawlStates(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxCrawlStates", map);
    }

    /**
     * The maximum time that the crawler is allowed to run.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionMaxDuration(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionMaxDuration", map);
    }

    /**
     * Sets the number of windows to be used by AJAX Spider.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionNumberOfBrowsers(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionNumberOfBrowsers", map);
    }

    /**
     * When enabled, inserts random values into form fields.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionRandomInputs(boolean bool) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Boolean", Boolean.toString(bool));
        return api.callApi("ajaxSpider", "action", "setOptionRandomInputs", map);
    }

    /**
     * Sets the time to wait after the page is loaded before interacting with it.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setOptionReloadWait(int i) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("Integer", Integer.toString(i));
        return api.callApi("ajaxSpider", "action", "setOptionReloadWait", map);
    }
}
