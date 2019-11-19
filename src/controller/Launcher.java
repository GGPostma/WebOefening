package controller;

import server.Server;

import java.io.IOException;

public class Launcher {


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        System.out.println("Starting server");
        server.start(6666);

    }
}
