package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.service.LinkService;
import com.example.project.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('USER')")
    public PlanResponse save(@Valid @RequestBody PlanRequest planRequest) throws IOException {
        return planService.save(planRequest);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<PlanResponse> getAll() {
        return planService.getAll();
    }


    @PostMapping("/select")
    @PreAuthorize("hasAnyAuthority('USER')")
    public List<PlanResponse> getOneByClientId(@Valid @RequestBody PlanSpecRequest planSpecRequest){
        return planService.findAllById(planSpecRequest);
    }

    @PutMapping("/delete")
    @PreAuthorize("hasAnyAuthority('USER')")
    public void delete(@Valid @RequestBody PlanSpecRequest planSpecRequest){
        planService.delete(planSpecRequest);
    }

}
