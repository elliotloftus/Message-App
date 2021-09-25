package message.controller

import message.model.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @GetMapping("/hello")
    fun placeholderHello(): String {
        return "Hello"
    }

    @PostMapping("send-message")
    fun sendMessage(@RequestBody message: Message): Message {
        return message
    }

}