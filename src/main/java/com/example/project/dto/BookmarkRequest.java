package com.example.project.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookmarkRequest {

    @NotNull
    private String link;

    @NotNull
    @Size(min=1, max=12)
    private String name;

    private Long idUser;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }


}
