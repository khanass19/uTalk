package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class PlanSpecRequest {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
