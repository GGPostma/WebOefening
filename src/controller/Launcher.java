package controller;

import server.Server;
import thread.Thread;

import java.io.IOException;

public class Launcher {


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        System.out.println("Starting server");
        server.start(6666);

        thread.Thread thread1 = new Thread("taakA","A",10,1);

        thread1.start();


    }
}
