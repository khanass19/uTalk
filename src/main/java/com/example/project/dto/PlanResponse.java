package com.example.project.dto;

import com.example.project.entity.Plan;

public class PlanResponse {
    private Long id;
    private String task;
    private String date;
    private String time;
    private Long idUser;

    public PlanResponse(Plan plan) {
        this.id = plan.getId();
        this.task = plan.getTask();
        this.date = plan.getDate();
        this.time = plan.getTime();
        this.idUser = plan.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
