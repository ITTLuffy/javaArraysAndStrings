import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero dispari per la base della piramide");
        int n = in.nextInt();

        String stringa = " ";
        // VERSIONE SENZA ARRAY

        int h = n;

        for (int i = 1; i < n; i += 2) {
            for (int j = h / 2; j > 0; j--) {
                System.out.print(stringa); // stampo gli spazi
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*"); // stampo gli asterischi
            }
            System.out.println("");
            h -= 2;
        }


        int altezzaTronco = ((n / 2) + 2)/3; // calcolo l'altezza del tronco
        for (int i = 0; i < altezzaTronco; i++) {
            for (int j = 0; j < (n / 2)-1; j++) {
                System.out.print(stringa);
            }
            for (int j = 0; j < 3; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        

        // VERSIONE CON ARRAY
        /*
         * int h = n;
         * char[] vettore = new char[n];
         * 
         * Arrays.fill(vettore, '*');
         * for (int i = 1; i < n; i += 2) {
         * for (int j = h / 2; j > 0; j--) {
         * System.out.print(stringa); // stampo gli spazi
         * }
         * 
         * for (int j = 0; j < i; j++) {
         * System.out.print(vettore[j]); // stampo gli asterischi
         * }
         * System.out.println("");
         * h -= 2;
         * 
         * }
         * 
         */

    }
}
