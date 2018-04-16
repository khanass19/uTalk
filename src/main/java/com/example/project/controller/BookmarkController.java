package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.entity.Bookmark;
import com.example.project.service.BookmarkService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bookmark")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USER')")
    public BookmarkResponse save(@Valid @RequestBody BookmarkRequest bookmarkRequest) throws IOException {
        return bookmarkService.save(bookmarkRequest);
    }

    @PostMapping("/selectOne")
    @PreAuthorize("hasAnyAuthority('USER')")
    public List<BookmarkResponse> getOneByClientId(@Valid @RequestBody BookmarkSpecRequest bookmarkSpecRequest){
        return bookmarkService.findAllById(bookmarkSpecRequest);
    }

    @GetMapping
    public List<BookmarkResponse> getAll() {
        return bookmarkService.getAll();
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('USER')")
    public void delete(@Valid @RequestBody BookmarkSpecRequest bookmarkSpecRequest){
        bookmarkService.delete(bookmarkSpecRequest);
    }
}
