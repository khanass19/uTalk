package com.example.project.dto;


import com.example.project.entity.Bookmark;
import com.example.project.entity.Message;
import com.example.project.entity.Role;
import com.example.project.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;

    private List<BookmarkResponse> bookmarkResponses = new ArrayList<BookmarkResponse>();

    public UserResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        for(Bookmark bookmark : user.getBookmarks()){
            BookmarkResponse bookmarkResponse = new BookmarkResponse(bookmark);
            bookmarkResponses.add(bookmarkResponse);
        }
        this.role = user.getRole();
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<BookmarkResponse> getBookmarkResponses() {
        return bookmarkResponses;
    }

    public void setBookmarkResponses(List<BookmarkResponse> bookmarkResponses) {
        this.bookmarkResponses = bookmarkResponses;
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
