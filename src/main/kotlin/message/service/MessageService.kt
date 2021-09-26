package message.service

import message.model.MessageRequest
import message.repository.MongoMessageInterface
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val mongoMessageInterface: MongoMessageInterface
) {

    fun sendMessage(
        messageRequest: MessageRequest
    ): MessageRequest {
        return messageRequest
    }

    fun getMessageBySenderForRecipient(
        senderId: String,
        recipientId: String,
        limit: Boolean
    ) : List<MessageRequest> {
        return listOf(MessageRequest(senderId,recipientId,"holdere"))
    }

    fun getMessageBySender(
        senderId: String,
        limit: Boolean
    ) : List<MessageRequest> {
        return listOf(MessageRequest(senderId,"recipient","holdere"))
    }

    fun getAllMessages(
        limit: Boolean
    ): List<MessageRequest>{
        return listOf(MessageRequest("senderId","recipient","holdere"))
    }
}