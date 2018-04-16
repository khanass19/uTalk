package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class PlanRequest {

    @NotNull
    private String task;

    @NotNull
    private String date;

    @NotNull
    private String time;

    @NotNull
    private Long idUser;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
