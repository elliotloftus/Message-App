# message-app

This is a simple enough messaging app with the following endpoints

1. POST ```/messages```
    
    ``` 
    {
        "senderId" : "12345",
        "recipientId" : "6789",
        "content" : "hey, how are you today?"
    }   
    ```
    ⋅*Responds with the message just posted.           
    ⋅*id is the unique id mongo db generates for the message.       
    ⋅sentAt is the timestamp for when the message was sent     
    ```
    {
        "id": "61525280de6add4bc70df6cf",
        "senderId": "12345",
        "recipientId": "6789",
        "content": "hey, how are you today?",
        "sentAt": "2021-09-27T23:23:44.280610Z"
    }
    ```
    Example screenshot below of Post man call can be found [here](https://github.com/elliotloftus/message-app/blob/main/postmanScreenshots/Post-example.png)

2. Get messages by sender for a recepient
    GET /messages/sender/{messageId}/recipient/{recipientId}?limit={boolean}

    Returns all messages by sender for a recipient. If limit = true, returns a max of 100 messages, otherwise returns messages withing the last 30 days
    Example screenshot below of Post man call and response can be found [here](https://github.com/elliotloftus/message-app/blob/main/postmanScreenshots/Get-message-by-recipient-and-sender.png)

3. Get messages for a recepient
    GET /messages/recipient/{recipientId}?limit={boolean}

    Returns all messages for a recipient. If limit = true, returns a max of 100 messages, otherwise returns messages withing the last 30 days
    Example screenshot below of Post man call and response can be found [here](https://github.com/elliotloftus/message-app/blob/main/postmanScreenshots/Get-message-by-recipient.png)

4. Get all messages
    GET /messages?limit={boolean}

    Returns all messages. If limit = true, returns a max of 100 messages, otherwise returns messages withing the last 30 days
    Example screenshot below of Post man call and response can be found [here](https://github.com/elliotloftus/message-app/blob/main/postmanScreenshots/Get-All-messages.png)
