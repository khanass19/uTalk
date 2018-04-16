package com.example.project.dto;

import com.example.project.entity.Role;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {

    // Fields

    @NotNull
    @Size(min=3, max=30)
    private String firstName;

    @NotNull
    @Size(min=3, max=30)
    private String lastName;

    @NotNull
    @Email
    @Size(min=6, max=30)
    private String email;

    @NotNull
    @Size(min=4, max=12)
    private String password;

    @NotNull
    private Role role;

    // Getters & Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}
