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

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port, 1, InetAddress.getByName("192.168.1.146"));

        keepgoing = true;


            clientSocket = serverSocket.accept();

           out = new PrintWriter(clientSocket.getOutputStream(), true);
           in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String greeting = in.readLine();
            System.out.println(greeting);

            Scanner keyboard = new Scanner(System.in);
            out.println(keyboard.nextLine());
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }


    @Override
    public void run() {
        try {
            start(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
