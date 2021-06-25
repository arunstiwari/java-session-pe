package com.sapient.contact.model;

import com.sapient.contact.exception.NewContactException;

public class Contact {
    private String firstName;
    private String lastName;
    private String id;

    public Contact(String id1, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void validateFirstName() {
        if(this.firstName == null || this.firstName.isBlank())
            throw new NewContactException("FirstName should not be blank");
    }

    public void validateLastName() {
        if(this.lastName ==null || this.lastName.isBlank())
            throw new NewContactException("LastName should not be blank");
    }
}
