package org.generation.italy.edenGame;

import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.entity.player.*;
import org.generation.italy.edenGame.room.*;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Start {
    public static void main(String[] args) {

        //INTRO DEL GIOCO
        Console console = System.console();
        System.out.println("Benvenuto in EdenGame, qual'è il tuo nome?");
        String playerName = console.readLine();
        System.out.println("Ciao " + playerName + ", scegli il nome del tuo personaggio");
        String name = console.readLine();
        System.out.println("Ora scegli la categoria tra: Wizard, Paladin, Priest, Thief");
        String answer;

        //inizializzazione Movimenti e Rooms

        Movements movements = new Movements();
        Map<String, Room> roomFinder = movements.getRoomFinder();


        Map<Compass, String> templeSquareDirections = movements.getTempleSquareDirections();
        Room templeSquare = movements.getTempleSquare();

        Map<Compass, String> templeDirections = movements.getTempleDirections();
        Room temple = movements.getTemple();

        Map<Compass, String> marketSquareDirections = movements.getMarketSquareDirections();
        Room marketSquare = movements.getMarketSquare();

        Map<Compass, String> bakeryDirections = movements.getBakeryDirections();
        Room bakery = movements.getBakery();

        Map<Compass, String> armoryDirections = movements.getArmoryDirections();
        Room armory = movements.getArmory();

        Map<Compass, String> gardensDirections = movements.getGardensDirections();
        Room gardens = movements.getGardens();

        Map<Compass, String> cityDoorDirections = movements.getCityDoorDirections();
        Room cityDoor = movements.getCityDoor();

        Map<Compass, String> woodsDirections = movements.getWoodsDirections();
        Room woods = movements.getWoods();


        //INIZIALIZZAZIONE GIOCATORE
        Random dice = new Random();
        Player player = null;


        do {
            System.out.println("Scegli una categoria tra le suggerite");
            answer = console.readLine();
            if (answer.toLowerCase().equals("wizard")) {
                int intelligence = dice.nextInt(20);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(10);
                int stamina = dice.nextInt(10);
                player = new Wizard(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Wizard");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("paladin")) {
                int intelligence = dice.nextInt(5);
                int strength = dice.nextInt(20);
                int agility = dice.nextInt(5);
                int stamina = dice.nextInt(15);
                player = new Paladin(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Paladin");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("priest")) {
                int intelligence = dice.nextInt(15);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(5);
                int stamina = dice.nextInt(20);
                player = new Priest(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Priest");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("thief")) {
                int intelligence = dice.nextInt(15);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(20);
                int stamina = dice.nextInt(5);
                player = new Thief(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Thief");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);
            }

        } while (!answer.toLowerCase().equals("wizard")
                && !answer.toLowerCase().equals("paladin")
                && !answer.toLowerCase().equals("priest")
                && !answer.toLowerCase().equals("thief"));
        System.out.println(" ");
        System.out.println("La tua storia inizia qui: " + "\n" + "--------/ " +  templeSquare.getNameRoom() + " /--------");
        templeSquare.printDescription();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(" ");

        //INIZIALIZZAZIONE MOVIMENTI
        //Todo: Tutti i movimenti che può fare il Player, vanno attivati con un conditional

        movements.moveFromTempleSquare(player, templeSquareDirections, roomFinder);
        movements.moveFromTemple(player,templeDirections, roomFinder);
        movements.moveFromMarketSquare(player, marketSquareDirections, roomFinder);
        movements.moveFromBakery(player, bakeryDirections, roomFinder);
        movements.moveFromArmory(player, armoryDirections, roomFinder);
        movements.moveFromGardens(player, gardensDirections, roomFinder);
        movements.moveFromCityDoor(player, cityDoorDirections, roomFinder);
        movements.moveFromWoods(player, woodsDirections, roomFinder);

    }

}
