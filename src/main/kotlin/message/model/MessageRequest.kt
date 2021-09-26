package message.model

data class MessageRequest (
    val senderId: String,
    val recipientId: String,
    val content: String
)