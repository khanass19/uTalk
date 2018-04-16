package com.example.project.service;

import com.example.project.dto.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

public interface UserInfoService {

    List<UserInfoResponse> getAll();
    UserInfoResponse update(Long id, UserInfoRequest userInfoRequest);
    UserInfoResponse getOne(Long id);

    UserInfoResponse findAllInfoForOneUserById(Long id);
}
