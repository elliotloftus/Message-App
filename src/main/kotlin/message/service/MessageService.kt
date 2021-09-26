package message.service

import message.model.MessageDocument
import message.model.MessageRequest
import message.repository.MessageRepository
import message.repository.MongoMessageInterface
import org.springframework.stereotype.Service

@Service
class MessageService(
    private val messageRepository: MessageRepository
) {

    fun sendMessage(
        messageRequest: MessageRequest
    ): MessageDocument {
        return messageRepository.saveMessage(messageRequest)
    }

    fun getMessageBySenderForRecipient(
        senderId: String,
        recipientId: String,
        limit: Boolean
    ) : List<MessageDocument> {
        return messageRepository.getMessagesBySenderAndRecipientIdId(senderId,recipientId,limit)
    }

    fun getMessageForRecipient(
        recipientId: String,
        limit: Boolean
    ) : List<MessageDocument> {
        return messageRepository.getMessagesByRecipientId(recipientId,limit)
    }

    fun getAllMessages(
        limit: Boolean
    ): List<MessageDocument> {
        return messageRepository.getMessagesForEveryone(limit)
    }
}