package com.example.project.service;

import com.example.project.dto.*;

import java.io.IOException;
import java.util.List;

public interface LinkService {

    List<LinkResponse> getAll();
    LinkResponse save(LinkRequest linkRequest) throws IOException;
    LinkResponse update(Long id, LinkRequest linkRequest);

    LinkResponse findAllLinksForOneUserById(LinkIdRequest linkIdRequest);
}
