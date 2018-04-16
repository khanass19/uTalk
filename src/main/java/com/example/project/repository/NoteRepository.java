package com.example.project.repository;

import com.example.project.entity.Bookmark;
import com.example.project.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select n from Note n where n.user.id=:userId")
    Note findBm(@Param("userId") Long userId);

}
