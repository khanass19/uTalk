package com.example.project.dto;

import com.example.project.entity.Avatar;

public class AvatarResponse {

    private Long id;

    private String photo;

    private Long idUser;

    public AvatarResponse(Avatar avatar) {
        this.id = avatar.getId();
        this.photo = avatar.getPhoto();
        this.idUser = avatar.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
