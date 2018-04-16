package com.example.project.repository;

import com.example.project.entity.Link;
import com.example.project.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {

    @Query("select s from Study s where s.user.id=:userId")
    Study findBm(@Param("userId") Long userId);

}
