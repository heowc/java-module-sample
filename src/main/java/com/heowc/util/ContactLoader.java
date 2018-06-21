package com.heowc.util;

import com.heowc.model.Address;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.heowc.internal.XmlUtil;
import com.heowc.model.Contact;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactLoader {

    public List<Contact> loadContacts(String fileName) throws ContactLoadException {
        List<Contact> contacts = new ArrayList<>();
        XmlUtil xmlUtil = new XmlUtil();

        Document doc;
        try {
            doc = xmlUtil.loadXmlFile(fileName);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ContactLoadException("Unable to load Contact file");
        }

        NodeList nodeList = doc.getElementsByTagName("contact");
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node contactNode = nodeList.item(temp);
            if (contactNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) contactNode;

                Contact contact = new Contact();
                contact.setFirstName(xmlUtil.getElement(contactNode, "firstname"));
                contact.setLastName(xmlUtil.getElement(contactNode, "lastname"));
                contact.setPhone(xmlUtil.getElement(contactNode, "phone"));
                Node addressNode = eElement.getElementsByTagName("address").item(0);

                Address address = new Address();
                address.setStreet(xmlUtil.getElement(addressNode, "street"));
                address.setCity(xmlUtil.getElement(addressNode, "city"));
                address.setState(xmlUtil.getElement(addressNode, "state"));
                address.setCountry(xmlUtil.getElement(addressNode, "country"));
                contact.setAddress(address);

                contacts.add(contact);
            }
        }
        return contacts;
    }
}
