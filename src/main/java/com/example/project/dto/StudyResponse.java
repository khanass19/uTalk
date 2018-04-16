package com.example.project.dto;

import com.example.project.entity.Study;

public class StudyResponse {

    private Long id;

    private String place1;

    private String few1;

    private String time1;

    private UserResponse userResponse;

    public StudyResponse(Study study){
        this.id = study.getId();
        this.place1 = study.getPlace1();
        this.few1 = study.getFew1();
        this.time1 = study.getTime1();
        this.userResponse = new UserResponse(study.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getFew1() {
        return few1;
    }

    public void setFew1(String few1) {
        this.few1 = few1;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
