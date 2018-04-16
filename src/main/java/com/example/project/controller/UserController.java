package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.entity.User;
import com.example.project.security.tokenUtils.TokenTool;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenTool tokenTool;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@Valid @PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public UserResponse update(@Valid @PathVariable Long id,@RequestBody UserRequest userRequest){
        return userService.update(id, userRequest);
    }

    @PostMapping("/filter")
    @PreAuthorize("hasAnyAuthority('USER')")
    public List<UserResponse> filter(@Valid @RequestBody UserSpecRequest userSpecRequest){
        return userService.filter(userSpecRequest);
    }

    @GetMapping("/get/by/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public UserResponse getOne(@Valid @PathVariable Long id) {
        return userService.findOne(id);
    }

}
