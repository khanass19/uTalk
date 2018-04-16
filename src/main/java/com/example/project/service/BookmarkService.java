package com.example.project.service;

import com.example.project.dto.*;
import com.example.project.entity.Bookmark;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

public interface BookmarkService {

    List<BookmarkResponse> getAll();
    BookmarkResponse save(BookmarkRequest bookmarkRequest) throws IOException;

   List<BookmarkResponse> findAllById(BookmarkSpecRequest bookmarkSpecRequest);
   void delete(BookmarkSpecRequest bookmarkSpecRequest);


}
