package com.example.project.repository;

import com.example.project.entity.Bookmark;
import com.example.project.entity.Photo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("select ph from Photo ph where ph.user.id=:userId")
    List<Photo> findPh(@Param("userId") Long userId);


}
