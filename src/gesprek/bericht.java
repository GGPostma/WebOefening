package gesprek;

import java.sql.Timestamp;

public class bericht {
    String bericht;
    Timestamp tijdstip;
    String user;

    public bericht(String bericht, String user) {
        this.bericht = bericht;
        this.tijdstip = new Timestamp(System.currentTimeMillis());
        this.user = user;
    }
}
