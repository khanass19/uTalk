package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class UserSpecRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
