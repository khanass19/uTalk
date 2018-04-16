package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.Link;
import com.example.project.entity.Study;
import com.example.project.entity.User;
import com.example.project.entity.Work;
import com.example.project.repository.LinkRepository;
import com.example.project.repository.StudyRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudyServiceImpl implements StudyService{


    @Autowired
    private StudyRepository studyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<StudyResponse> getAll() {
        List<Study> studies = studyRepository.findAll();
        List<StudyResponse> studyResponses = new ArrayList<StudyResponse>();
        for (Study study:studies){
            studyResponses.add(new StudyResponse(study));
        }
        return studyResponses;
    }

    @Override
    public StudyResponse save(StudyRequest studyRequest) throws IOException {
        Study study = new Study();
        study.setPlace1(studyRequest.getPlace1());
        study.setFew1(studyRequest.getFew1());
        study.setTime1(studyRequest.getTime1());
        study.setUser(userRepository.getOne(studyRequest.getIdUser()));
        return new StudyResponse(studyRepository.save(study));
    }

    @Override
    public StudyResponse update(Long id, StudyRequest studyRequest) {
        User user = userRepository.getOne(id);
        Study study = user.getStudy();
        if(null == study){
            study = new Study();
        }
        study.setPlace1(studyRequest.getPlace1());
        study.setFew1(studyRequest.getFew1());
        study.setTime1(studyRequest.getTime1());
        study.setUser(userRepository.getOne(studyRequest.getIdUser()));
        return new StudyResponse(studyRepository.save(study));
    }

    @Override
    public StudyResponse findAllStudyForOneUserById(StudyIdRequest studyIdRequest) {
        return new StudyResponse(studyRepository.findBm(studyIdRequest.getId()));
    }

}
