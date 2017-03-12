package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class Server
{

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Enter server port:");
        int port = ConsoleHelper.readInt();


        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Server is running.");

            while (true)
            {
                Socket clientSocket = serverSocket.accept();
                new Handler(clientSocket).start();
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Error: " + e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
        {
            try
            {
                entry.getValue().send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Can not send message to : " + entry.getKey());
            }
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response = connection.receive();
                if (response.getType() == MessageType.USER_NAME)
                {
                    String clientName = response.getData();
                    if (clientName != null && !clientName.isEmpty() && !connectionMap.containsKey(clientName))
                    {
                        connectionMap.put(clientName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return clientName;
                    }
                }

            }

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {

            for (String clientName : connectionMap.keySet())
            {
                if (!clientName.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
                }
            }

        }


        private void serverMainLoop(Connection connection, String userName) throws
                IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else
                {
                    ConsoleHelper.writeMessage("Message in incorrect format.");
                }
            }
        }

        @Override
        public void run()
        {
            ConsoleHelper.writeMessage("New connection was created with client " + socket.getRemoteSocketAddress());
            Connection connection = null;
            String clientName = null;
            try
            {
                connection = new Connection(socket);
                clientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                sendListOfUsers(connection, clientName);
                serverMainLoop(connection, clientName);

            }
            catch (IOException e)
            {
                handleHandlerException(e, connection);
            }
            catch (ClassNotFoundException e)
            {
                handleHandlerException(e, connection);
            }

            // disconnecting client
            if (clientName != null)
            {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }

            ConsoleHelper.writeMessage(String.format("Connection with remote address (%s) has been closed.", socket.getRemoteSocketAddress()));

        }

        private void handleHandlerException(Exception e, Connection connection)
        {
            ConsoleHelper.writeMessage("Error was happened during exchange data with remote address: " +
                    socket.getRemoteSocketAddress() + "%n" +
                    "Error type: " + e.getClass().getSimpleName() + "%n" +
                    "Error text: " + e.getMessage());
            try
            {
                if (connection != null)
                    connection.close();
                socket.close();
            }
            catch (IOException e_)
            { /* NOP */ }
        }
    }


}
