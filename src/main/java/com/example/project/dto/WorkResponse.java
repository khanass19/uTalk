package com.example.project.dto;

import com.example.project.entity.Work;

public class WorkResponse {

    private Long id;

    private String place1;
    private String place2;

    private String few1;
    private String few2;

    private String time1;
    private String time2;

    private UserResponse userResponse;

    public WorkResponse(Work work) {
        this.id = work.getId();
        this.place1 = work.getPlace1();
        this.place2 = work.getPlace2();
        this.few1 = work.getFew1();
        this.few2 = work.getFew2();
        this.time1 = work.getTime1();
        this.time2 = work.getTime2();
        this.userResponse = new UserResponse(work.getUser());
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

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public String getFew1() {
        return few1;
    }

    public void setFew1(String few1) {
        this.few1 = few1;
    }

    public String getFew2() {
        return few2;
    }

    public void setFew2(String few2) {
        this.few2 = few2;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }


}
