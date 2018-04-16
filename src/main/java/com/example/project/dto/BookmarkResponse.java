package com.example.project.dto;

import com.example.project.entity.Bookmark;

public class BookmarkResponse {

    private String link;
    private String name;
    private Long idUser;

    public BookmarkResponse(Bookmark bookmark) {
        this.link = bookmark.getLink();
        this.name = bookmark.getName();
        this.idUser = bookmark.getUser().getId();
    }

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
