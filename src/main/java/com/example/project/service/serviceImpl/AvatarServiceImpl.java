package com.example.project.service.serviceImpl;

import com.example.project.controller.AvatarController;
import com.example.project.dto.*;
import com.example.project.entity.Avatar;
import com.example.project.entity.User;
import com.example.project.repository.AvatarRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.AvatarService;
import com.example.project.service.PhotoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.transaction.Transactional;
import java.io.*;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class AvatarServiceImpl implements AvatarService{

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoService photoService;

    private void saveFile(MultipartFile file) throws IOException {
        final String PATH_TO_FILE = "..\\src\\main\\resources\\public\\img";
        File pathToFolder = new File(PATH_TO_FILE);
        if(!pathToFolder.exists()){
            pathToFolder.mkdirs();
        }
        File newFile = new File(pathToFolder + "\\" + file.getOriginalFilename());
        OutputStream fos = new FileOutputStream(newFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(file.getBytes(),0, file.getBytes().length);
        bos.flush();
    }

    @Override
    @Transactional
    public AvatarResponse update(Long id, AvatarRequest avatarRequest) throws IOException {
        User user = userRepository.getOne(id);
        Avatar avatar = user.getAvatar();
        if(null == avatar){
            avatar = new Avatar();
        }
        byte[] fileContent;
        BASE64Decoder decoder = new BASE64Decoder();
        fileContent = decoder.decodeBuffer(avatarRequest.getPhoto().split(",")[1]);
        String expansion = avatarRequest.getPhoto().split(",")[0].split("/")[1].split(";")[0];
        String name = UUID.randomUUID().toString();
        MyMultipartFile multipartFile = new MyMultipartFile(fileContent, name, expansion);
        saveFile(multipartFile);
        avatar.setPhoto(name + "." + expansion);
        avatar.setUser(userRepository.getOne(avatarRequest.getIdUser()));
        return new AvatarResponse(avatarRepository.save(avatar));
    }

    @Override
    public AvatarResponse findAvatarForOneUser(AvatarIdRequest avatarIdRequest) {

        return new AvatarResponse(avatarRepository.findAv(avatarIdRequest.getId()));
    }

}
