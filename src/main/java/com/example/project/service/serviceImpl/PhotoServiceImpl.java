package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.Bookmark;
import com.example.project.entity.Photo;
import com.example.project.entity.Plan;
import com.example.project.repository.PhotoRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PhotoResponse> findAllById(PhotoSpecRequest photoSpecRequest) {
        List<Photo> photos = photoRepository.findPh(photoSpecRequest.getId());
        List<PhotoResponse> photoResponses = new ArrayList<PhotoResponse>();
        for (Photo photo:photos){
            photoResponses.add(new PhotoResponse(photo));
        }
        return photoResponses;
    }

    @Override
    public PhotoResponse save(PhotoRequest photoRequest) throws IOException {
        Photo photo = new Photo();
        photo.setFoot(photoRequest.getFoot());
        photo.setUser(userRepository.getOne(photoRequest.getIdUser()));

        byte[] fileContent;
        BASE64Decoder decoder = new BASE64Decoder();
        fileContent = decoder.decodeBuffer(photoRequest.getUrl().split(",")[1]);
        String expansion = photoRequest.getUrl().split(",")[0].split("/")[1].split(";")[0];
        String name = UUID.randomUUID().toString();
        MyMultipartFile multipartFile = new MyMultipartFile(fileContent, name, expansion);
        saveFile(multipartFile);
        photo.setUrl(name + "." + expansion);
     return new PhotoResponse(photoRepository.save(photo));
    }

    private  void saveFile(MultipartFile file) throws IOException {
        File pathToFolder = new File("C:\\Users\\CodeBrain21\\Desktop\\final\\img");
        if(!pathToFolder.exists()){
            pathToFolder.mkdirs();
        }
        File newFile = new File(pathToFolder + "/" + file.getOriginalFilename());
        OutputStream fos = new FileOutputStream(newFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(file.getBytes(),0, file.getBytes().length);
        bos.flush();
    }

    @Override
    public void delete(PhotoSpecRequest photoSpecRequest) {
        List<Photo> photos = photoRepository.findPh(photoSpecRequest.getId());
        photoRepository.delete(photos);
    }



}