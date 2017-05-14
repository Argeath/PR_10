public class Main {

    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn();

        Thread[] producenci = new Thread[5];
        Thread[] konsumenci = new Thread[5];

        for(int i = 0; i < 5; i++) {
            Producent p = new Producent(magazyn);
            producenci[i] = new Thread(p);
            producenci[i].start();
        }

        for(int i = 0; i < 5; i++) {
            Konsument p = new Konsument(magazyn);
            konsumenci[i] = new Thread(p);
            konsumenci[i].start();
        }
    }
}
