package com.heowc.internal;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlUtil {

    public Document loadXmlFile(String fileName) throws IOException, SAXException, ParserConfigurationException {
        File file = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        return document;
    }

    public String getElement(Node node, String tagName) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            return element.getElementsByTagName(tagName).item(0).getTextContent();
        }
        return "";
    }
}
