package com.example.project.controller;


import com.example.project.dto.*;
import com.example.project.service.NoteService;
import com.example.project.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<NoteResponse> getAll() {
        return noteService.getAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public NoteResponse update(@Valid @PathVariable Long id, @RequestBody NoteRequest noteRequest){
        return noteService.update(id,noteRequest);
    }

    @PostMapping("/selectOne")
    @PreAuthorize("hasAnyAuthority('USER')")
    public NoteResponse getOneByUserId(@Valid @RequestBody NoteIdRequest noteIdRequest){
        return noteService.findAllNoteForOneUserById(noteIdRequest);
    }

}
