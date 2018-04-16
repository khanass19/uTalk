package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public AvatarResponse update(@Valid @PathVariable Long id, @RequestBody AvatarRequest avatarRequest) throws IOException {
        return avatarService.update(id,avatarRequest);
    }

    @PostMapping("/select")
    @PreAuthorize("hasAnyAuthority('USER')")
    public AvatarResponse getOneByUserId(@Valid @RequestBody AvatarIdRequest avatarIdRequest){
        return avatarService.findAvatarForOneUser(avatarIdRequest);
    }


}
