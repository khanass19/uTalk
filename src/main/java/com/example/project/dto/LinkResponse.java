package com.example.project.dto;

import com.example.project.entity.Link;

public class LinkResponse {

    private Long id;

    private String facebookLink;

    private String vkLink;

    private String linkedinLink;

    private String twitterLink;

    private UserResponse userResponse;

    public LinkResponse(Link link) {
        this.id = link.getId();
        this.facebookLink = link.getFacebookLink();
        this.vkLink = link.getVkLink();
        this.linkedinLink = link.getLinkedinLink();
        this.twitterLink = link.getTwitterLink();
        this.userResponse = new UserResponse(link.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getVkLink() {
        return vkLink;
    }

    public void setVkLink(String vkLink) {
        this.vkLink = vkLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
