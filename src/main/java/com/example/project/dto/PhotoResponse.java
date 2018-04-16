package com.example.project.dto;

import com.example.project.entity.Photo;

public class PhotoResponse {

    private Long id;
    private String url;
    private String foot;
    private UserResponse userResponse;

    public PhotoResponse(Photo photo) {
        this.id = photo.getId();
        this.url = photo.getUrl();
        this.foot = photo.getFoot();
        this.userResponse = new UserResponse(photo.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
