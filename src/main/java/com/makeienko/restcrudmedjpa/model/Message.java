package com.makeienko.restcrudmedjpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_room_id", nullable = false)
    private ChatRoom chatRoom;

    public Message() {
    }

    public Message(String content, ChatRoom chatRoom) {
        this.content = content;
        this.chatRoom = chatRoom;
    }
}