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

import java.io.File;
import java.util.HashMap;
import org.zaproxy.clientapi.service.ClientApiTaskService;

public class ClientApiMain {

    private final HashMap<String, Object> params = new HashMap<>();
    private String zapaddr = "localhost";
    private int zapport = 8090;
    private Task task;
    private ClientApi api;
    private boolean debug = false;

    private enum Task {
        stop,
        showAlerts,
        checkAlerts,
        saveSession,
        newSession,
        activeScanUrl,
        activeScanSiteInScope,
        addExcludeRegexToContext,
        addIncludeRegexToContext,
        addIncludeOneMatchingNodeToContext
    }

    public static void main(String[] args) {
        new ClientApiMain(args);
    }

    public ClientApiMain(String[] args) {
        initialize(args);
        executeTask();
    }

    private void executeTask() {

        ClientApiTaskService service = new ClientApiTaskService(api, params);

        try {
            switch (task) {
                case stop:
                    service.stop();
                    break;
                case checkAlerts:
                    service.checkAlerts();
                    break;
                case showAlerts:
                    service.showAlerts();
                    break;
                case saveSession:
                    service.saveSession();
                    break;
                case newSession:
                    service.newSession();
                    break;
                case activeScanUrl:
                    service.activeScanUrl();
                    break;
                case activeScanSiteInScope:
                    service.activeScanSiteInScope();
                    break;
                case addExcludeRegexToContext:
                    service.excludeRegexFromContext();
                    break;
                case addIncludeRegexToContext:
                    service.includeRegexInContext();
                    break;
                case addIncludeOneMatchingNodeToContext:
                    service.includeOneMatchingNode();
                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            showHelp();
            System.exit(1);
        }
    }

    private void initialize(String[] args) {
        if (args.length == 0) {
            showHelp();
            System.exit(1);
        }

        if ("help".equalsIgnoreCase(args[0])) {
            if (args.length > 1) {
                setTask(args[1]);
            }
            showHelp();
            System.exit(0);
        }

        setTask(args[0]);

        for (String arg : args) {
            String[] pair = arg.split("=", 2);
            if (pair.length != 2) {
                continue;
            }

            String key = pair[0];
            String value = pair[1];

            if ("zapaddr".equalsIgnoreCase(key)) {
                zapaddr = value;
            } else if ("zapport".equalsIgnoreCase(key)) {
                try {
                    zapport = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid zapport: " + value);
                    showHelp();
                    System.exit(1);
                }
            } else if ("debug".equalsIgnoreCase(key) && "true".equalsIgnoreCase(value)) {
                debug = true;
            } else if (key.endsWith("File")) {
                params.put(key, new File(value));
            } else {
                params.put(key, value);
            }
        }

        api = new ClientApi(zapaddr, zapport, (String) params.get("apikey"), debug);
    }

    private void setTask(String arg) {
        try {
            task = Task.valueOf(arg);
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown task: " + arg);
            showHelp();
            System.exit(1);
        }
    }

    private void showHelp() {
        String help =
                "usage: java -jar zap-api.jar <subcommand> [args]\n\n"
                        + "Type 'java -jar zap-api.jar help <subcommand>' for help on a specific subcommand.\n\n"
                        + "Available subcommands:\n"
                        + "\tstop\n"
                        + "\tcheckAlerts\n"
                        + "\tshowAlerts\n"
                        + "\tsaveSession\n"
                        + "\tnewSession\n"
                        + "\tactiveScanUrl\n"
                        + "\tactiveScanSiteInScope\n"
                        + "\taddExcludeRegexToContext\n"
                        + "\taddIncludeRegexToContext\n"
                        + "\taddIncludeOneMatchingNodeToContext\n";

        System.out.println(help);
    }
}
