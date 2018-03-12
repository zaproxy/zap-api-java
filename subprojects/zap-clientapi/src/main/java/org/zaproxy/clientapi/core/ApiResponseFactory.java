/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2012 The ZAP Development Team
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
package org.zaproxy.clientapi.core;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public final class ApiResponseFactory {
	
	private ApiResponseFactory() {
	}
	
	public static ApiResponse getResponse(Node node) throws ClientApiException {
		if (node == null) {
			throw new ClientApiException("Null node");
		}
		Node typeNode = node.getAttributes().getNamedItem("type");
		if (typeNode != null) {
			String type = typeNode.getNodeValue();
			if ("list".equals(type)) {
				return new ApiResponseList(node);
			}
			if ("set".equals(type)) {
				return new ApiResponseSet(node);
			}
			if ("exception".equals(type)) {
				NamedNodeMap atts = node.getAttributes();

				String code = atts.getNamedItem("code").getNodeValue();
				String detail = null;
				if (atts.getNamedItem("detail") != null) {
					detail = atts.getNamedItem("detail").getNodeValue();
				}
				throw new ClientApiException(node.getTextContent(), code, detail); 
			}
		}
		return new ApiResponseElement(node);
	}

}
