package com.example.project.controller;


import com.example.project.dto.LoginRequest;
import com.example.project.dto.UserFindByEmailRequest;
import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody UserRequest user) throws IOException {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @PostMapping("/verify/getid")
    public UserResponse verifyForLogin(@RequestBody UserFindByEmailRequest userFindByEmailRequest){
       return userService.verifyForLogin(userFindByEmailRequest);
    }


}
