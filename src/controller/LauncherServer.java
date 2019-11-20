package controller;

import gesprek.Gesprek;
import server.Server;
import thread.Thread;

import java.io.IOException;


public class LauncherServer {
    public static void main(String[] args) throws IOException, InterruptedException {

        Gesprek gesprek = new Gesprek();

        Server server1 = new Server(gesprek);
        Server server2 = new Server(gesprek);

       // server1.setPort(6666);
        server2.setPort(6667);

       // Thread serverThread1 = new Thread(server1);
        Thread serverThread2 = new Thread(server2);

        //server1.getClientConnection();
        server2.getClientConnection();


        boolean keepgoing = true;

        while (keepgoing){

           // server1.getClientMessage();
            server2.getClientMessage();
         //   server1.setClientMessage();
            server2.setClientMessage();

        }

    }
}
