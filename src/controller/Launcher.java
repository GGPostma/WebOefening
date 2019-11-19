package controller;

import client.Client;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {


    public static void main(String[] args) throws IOException {


        Client client = new Client();
        client.startConnection("192.168.1.146",6667);
        Scanner keyboard = new Scanner(System.in);
        while (true){
            String message = client.sendMessage(keyboard.nextLine());
            System.out.println(message);
        }





    }
}
