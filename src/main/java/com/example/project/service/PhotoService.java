package com.example.project.service;

import com.example.project.dto.MyPageRequest;
import com.example.project.dto.PhotoRequest;
import com.example.project.dto.PhotoResponse;
import com.example.project.dto.PhotoSpecRequest;
import com.example.project.entity.Photo;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface PhotoService {

    PhotoResponse save(PhotoRequest photoRequest) throws IOException;
    List<PhotoResponse> findAllById(PhotoSpecRequest photoSpecRequest);
    void delete(PhotoSpecRequest photoSpecRequest);

}
