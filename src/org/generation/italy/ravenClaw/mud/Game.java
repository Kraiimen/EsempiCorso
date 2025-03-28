package org.generation.italy.ravenClaw.mud;

import java.io.Console;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        System.out.println();
        Console console = System.console();
        Random dice = new Random();
        String choice;
        Wizard playerW = null;
        Paladin playerP = null;
        Berserker playerB = null;

        String playerClass = console.readLine("che clase vuoi giocare, Wizard, Berseker, Paladin \n");
        if(playerClass.equalsIgnoreCase("wizard")){
            playerW = new Wizard(console.readLine("Come vuoi chiamare il tuo eroe? "),dice.nextInt(50)+1,dice.nextInt(10)+1,console.readLine("Giocatore, come ti chiami "), dice.nextInt(100)+6);
            playerW.printSheet();
        }else if(playerClass.equalsIgnoreCase("paladin")){
            playerP = new Paladin(console.readLine("Come vuoi chiamare il tuo eroe? "),dice.nextInt(50)+25,dice.nextInt(20)+1,console.readLine("Giocatore, come ti chiami "));
            playerP.printSheet();
        } else if (playerClass.equalsIgnoreCase("berserker")) {
            playerB = new Berserker(console.readLine("Come vuoi chiamare il tuo eroe? "),dice.nextInt(50)+50,dice.nextInt(15)+1,console.readLine("Giocatore, come ti chiami "));
            playerB.printSheet();
        }
        Npc prisonGuy = new Npc("Prison jerk", 5,15,40,true);
        System.out.println("\nti risvegli in una cella fatta di roccia, hai una spada arrugginita alla tua destra, \n un umano dai lunghi capelli neri ti squadra dal fondo della cella \n Hey \n che ti guardi?,cerchi rogne!?\n");
        choice = console.readLine("Sembrerebbe che questo tizio non sia troppo cordiale,\n se vuoi attaccarlo scrivi ATTACCA , \n se invece vuoi richiamare una guardia scrivi URLA ");
        if(choice.equalsIgnoreCase("ATTACCA")){
            if(playerClass.equalsIgnoreCase("wizard")){
                playerW.castFireball(prisonGuy);
            }else if(playerClass.equalsIgnoreCase("paladin")){
                playerP.attack(prisonGuy);
            } else if (playerClass.equalsIgnoreCase("berserker")) {
                playerB.attack(prisonGuy);
            }
            choice= console.readLine("\nil rompipalle è morto, trovi del pane tra le sue cose, \n se vuoi mangiarlo scrivi MANGIA, \n sennò scrivi NO ");
            if (choice.equalsIgnoreCase("MANGIA")){
                if(playerClass.equalsIgnoreCase("wizard")){
                    playerW.eat();
                }else if(playerClass.equalsIgnoreCase("paladin")){
                    playerP.eat();
                } else if (playerClass.equalsIgnoreCase("berserker")) {
                    playerB.eat();
                }
            }

        } else if (choice.equalsIgnoreCase("URLA")) {
            System.out.println("\n urli a squarciagola, ma nessuno arriva \n il tizzio sembra irritarsi, e alzatosi dalla sua branda ti da un pugno \n E statti un pò zitto!\n");
            if(playerClass.equalsIgnoreCase("wizard")){
                prisonGuy.attack(playerW);
            }else if(playerClass.equalsIgnoreCase("paladin")){
                prisonGuy.attack(playerP);
            } else if (playerClass.equalsIgnoreCase("berserker")) {
                prisonGuy.attack(playerB);
            }
            choice = console.readLine("\n vuoi contrattaccare?, il tizzio sembra molto mal messo \n scrivi YES per contrattaccare \n scrivi NO per non contrattaccare e andare a dormire");

            if (choice.equalsIgnoreCase("YES")){
                if(playerClass.equalsIgnoreCase("wizard")){
                    playerW.castFireball(prisonGuy);
                }else if(playerClass.equalsIgnoreCase("paladin")){
                    playerP.attack(prisonGuy);
                } else if (playerClass.equalsIgnoreCase("berserker")) {
                    playerB.attack(prisonGuy);
                }
            }else if (choice.equalsIgnoreCase("NO")){
                if(playerClass.equalsIgnoreCase("wizard")){
                    playerW.sleep();
                }else if(playerClass.equalsIgnoreCase("paladin")){
                    playerP.sleep();
                } else if (playerClass.equalsIgnoreCase("berserker")) {
                    playerB.sleep();
                }
            }
        }
        System.out.println("\nhai completato questo esempio di gioco del nostro gioco CONGRATULAZIONI!!");
    }
}
