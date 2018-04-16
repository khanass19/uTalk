package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.Study;
import com.example.project.entity.User;
import com.example.project.entity.UserInfo;
import com.example.project.entity.Work;
import com.example.project.repository.StudyRepository;
import com.example.project.repository.UserRepository;
import com.example.project.repository.WorkRepository;
import com.example.project.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<WorkResponse> getAll() {
        List<Work> works = workRepository.findAll();
        List<WorkResponse> workResponses = new ArrayList<WorkResponse>();
        for (Work work:works){
            workResponses.add(new WorkResponse(work));
        }
        return workResponses;
    }

    @Override
    public WorkResponse save(WorkRequest workRequest) throws IOException {
        Work work = new Work();
        work.setPlace1(workRequest.getPlace1());
        work.setPlace2(workRequest.getPlace2());
        work.setFew1(workRequest.getFew1());
        work.setFew2(workRequest.getFew2());
        work.setTime1(workRequest.getTime1());
        work.setTime2(workRequest.getTime2());
        work.setUser(userRepository.getOne(workRequest.getIdUser()));
        return new WorkResponse(workRepository.save(work));
    }

    @Override
    @Transactional
    public WorkResponse update(Long id, WorkRequest workRequest) {
        User user = userRepository.getOne(id);
        Work work = user.getWork();
        if(null == work){
            work = new Work();
        }
        work.setPlace1(workRequest.getPlace1());
        work.setPlace2(workRequest.getPlace2());
        work.setFew1(workRequest.getFew1());
        work.setFew2(workRequest.getFew2());
        work.setTime1(workRequest.getTime1());
        work.setTime2(workRequest.getTime2());
        work.setUser(userRepository.getOne(workRequest.getIdUser()));
        return new WorkResponse(workRepository.save(work));
    }

    @Override
    public WorkResponse findAllWorkForOneUserById(WorkIdRequest workIdRequest) {
        return new WorkResponse(workRepository.findBm(workIdRequest.getId()));
    }

}
