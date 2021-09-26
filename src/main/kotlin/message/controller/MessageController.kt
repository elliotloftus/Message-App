package message.controller

import message.model.Message
import message.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
class MessageController(
    val messageService: MessageService
) {

    @GetMapping("/hello")
    fun placeholderHello(): String {
        return "Hello"
    }

    @PostMapping("/message")
    fun sendMessage(
        @RequestBody message: Message
    ): Message {
        return messageService.sendMessage(message)
    }

    @GetMapping("/message/sender/{senderId}/recipient/{recipientId}")
    fun getMessageBySenderForRecipient(
        @PathVariable senderId: String,
        @PathVariable recipientId: String,
        @RequestAttribute limit: Boolean
    ) : List<Message> {
        return messageService.getMessageBySenderForRecipient(senderId,recipientId,limit)
    }

    @GetMapping("/message/sender/{senderId}")
    fun getMessageBySender(
        @PathVariable senderId: String,
        @RequestAttribute limit: Boolean
    ) : List<Message> {
        return messageService.getMessageBySender(senderId,limit)
    }

    @GetMapping("/message")
    fun getAllMessages(
        @RequestAttribute limit: Boolean
    ): List<Message>{
        return messageService.getAllMessages(limit)
    }


}