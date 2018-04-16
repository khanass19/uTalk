package com.example.project.service;

import com.example.project.dto.*;

import java.io.IOException;
import java.util.List;

public interface WorkService {

    List<WorkResponse> getAll();
    WorkResponse save(WorkRequest workRequest) throws IOException;
    WorkResponse update(Long id, WorkRequest workRequest);

    WorkResponse findAllWorkForOneUserById(WorkIdRequest workIdRequest);
}
