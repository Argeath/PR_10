import java.util.Random;

/**
* @author Dominik Kinal <kinaldominik@gmail.com>
*/
public class Konsument implements Runnable {
    private Magazyn magazyn;

    Konsument(Magazyn m) {
        magazyn = m;
    }

    @Override
    public void run() {
        try {
            Random rand = new Random();
            while(!Thread.interrupted()) {
                int typ = rand.nextInt(5);
                int ilosc = rand.nextInt(20);

                System.out.print("Konsument kupuje: " + ilosc + " x " + typ + ". ");
                magazyn.kup(typ, ilosc);

                Thread.sleep(rand.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
