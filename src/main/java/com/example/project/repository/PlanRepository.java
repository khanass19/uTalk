package com.example.project.repository;

import com.example.project.entity.Bookmark;
import com.example.project.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("select p from Plan p where p.user.id=:userId")
    List<Plan> findBm(@Param("userId") Long userId);

}
