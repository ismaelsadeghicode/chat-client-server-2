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
    * broadcast messages

Commands:
    login <user> <password>
    logoff

````