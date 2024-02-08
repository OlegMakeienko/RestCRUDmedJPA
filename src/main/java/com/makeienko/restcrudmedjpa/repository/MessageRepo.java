package com.makeienko.restcrudmedjpa.repository;

import com.makeienko.restcrudmedjpa.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.chatRoom.id = :id")
    List<Message> findByChannelId(Long id);

    @Query("SELECT m FROM Message m WHERE m.id = :messageId AND m.chatRoom.id = :channelId")
    Message findByIdAndChannelId(Long messageId, Long channelId);

//    @Modifying
//    @Query("DELETE FROM Message m WHERE m.id = :messageId AND m.chatRoom.id = :channelId")
//    Message deleteByIdAndChannelId(Long messageId, Long id);
}
