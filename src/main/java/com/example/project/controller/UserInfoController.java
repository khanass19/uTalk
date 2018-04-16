package com.example.project.controller;


import com.example.project.dto.*;
import com.example.project.service.UserInfoService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/information")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UserInfoResponse> getAll() {
        return userInfoService.getAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public UserInfoResponse update(@Valid @PathVariable Long id, @RequestBody UserInfoRequest userInfoRequest) {
        return userInfoService.update(id,userInfoRequest);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserInfoResponse getOne(@Valid @PathVariable Long id){
        return userInfoService.getOne(id);
    }

    @PostMapping("/public/select/{id}")
    public UserInfoResponse getOneByUserId(@PathVariable Long id){
        return userInfoService.findAllInfoForOneUserById(id);
    }

}
