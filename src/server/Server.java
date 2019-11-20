package server;

import gesprek.Bericht;
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

    public void setClientMessage() throws IOException {

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        Bericht output = gesprek.geefNieuwBericht(clientSocket.getLocalPort());
        if (!(output == null)){
            out.println(output);
            System.out.println(output);
        }
    }


    public void getClientMessage () throws IOException, InterruptedException {

        TimeUnit.MILLISECONDS.sleep(100);
        if ((clientSocket.getInputStream().available()> 0)) {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();

            Bericht bericht = new Bericht(greeting,clientSocket.getLocalPort());
            System.out.println(bericht.toString());
            gesprek.setNieuweBerichten(bericht);
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
