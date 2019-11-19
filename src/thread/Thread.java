package thread;

public class Thread extends java.lang.Thread {
    private String naam;
    private int aantal;
    private int kolom;
    private String s;

    public Thread(String threadName, String naam, int aantal, int kolom) {
        super(threadName);
        this.naam = naam;
        this.aantal = aantal;
        s = " ";
        for (int j = 0; j < kolom; j++)
            s = "\t" + s;
        s = s + "x";
    }

    public void run() {
        for (int i = 0; i < aantal; i++) {
            System.out.println(naam + i + s);
        }
    }
}
