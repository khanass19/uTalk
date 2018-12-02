package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.Ban;
import com.example.project.entity.Link;
import com.example.project.entity.User;
import com.example.project.repository.BanRepository;
import com.example.project.repository.LinkRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BanServiceImpl implements BanService{

    @Autowired
    private BanRepository banRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BanResponse> getAll() {
        List<Ban> bans = banRepository.findAll();
        List<BanResponse> banResponses = new ArrayList<BanResponse>();
        for (Ban ban:bans){
            banResponses.add(new BanResponse(ban));
        }
        return banResponses;
    }

    @Override
    public BanResponse update(Long id, BanRequest banRequest) {
        User user = userRepository.getOne(id);
        Ban ban = user.getBan();
        if(null == ban){
            ban = new Ban();
        }
        ban.setUser(userRepository.getOne(banRequest.getIdUser()));
        return new BanResponse(banRepository.save(ban));
    }

    @Override
    public void deleteOne(BanIdRequest banIdRequest) {
            banRepository.deleteById(banIdRequest.getId());
    }

    @Override
    public BanResponse findBanForOneUserById(BanIdRequest banIdRequest) {
        return new BanResponse(banRepository.findBan(banIdRequest.getId()));
    }



}
