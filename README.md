# DSMQ - Lightweight message queue server

Lightweight message queue server.

## Description

Lightweight non-persistent message queue server.  
This is not a pub-sub system, each message in queue can be consumed only once.

### Endpoints exposed :

1. `PUT /create/{channel}`
   - Create a `channel`
   - A `channel` is just a named message queue
2. `POST /send/{channel}`
   - Send a `message` to a `channel`.
   - See `dsmq.postman_collection.json` for message format
3. `GET /receive/{channel}`
   - Consume first available `message` from a `channel`
   - If no message is available, returns a blank message
   - See `dsmq.postman_collection.json` for message format

### Roadmap:

1. Improve readme
2. Improve endpoint format
3. Improve message format
4. Improve error handling
5. Evaluate performance
6. Use github releases
7. Implement AMQP
