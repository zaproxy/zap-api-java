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

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.tools.ant.BuildException;

public class ReportTask extends ZapTask {

	private static final String HTML_REPORT_TYPE = "html";
	private static final String MD_REPORT_TYPE = "md";
	private static final String XML_REPORT_TYPE = "xml";
	private static final String DEFAULT_REPORT_TYPE = HTML_REPORT_TYPE;

	private static final List<String> SUPPORTED_REPORT_TYPES = Arrays.asList(HTML_REPORT_TYPE, MD_REPORT_TYPE, XML_REPORT_TYPE);

	private String type = DEFAULT_REPORT_TYPE;
	private File file;
	private boolean overwrite;

	public void setType(String type) {
		this.type = type;
	}

	public void setFile(String file) {
		this.file = new File(file);
		if (!this.file.isAbsolute()) {
			this.file = new File(getProject().getBaseDir(), file);
		}
	}

	public void setOverwrite(boolean overwrite) {
		this.overwrite = overwrite;
	}

	@Override
	public void execute() throws BuildException {
		validateTaskAttributes();

		byte[] reportContents;
		try {
			switch (type.toLowerCase()) {
			case MD_REPORT_TYPE:
				reportContents = this.getClientApi().core.mdreport();
				break;
			case XML_REPORT_TYPE:
				reportContents = this.getClientApi().core.xmlreport();
				break;
			case HTML_REPORT_TYPE:
			default:
				reportContents = this.getClientApi().core.htmlreport();
				break;
			}
		} catch (Exception e) {
			throw new BuildException("Failed to obtain the report from ZAP: " + e.getMessage(), e);
		}

		try (OutputStream os = Files.newOutputStream(file.toPath())) {
			os.write(reportContents);
		} catch (IOException e) {
			throw new BuildException("Failed to save the report: " + e.getMessage(), e);
		}

	}

	private void validateTaskAttributes() {
		if (type == null || type.isEmpty()) {
			type = DEFAULT_REPORT_TYPE;
		} else {
			type = type.toLowerCase(Locale.ROOT);
			if (!SUPPORTED_REPORT_TYPES.contains(type)) {
				throw new BuildException("Unknown report type [" + type + "], supported types: " + SUPPORTED_REPORT_TYPES);
			}
		}

		if (file == null) {
			throw new BuildException("The 'file' attribute must be provided.");
		}

		if (file.isFile()) {
			if (!file.canWrite()) {
				throw new BuildException("The provided file is not writable: " + file.getAbsolutePath());
			}

			if (!overwrite) {
				throw new BuildException(
						"The file already exists but 'overwrite' attribute is not set to 'true': " + file.getAbsolutePath());
			}
		} else if (!file.exists()) {
			File dir = file.getParentFile();
			if (dir == null) {
				throw new BuildException(
						"Unable to determine parent directory of the file provided: " + file.getAbsolutePath());
			}

			dir.mkdirs();
			if (!dir.canWrite()) {
				throw new BuildException("The provided directory does not exist or is not writable: " + dir.getAbsolutePath());
			}
		} else {
			throw new BuildException("The 'file' attribute does not specify a file: " + file.getAbsolutePath());
		}
	}

}
