package com.websocket.commusync.controller;

import com.websocket.commusync.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")//maps websocket messages to destination
    @SendTo("/topic/messages")//who ever want to see the messages should be subscribed to this topic
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
