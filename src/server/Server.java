package server;

import gesprek.Gesprek;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean keepgoing;
    private int port;
    private Gesprek gesprek;

    public Server(Gesprek gesprek) {
        this.gesprek = gesprek;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(this.port, 1, InetAddress.getByName("192.168.1.146"));
        keepgoing = true;
    }

    public void getClientConnection () throws IOException {
        clientSocket = serverSocket.accept();
    }

    public void getClientMessage () throws IOException, InterruptedException {
        //out = new PrintWriter(clientSocket.getOutputStream(), true);


        TimeUnit.MILLISECONDS.sleep(100);
        if ((clientSocket.getInputStream().available()> 0)) {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String greeting = in.readLine();

            if (!(greeting == null)) {
                gesprek.setGesprekArrayList(greeting);
                System.out.println(gesprek.getGesprekArrayList().get((gesprek.getGesprekArrayList().size() - 1)));
            }
        }

    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }


    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            start();
            System.out.println("Server started at port: " + this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
