package com.sapient.contact.repository;

import com.sapient.contact.model.Contact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactRepository {
    private List<Contact> contactList = new ArrayList<>();

    public Contact createNewContact(Contact contact) {
        String id = new Date().toString();
        contact.validateFirstName();
        contact.validateLastName();
        Contact c = new Contact("id1", contact.getFirstName(), contact.getLastName());
        contactList.add(c);
        return c;
    }
}
