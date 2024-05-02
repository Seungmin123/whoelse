package com.whoelse.web

import com.whoelse.domain.chat.model.ChatMessage
import com.whoelse.service.chat.ChatService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ChatController(
    private val chatService: ChatService
){
    @MessageMapping("/chat.sendMessage")
    @SendTo("/chat/{recipient}")
    fun sendMessage(@DestinationVariable recipient: String, @Payload chatMessage: ChatMessage): ChatMessage{
        return chatMessage
    }

    @MessageMapping("/chat.sendNotice")
    @SendTo("/notice")
    fun sendNotice(@Payload chatMessage: ChatMessage): ChatMessage {
        return chatMessage
    }

}