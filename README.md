# message-app

## Running Locally 💯
This service runs in docker. If you do not have docker downloaded yet, please follow directions at:
[Docker](https://docs.docker.com/get-docker/).

Run the following:
`docker-compose up`

Once the service is running, check out the api endpoints below for how to save and retrieve messages

## API Endpoints 

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
    GET ```/messages/sender/{messageId}/recipient/{recipientId}?limit={boolean}```

    ⋅*Returns all messages by sender for a recipient.         
    ⋅*If limit = true, returns a max of 100 messages, otherwise returns messages withing the last 30 days                   
    ⋅Example screenshot below of Post man call and response can be found [here](https://github.com/elliotloftus/message-app/blob/main/postmanScreenshots/Get-message-by-recipient-and-sender.png)

3. Get messages for a recepient              
    GET ```/messages/recipient/{recipientId}?limit={boolean}```

    ⋅*Returns all messages for a recipient.         
    ⋅*If limit = true, returns a max of 100 messages, otherwise returns messages withing the last 30 days                   
    ⋅Example screenshot below of Post man call and response can be found [here](https://github.com/elliotloftus/message-app/blob/main/postmanScreenshots/Get-message-by-recipient.png)

4. Get all messages             
   GET ```/messages?limit={boolean}```
   
    ⋅*Returns all messages for a recipient.         
    ⋅*If limit = true, returns a max of 100 messages, otherwise returns messages withing the last 30 days                   
    ⋅Example screenshot below of Post man call and response can be found [here](https://github.com/elliotloftus/message-app/blob/main/postmanScreenshots/Get-All-messages.png)
    
### Architecture Choices
I chose a Kotlin, Spring REST microservice, with a mongodb database because it is what I'm familiar with and my go to choise for simple CRUD applications.

All of the logic is handled in the repository layer. The filtering based on recieptIds and senderIds, and limit/time based logic is all done in the queries.  I chose this to take advantage of any future indexes that would be added to this table.  For now I don't have any indexes due to keeping this as simple as possible, but I could certainly see indexes being added on sentAt time, to aid in quickly getting recent records in the last month.  Also, I could see an index being added for ```{recipientId:senderId}``` . This would allow super quick queries to get recipientId and senderId combos, and still allow for querying quickly by recipientId
by specifying index starts with recipienttId

### Future Considerations
1. Right now the architecture is pretty locked in to 1 sender and 1 recipient, so if there was a possibiity in the future to open it up to group chat we may want to consider a differnt approach
2. I didn't add any tests, which of course is a big uh oh, but that was the thing I scratched to keep it in the time frame (go figure 😅) jk, I understand tests are very important and realize they should be added for all new logic.  But to productionize this, I would certainly add a full suite of controller/service/repository unit tests, and some integration tests.
3. Add some data validation 

### Thank you so much for takin the time to look over my project 🎉
