package message.controller

import message.model.Message
import org.springframework.web.bind.annotation.*

@RestController
class MessageController {

    @GetMapping("/hello")
    fun placeholderHello(): String {
        return "Hello"
    }

    @PostMapping("/message")
    fun sendMessage(
        @RequestBody message: Message
    ): Message {
        return message
    }

    @GetMapping("/message/sender/{senderId}/recipient/{recipientId}")
    fun getMessageBySenderForRecipient(
        @PathVariable senderId: String,
        @PathVariable recipientId: String,
        @RequestAttribute limit: Boolean
    ) : List<Message> {
        return listOf(Message(senderId,recipientId,"holdere"))
    }

    @GetMapping("/message/sender/{senderId}")
    fun getMessageBySender(
        @PathVariable senderId: String,
        @RequestAttribute limit: Boolean
    ) : List<Message> {
        return listOf(Message(senderId,"recipient","holdere"))
    }

    @GetMapping("/message")
    fun getAllMessages(
        @RequestAttribute limit: Boolean
    ): List<Message>{
        return listOf(Message("senderId","recipient","holdere"))
    }


}