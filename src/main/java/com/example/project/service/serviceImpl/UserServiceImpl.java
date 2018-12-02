package com.example.project.service.serviceImpl;


import com.example.project.dto.*;
import com.example.project.entity.Message;
import com.example.project.entity.Note;
import com.example.project.entity.Plan;
import com.example.project.entity.User;
import com.example.project.repository.BookmarkRepository;
import com.example.project.repository.UserRepository;
import com.example.project.security.tokenUtils.TokenTool;
import com.example.project.service.UserService;
import com.example.project.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private TokenTool tokenTool;

    public String login(LoginRequest loginRequest) {
        User user = userRepository.getOneByEmail(loginRequest.getLogin());
        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return tokenTool.createToken(user.getEmail(), user.getRole().name());
            } else {
                throw new IllegalArgumentException("Wrong input data");
            }
        } else {
            throw new IllegalArgumentException("Wrong input data");
        }
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<UserResponse>();
        for (User user : users) {
            userResponses.add(new UserResponse(user));
        }
        return userResponses;
    }

    @Override
    public UserResponse register(UserRequest userRequest) throws IOException {
            User userVerify = userRepository.findUs(userRequest.getEmail(), userRequest.getPassword());
            if(userVerify != null){
                throw new IllegalArgumentException("User with such email/password already exists !");
            }
            else {
                User user = new User();
                user.setFirstName(userRequest.getFirstName());
                user.setLastName(userRequest.getLastName());
                user.setEmail(userRequest.getEmail());
                user.setPassword(userRequest.getPassword());
                user.setBookmarks(bookmarkRepository.findBm(user.getId()));
                user.setRole(userRequest.getRole());
                return new UserResponse(userRepository.save(user));
            }
    }

    @Override
    public UserResponse verifyForLogin(UserFindByEmailRequest userFindByEmailRequest) {
        return new UserResponse(userRepository.findUsAND(userFindByEmailRequest.getLogin(),userFindByEmailRequest.getPassword()));
    }

    @Override
    public UserResponse getOne(Long id) {
        return new UserResponse(userRepository.getOne(id));
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.getOne(id);
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> filter(UserSpecRequest userSpecRequest) {
        UserSpecification userSpecification = new UserSpecification(userSpecRequest);
        List<User> users = userRepository.findAll(userSpecification);
        List<UserResponse> userResponses = new ArrayList<UserResponse>();
        for (User user : users) {
            userResponses.add(new UserResponse(user));
        }
        return userResponses;
    }



}
