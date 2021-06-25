package com.sapient.service.contact;

import com.sapient.contact.ContactManager;
import com.sapient.contact.model.Contact;
import com.sapient.contact.repository.ContactRepository;
import com.sapient.contact.exception.NewContactException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContactManagerTest {

    ContactRepository repository;
    ContactManager contactManager;



    @BeforeEach
    public void setup(){
        repository = new ContactRepository();
        contactManager = new ContactManager(repository);
    }

    /**
     *  Requirement 1: I am an admin user, i want to add a new contact in contact list
     *
     *  ContactManager/ContactService -> who is going to manage the contacts
     *  Contact Entity {}
     */

    @Test
    @DisplayName("Should Add New Contact")
    public void shouldCreateContactSuccesffully(){
        Contact contact = new Contact("id1", "firstName", "lastName");

        Contact createdContact = contactManager.addNewContact(contact);
        assertNotNull(createdContact);

    }

    /**
     *  My contact con't created if firstname and lastname
     */

    @Test
    public void shouldCreateContactIfFirstNameAndLastNameHasBeenSpecified(){
        String firstName = "Shobhit";
        String lastName = "Singh";
        Contact contact = new Contact("id1", firstName, lastName);
        Contact createdContact = contactManager.addNewContact(contact);
        assertNotNull(createdContact);
    }

    @Test
    public void shouldNotCreateContactIfFirstNameAndLastNameHasNotBeenSpecified(){
        String firstName = null;
        String lastName = null;
        Contact contact = new Contact("id1", firstName, lastName);
        Assertions.assertThrows(NewContactException.class, () -> {
            contactManager.addNewContact(contact);
        });
    }

    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "Should Run only on Windows")
    public void shouldNotCreateContactIfFirstNameAndLastNameHasNotBeenSpecified222(){
        String firstName = null;
        String lastName = null;
        Contact contact = new Contact("id1", firstName, lastName);
        Assertions.assertThrows(NewContactException.class, () -> {
            contactManager.addNewContact(contact);
        });
    }

    //Assumptions
    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "Should Run only on Windows")
    public void shouldNotCreateContactIfFirstNameAndLastNameHasNotBeenSpecified333(){
        String firstName = null;
        String lastName = null;

        Assumptions.assumeTrue("DEV".equalsIgnoreCase(System.getProperty("ENV")));
        Contact contact = new Contact("id1", firstName, lastName);
        Assertions.assertThrows(NewContactException.class, () -> {
            contactManager.addNewContact(contact);
        });
    }


    //@RepeatedTest

    @Test
    @RepeatedTest(value = 5,name="Repeating Contact Creation {currentRepetition} of {totalRepetions}")
    public void shouldNotCreateContactIfFirstNameAndLastNameHasNotBeenSpecified3434(){
        String firstName = null;
        String lastName = null;
        Contact contact = new Contact("id1", firstName, lastName);
        Assertions.assertThrows(NewContactException.class, () -> {
            contactManager.addNewContact(contact);
        });
    }

    //Parameterized Test
    //Source


    @ParameterizedTest
    @CsvFileSource( resources = "/data.csv")
    public void shouldCreateContactIfFirstNameAndLastNameHasBeenSpecified3232(String firstName){
//        String firstName = "Shobhit";
        String lastName = "Singh";
        Contact contact = new Contact("id1", firstName, lastName);
        Contact createdContact = contactManager.addNewContact(contact);
        assertNotNull(createdContact);
    }




    @Nested
    class RepeatedTests {
        @Test
        @RepeatedTest(value = 5,name="Repeating232 Contact Creation {currentRepetition} of {totalRepetions}")
        public void shouldNotCreateContactIfFirstNameAndLastNameHasNotBeenSpecified3434(){
            String firstName = null;
            String lastName = null;
            Contact contact = new Contact("id1", firstName, lastName);
            Assertions.assertThrows(NewContactException.class, () -> {
                contactManager.addNewContact(contact);
            });
        }
    }

}
