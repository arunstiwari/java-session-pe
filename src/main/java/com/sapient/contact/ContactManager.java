package com.sapient.contact;

import com.sapient.contact.model.Contact;
import com.sapient.contact.repository.ContactRepository;

import java.util.Date;

public class ContactManager {

    private ContactRepository contactRepository;

    public ContactManager(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact addNewContact(Contact contact) {
        return contactRepository.createNewContact(contact);
    }
}
