package controller;

import client.Client;
import server.Server;
import thread.Thread;

import java.io.IOException;

public class Launcher {


    public static void main(String[] args) throws IOException {
        Server server = new Server();
       /* System.out.println("Starting server");
        server.start(6666);*/

        Client client = new Client();

        Thread serverThread = new Thread(server);
        Thread clientThread = new Thread(client);

        clientThread.start();
        serverThread.start();



    }
}
