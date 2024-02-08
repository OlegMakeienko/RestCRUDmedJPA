package com.makeienko.restcrudmedjpa.controller;

import com.makeienko.restcrudmedjpa.model.ChatRoom;
import com.makeienko.restcrudmedjpa.model.Message;
import com.makeienko.restcrudmedjpa.service.ChatRoomService;
import com.makeienko.restcrudmedjpa.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channels/")
public class MessageController {

    @Autowired
    private ChatRoomService chatRoomService;

    @Autowired
    private MessageService messageService;

    @PutMapping("{id}/messages")
    public ResponseEntity<String> createMessageInChannel(@PathVariable Long id, @RequestBody Message message) {
        ChatRoom chatRoom = chatRoomService.getChannelById(id);
        message.setChatRoom(chatRoom);
        messageService.saveMessage(message);
        return ResponseEntity.status(200).body("Message created successfully");
    }

    @GetMapping("{id}/messages")
    public ResponseEntity<List<Message>> getAllMessagesInChannel(@PathVariable Long id) {
        List<Message> messages = messageService.getAllMessagesInChannel(id);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PatchMapping("/{id}/messages/{messageId}")
    public ResponseEntity<Message> updateMessageContent(@PathVariable Long id, @PathVariable Long messageId, @RequestBody Message updatedMessage) {
        Message message = messageService.updateMessageContent(id, messageId, updatedMessage);
        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//
//    @DeleteMapping("/{id}/messages/{messageId}")
//    public ResponseEntity<Void> deleteMessage(@PathVariable Long id, @PathVariable Long messageId) {
//        messageService.deleteMessageById(id, messageId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
