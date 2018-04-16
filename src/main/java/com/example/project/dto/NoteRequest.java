package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class NoteRequest {

    private String text;

    @NotNull
    private Long idUser;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
