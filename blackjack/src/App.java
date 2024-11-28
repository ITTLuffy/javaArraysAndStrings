import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // importo Scanner e Random
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        // scritta iniziale gioco
        System.out.println("""
                           *************
                           """);
        System.out.println("""
                           * BLACKJACK *
                           """);
        System.out.println("*************");
        System.out.println("Premi 1 per iniziare :)");
        int inizio = in.nextInt();

        int soldi = 1000;
        System.out.println("I soldi a tua disposizione sono: " + soldi);
        // somma per vedere se abbiamo vinto o perso (GIOCATORE)
        int somma = 0;
        // somma per banco
        int sommaBanco = 0;

        // variabile per indice superiore a 2 per giocatore
        int j = 2;

        // variabile per indice superiore a 2 per banco
        int k = 2;

        // sentinella per uscire dal ciclo while
        boolean sentinella = true;
        
        boolean sentinella2 = true;

        // array per giocatore 
        int[] giocatore = new int[10];

        // array per banco
        int[] banco = new int[10];
        
        // soldi x banco
        int soldiBanco, sommaSoldiBanco = 0;
        
        int sFBanco = 0;

        
        // soldi
        System.out.println("Inserisci la puntata");
        int puntata = in.nextInt();
        soldi = soldi-puntata;
        System.out.println("I soldi a tua disposizione sono: " + soldi);
        // banco
        soldiBanco = r.nextInt(1, 401);
        sommaSoldiBanco += soldiBanco;
        System.out.println("Puntata banco: " + soldiBanco);

        // ciclo per generare le prime due carte
        for (int i = 0; i < 2; i++) {
            // genero casualmente le carte
            giocatore[i] = r.nextInt(1, 12);
            // somma carte giocatore
            somma += giocatore[i];

            // genero casualmente le carte del banco
            banco[i] = r.nextInt(1, 12);
            // somma carte banco
            sommaBanco += banco[i];
        }

        // stampo i risultati
        System.out.println("Carte: " + Arrays.toString(giocatore));
        System.out.println("La somma attuale delle carte è " + somma);

        while (sentinella) {
            // chiediamo all'utente il prossimo passo
            System.out.println("Vuoi continuare? Premi 1 se vuoi continuare o 2 se ti vuoi fermare");
            // leggiamo il numero
            int n = in.nextInt();

            // creiamo la selezione per continuare o smettere
            if (n == 1) {
                // puntata
                System.out.println("Inserisci la tua puntata");
                puntata = in.nextInt();
                soldi = soldi-puntata;
                System.out.println("I soldi a tua disposizione sono: " + soldi);
                
                // banco
                System.out.println("Soldi spesi dal banco: " + sommaSoldiBanco);
                soldiBanco = r.nextInt(1, 401);
                sommaSoldiBanco += soldiBanco;
                System.out.println("Puntata banco: " + soldiBanco);

                // non è consentito all in o arrivare a 0; in quel caso si perde tutto
                if (soldi == 0) {
                    System.out.println("Non hai più soldi");
                    sentinella = false;
                    sentinella2 = false;
                    n = 2;
                }

                // inseriamo un altro numero casuale
                giocatore[j] = r.nextInt(1, 12);

                // somma
                somma += giocatore[j];

                // stampo il risultati
                System.out.println("Le carte che hai sono: " + Arrays.toString(giocatore));
                System.out.println("La somma è uguale a " + somma);

                // incremento l'indice
                j++;
                if (somma > 21) {
                    System.out.println("Hai perso!!");
                    System.out.println("Il banco ha guadagnato " + soldi);
                    sFBanco = sommaSoldiBanco + soldi;
                    System.out.println("Il banco ora ha: " + sFBanco);

                    System.out.println("Hai " + soldi + " soldi");
                    System.out.println("Non sprecarli");
                    sentinella = false;
                    sentinella2 = false;
                }

            } else {

                // esco dal ciclo
                sentinella = false;

                // stampo i risultati
                System.out.println("Le carte che hai sono: " + Arrays.toString(giocatore));
                System.out.println("la somma delle carte è uguale a " + somma);
            }

        }
        // mettiamo un ciclo per bypassarlo nel caso la somma del giocatore sia maggiore di 21
        if (sentinella2 == true) {
            // facciamo pescare altre carte al banco
            while (somma > sommaBanco) {
                if (somma > sommaBanco) {
                    banco[k] = r.nextInt(1, 12);
                    sommaBanco += banco[k];
                    k++;
                }
            }

            System.out.println("Le carte del banco sono " + Arrays.toString(banco));
            System.out.println("La somma del banco è uguale a " + sommaBanco);

            // RISULTATI FINALI
            if (somma == 21 && sommaBanco == 21) {
                System.out.println("Hai perso, il banco ha vinto!!!");
                System.out.println("Ti rimangono " + soldi + " soldi");
                sFBanco = soldiBanco + soldi;
                System.out.println("Il banco ha");
                System.out.println("Torna subito a casa, non spendere soldi inutilmente");
            } else if (somma == 21) {
                System.out.println("Hai vinto, complimenti!!!");
                soldi = 1000;
                System.out.println("Ti rimangono " + soldi + " soldi");
                System.out.println("Ora che hai riavuto i tuoi soldi, pensa bene alla prossima mossa; non sprecarli");
            }

            if (somma > sommaBanco) {
                System.out.println("Hai vinto, complimenti!!!");
                soldi = 1000;
                System.out.println("Ti rimangono " + soldi + " soldi");
                System.out.println("Ora che hai riavuto i tuoi soldi, pensa bene alla prossima mossa; non sprecarli");
            } 
            
            if (sommaBanco > 21) {
                System.out.println("Hai vinto, complimenti!!!");
                soldi = 1000;
                System.out.println("Ti rimangono " + soldi + " soldi");
                System.out.println("Ora che hai riavuto i tuoi soldi, pensa bene alla prossima mossa; non sprecarli");

            }
            
            if (somma == sommaBanco) {
                System.out.println("Nessuno ha vinto!");
                soldi = 1000;
                System.out.println("Ti rimangono " + soldi + "; non sprecarli");
                
            }
            
            if (somma > sommaBanco && somma < 21 && sommaBanco < 21) {
                System.out.println("Hai perso, il banco ha vinto!!!");
                System.out.println("Ti rimangono " + soldi + " soldi");
                System.out.println("Torna subito a casa, non spendere soldi inutilmente");               
            } 
        }

        in.close();

    }
}
