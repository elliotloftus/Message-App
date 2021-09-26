package message.repository

import message.model.MessageDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoMessageInterface :  MongoRepository<MessageDocument, String> {


}