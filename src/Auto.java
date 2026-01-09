import java.util.Random;

public class Auto {
    private int cislo;
    private int odjetaKola;
    private int cilKola;

    Random rn = new Random();

    public Auto(int cislo) {
        this.cislo = cislo;
        this.cilKola = rn.nextInt(10, 20);
        this.odjetaKola = 0;

    }

    public synchronized void pridejKolo() {
        odjetaKola++;
    }

    public int getOdjetaKola() {
        return odjetaKola;
    }

    public int getCilKola() {
        return cilKola;
    }

    public int getCislo() {
        return cislo;
    }
}
