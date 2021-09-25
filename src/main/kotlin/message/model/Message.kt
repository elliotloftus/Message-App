package message.model

data class Message(
    val senderId: String,
    val recipientId: String,
    val content: String
)
