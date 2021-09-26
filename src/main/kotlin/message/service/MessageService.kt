package message.service

import message.model.Message
import org.springframework.stereotype.Service

@Service
class MessageService {

    fun sendMessage(
        message: Message
    ): Message {
        return message
    }

    fun getMessageBySenderForRecipient(
        senderId: String,
        recipientId: String,
        limit: Boolean
    ) : List<Message> {
        return listOf(Message(senderId,recipientId,"holdere"))
    }

    fun getMessageBySender(
        senderId: String,
        limit: Boolean
    ) : List<Message> {
        return listOf(Message(senderId,"recipient","holdere"))
    }

    fun getAllMessages(
        limit: Boolean
    ): List<Message>{
        return listOf(Message("senderId","recipient","holdere"))
    }
}