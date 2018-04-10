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

import static org.junit.Assert.assertTrue;

import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.BuildFileRule;
import org.apache.tools.ant.filters.StringInputStream;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.zaproxy.clientapi.core.ClientApiException;

/** Tests that the tasks accept the expected attributes and nested elements. */
public class BuildTest {

    private static final String BUILD_FILE_NAME = "build.xml";
    private static final String REPORT_PATH = "report.html";

    private static SimpleServer zap;
    private static SimpleServer targetSite;

    @Rule public final TemporaryFolder buildDir = new TemporaryFolder();

    @Rule public final BuildFileRule buildRule = new BuildFileRule();

    @BeforeClass
    public static void setUp() throws IOException {
        zap =
                new SimpleServer(
                        "text/xml; charset=UTF-8",
                        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><response>OK</response>");

        targetSite = new SimpleServer("text/plain", "");
    }

    @Before
    public void setUpBuildFile() {
        zap.clearResponses();

        File buildFile = new File(buildDir.getRoot(), BUILD_FILE_NAME);
        if (!buildFile.exists()) {
            try {
                try (InputStream is = BuildTest.class.getResourceAsStream(BUILD_FILE_NAME)) {
                    Files.copy(is, buildFile.toPath());
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to set up the test:", e);
            }
        }

        buildRule.configureProject(buildFile.getAbsolutePath());

        // Properties used in build.xml file
        buildRule.getProject().setProperty("zap.addr", "localhost");
        buildRule.getProject().setProperty("zap.port", Integer.toString(zap.getListeningPort()));
        buildRule.getProject().setProperty("zap.key", "API_KEY");
        buildRule
                .getProject()
                .setProperty("zap.targetUrl", "http://localhost:" + targetSite.getListeningPort());
        buildRule.getProject().setProperty("zap.session", "session");
        buildRule.getProject().setProperty("zap.report.path", REPORT_PATH);
        buildRule.getProject().setProperty("zap.report.type", "html");
        buildRule.getProject().setProperty("zap.report.overwrite", "false");
    }

    @AfterClass
    public static void tearDown() {
        if (zap != null) {
            zap.stop();
        }

        if (targetSite != null) {
            targetSite.stop();
        }
    }

    @Test
    public void shouldExecuteTargetAccessUrl() {
        buildRule.executeTarget("accessUrl");
    }

    @Test
    public void shouldExecuteTargetActiveScanSubtree() {
        zap.addResponse("http://zap/xml/ascan/action/scan/", "<scan>0</scan>");
        zap.addResponse("http://zap/xml/ascan/view/status/", "<status>100</status>");
        buildRule.executeTarget("activeScanSubtree");
    }

    @Test
    public void shouldExecuteTargetActiveScanUrl() {
        zap.addResponse("http://zap/xml/ascan/action/scan/", "<scan>0</scan>");
        zap.addResponse("http://zap/xml/ascan/view/status/", "<status>100</status>");
        buildRule.executeTarget("activeScanUrl");
    }

    @Test
    public void shouldExecuteTargetAlertCheck() {
        try {
            buildRule.executeTarget("alertCheck");
        } catch (BuildException e) {
            assertTrue(e.getCause() instanceof ClientApiException);
            assertTrue(e.getCause().getMessage().startsWith("Not found 1 alerts"));
        }
    }

    @Test
    public void shouldExecuteTargetLoadSession() {
        buildRule.executeTarget("loadSession");
    }

    @Test
    public void shouldExecuteTargetNewSession() {
        buildRule.executeTarget("newSession");
    }

    @Test
    public void shouldExecuteTargetSaveSession() {
        buildRule.executeTarget("saveSession");
    }

    @Test
    public void shouldExecuteTargetSpider() {
        zap.addResponse("http://zap/xml/spider/action/scan/", "<scan>0</scan>");
        zap.addResponse("http://zap/xml/spider/view/status/", "<status>100</status>");
        buildRule.executeTarget("spider");
    }

    @Test
    public void shouldExecuteTargetStopZap() {
        buildRule.executeTarget("stopZap");
    }

    @Test
    public void shouldExecuteReport() {
        buildRule.executeTarget("report");
        assertTrue("Report file not created.", new File(buildDir.getRoot(), REPORT_PATH).exists());
    }

    private static class SimpleServer extends NanoHTTPD {

        private final String mimeType;
        private final String defaultResponse;
        private final Map<String, String> pathResponses;

        public SimpleServer(String mimeType, String defaultResponse) throws IOException {
            super(0);
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);

            this.mimeType = mimeType;
            this.defaultResponse = defaultResponse;
            this.pathResponses = new HashMap<>();
        }

        public void addResponse(String path, String string) {
            pathResponses.put(path, string);
        }

        public void clearResponses() {
            pathResponses.clear();
        }

        @Override
        public Response serve(IHTTPSession session) {
            String response = pathResponses.get(session.getUri());
            if (response == null) {
                response = defaultResponse;
            }
            return new Response(
                    Response.Status.OK,
                    mimeType,
                    new StringInputStream(response),
                    response.length()) {
                // Extend to access the constructor.
            };
        }
    }
}
