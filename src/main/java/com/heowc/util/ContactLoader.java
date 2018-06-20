package com.heowc.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.heowc.internal.XmlUtil;
import com.heowc.model.Contact;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ContactLoader {

    public List<Contact> loadContacts(String fileName) throws ParserConfigurationException, SAXException, IOException {
        XmlUtil xmlUtil = new XmlUtil();
        Document document = xmlUtil.loadXmlFile(fileName);
        return null;
    }
}
