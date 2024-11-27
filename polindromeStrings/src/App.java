

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] vettore = {2,3,5,6,8,10,11,14,16,20};
        boolean ordinato = true;
        
        for (int i = 0; i < vettore.length-1; i++) {
            if (vettore[i] > vettore[i+1]) {
                ordinato = false;
                break;
            }
            
        }
        

        if (ordinato) {
            System.out.println("Il vettore è ordinato");
        } else {
            System.out.println("Il vettore non è ordinato");
        }
        
        
        // operatore TERNARIO
        String risposta = "Il vettore ";
        risposta  += (ordinato ? "è ordinato" : "non è ordinato");  
        System.out.println(risposta);
        
        System.out.println(Arrays.toString(vettore));
            
    //        int[] vettore2 = {2,3,5,6,8,10,11,14,16,20,6};
    //        
    //        Arrays.sort(vettore2);
    //        
    //        System.out.println(Arrays.toString(vettore2));
    //        
    //        if (vettore == vettore2) {
    //            System.out.println("Il vettore è ordinato");
    //            
    //        } else {
    //            System.out.println("Il vettore non è ordinato");
    //        }

        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci una stringa");
        
        String stringa = in.next();
        
        int j = stringa.length();
        boolean sentinella = true;
        
        for (int i = 0; i < stringa.length()/2; i++) {
            if (stringa.charAt(i) != stringa.charAt(j-1) && j > (stringa.length()/2)) {
                sentinella = false;
                break;
            } 
            j--;
        }
        
        if(sentinella) {
            System.out.println("La stringa è polindroma");  
        } else {
            System.out.println("La stringa non è polindroma");
        }
        
        in.close();

    }
}
