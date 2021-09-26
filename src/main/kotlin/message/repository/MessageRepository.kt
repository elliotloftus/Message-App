package message.repository

import message.model.MessageDocument
import message.model.MessageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository
import java.time.Instant
import java.time.temporal.ChronoUnit

@Repository
class MessageRepository(
    val mongoTemplate: MongoTemplate
) {

    fun saveMessage(message: MessageRequest): MessageDocument {

        val messageToSave = MessageDocument(id = null,senderId = message.senderId, recipientId = message.recipientId,
            content = message.content, sentAt = Instant.now().toString())
       return mongoTemplate.insert(messageToSave)
    }

    fun getMessagesBySenderAndRecipientIdId(
        senderId: String,
        recipientId: String,
        limit: Boolean)
    : List<MessageDocument> {
        val getMessagesBySenderAndRecipientIdCriteria = Criteria.where(SENDER_ID).isEqualTo(senderId)
            .and(RECIPIENT_ID).isEqualTo(recipientId)
        val getMessagesBySenderAndRecipientIdQuery = Query().addCriteria(getMessagesBySenderAndRecipientIdCriteria)
        if (limit) {
            getMessagesBySenderAndRecipientIdQuery.limit(LIMIT_SIZE)
        }
        return mongoTemplate.find(getMessagesBySenderAndRecipientIdQuery, MessageDocument::class.java)
    }

    fun getMessagesByRecipientId(
        recipientId: String,
        limit: Boolean)
    : List<MessageDocument> {
        val getMessagesByRecipientIdCriteria = Criteria.where(RECIPIENT_ID).isEqualTo(recipientId)

        //If limit, set query to limits by 100 (limit_size)
        //if not limit, add to criteria to make sure we only get last month of messages
        val getMessagesByRecipientIdQuery =
            if (limit) {
                Query().addCriteria(messageInLastMonthCriteria).limit(LIMIT_SIZE)
            }
            else {
                getMessagesByRecipientIdCriteria.and(Instant.now().toString())
                    .gte(Instant.now().minus(1,ChronoUnit.MONTHS))
                Query().addCriteria(getMessagesByRecipientIdCriteria)
            }
        return mongoTemplate.find(getMessagesByRecipientIdQuery, MessageDocument::class.java)
    }

    //Define MongoDB document field names here to use everywhere to be consistent with naming
    companion object {
        const val SENDER_ID = "sender_id"
        const val RECIPIENT_ID = "recipient_id"
        const val SENT_AT = "sent_at"
        const val CONTENT = "content"
        const val LIMIT_SIZE = 100
    }
}