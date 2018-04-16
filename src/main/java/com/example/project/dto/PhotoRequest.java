package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class PhotoRequest {

    @NotNull
    private String url;

    private String foot;

    @NotNull
    private Long idUser;

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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
