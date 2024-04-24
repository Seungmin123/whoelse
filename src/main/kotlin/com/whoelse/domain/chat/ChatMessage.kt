package com.whoelse.domain.chat

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "chat")
class ChatMessage(

    @Id
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

    val timestamp: LocalDateTime = LocalDateTime.now()
)

enum class MessageType {
    CHAT,
    JOIN,
    LEAVE
}