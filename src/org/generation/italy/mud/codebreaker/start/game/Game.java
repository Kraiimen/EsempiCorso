package org.generation.italy.mud.codebreaker.start.game;

import org.generation.italy.mud.codebreaker.entities.Bitborne;
import org.generation.italy.mud.codebreaker.zones.MapAreas;
import org.generation.italy.mud.codebreaker.zones.Navigate;
import org.generation.italy.mud.codebreaker.zones.Zone;

import java.awt.*;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private MapAreas Codetopia;
    private Zone currentZone;

    public void start(){
        Scanner scannerCheckIntro = new Scanner(System.in);

        Boolean checkIntroChoice = false;
        do {
            System.out.println("Vuoi vedere l'intro? Y/N");
            String choice = scannerCheckIntro.nextLine();
            switch (choice.toUpperCase()) {
                case "Y":
                    intro();
                    checkIntroChoice = true;
                    break;
                case "N":
                    checkIntroChoice = true;
//                    System.out.println("\u001B[36mPuoi muoverti con i numeri o digitando la direzione cardinale in cui vuoi andare\n" +
//                            "Premi 1 per iniziare a muoverti!\u001B[0m");
                    break;
                default:
                    System.out.println("Seleziona una scelta disponibile");
            }
        } while (!checkIntroChoice);
        Codetopia = new MapAreas();
//        System.out.println("Sei arrivato alla seconda linea di start su game");
//        currentZone = Codetopia.getStartingZone();


//        Bitborne maincharacter = new Bitborne("BitBorne",4,4,4,4);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Come ti chiami?(dai un nome al tuo personaggio)");
//        maincharacter.setClassName(scanner.nextLine());

    }





    public void intro(){
        try {
            System.out.println("È una giornata come le altre");
            Thread.sleep(1500);
            System.out.println("Dopo una lunga sessione di gioco su Aardwolf, decidi di aggiornare Java.");
            Thread.sleep(2600);
            System.out.println("Mentre navighi tra vecchi siti e repository dimenticati, ti imbatti in un forum abbandonato da anni.");
            Thread.sleep(2600);
            System.out.println("Lì, nascosta tra righe di codice e post dimenticati, trovi una versione misteriosa: JAVA X.");
            Thread.sleep(2600);
            System.out.println("Spinto dalla curiosità, scarichi il file e avvii l’installazione...");
            Thread.sleep(2600);
            for(int i = 0; i < 5; i++){
                System.out.print("\033[31mLo schermo lampeggia \033[0m"); //Testo rosso
                Thread.sleep(500);
                for (int j = 0; j < 50; j++){
                    System.out.println("           ");
                }
            }
            System.out.println();
            Thread.sleep(2600);
            System.out.println("\033[37mTi senti risucchiato da un energia superiore, perdi i sensi...\033[0m");
            Thread.sleep(4000);
            for(int i = 0; i <= 100; i++){
                System.out.println("Conversione funzioni umane da analogico a digitale " + i + " %." );
                Thread.sleep(50);
            }
            Thread.sleep(4000);

            System.out.println("\033[32mUn oggetto di tipo Bitborne.javaX è stato compilato\033[0m");
            Thread.sleep(2000);
            System.out.println("...");
            Thread.sleep(2000);
            System.out.println("\033[37T Ti svegli frastornato"); //Inizio linee di testo in grigio chiaro
            Thread.sleep(2600);
            System.out.println("L'odore di metallo caldo ti punge le narici.");
            Thread.sleep(2600);
            System.out.println("Ti guardi attorno, ma questo luogo non ti è familiare..");
            Thread.sleep(2600);
            System.out.println("Davanti a te si estende una strada lunga e luminosa sospesa nel vuoto");

        } catch (InterruptedException e){
            System.out.println( "qualcosa è andato storto con il timer."  );
        }

    }
}
