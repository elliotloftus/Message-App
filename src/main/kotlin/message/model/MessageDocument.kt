package message.model

import message.repository.MessageRepository
import message.repository.MongoMessageInterface
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
data class MessageDocument(

    //unique id mongodb assings to each document
    @Id
    @Field(MessageRepository.ID)
    val id: String? = null,

    @Field(MessageRepository.SENDER_ID)
    val senderId: String,

    @Field(MessageRepository.RECIPIENT_ID)
    val recipientId: String,

    @Field(MessageRepository.CONTENT)
    val content: String,

    @Field(MessageRepository.SENT_AT)
    val sentAt: String,

)
