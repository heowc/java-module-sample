package com.heowc;

import com.heowc.model.Contact;
import com.heowc.util.ContactLoadException;
import com.heowc.util.ContactLoader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Address book viewer application: Started");
        List<Contact> contacts = new ArrayList<>();
        ContactLoader contactLoader = new ContactLoader();

        try {
            contacts = contactLoader.loadContacts(getResourceFileName("contact.xml"));
        } catch (ContactLoadException e) {
            logger.severe(e.getLocalizedMessage());
            System.exit(0);
        }

        System.out.println(contacts);
        logger.info("Address book viewer application: Completed");
    }

    private static String getResourceFileName(String fileName) {
        URL resource = ClassLoader.getSystemClassLoader().getResource(fileName);
        if (resource != null) {
            return resource.getPath();
        } else {
            return null;
        }
    }
}
