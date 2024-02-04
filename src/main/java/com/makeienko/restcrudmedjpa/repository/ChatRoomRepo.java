package com.makeienko.restcrudmedjpa.repository;

import com.makeienko.restcrudmedjpa.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepo extends JpaRepository<ChatRoom, Long > {
    ChatRoom findChatById(Long id);
}
