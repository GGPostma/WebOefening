package gesprek;

import java.util.ArrayList;

public class Gesprek {
    ArrayList<String> gesprekArrayList = new ArrayList<>();

    public Gesprek() {
    }

    public void setGesprekArrayList(String tekst) {
        this.gesprekArrayList.add(tekst);
    }

    public ArrayList<String> getGesprekArrayList() {
        return gesprekArrayList;
    }
}
