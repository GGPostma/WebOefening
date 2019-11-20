package thread;

import client.Client;
import client.Keyboard;
import server.Server;

import java.io.IOException;
import java.security.Key;

public class Thread extends java.lang.Thread {


    public Thread() {

    }

    public Thread (Keyboard keyboard){
        keyboard.run();
    }


    public Thread(Server server) throws IOException {
        server.run();
    }


    public void run() {
        //System.out.println("My thread is in running state.");
    }

}
