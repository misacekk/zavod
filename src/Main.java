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
    }

    //Tuto 1x a pak to stačí napsat např. jako: Thread a1 = Vlakno(auto1);
    private static Thread Vlakno(Auto auto) {
        return new Thread(() -> {
            for (int i = 1; i <= auto.getCilKola(); i++) {
                auto.pridejKolo();
                System.out.println("Auto " + auto.getCislo() + " dokončilo kolo " + auto.getOdjetaKola());
            }
        });
    }

    //Tuto 1x a pak to stačí napsat např. jako: vypis(auto1);
    private static void vypis(Auto auto) {
        System.out.println("Auto " + auto.getCislo() + " odjelo celkem kol: " + auto.getOdjetaKola());
    }
}
