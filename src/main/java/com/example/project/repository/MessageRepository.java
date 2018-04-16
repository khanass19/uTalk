package com.example.project.repository;

import com.example.project.entity.Message;
import com.example.project.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

    @Query("select m from Message m where m.conversationId.id=:conversationId")
    List<Message> findMsg(@Param("conversationId") Long conversationId);

}
