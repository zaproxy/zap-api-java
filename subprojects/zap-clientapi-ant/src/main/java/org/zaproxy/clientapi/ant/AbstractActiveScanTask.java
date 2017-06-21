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
package org.zaproxy.clientapi.ant;

import org.apache.tools.ant.BuildException;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApiException;

public abstract class AbstractActiveScanTask extends ZapTask {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void execute() throws BuildException {
		try {
			waitForActiveScan(extractValue(startScan()));
		} catch (Exception e) {
			throw new BuildException(e);
		}
	}

	protected abstract ApiResponse startScan() throws ClientApiException;

	private void waitForActiveScan(String scanId) throws ClientApiException, InterruptedException {
		int progress;
		do {
			progress = Integer.parseInt(extractValue(getClientApi().ascan.status(scanId)));
			Thread.sleep(1000);
		} while (progress < 100);
	}
}
