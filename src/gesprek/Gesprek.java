package gesprek;

import java.util.ArrayList;

public class Gesprek {
    ArrayList<Bericht> gesprekArrayList = new ArrayList<>();
    ArrayList<Bericht> nieuweBerichten = new ArrayList<>();
    int indexGebruiker1;
    int indexGebruiker2;
    int poortNummerGebruiker1;
    int poortNummerGebruiker2;

    public Gesprek() {
    }

    public void setGesprekArrayList(Bericht nieuwBericht) {
        this.gesprekArrayList.add(nieuwBericht);
    }

    public ArrayList<Bericht> getGesprekArrayList() {
        return gesprekArrayList;
    }

    public Bericht geefNieuwBericht(){
        if (!(nieuweBerichten.isEmpty())){
            Bericht bericht = nieuweBerichten.get(nieuweBerichten.size()-1);
            nieuweBerichten.remove(bericht);
            gesprekArrayList.add(bericht);
            return bericht;
        }
        return null;
    }


    public void setNieuweBerichten(Bericht nieuweBerichten) {
        this.nieuweBerichten.add(nieuweBerichten);
    }

    public void setPoortNummerGebruiker1(int poortNummerGebruiker1) {
        this.poortNummerGebruiker1 = poortNummerGebruiker1;
    }

    public void setPoortNummerGebruiker2(int poortNummerGebruiker2) {
        this.poortNummerGebruiker2 = poortNummerGebruiker2;
    }
}
