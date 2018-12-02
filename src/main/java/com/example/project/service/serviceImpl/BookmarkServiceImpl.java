package com.example.project.service.serviceImpl;

import com.example.project.dto.*;
import com.example.project.entity.Bookmark;
import com.example.project.repository.BookmarkRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BookmarkResponse> getAll() {
        List<Bookmark> bookmarks = bookmarkRepository.findAll();
        List<BookmarkResponse> bookmarkResponses = new ArrayList<BookmarkResponse>();
        for (Bookmark bookmark:bookmarks){
            bookmarkResponses.add(new BookmarkResponse(bookmark));
        }
        return bookmarkResponses;
    }

    @Override
    public BookmarkResponse save(BookmarkRequest bookmarkRequest) throws IOException {
        Bookmark bookmark = new Bookmark();
        bookmark.setLink(bookmarkRequest.getLink());
        bookmark.setName(bookmarkRequest.getName());
        bookmark.setUser(userRepository.getOne(bookmarkRequest.getIdUser()));
        return new BookmarkResponse(bookmarkRepository.save(bookmark));
    }

    @Override
    public void delete(BookmarkSpecRequest bookmarkSpecRequest) {
        List<Bookmark> bookmarks = bookmarkRepository.findBm(bookmarkSpecRequest.getId());
        bookmarkRepository.deleteAll(bookmarks);
    }

    @Override
    public List<BookmarkResponse> findAllById(BookmarkSpecRequest bookmarkSpecRequest) {
        List<Bookmark> bookmarks = bookmarkRepository.findBm(bookmarkSpecRequest.getId());
        List<BookmarkResponse> bookmarkResponses = new ArrayList<BookmarkResponse>();
        for (Bookmark bookmark:bookmarks){
            bookmarkResponses.add(new BookmarkResponse(bookmark));
        }
        return bookmarkResponses;
    }
}