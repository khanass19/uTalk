package com.example.project.repository;

import com.example.project.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query("select u from UserInfo u where u.user.id=:userId")
    UserInfo findBm(@Param("userId") Long userId);

}
