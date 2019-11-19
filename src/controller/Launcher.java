package controller;

import client.Client;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.IOException;
import java.util.Scanner;

public class Launcher {


    public static void main(String[] args) throws IOException, InterruptedException {


        Client client = new Client();
        client.startConnection("192.168.2.9",6667);
        Scanner keyboard = new Scanner(System.in);
        client.sendMessage(keyboard.nextLine());
        while (true){
            System.out.println(keyboard.hasNextLine());

                client.sendMessage(keyboard.nextLine());

            client.receiveMessage();


        }





    }
}
