package thread;

import client.Client;
import server.Server;

import java.io.IOException;

public class Thread extends java.lang.Thread {


    public Thread() {

    }

    public Thread(Client client) {
        client.run();

    }

    public Thread(Server server) throws IOException {
     server.run();
    }


    public void run() {
        //System.out.println("My thread is in running state.");
    }

}
