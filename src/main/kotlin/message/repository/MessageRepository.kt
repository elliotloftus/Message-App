package message.repository

import message.model.MessageDocument
import message.model.MessageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class MessageRepository(
    val mongoTemplate: MongoTemplate
) {

    fun saveMessage(message: MessageRequest): MessageDocument {

        val messageToSave = MessageDocument(id = null,senderId = message.senderId, recipientId = message.recipientId,
            content = message.content, sentAt = System.currentTimeMillis().toString())
       return mongoTemplate.insert(messageToSave)
    }

    fun getMessagesBySenderAndRecipientIdId(senderId: String, recipientId: String) : List<MessageDocument> {
        val getMessagesBySenderAndRecipientIdCriteria = Criteria.where(SENDER_ID).isEqualTo(senderId)
            .and(RECIPIENT_ID).isEqualTo(recipientId)
        val getMessagesBySenderAndRecipientIdQuery = Query().addCriteria(getMessagesBySenderAndRecipientIdCriteria)
        return mongoTemplate.find(getMessagesBySenderAndRecipientIdQuery, MessageDocument::class.java)
    }

    fun getMessagesByRecipientId(recipientId: String): List<MessageDocument> {
        val getMessagesByRecipientIdCriteria = Criteria.where(RECIPIENT_ID).isEqualTo(recipientId)
        val getMessagesByRecipientIdQuery = Query().addCriteria(getMessagesByRecipientIdCriteria)
        return mongoTemplate.find(getMessagesByRecipientIdQuery, MessageDocument::class.java)
    }

    //Define MongoDB document field names here to use everywhere to be consistent with naming
    companion object {
        const val ID = "id"
        const val SENDER_ID = "sender_id"
        const val RECIPIENT_ID = "recipient_id"
        const val SENT_AT = "sent_at"
        const val CONTENT = "content"
    }
}