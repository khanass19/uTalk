package com.example.project.service;

import com.example.project.dto.*;

import java.io.IOException;
import java.util.List;

public interface PlanService {

    List<PlanResponse> getAll();
    PlanResponse save(PlanRequest planRequest) throws IOException;
    void delete(Long id);

    List<PlanResponse> findAllById(PlanSpecRequest planSpecRequest);
    void delete(PlanSpecRequest planSpecRequest);
}
