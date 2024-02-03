package com.makeienko.restcrudmedjpa.controller;
import com.makeienko.restcrudmedjpa.model.ChatRoom;
import com.makeienko.restcrudmedjpa.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;
//
//    @Autowired
//    private MessageService messageService;

    @GetMapping("/")
    @ResponseBody
    public String test() {
        return "test";
    }

    @GetMapping("/channels")
    public List<ChatRoom> getAllChannels() {
        return chatRoomService.getAllChannels();
    }

    @PostMapping("/channels")
    public String createChannel(@RequestBody ChatRoom channel) {
        chatRoomService.createChannel(channel);
        return "Success";
    }

    @DeleteMapping("/channels/{id}")
    public String deleteChannel(@PathVariable Long id) {
        chatRoomService.deleteChannelById(id);
        return "Success";
    }

    @PatchMapping("/{id}")
    public String updateChannelTitle(@PathVariable Long id, @RequestBody ChatRoom updatedChannel) {
        chatRoomService.updateChannelTitle(id, updatedChannel.getTitle());
        return "Success";
    }
//
//    @PutMapping("/{id}/messages")
//    public String createMessageInChannel(@PathVariable Long id, @RequestBody Message message) {
//        messageService.createMessage(message);
//        return "Success";
//    }
//
//    @GetMapping("/{id}/messages")
//    public List<Message> getAllMessagesInChannel(@PathVariable Long id) {
//        return messageService.getAllMessagesInChannel(id);
//    }
}
