package com.example.project.repository;

import com.example.project.entity.Link;
import com.example.project.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long>{

    @Query("select l from Link l where l.user.id=:userId")
    Link findBm(@Param("userId") Long userId);

}
