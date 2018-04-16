package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.*;
import com.example.project.repository.NoteRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<NoteResponse> getAll() {
        List<Note> notes = noteRepository.findAll();
        List<NoteResponse> noteResponses = new ArrayList<NoteResponse>();
        for (Note note : notes) {
            noteResponses.add(new NoteResponse(note));
        }
        return noteResponses;
    }

    @Override
    public NoteResponse save(NoteRequest noteRequest) throws IOException {
        Note note = new Note();
        note.setId(noteRequest.getIdUser());
        note.setText(noteRequest.getText());
        note.setUser(userRepository.getOne(noteRequest.getIdUser()));
        return new NoteResponse(noteRepository.save(note));
    }

    @Override
    @Transactional
    public NoteResponse update(Long id, NoteRequest noteRequest) {
        User user = userRepository.getOne(id);
        Note note = user.getNote();
        if(null == note){
            note = new Note();
        }
        note.setId(noteRequest.getIdUser());
        note.setText(noteRequest.getText());
        note.setUser(userRepository.getOne(noteRequest.getIdUser()));
        return new NoteResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponse findAllNoteForOneUserById(NoteIdRequest noteIdRequest) {
           return new NoteResponse(noteRepository.findBm(noteIdRequest.getId()));
    }


    @Override
    public void delete(Long id) {
        noteRepository.delete(id);
    }

    @Override
    public NoteResponse getOne(Long id) {
        return new NoteResponse(noteRepository.getOne(id));
    }



}
