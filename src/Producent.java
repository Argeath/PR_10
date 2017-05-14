import java.util.Random;

/**
* @author Dominik Kinal <kinaldominik@gmail.com>
*/
public class Producent implements Runnable {
    private Magazyn magazyn;

    Producent(Magazyn m) {
        magazyn = m;
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
            while(!Thread.interrupted()) {

                int typ = rand.nextInt(5);
                int ilosc = rand.nextInt(30);

                System.out.print("Producent produkuje: " + ilosc + " x " + typ + ". ");
                magazyn.dodaj(typ, ilosc);

                Thread.sleep(rand.nextInt(2000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
