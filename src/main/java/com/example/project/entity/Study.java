package com.example.project.entity;

import javax.persistence.*;

@Entity
public class Study {

    @OneToOne
    @MapsId
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String place1;

    @Column(length = 3000)
    private String few1;

    @Column(length = 100)
    private String time1;

    public Study() {
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
}
