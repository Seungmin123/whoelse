package com.whoelse.domain.chat.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "chat")
class ChatMessage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "message_type")
    var type: MessageType = MessageType.CHAT,

    @Column(name = "content")
    var content: String = "",

    @Column(name = "sender")
    var sender: Long = -1,

    @Column(name = "recipient")
    var recipient: Long = -1,

    @Column(name = "createdAt")
    val timestamp: LocalDateTime = LocalDateTime.now()
)

enum class MessageType {
    CHAT,
    JOIN,
    LEAVE
}