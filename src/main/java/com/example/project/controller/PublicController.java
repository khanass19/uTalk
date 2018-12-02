package com.example.project.controller;


import com.example.project.dto.LoginRequest;
import com.example.project.dto.UserFindByEmailRequest;
import com.example.project.dto.UserRequest;
import com.example.project.dto.UserResponse;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@CrossOrigin
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public UserResponse register(@Valid @RequestBody UserRequest user) throws IOException {
        return userService.register(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@Valid @RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @PostMapping("/verify/getid")
    @ResponseBody
    public UserResponse verifyForLogin(@RequestBody UserFindByEmailRequest userFindByEmailRequest){
       return userService.verifyForLogin(userFindByEmailRequest);
    }

}
