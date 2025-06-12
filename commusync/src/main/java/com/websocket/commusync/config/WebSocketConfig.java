package com.websocket.commusync.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//web socket is for real time connection
//stomp is used to route the messages

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //ie localhost:8080/chat
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080")//we want to entertain request from this url only for securoty
                .withSockJS();//provide comaptibilty for clients that dont support websocket so app accessible to more users
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //set message broker that handles message for topic
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
