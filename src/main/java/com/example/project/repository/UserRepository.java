package com.example.project.repository;

import com.example.project.dto.UserResponse;
import com.example.project.entity.Plan;
import com.example.project.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.HTMLDocument;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User>{

    User findOneByEmail(String email);

    @Query("select u from User u where u.email=:email OR u.password=:password")
    User findUs(@Param("email") String email, @Param("password") String password);

    @Query("select u from User u where u.email=:email AND u.password=:password")
    User findUsAND(@Param("email") String email, @Param("password") String password);

}
