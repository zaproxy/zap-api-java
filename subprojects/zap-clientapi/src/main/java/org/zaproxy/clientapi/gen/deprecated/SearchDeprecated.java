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

import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

/**
 * API implementation with deprecated methods, (re)moved from generated class.
 */
@SuppressWarnings("javadoc")
public class SearchDeprecated {

    private final ClientApi api;

    public SearchDeprecated(ClientApi api) {
        this.api = api;
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public byte[] harByUrlRegex(String apikey, String regex, String baseurl, String start, String count)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("regex", regex);
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApiOther("search", "other", "harByUrlRegex", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public byte[] harByRequestRegex(String apikey, String regex, String baseurl, String start, String count)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("regex", regex);
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApiOther("search", "other", "harByRequestRegex", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public byte[] harByResponseRegex(String apikey, String regex, String baseurl, String start, String count)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("regex", regex);
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApiOther("search", "other", "harByResponseRegex", map);
    }

    /**
     * @deprecated (TODO add version) Use the method without the API key and use one of the {@code ClientApi} constructors that allow to
     *             set the API key (e.g. {@link ClientApi#ClientApi(String, int, String)}).
     */
    @Deprecated
    public byte[] harByHeaderRegex(String apikey, String regex, String baseurl, String start, String count)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (apikey != null) {
            map.put("apikey", apikey);
        }
        map.put("regex", regex);
        if (baseurl != null) {
            map.put("baseurl", baseurl);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        return api.callApiOther("search", "other", "harByHeaderRegex", map);
    }

}
