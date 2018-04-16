package com.example.project.controller;


import com.example.project.dto.*;
import com.example.project.service.LinkService;
import com.example.project.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping
    public List<WorkResponse> getAll() {
        return workService.getAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public WorkResponse update(@Valid @PathVariable Long id, @RequestBody WorkRequest workRequest){
        return workService.update(id,workRequest);
    }

    @PostMapping("/select")
    @PreAuthorize("hasAnyAuthority('USER')")
    public WorkResponse getOneByUserId(@Valid @RequestBody WorkIdRequest workIdRequest){
        return workService.findAllWorkForOneUserById(workIdRequest);
    }




}
