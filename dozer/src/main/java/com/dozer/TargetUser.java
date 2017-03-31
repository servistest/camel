package com.dozer;

import java.util.Date;

/**
 * Created by alex on 31.3.17.
 */
public class TargetUser {

    private String myFirstName;
    private String myLastName;

    public String getMyFirstName() {
        return myFirstName;
    }

    public void setMyFirstName(String myFirstName) {
        this.myFirstName = myFirstName;
    }

    public String getMyLastName() {
        return myLastName;
    }

    public void setMyLastName(String myLastName) {
        this.myLastName = myLastName;
    }

    @Override
    public String toString() {
        return "TargetUser{" +
                "myFirstName='" + myFirstName + '\'' +
                ", myLastName='" + myLastName + '\'' +
                '}';
    }
}
