package com.whoelse.web

import com.whoelse.domain.chat.ChatMessage
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class ChatController(
    private val template: SimpMessagingTemplate
) {
    @MessageMapping("/chat")
    fun sendMessage(@Payload chatMessage: ChatMessage, principal: Principal) {
        val senderId = principal.name
        template.convertAndSendToUser(chatMessage.recipient.toString(), "/queue/messages", chatMessage)
    }
}