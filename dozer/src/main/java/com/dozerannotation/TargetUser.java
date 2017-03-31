package com.dozerannotation;

import java.util.Date;

/**
 * Created by alex on 31.3.17.
 */
public class TargetUser {

    private String myFirstName;
    private String myLastName;
    private Date myDob;

    public void setMyFirstName(String myFirstName) {
        this.myFirstName = myFirstName;
    }

    public void setMyLastName(String myLastName) {
        this.myLastName = myLastName;
    }

    public void setMyDob(Date myDob) {
        this.myDob = myDob;
    }

    @Override
    public String toString() {
        return "TargetUser{" +
                "myFirstName='" + myFirstName + '\'' +
                ", myLastName='" + myLastName + '\'' +
                ", myDob=" + myDob +
                '}';
    }
}
