/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2025 The ZAP Development Team
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
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AlertsFile {

    /**
     * Writes the alerts into an XML file with the following structure:
     *
     * <pre>
     * &lt;alerts&gt;
     *   &lt;alertsFound alertsFound="N"&gt;
     *     &lt;alert .../&gt;
     *   &lt;/alertsFound&gt;
     *   &lt;alertsNotFound alertsNotFound="M"&gt;
     *     &lt;alert .../&gt;
     *   &lt;/alertsNotFound&gt;
     *   &lt;ignoredAlertsFound ignoredAlertsFound="K"&gt;
     *     &lt;alert .../&gt;
     *   &lt;/ignoredAlertsFound&gt;
     * &lt;/alerts&gt;
     * </pre>
     */
    public static void saveAlertsToFile(
            List<Alert> requireAlerts,
            List<Alert> reportAlerts,
            List<Alert> ignoredAlerts,
            File outputFile)
            throws IOException {

        if (requireAlerts == null) {
            requireAlerts = new ArrayList<>();
        }
        if (reportAlerts == null) {
            reportAlerts = new ArrayList<>();
        }
        if (ignoredAlerts == null) {
            ignoredAlerts = new ArrayList<>();
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document alertsDocument = builder.newDocument();

            Element root = alertsDocument.createElement("alerts");
            alertsDocument.appendChild(root);

            if (!reportAlerts.isEmpty()) {
                Element alertsFound = alertsDocument.createElement("alertsFound");
                alertsFound.setAttribute("alertsFound", Integer.toString(reportAlerts.size()));
                for (Alert alert : reportAlerts) {
                    createAlertXMLElements(alertsDocument, alertsFound, alert);
                }
                root.appendChild(alertsFound);
            }

            if (!requireAlerts.isEmpty()) {
                Element alertsNotFound = alertsDocument.createElement("alertsNotFound");
                alertsNotFound.setAttribute(
                        "alertsNotFound", Integer.toString(requireAlerts.size()));
                for (Alert alert : requireAlerts) {
                    createAlertXMLElements(alertsDocument, alertsNotFound, alert);
                }
                root.appendChild(alertsNotFound);
            }

            if (!ignoredAlerts.isEmpty()) {
                Element ignoredAlertsFound = alertsDocument.createElement("ignoredAlertsFound");
                ignoredAlertsFound.setAttribute(
                        "ignoredAlertsFound", Integer.toString(ignoredAlerts.size()));
                for (Alert alert : ignoredAlerts) {
                    createAlertXMLElements(alertsDocument, ignoredAlertsFound, alert);
                }
                root.appendChild(ignoredAlertsFound);
            }

            writeAlertsToFile(outputFile, alertsDocument);

        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException("Failed to save alerts to file: " + outputFile, e);
        }
    }

    private static void writeAlertsToFile(File outputFile, Document doc)
            throws IOException, TransformerException {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        try (OutputStream os = Files.newOutputStream(outputFile.toPath())) {
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(os);
            transformer.transform(source, result);
            System.out.println("alert xml report saved to: " + outputFile.getAbsolutePath());
        }
    }

    private static void createAlertXMLElements(Document doc, Element alertsParent, Alert alert) {

        Element alertElement = doc.createElement("alert");

        if (alert.getName() != null) {
            alertElement.setAttribute("name", alert.getName());
            // TODO Remove once alert attribute is no longer supported.
            alertElement.setAttribute("alert", alert.getName());
        }

        if (alert.getRisk() != null) {
            alertElement.setAttribute("risk", alert.getRisk().name());
        }

        if (alert.getConfidence() != null) {
            alertElement.setAttribute("confidence", alert.getConfidence().name());
        }

        if (alert.getUrl() != null) {
            alertElement.setAttribute("url", alert.getUrl());
        }

        if (alert.getParam() != null) {
            alertElement.setAttribute("param", alert.getParam());
        }

        if (alert.getOther() != null) {
            alertElement.setAttribute("other", alert.getOther());
        }

        if (alert.getAttack() != null) {
            alertElement.setAttribute("attack", alert.getAttack());
        }

        if (alert.getDescription() != null) {
            alertElement.setAttribute("description", alert.getDescription());
        }

        if (alert.getSolution() != null) {
            alertElement.setAttribute("solution", alert.getSolution());
        }

        if (alert.getReference() != null) {
            alertElement.setAttribute("reference", alert.getReference());
        }

        alertsParent.appendChild(alertElement);
    }

    /**
     * Reads alerts of a given type from the file.
     *
     * @param file The XML file previously written by {@link #saveAlertsToFile}.
     * @param alertType The wrapper element name under &lt;alerts&gt;:
     *     <ul>
     *       <li>"alertsFound"
     *       <li>"alertsNotFound"
     *       <li>"ignoredAlertsFound"
     *     </ul>
     *
     * @return list of {@link Alert}s found inside the matching wrapper(s).
     */
    public static List<Alert> getAlertsFromFile(File file, String alertType)
            throws IOException {

        List<Alert> alerts = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document alertsDoc = builder.parse(file);

            Element root = alertsDoc.getDocumentElement();

            NodeList rootChildren = root.getChildNodes();
            for (int i = 0; i < rootChildren.getLength(); i++) {
                Node wrapperNode = rootChildren.item(i);
                if (wrapperNode.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Element wrapperElem = (Element) wrapperNode;
                if (!alertType.equals(wrapperElem.getTagName())) {
                    continue;
                }

                NodeList childNodes = wrapperElem.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node node = childNodes.item(j);
                    if (node.getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }

                    Element element = (Element) node;
                    if (!"alert".equals(element.getTagName())) {
                        continue;
                    }

                    String name = element.getAttribute("name");
                    if (name == null || name.isEmpty()) {
                        // TODO Remove once alert attribute is no longer supported.
                        name = element.getAttribute("alert");
                    }

                    Alert alert =
                            new Alert(
                                    emptyToNull(element.getAttribute("url")),
                                    emptyToNull(element.getAttribute("risk")),
                                    emptyToNull(element.getAttribute("confidence")),
                                    emptyToNull(element.getAttribute("param")),
                                    emptyToNull(element.getAttribute("other")),
                                    name);

                    alerts.add(alert);
                }
            }

        } catch (ParserConfigurationException | SAXException e) {
            throw new RemoteException("Failed to read alerts from file: " + file, e);
        }

        return alerts;
    }

    private static String emptyToNull(String value) {
        return (value == null || value.isEmpty()) ? null : value;
    }
}