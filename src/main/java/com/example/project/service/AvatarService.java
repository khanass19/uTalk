package com.example.project.service;

import com.example.project.dto.*;

import java.io.IOException;
import java.util.List;

public interface AvatarService {

    AvatarResponse update(Long id, AvatarRequest avatarRequest) throws IOException;

    AvatarResponse findAvatarForOneUser(AvatarIdRequest avatarIdRequest);

}
