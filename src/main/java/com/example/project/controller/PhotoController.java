package com.example.project.controller;


import com.example.project.dto.*;
import com.example.project.service.PhotoService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USER')")
    public PhotoResponse save(@Valid @RequestBody PhotoRequest photoRequest) throws IOException {
            return photoService.save(photoRequest);
    }

    @PostMapping("/select")
    @PreAuthorize("hasAnyAuthority('USER')")
    public List<PhotoResponse> findPhotosByUserId(@Valid @RequestBody PhotoSpecRequest photoSpecRequest){
        return photoService.findAllById(photoSpecRequest);
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('USER')")
    public void deleteAllPhotos(@RequestBody PhotoSpecRequest photoSpecRequest){
        photoService.delete(photoSpecRequest);
    }

}
