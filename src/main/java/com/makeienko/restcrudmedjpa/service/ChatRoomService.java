package com.makeienko.restcrudmedjpa.service;

import com.makeienko.restcrudmedjpa.model.ChatRoom;
import com.makeienko.restcrudmedjpa.repository.ChatRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {
    final private ChatRoomRepo chatRoomRepo;

    @Autowired
    public ChatRoomService(ChatRoomRepo chatRoomRepo) {
        this.chatRoomRepo = chatRoomRepo;
    }

    public List<ChatRoom> getAllChannels() {
        return chatRoomRepo.findAll();
    }

    public ChatRoom getChannelById(Long id) {
        return chatRoomRepo.findChatById(id);
    }

    public void createChannel(ChatRoom channel) {
        chatRoomRepo.save(channel);
    }

    public boolean deleteChannelById(Long id) {
        chatRoomRepo.deleteById(id);
        return false;
    }

    public void updateChannelTitle(Long id, String newTitle) {
        Optional<ChatRoom> optionalChannel = chatRoomRepo.findById(id);
        if (optionalChannel.isPresent()) {
            ChatRoom channel = optionalChannel.get();
            channel.setTitle(newTitle);
            chatRoomRepo.save(channel);
        } else {
           throw new RuntimeException();
        }
    }
}
