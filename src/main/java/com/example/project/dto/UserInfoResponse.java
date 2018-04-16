package com.example.project.dto;

import com.example.project.entity.UserInfo;

public class UserInfoResponse {

    private Long id;

    private String city;

    private String country;

    private int age;

    private String gender;

    private String fewWords;

    private String number;

    private UserResponse userResponse;

    public UserInfoResponse(UserInfo userInfo) {
        this.id = userInfo.getId();
        this.city = userInfo.getCity();
        this.country = userInfo.getCountry();
        this.age = userInfo.getAge();
        this.gender = userInfo.getGender();
        this.fewWords = userInfo.getFewWords();
        this.number = userInfo.getNumber();
        this.userResponse = new UserResponse(userInfo.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFewWords() {
        return fewWords;
    }

    public void setFewWords(String fewWords) {
        this.fewWords = fewWords;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
