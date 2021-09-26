package message.controller

import message.model.MessageDocument
import message.model.MessageRequest
import message.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
class MessageController(
    private val messageService: MessageService
) {

    @GetMapping("/hello")
    fun placeholderHello(): String {
        return "Hello"
    }

    @PostMapping("/message")
    fun sendMessage(
        @RequestBody messageRequest: MessageRequest
    ): MessageDocument {
        return messageService.sendMessage(messageRequest)
    }

    @GetMapping("/message/sender/{senderId}/recipient/{recipientId}")
    fun getMessageBySenderForRecipient(
        @PathVariable senderId: String,
        @PathVariable recipientId: String,
        @RequestAttribute limit: Boolean
    ) : List<MessageDocument> {
        return messageService.getMessageBySenderForRecipient(senderId,recipientId,limit)
    }

    @GetMapping("/message/recipient/{recipientId}")
    fun getMessageForRecipient(
        @PathVariable recipientId: String,
        @RequestAttribute limit: Boolean
    ) : List<MessageDocument> {
        return messageService.getMessageForRecipient(recipientId,limit)
    }

    @GetMapping("/message")
    fun getAllMessages(
        @RequestAttribute limit: Boolean
    ): List<MessageRequest>{
        return messageService.getAllMessages(limit)
    }


}