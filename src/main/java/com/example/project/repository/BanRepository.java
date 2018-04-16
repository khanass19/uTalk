package com.example.project.repository;

import com.example.project.entity.Ban;
import com.example.project.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long> {

    @Query("select ban from Ban ban where ban.user.id=:userId")
    Ban findBan(@Param("userId") Long userId);

}
