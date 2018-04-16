package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.service.StudyService;
import com.example.project.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/study")
public class StudyController {

    @Autowired
    private StudyService studyService;

    @GetMapping
    public List<StudyResponse> getAll() {
        return studyService.getAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public StudyResponse update(@Valid @PathVariable Long id, @RequestBody StudyRequest studyRequest){
        return studyService.update(id,studyRequest);
    }

    @PostMapping("/select")
    @PreAuthorize("hasAnyAuthority('USER')")
    public StudyResponse getOneByUserId(@Valid @RequestBody StudyIdRequest studyIdRequest){
        return studyService.findAllStudyForOneUserById(studyIdRequest);
    }
}
