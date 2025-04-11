package capstoneproject.rooms;

import capstoneproject.Directions;
import capstoneproject.entity.Paladin;
import capstoneproject.entity.Player;
import capstoneproject.entity.Thief;
import capstoneproject.entity.Wizard;

import java.util.Scanner;

public class World {
    private Room start;
    private Player player;
    Scanner scanner;

     public World(){
         start = new Room("Temple Square" , "Una piazza ampia ed elegante, circondata con edifici costruiti in archittetura classica");

     }

     public void create(){
         Room ms = new Room("Market Square", "Piazza principale con mercato esotico");
         Room t = new Room("The Temple" , "Un tempio magico in cui curarsi");
         Room b = new Room ("The Bakery", "Un panetteria");
         Room a = new Room("The Armory" , "Un' Armeria");
         Room g = new Room("The Gardens" , "Un'giardino pieno di lucentezza");
         start.addExit(Directions.S , ms);
         start.addExit(Directions.E , t);
         ms.addExit(Directions.E, b);
         ms.addExit(Directions.W, a);
         ms.addExit(Directions.S , g);
     }


    public void chooseCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli il tuo personaggio:");
        System.out.println("1. Paladino");
        System.out.println("2. Guerriero");
        System.out.println("3. Mago");
        System.out.print("Scelta: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> player = new Paladin("Aladin", 20, 100, start);
            case "2" -> player = new Wizard("Magone", 15, 100, start);
            case "3" -> player = new Thief("Ladrone", 30, 100, start);
            default -> {
                System.out.println("Scelta non valida. Verrà assegnato un Paladino di default.");
                player = new Paladin("Aladino", 20, 100, start);
            }
        }
    }



     public Player getPlayer() {
         return player;
     }
}
