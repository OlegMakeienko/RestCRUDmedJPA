package com.makeienko.restcrudmedjpa.repository;

import com.makeienko.restcrudmedjpa.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE m.chatRoom.title = :title")
    List<Message> findAllMessagesInChatRoom(@Param("title") String title);

}
