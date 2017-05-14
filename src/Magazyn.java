
import java.util.Random;

/**
* @author Dominik Kinal <kinaldominik@gmail.com>
*/
public class Magazyn {
    private final int magazyn[] = new int[5];

    private final int max = 100;

    Magazyn() {
        Random rand = new Random();
        for(int i = 0; i < 5; i++) {
            magazyn[i] = rand.nextInt(100);
        }
    }

    void dodaj(int typ, int ilosc) {
        synchronized (magazyn) {
            magazyn[typ] += ilosc;
            if(magazyn[typ] > max)
                magazyn[typ] = max;
        }
        print();
    }

    void kup(int typ, int ilosc) {
        synchronized (magazyn) {
            if(magazyn[typ] - ilosc < 0)
                ilosc = magazyn[typ];

            magazyn[typ] -= ilosc;
        }
        print();
    }

    int sprawdzIlosc(int typ) {
        synchronized (magazyn) {
            return magazyn[typ];
        }
    }

    private void print() {
        System.out.print("magazyn: ");
        for(int i = 0; i < 5; i++) {
            System.out.print(i + " = " + sprawdzIlosc(i) + ", ");
        }
        System.out.println();
    }
}
