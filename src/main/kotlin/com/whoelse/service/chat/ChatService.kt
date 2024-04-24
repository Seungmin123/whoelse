package com.whoelse.service.chat

import com.whoelse.domain.chat.model.ChatMessage
import com.whoelse.domain.chat.repository.ChatMessageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChatService(
    private val chatMessageRepository: ChatMessageRepository
) {

    @Transactional
    fun save(chatMessage: ChatMessage): ChatMessage {
        return chatMessageRepository.save(chatMessage)
    }
}