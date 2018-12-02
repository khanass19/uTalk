package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.Bookmark;
import com.example.project.entity.Plan;
import com.example.project.entity.User;
import com.example.project.repository.PlanRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PlanResponse> getAll() {
        List<Plan> planList = planRepository.findAll();
        List<PlanResponse> planResponses = new ArrayList<PlanResponse>();
        for (Plan plan:planList){
            planResponses.add(new PlanResponse(plan));
        }
        return planResponses;
    }

    @Override
    public PlanResponse save(PlanRequest planRequest) throws IOException {
        Plan plan = new Plan();
        plan.setTask(planRequest.getTask());
        plan.setDate(planRequest.getDate());
        plan.setTime(planRequest.getTime());
        plan.setUser(userRepository.getOne(planRequest.getIdUser()));
        return new PlanResponse(planRepository.save(plan));
    }

    @Override
    public void deleteById(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public List<PlanResponse> findAllById(PlanSpecRequest planSpecRequest) {
        List<Plan> plans = planRepository.findBm(planSpecRequest.getId());
        List<PlanResponse> planResponses = new ArrayList<PlanResponse>();
        for (Plan plan:plans){
            planResponses.add(new PlanResponse(plan));
        }
        return planResponses;
    }

    @Override
    public void deleteById(PlanSpecRequest planSpecRequest) {
        List<Plan> plans = planRepository.findBm(planSpecRequest.getId());
        planRepository.deleteAll(plans);
    }


}
