/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2018 The ZAP Development Team
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
public class Websocket {

    private final ClientApi api;

    public Websocket(ClientApi api) {
        this.api = api;
    }

    /**
     * Returns all of the registered web socket channels
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse channels() throws ClientApiException {
        return api.callApi("websocket", "view", "channels", null);
    }

    /**
     * Returns full details of the message specified by the channelId and messageId
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse message(String channelid, String messageid) throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("channelId", channelid);
        map.put("messageId", messageid);
        return api.callApi("websocket", "view", "message", map);
    }

    /**
     * Returns a list of all of the messages that meet the given criteria (all optional), where
     * channelId is a channel identifier, start is the offset to start returning messages from
     * (starting from 0), count is the number of messages to return (default no limit) and
     * payloadPreviewLength is the maximum number bytes to return for the payload contents
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse messages(
            String channelid, String start, String count, String payloadpreviewlength)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (channelid != null) {
            map.put("channelId", channelid);
        }
        if (start != null) {
            map.put("start", start);
        }
        if (count != null) {
            map.put("count", count);
        }
        if (payloadpreviewlength != null) {
            map.put("payloadPreviewLength", payloadpreviewlength);
        }
        return api.callApi("websocket", "view", "messages", map);
    }

    /**
     * Returns a text representation of an intercepted websockets message
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse breakTextMessage() throws ClientApiException {
        return api.callApi("websocket", "view", "breakTextMessage", null);
    }

    /**
     * Sends the specified message on the channel specified by channelId, if outgoing is 'True' then
     * the message will be sent to the server and if it is 'False' then it will be sent to the
     * client
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse sendTextMessage(String channelid, String outgoing, String message)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("channelId", channelid);
        map.put("outgoing", outgoing);
        map.put("message", message);
        return api.callApi("websocket", "action", "sendTextMessage", map);
    }

    /**
     * Sets the text message for an intercepted websockets message
     *
     * <p>This component is optional and therefore the API will only work if it is installed
     */
    public ApiResponse setBreakTextMessage(String message, String outgoing)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        map.put("outgoing", outgoing);
        return api.callApi("websocket", "action", "setBreakTextMessage", map);
    }
}
