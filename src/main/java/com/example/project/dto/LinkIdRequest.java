package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class LinkIdRequest {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
