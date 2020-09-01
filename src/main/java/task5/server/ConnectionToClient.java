package task5.server;

import task5.messages.ServerMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ConnectionToClient{
    private final String sessionId;
    private final Socket socket;
    private final ServerConnections serverConnections;

    public ConnectionToClient(String sessionId, Socket socket, ServerConnections serverConnections) {
        this.sessionId = sessionId;
        this.socket = socket;
        this.serverConnections = serverConnections;
        new Thread(runnable()).start(); // запуск потока который слушает клиента
    }

    private Runnable runnable() {
        return () -> {
            try {
                //TODO: класс ConnectionToClient содержит связь сервера с одним клиентом,
                // в нем содержится отдельный поток который слушает одного клиента (исполняет этот Runnable)
                // суть этого потока - слушать бесконечно objectInputStream и пересылать принятые объекты в ServerConnections
                // когда сокет будет закрыт - здесь сгенерится эксепшен, и этот поток должен закончиться
                // но перед тем как он закончится он должен уведомить ServerConnections об этом
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                while(true){

                }


            } catch (IOException ignored) {
            }
        };
    }

    public void sendMessage(ServerMessage serverMessage){
        //TODO: отправка сообщения клиенту
    }

    public void close(){
        // метод разрывает соединение с клиентом - закрывает сокет, после этого thread должен завершиться
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
