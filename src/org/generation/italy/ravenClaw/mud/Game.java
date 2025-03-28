package org.generation.italy.ravenClaw.mud;

import java.io.Console;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        System.out.println();
        Console console = System.console();
        Random dice = new Random();
        String choice;
        Player player = null;  // POLYMORPHIC VARIABLE
        String playerClass = console.readLine("Che classe vuoi giocare? Wizard, Berserker, Paladin: ");
        String playerName = console.readLine("Come vuoi chiamare il tuo eroe? ");
        String realPlayerName = console.readLine("Giocatore, come ti chiami? ");

        if(playerClass.equalsIgnoreCase("wizard")){
            player = new Wizard(playerName, dice.nextInt(50) + 1, dice.nextInt(10) + 1, realPlayerName, dice.nextInt(100) + 6);
        } else if(playerClass.equalsIgnoreCase("paladin")){
            player = new Paladin(playerName, dice.nextInt(50) + 25, dice.nextInt(20) + 1, realPlayerName);
        } else if (playerClass.equalsIgnoreCase("berserker")) {
            player = new Berserker(playerName, dice.nextInt(50) + 50, dice.nextInt(15) + 1, realPlayerName);
        }
        player.printSheet();

        Npc prisonGuy = new Npc("Prison jerk", 30,15,40,true);
        System.out.println("\nti risvegli in una cella fatta di roccia, hai una spada arrugginita alla tua destra, \n un umano dai lunghi capelli neri ti squadra dal fondo della cella \n Hey \n che ti guardi?,cerchi rogne!?\n");
        choice = console.readLine("Sembrerebbe che questo tizio non sia troppo cordiale,\n se vuoi attaccarlo scrivi ATTACCA , \n se invece vuoi richiamare una guardia scrivi URLA ");

        if(choice.equalsIgnoreCase("ATTACCA")){
            while(!prisonGuy.isDead()){

                player.attack(prisonGuy);
                if (!prisonGuy.isDead()){
                    prisonGuy.attack(player);
                }
                if(player.isDead()){
                    break;
                }
            }
            choice= console.readLine("\nil rompipalle è morto, trovi del pane tra le sue cose, \n se vuoi mangiarlo scrivi MANGIA, \n sennò scrivi NO ");
            if (choice.equalsIgnoreCase("MANGIA")){
                player.eat();
            }

        } else if (choice.equalsIgnoreCase("URLA")) {
            System.out.println("\n urli a squarciagola, ma nessuno arriva \n il tizzio sembra irritarsi, e alzatosi dalla sua branda ti da un pugno \n E statti un pò zitto!\n");
            prisonGuy.attack(player);
            choice = console.readLine("\n vuoi contrattaccare?, il tizzio sembra molto mal messo \n scrivi YES per contrattaccare \n scrivi NO per non contrattaccare e andare a dormire");

            if (choice.equalsIgnoreCase("YES")){
                while(!prisonGuy.isDead()){

                    player.attack(prisonGuy);
                    if (!prisonGuy.isDead()){
                        prisonGuy.attack(player);
                    }
                    if(player.isDead()){
                        break;
                    }
                }
            }else if (choice.equalsIgnoreCase("NO")){
                player.sleep();
            }
        }
        if(player.isDead()){
            System.out.println("SEI MORTO");
        }
        System.out.println("\nhai completato questo esempio di gioco del nostro gioco CONGRATULAZIONI!!");
    }
}
