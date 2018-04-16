package com.example.project.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(mappedBy = "user")
    private List<Photo> photos =  new ArrayList<Photo>();

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks =  new ArrayList<Bookmark>();

    @OneToMany(mappedBy = "user")
    private List<Plan> plans = new ArrayList<Plan>();

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Note note;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Ban ban;

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    private Avatar avatar;

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    private Link link;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Work work;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Study study;

    @OneToMany(mappedBy ="author")
    private List<Message> messages = new ArrayList<Message>();

    public User(){
    }

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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
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

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
}

