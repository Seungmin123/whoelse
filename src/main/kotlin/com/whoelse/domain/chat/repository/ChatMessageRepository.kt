package com.whoelse.domain.chat.repository

import com.whoelse.domain.chat.model.ChatMessage
import org.springframework.data.jpa.repository.JpaRepository

interface ChatMessageRepository: JpaRepository<ChatMessage, Long>