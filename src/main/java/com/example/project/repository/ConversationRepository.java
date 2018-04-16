package com.example.project.repository;

import com.example.project.entity.Conversation;
import com.example.project.entity.Plan;
import com.example.project.entity.User;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>{

    @Query("select c from Conversation c where (c.author.id=:myId AND c.receiver.id=:otherId) OR (c.author.id=:otherId AND c.receiver.id=:myId)")
    List<Conversation> findCv(@org.springframework.data.repository.query.Param("myId") Long myId, @org.springframework.data.repository.query.Param("otherId") Long otherId);

    @Query("select c from Conversation c where (c.author.id=:myId AND c.receiver.id=:otherId) OR (c.author.id=:otherId AND c.receiver.id=:myId)")
    Conversation findCvForDelete(@org.springframework.data.repository.query.Param("myId") Long myId, @org.springframework.data.repository.query.Param("otherId") Long otherId);

}
