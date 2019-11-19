package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean keepgoing;
    private int port;

    public void start() throws IOException {
        serverSocket = new ServerSocket(this.port, 1, InetAddress.getByName("192.168.1.146"));

        /*keepgoing = true;


            clientSocket = serverSocket.accept();

           out = new PrintWriter(clientSocket.getOutputStream(), true);
           in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String greeting = in.readLine();
            System.out.println(greeting);

            Scanner keyboard = new Scanner(System.in);
            out.println(keyboard.nextLine());*/
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
