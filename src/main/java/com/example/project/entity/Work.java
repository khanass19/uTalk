package com.example.project.entity;

import javax.persistence.*;

@Entity
public class Work {

    @OneToOne
    @MapsId
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String place1;

    @Column(length = 500)
    private String place2;

    @Column(length = 3000)
    private String few1;

    @Column(length = 3000)
    private String few2;

    @Column(length = 500)
    private String time1;

    @Column(length = 500)
    private String time2;

    public Work() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
