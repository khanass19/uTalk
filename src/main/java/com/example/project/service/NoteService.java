package com.example.project.service;

import com.example.project.dto.*;

import java.io.IOException;
import java.util.List;

public interface NoteService {

    List<NoteResponse> getAll();
    NoteResponse save(NoteRequest noteRequest) throws IOException;
    void deleteById(Long id);
    NoteResponse getOne(Long id);
    NoteResponse update(Long id, NoteRequest noteRequest);

    NoteResponse findAllNoteForOneUserById(NoteIdRequest noteIdRequest);

}
