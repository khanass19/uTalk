package com.example.project.repository;

import com.example.project.entity.Bookmark;
import com.example.project.entity.User;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select b from Bookmark b where b.user.id=:userId")
    List<Bookmark> findBm(@Param("userId") Long userId);

}
