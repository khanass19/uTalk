package com.example.project.repository;

import com.example.project.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Long> {

    @Query("select av from Avatar av where av.user.id=:userId")
    Avatar findAv(@Param("userId") Long userId);

}
