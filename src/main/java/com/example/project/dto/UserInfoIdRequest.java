package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class UserInfoIdRequest {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
