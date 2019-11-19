package gesprek;

import java.util.ArrayList;

public class Gesprek {
    private ArrayList<Bericht> gesprekArrayList = new ArrayList<>();
    private ArrayList<Bericht> nieuweBerichten1 = new ArrayList<>();
    private ArrayList<Bericht> nieuweBerichten2 = new ArrayList<>();


    public Gesprek() {
    }

    public void setGesprekArrayList(Bericht nieuwBericht) {
        this.gesprekArrayList.add(nieuwBericht);
    }

    public ArrayList<Bericht> getGesprekArrayList() {
        return gesprekArrayList;
    }

    public Bericht geefNieuwBericht(int port) {
        if (port == 6666) {
            if (!(this.nieuweBerichten1.isEmpty())) {
                Bericht bericht = this.nieuweBerichten1.get(nieuweBerichten1.size() - 1);
                gesprekArrayList.add(bericht);
                this.nieuweBerichten1.remove(bericht);
                return bericht;
            }
            return null;
        } else if (port == 6667) {
            if (!(this.nieuweBerichten2.isEmpty())) {
                Bericht bericht = this.nieuweBerichten2.get(nieuweBerichten2.size() - 1);
                gesprekArrayList.add(bericht);
                this.nieuweBerichten2.remove(bericht);
                return bericht;
            }
            return null;
        }
        return null;
    }




    public void setNieuweBerichten(Bericht bericht) {
        if (bericht.port == 6667){
            nieuweBerichten1.add(bericht);
        } else if (bericht.port ==6666){
            nieuweBerichten2.add(bericht);
        }

    }


}
