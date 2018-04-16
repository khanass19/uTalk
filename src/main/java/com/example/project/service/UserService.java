package com.example.project.service;

import com.example.project.dto.*;
import com.example.project.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<UserResponse> getAll();
    UserResponse register(UserRequest userRequest) throws IOException;

    void delete(Long id);
    UserResponse update(Long id,UserRequest userRequest);
    List<UserResponse> filter(UserSpecRequest userSpecRequest);
    String login(LoginRequest loginRequest);

    UserResponse verifyForLogin(UserFindByEmailRequest userFindByEmailRequest);
    UserResponse findOne(Long id);
}
