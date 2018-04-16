package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.User;
import com.example.project.entity.UserInfo;
import com.example.project.repository.UserInfoRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserInfoResponse> getAll() {
        List<UserInfo> userInfos = userInfoRepository.findAll();
        List<UserInfoResponse> userInfoResponses = new ArrayList<UserInfoResponse>();
        for (UserInfo userInfo : userInfos) {
            userInfoResponses.add(new UserInfoResponse(userInfo));
        }
        return userInfoResponses;
    }

    @Override
    @Transactional
    public UserInfoResponse update(Long id, UserInfoRequest userInfoRequest) {
        User user = userRepository.getOne(id);
        UserInfo userInfo = user.getUserInfo();
        if(null == userInfo){
            System.out.println("create new user");
            userInfo = new UserInfo();
        }
        userInfo.setId(userInfoRequest.getIdUser());
        userInfo.setCity(userInfoRequest.getCity());
        userInfo.setCountry(userInfoRequest.getCountry());
        userInfo.setAge(userInfoRequest.getAge());
        userInfo.setGender(userInfoRequest.getGender());
        userInfo.setFewWords(userInfoRequest.getFewWords());
        userInfo.setNumber(userInfoRequest.getNumber());
        userInfo.setUser(userRepository.getOne(id));

        return new UserInfoResponse(userInfoRepository.save(userInfo));
    }

    @Override
    public UserInfoResponse getOne(Long id) {
        return new UserInfoResponse(userInfoRepository.getOne(id));
    }

    @Override
    public UserInfoResponse findAllInfoForOneUserById(Long id) {
        UserInfo userInfo = userInfoRepository.findBm(id);
        return new UserInfoResponse(userInfo);
    }
}
