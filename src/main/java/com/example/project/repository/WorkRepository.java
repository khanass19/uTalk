package com.example.project.repository;

import com.example.project.entity.Link;
import com.example.project.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long>{

    @Query("select w from Work w where w.user.id=:userId")
    Work findBm(@Param("userId") Long userId);

}
