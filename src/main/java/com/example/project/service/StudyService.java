package com.example.project.service;

import com.example.project.dto.*;

import java.io.IOException;
import java.util.List;

public interface StudyService {

    List<StudyResponse> getAll();
    StudyResponse save(StudyRequest studyRequest) throws IOException;
    StudyResponse update(Long id, StudyRequest studyRequest);

    StudyResponse findAllStudyForOneUserById(StudyIdRequest studyIdRequest);
}
