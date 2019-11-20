package controller;

import client.Client;
import client.Keyboard;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.io.IOException;
import java.security.Key;
import java.util.Scanner;

public class Launcher {


    public static void main(String[] args) throws IOException, InterruptedException {

     Keyboard keyboard = new Keyboard();


     Thread keyboardThread = new Thread(keyboard);


     keyboardThread.start();


        Client client = new Client();
        client.startConnection("192.168.1.146",6667);




        while (true){

          client.receiveMessage();

          client.sendMessage(keyboard);

        }







    }
}
