package gesprek;

import java.sql.Timestamp;

public class Bericht {
    String bericht;
    Timestamp tijdstip;
    int port;

    public Bericht(String bericht, int port) {
        this.bericht = bericht;
        this.tijdstip = new Timestamp(System.currentTimeMillis());
        this.port = port;
    }

    @Override
    public String toString() {
        return "Bericht{" +
                "bericht='" + bericht + '\'' +
                ", tijdstip=" + tijdstip +
                ", port=" + port +
                '}';
    }
}
