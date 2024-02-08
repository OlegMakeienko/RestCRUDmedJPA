package com.makeienko.restcrudmedjpa.service;

import com.makeienko.restcrudmedjpa.model.Message;
import com.makeienko.restcrudmedjpa.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepo messageRepository;

    @Autowired
    public MessageService(MessageRepo messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessagesInChannel(Long id) {
        return messageRepository.findByChannelId(id);
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public boolean deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
        return false;
    }

    public Message updateMessageContent(Long id, Long messageId, Message updatedMessage) {
        Message existingMessage = messageRepository.findByIdAndChannelId(messageId, id);
        if (existingMessage == null) {
            throw new RuntimeException("Message not found with id " + messageId + " and channelId " + id);
        } else {
            existingMessage.setContent(updatedMessage.getContent());
            return messageRepository.save(existingMessage);
        }
    }
}
