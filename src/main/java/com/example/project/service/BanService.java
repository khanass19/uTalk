package com.example.project.service;

import com.example.project.dto.*;

import java.io.IOException;
import java.util.List;

public interface BanService {

    List<BanResponse> getAll();
    BanResponse update(Long id, BanRequest banRequest);
    void deleteOne(BanIdRequest banIdRequest);
    BanResponse findBanForOneUserById(BanIdRequest banIdRequest);

}
