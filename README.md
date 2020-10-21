# chat-client-server-2

## Phase 1
````
summary: 
        * ServerSocket  --> accept connection
        * Socket (client)
            --> getInputStream()
            --> getOutputStream()
        * Worker Thraed to handle client connections
        * Accept Multiple

````


## Phase 2
````
summery:
        User & Server
1- User --> Server
    * login | logoff
    * status
    
2- Server --> User
    * online | offline

3- User --> User
    * direct messages
    * broadcast messages / group messaging

Commands:
    login <user> <password>
    logoff

    msg <user> text...
    guest: "msg jim Hello world" <--- send
    jim: "msg guest Hello world" <--- recv
    
    #topic <-- chatroom / group chat
    join #topic
    level #topic
    send: msg #topic body ..
    recv: msg #topic:<login> body .. 

````