/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2022 The ZAP Development Team
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
public class Network {

    private final ClientApi api;

    public Network(ClientApi api) {
        this.api = api;
    }

    /**
     * Gets the Root CA certificate validity, in days. Used when generating a new Root CA
     * certificate.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getRootCaCertValidity() throws ClientApiException {
        return api.callApi("network", "view", "getRootCaCertValidity", null);
    }

    /**
     * Gets the server certificate validity, in days. Used when generating server certificates.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getServerCertValidity() throws ClientApiException {
        return api.callApi("network", "view", "getServerCertValidity", null);
    }

    /**
     * Gets the aliases used to identify the local servers/proxies.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getAliases() throws ClientApiException {
        return api.callApi("network", "view", "getAliases", null);
    }

    /**
     * Gets the local servers/proxies.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getLocalServers() throws ClientApiException {
        return api.callApi("network", "view", "getLocalServers", null);
    }

    /**
     * Gets the authorities that will pass-through the local proxies.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getPassThroughs() throws ClientApiException {
        return api.callApi("network", "view", "getPassThroughs", null);
    }

    /**
     * Gets the connection timeout, in seconds.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getConnectionTimeout() throws ClientApiException {
        return api.callApi("network", "view", "getConnectionTimeout", null);
    }

    /**
     * Gets the default user-agent.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getDefaultUserAgent() throws ClientApiException {
        return api.callApi("network", "view", "getDefaultUserAgent", null);
    }

    /**
     * Gets the TTL (in seconds) of successful DNS queries.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getDnsTtlSuccessfulQueries() throws ClientApiException {
        return api.callApi("network", "view", "getDnsTtlSuccessfulQueries", null);
    }

    /**
     * Gets the HTTP proxy.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getHttpProxy() throws ClientApiException {
        return api.callApi("network", "view", "getHttpProxy", null);
    }

    /**
     * Gets the HTTP proxy exclusions.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getHttpProxyExclusions() throws ClientApiException {
        return api.callApi("network", "view", "getHttpProxyExclusions", null);
    }

    /**
     * Gets the SOCKS proxy.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getSocksProxy() throws ClientApiException {
        return api.callApi("network", "view", "getSocksProxy", null);
    }

    /**
     * Tells whether or not the HTTP proxy authentication is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse isHttpProxyAuthEnabled() throws ClientApiException {
        return api.callApi("network", "view", "isHttpProxyAuthEnabled", null);
    }

    /**
     * Tells whether or not the HTTP proxy is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse isHttpProxyEnabled() throws ClientApiException {
        return api.callApi("network", "view", "isHttpProxyEnabled", null);
    }

    /**
     * Tells whether or not the SOCKS proxy is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse isSocksProxyEnabled() throws ClientApiException {
        return api.callApi("network", "view", "isSocksProxyEnabled", null);
    }

    /**
     * Tells whether or not to use global HTTP state.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse isUseGlobalHttpState() throws ClientApiException {
        return api.callApi("network", "view", "isUseGlobalHttpState", null);
    }

    /**
     * List of rate limit rules.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse getRateLimitRules() throws ClientApiException {
        return api.callApi("network", "view", "getRateLimitRules", null);
    }

    /**
     * Generates a new Root CA certificate, used to issue server certificates.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse generateRootCaCert() throws ClientApiException {
        return api.callApi("network", "action", "generateRootCaCert", null);
    }

    /**
     * Imports a Root CA certificate to be used to issue server certificates.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse importRootCaCert(String filepath) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        return api.callApi("network", "action", "importRootCaCert", map);
    }

    /**
     * Sets the Root CA certificate validity. Used when generating a new Root CA certificate.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setRootCaCertValidity(String validity) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("validity", validity);
        return api.callApi("network", "action", "setRootCaCertValidity", map);
    }

    /**
     * Sets the server certificate validity. Used when generating server certificates.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setServerCertValidity(String validity) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("validity", validity);
        return api.callApi("network", "action", "setServerCertValidity", map);
    }

    /**
     * Adds an alias for the local servers/proxies.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addAlias(String name, String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        return api.callApi("network", "action", "addAlias", map);
    }

    /**
     * Adds a local server/proxy.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addLocalServer(
            String address,
            String port,
            String api,
            String proxy,
            String behindnat,
            String decoderesponse,
            String removeacceptencoding)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("address", address);
        map.put("port", port);
        if (api != null) {
            map.put("api", api);
        }
        if (proxy != null) {
            map.put("proxy", proxy);
        }
        if (behindnat != null) {
            map.put("behindNat", behindnat);
        }
        if (decoderesponse != null) {
            map.put("decodeResponse", decoderesponse);
        }
        if (removeacceptencoding != null) {
            map.put("removeAcceptEncoding", removeacceptencoding);
        }
        return this.api.callApi("network", "action", "addLocalServer", map);
    }

    /**
     * Adds an authority to pass-through the local proxies.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addPassThrough(String authority, String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("authority", authority);
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        return api.callApi("network", "action", "addPassThrough", map);
    }

    /**
     * Removes an alias.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeAlias(String name) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return api.callApi("network", "action", "removeAlias", map);
    }

    /**
     * Removes a local server/proxy.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeLocalServer(String address, String port) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("address", address);
        map.put("port", port);
        return api.callApi("network", "action", "removeLocalServer", map);
    }

    /**
     * Removes a pass-through.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removePassThrough(String authority) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("authority", authority);
        return api.callApi("network", "action", "removePassThrough", map);
    }

    /**
     * Sets whether or not an alias is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setAliasEnabled(String name, String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("enabled", enabled);
        return api.callApi("network", "action", "setAliasEnabled", map);
    }

    /**
     * Sets whether or not a pass-through is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setPassThroughEnabled(String authority, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("authority", authority);
        map.put("enabled", enabled);
        return api.callApi("network", "action", "setPassThroughEnabled", map);
    }

    /**
     * Sets the timeout, for reads and connects.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setConnectionTimeout(String timeout) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("timeout", timeout);
        return api.callApi("network", "action", "setConnectionTimeout", map);
    }

    /**
     * Sets the default user-agent.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setDefaultUserAgent(String useragent) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("userAgent", useragent);
        return api.callApi("network", "action", "setDefaultUserAgent", map);
    }

    /**
     * Sets the TTL of successful DNS queries.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setDnsTtlSuccessfulQueries(String ttl) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("ttl", ttl);
        return api.callApi("network", "action", "setDnsTtlSuccessfulQueries", map);
    }

    /**
     * Adds a host to be excluded from the HTTP proxy.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addHttpProxyExclusion(String host, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("host", host);
        if (enabled != null) {
            map.put("enabled", enabled);
        }
        return api.callApi("network", "action", "addHttpProxyExclusion", map);
    }

    /**
     * Removes an HTTP proxy exclusion.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeHttpProxyExclusion(String host) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("host", host);
        return api.callApi("network", "action", "removeHttpProxyExclusion", map);
    }

    /**
     * Sets the HTTP proxy configuration.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setHttpProxy(
            String host, String port, String realm, String username, String password)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("host", host);
        map.put("port", port);
        if (realm != null) {
            map.put("realm", realm);
        }
        if (username != null) {
            map.put("username", username);
        }
        if (password != null) {
            map.put("password", password);
        }
        return api.callApi("network", "action", "setHttpProxy", map);
    }

    /**
     * Sets whether or not the HTTP proxy authentication is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setHttpProxyAuthEnabled(String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("enabled", enabled);
        return api.callApi("network", "action", "setHttpProxyAuthEnabled", map);
    }

    /**
     * Sets whether or not the HTTP proxy is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setHttpProxyEnabled(String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("enabled", enabled);
        return api.callApi("network", "action", "setHttpProxyEnabled", map);
    }

    /**
     * Sets whether or not an HTTP proxy exclusion is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setHttpProxyExclusionEnabled(String host, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("host", host);
        map.put("enabled", enabled);
        return api.callApi("network", "action", "setHttpProxyExclusionEnabled", map);
    }

    /**
     * Sets the SOCKS proxy configuration.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setSocksProxy(
            String host,
            String port,
            String version,
            String usedns,
            String username,
            String password)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("host", host);
        map.put("port", port);
        if (version != null) {
            map.put("version", version);
        }
        if (usedns != null) {
            map.put("useDns", usedns);
        }
        if (username != null) {
            map.put("username", username);
        }
        if (password != null) {
            map.put("password", password);
        }
        return api.callApi("network", "action", "setSocksProxy", map);
    }

    /**
     * Sets whether or not the SOCKS proxy is enabled.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setSocksProxyEnabled(String enabled) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("enabled", enabled);
        return api.callApi("network", "action", "setSocksProxyEnabled", map);
    }

    /**
     * Sets whether or not to use the global HTTP state.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setUseGlobalHttpState(String use) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("use", use);
        return api.callApi("network", "action", "setUseGlobalHttpState", map);
    }

    /**
     * Adds a client certificate contained in a PKCS#12 file, the certificate is automatically set
     * as active and used.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addPkcs12ClientCertificate(String filepath, String password, String index)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("filePath", filepath);
        map.put("password", password);
        if (index != null) {
            map.put("index", index);
        }
        return api.callApi("network", "action", "addPkcs12ClientCertificate", map);
    }

    /**
     * Sets whether or not to use the active client certificate.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setUseClientCertificate(String use) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("use", use);
        return api.callApi("network", "action", "setUseClientCertificate", map);
    }

    /**
     * Adds a rate limit rule
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse addRateLimitRule(
            String description,
            String enabled,
            String matchregex,
            String matchstring,
            String requestspersecond,
            String groupby)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("description", description);
        map.put("enabled", enabled);
        map.put("matchRegex", matchregex);
        map.put("matchString", matchstring);
        map.put("requestsPerSecond", requestspersecond);
        map.put("groupBy", groupby);
        return api.callApi("network", "action", "addRateLimitRule", map);
    }

    /**
     * Remove a rate limit rule
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse removeRateLimitRule(String description) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("description", description);
        return api.callApi("network", "action", "removeRateLimitRule", map);
    }

    /**
     * Set enabled state for a rate limit rule.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setRateLimitRuleEnabled(String description, String enabled)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("description", description);
        map.put("enabled", enabled);
        return api.callApi("network", "action", "setRateLimitRuleEnabled", map);
    }

    /**
     * Provides a PAC file, proxying through the main proxy.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public byte[] proxypac() throws ClientApiException {
        return api.callApiOther("network", "other", "proxy.pac", null);
    }

    /**
     * Sets the HTTP proxy configuration.
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public byte[] setProxy(String proxy) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("proxy", proxy);
        return api.callApiOther("network", "other", "setProxy", map);
    }

    /**
     * Gets the Root CA certificate used to issue server certificates. Suitable to import into
     * client applications (e.g. browsers).
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public byte[] rootCaCert() throws ClientApiException {
        return api.callApiOther("network", "other", "rootCaCert", null);
    }
}
