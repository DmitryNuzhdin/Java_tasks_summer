package task5.server;

import task5.messages.*;

import java.util.*;

public class ServerLogic {
    private final ServerConnections serverConnections;
    private final Map<String, String> connectedUsers = new HashMap<>();
    private final List<MessageFromServer> messagesHistory = new ArrayList<>();

    public ServerLogic(ServerConnections serverConnections) {
        this.serverConnections = serverConnections;
    }

    public ServerMessage registerClient(RegisterClient registerClient, String sessionId) {
        if (connectedUsers.containsValue(registerClient.chatClientName))
            return new ServerErrorAnswer("This name is already in use");
        connectedUsers.put(sessionId, registerClient.chatClientName);
        return new ClientRegistered(sessionId);
    }

    public void messageFromClient(SendMessage sendMessage){
        String clientName = connectedUsers.get(sendMessage.sessionId);
        if (clientName != null) {
            MessageFromServer messageFromServer = new MessageFromServer(sendMessage.message, clientName);
            messagesHistory.add(messageFromServer);
            //TODO: send message to all clients
            //connectedUsers.forEach(RegisterClient -> );
        }
    }

    public SendMessage unregisterClient(ClientMessage clientMessage){
        return null;
    }
}
