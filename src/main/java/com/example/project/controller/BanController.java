package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.service.BanService;
import com.example.project.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ban")
public class BanController {

    @Autowired
    private BanService banService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<BanResponse> getAll() {
        return banService.getAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public BanResponse update(@Valid @PathVariable Long id, @RequestBody BanRequest banRequest){
        return banService.update(id,banRequest);
    }

    @PostMapping("/public/select")
    public BanResponse getOneByUserId(@Valid @RequestBody BanIdRequest banIdRequest){
        return banService.findBanForOneUserById(banIdRequest);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@Valid @RequestBody BanIdRequest banIdRequest){
        banService.deleteOne(banIdRequest);
    }




}
