package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.Link;
import com.example.project.entity.Study;
import com.example.project.entity.User;
import com.example.project.repository.LinkRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {


    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<LinkResponse> getAll() {
        List<Link> links = linkRepository.findAll();
        List<LinkResponse> linkResponses = new ArrayList<LinkResponse>();
        for (Link link:links){
            linkResponses.add(new LinkResponse(link));
        }
        return linkResponses;
    }

    @Override
    public LinkResponse save(LinkRequest linkRequest) throws IOException {
        Link link = new Link();
        link.setFacebookLink(linkRequest.getFacebookLink());
        link.setLinkedinLink(linkRequest.getLinkedinLink());
        link.setVkLink(linkRequest.getVkLink());
        link.setTwitterLink(linkRequest.getTwitterLink());
        link.setUser(userRepository.getOne(linkRequest.getIdUser()));
        return new LinkResponse(linkRepository.save(link));
    }

    @Override
    public LinkResponse update(Long id, LinkRequest linkRequest) {
        User user = userRepository.getOne(id);
        Link link = user.getLink();
        if(null == link){
            link = new Link();
        }
        link.setFacebookLink(linkRequest.getFacebookLink());
        link.setLinkedinLink(linkRequest.getLinkedinLink());
        link.setVkLink(linkRequest.getVkLink());
        link.setTwitterLink(linkRequest.getTwitterLink());
        link.setUser(userRepository.getOne(linkRequest.getIdUser()));
        return new LinkResponse(linkRepository.save(link));
    }

    @Override
    public LinkResponse findAllLinksForOneUserById(LinkIdRequest linkIdRequest) {
        return new LinkResponse(linkRepository.findBm(linkIdRequest.getId()));
    }


}
