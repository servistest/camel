package com.dozerannotation;

import org.dozer.Mapping;

import java.util.Date;

/**
 * Created by alex on 31.3.17.
 */
public class User {
    @Mapping("myFirstName")
    private String firstName;
    @Mapping("myLastName")
    private String lastName;
    @Mapping("myDob")
    private Date dob;

    public User(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
