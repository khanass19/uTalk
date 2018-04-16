package com.example.project.dto;

import com.example.project.entity.Note;

public class NoteResponse {

    private Long id;

    private String text;

    private Long idUser;

    public NoteResponse(Note note) {
        this.id = note.getId();
        this.text = note.getText();
        this.idUser = note.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
