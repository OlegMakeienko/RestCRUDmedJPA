package com.makeienko.restcrudmedjpa.controller;
import com.makeienko.restcrudmedjpa.model.ChatRoom;
import com.makeienko.restcrudmedjpa.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channels/")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;
//
//    @Autowired
//    private MessageService messageService;

    @GetMapping(value = "{id}")
    public ChatRoom getChannel(@PathVariable("id") Long id) {
        return this.chatRoomService.getChannelById(id);
    }

    @GetMapping("")
    public List<ChatRoom> getAllChannels() {
        return chatRoomService.getAllChannels();
    }

//    @GetMapping("/channel-list")
//    public String showAllChannels() {
//        List<ChatRoom> channels = chatRoomService.getAllChannels();
//        return "channel-list";
//    }

    @GetMapping("/index")
    public String getLandingPage() {
        return "index";
    }

    @PostMapping("")
    public String createChannel(@RequestBody ChatRoom channel) {
        chatRoomService.createChannel(channel);
        return "Success";
    }

    @DeleteMapping("{id}")
    public String deleteChannel(@PathVariable ("id") Long id) {
        chatRoomService.deleteChannelById(id);
        return "Success";
    }

    @PutMapping("{id}")
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
