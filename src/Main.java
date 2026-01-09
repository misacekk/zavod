import java.time.LocalTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Auto auto1 = new Auto(1);
        Auto auto2 = new Auto(2);
        Auto auto3 = new Auto(3);
        Auto auto4 = new Auto(4);

        Thread a1 = Vlakno(auto1);
        Thread a2 = Vlakno(auto2);
        Thread a3 = Vlakno(auto3);
        Thread a4 = Vlakno(auto4);

        a1.start();
        a2.start();
        a3.start();
        a4.start();

        a1.join();
        a2.join();
        a3.join();
        a4.join();

        System.out.println("----------------------------------------------------------");

        vypis(auto1);
        vypis(auto2);
        vypis(auto3);
        vypis(auto4);

        int celkemKol = auto1.getOdjetaKola() + auto2.getOdjetaKola() + auto3.getOdjetaKola() + auto4.getOdjetaKola();




        System.out.println("----------------------------------------------------------");
        System.out.println("Závod skončil! Celkový počet ujetých kol: " + celkemKol);
        System.out.println("----------------------------------------------------------");

        Auto prvni = auto1;
        if (auto2.getCas().isBefore(prvni.getCas())) prvni = auto2;
        if (auto3.getCas().isBefore(prvni.getCas())) prvni = auto3;
        if (auto4.getCas().isBefore(prvni.getCas())) prvni = auto4;

        System.out.println("První je auto č. " + prvni.getCislo());
    }



    private static Thread Vlakno(Auto auto) {
        return new Thread(() -> {
            Random rn = new Random();
            for (int i = 1; i <= auto.getCilKola(); i++) {
                try {
                    Thread.sleep(rn.nextInt(300) + 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                auto.pridejKolo();
                System.out.println("Auto " + auto.getCislo() + " dokončilo kolo " + auto.getOdjetaKola());
            }
            auto.nastavKonecnyCas();
        });
    }

    private static void vypis(Auto auto) {
        System.out.println("Auto " + auto.getCislo() + " odjelo celkem kol: " + auto.getOdjetaKola());
    }
}