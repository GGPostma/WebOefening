package controller;

import server.Server;
import thread.Thread;

import java.io.IOException;

public class LauncherServer {
    public static void main(String[] args) throws IOException {
        Server server1 = new Server();
        Server server2 = new Server();

        server1.setPort(6666);
        server2.setPort(6667);

        Thread serverThread1 = new Thread(server1);
        Thread serverThread2 = new Thread(server2);

        serverThread1.start();
        serverThread2.start();

        while (true){

        }

    }
}
