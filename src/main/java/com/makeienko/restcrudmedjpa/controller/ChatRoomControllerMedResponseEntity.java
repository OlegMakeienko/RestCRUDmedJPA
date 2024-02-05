package com.makeienko.restcrudmedjpa.controller;

import com.makeienko.restcrudmedjpa.model.ChatRoom;
import com.makeienko.restcrudmedjpa.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channels/")
public class ChatRoomControllerMedResponseEntity {

    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping(value = "{id}")
    public ResponseEntity<ChatRoom> getChannel(@PathVariable("id") Long id) {
        ChatRoom channel = chatRoomService.getChannelById(id);
        if (channel != null) {
            return ResponseEntity.ok(channel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ChatRoom>> getAllChannels() {
        List<ChatRoom> channels = chatRoomService.getAllChannels();
        return ResponseEntity.ok(channels);
    }

    @GetMapping("/index")
    public String getLandingPage() {
        return "index";
    }

    @PostMapping("")
    public ResponseEntity<String> createChannel(@RequestBody ChatRoom channel) {
        chatRoomService.createChannel(channel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Channel" + channel + " created successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteChannel(@PathVariable("id") Long id) {
        boolean deleted = chatRoomService.deleteChannelById(id);
        if (deleted) {
            return ResponseEntity.ok("Channel with ID " + id + " has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateChannelTitle(@PathVariable Long id, @RequestBody ChatRoom updatedChannel) {
        chatRoomService.updateChannelTitle(id, updatedChannel.getTitle());
        return ResponseEntity.ok("Channel title updated successfully");
    }
}

