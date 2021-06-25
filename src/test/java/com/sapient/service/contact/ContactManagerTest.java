package com.sapient.service.contact;

import com.sapient.contact.ContactManager;
import com.sapient.contact.model.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactManagerTest {

    /**
     *  Requiremet 1: I am an admin user, i want to add a new contact in contact list
     *
     *  ContactManager/ContactService -> who is going to manage the contacts
     *  Contact Entity {}
     */

    @Test
    @DisplayName("Should Add New Contact")
    public void shouldCreateContactSuccesffully(){
        Contact contact = null;

        ContactManager contactManager = new ContactManager();

        int contactId = contactManager.addNewContact(contact);
        assertEquals(0,contactId);

    }
}
