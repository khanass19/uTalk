package com.example.project.controller;


import com.example.project.dto.*;
import com.example.project.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping
    public List<LinkResponse> getAll() {
        return linkService.getAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public LinkResponse update(@Valid @PathVariable Long id, @RequestBody LinkRequest linkRequest){
        return linkService.update(id,linkRequest);
    }

    @PostMapping("/selectOne")
    @PreAuthorize("hasAnyAuthority('USER')")
    public LinkResponse getOneByUserId(@Valid @RequestBody LinkIdRequest linkIdRequest){
        return linkService.findAllLinksForOneUserById(linkIdRequest);
    }
}
