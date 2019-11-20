package client;

import gesprek.Bericht;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Keyboard implements Runnable{
    private ArrayList<String> nieuweBerichten = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);
    int counter = 0;


    public void activateKeyboard(){
        System.out.println("Keyboard activated");
        while (true){
            nieuweBerichten.add(keyboard.nextLine());
            System.out.println(nieuweBerichten);
        }
    }

    public String geefNieuwKeyboardBericht(){
        if (counter < nieuweBerichten.size()) {
            return this.nieuweBerichten.get(counter++);

        }
        return null;
    }

    @Override
    public void run() {
       activateKeyboard();
    }
}
