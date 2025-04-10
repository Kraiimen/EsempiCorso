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

        //ROOMs
        Map<Compass, Room> templeDirections = new HashMap<Compass, Room>();
        Room temple = new Temple("Temple", templeDirections);

        Map<Compass, Room> templeSquareDirections = new HashMap<Compass, Room>();
        Room templeSquare = new TempleSquare("Temple Square", templeSquareDirections);

        Map<Compass, Room> marketSquareDirections = new HashMap<Compass, Room>();
        Room marketSquare = new MarketSquare("Market Square", marketSquareDirections);

        Map<Compass, Room> bakeryDirections = new HashMap<Compass, Room>();
        Room bakery = new Bakery("The Bakery", bakeryDirections);

        Map<Compass, Room> armoryDirections = new HashMap<Compass, Room>();
        Room armory = new Armory("The Armory", armoryDirections);

        Map<Compass, Room> gardensDirections = new HashMap<Compass, Room>();
        Room gardens = new Gardens("The Gardens", gardensDirections);

        Map<Compass, Room> woodsDirections = new HashMap<Compass, Room>();
        Room woods = new Woods("Woods", woodsDirections);

        Map<Compass, Room> cityDoorDirections = new HashMap<Compass, Room>();
        Room cityDoor = new CityDoor("City Door", cityDoorDirections);

        //BLOCCO DIRECTIONS

        //Temple:
        templeDirections.put(Compass.WEST, templeSquare);
        templeDirections.put(Compass.SOUTH, bakery);
        templeDirections.put(Compass.NORTH, null);
        templeDirections.put(Compass.EAST, null);

        //TempleSquare
        templeSquareDirections.put(Compass.WEST, null);
        templeSquareDirections.put(Compass.SOUTH, marketSquare);
        templeSquareDirections.put(Compass.NORTH, null);
        templeSquareDirections.put(Compass.EAST, temple);

        //MarketSquare
        marketSquareDirections.put(Compass.WEST, armory);
        marketSquareDirections.put(Compass.SOUTH, gardens);
        marketSquareDirections.put(Compass.NORTH, templeSquare);
        marketSquareDirections.put(Compass.EAST, bakery);

        //Bakery
        bakeryDirections.put(Compass.WEST, marketSquare);
        bakeryDirections.put(Compass.SOUTH, null);
        bakeryDirections.put(Compass.NORTH, temple);
        bakeryDirections.put(Compass.EAST, null);

        //Armory
        armoryDirections.put(Compass.WEST, null);
        armoryDirections.put(Compass.SOUTH, null);
        armoryDirections.put(Compass.NORTH, null);
        armoryDirections.put(Compass.EAST, marketSquare);

        //Gardens
        gardensDirections.put(Compass.WEST, null);
        gardensDirections.put(Compass.SOUTH, cityDoor);
        gardensDirections.put(Compass.NORTH, marketSquare);
        gardensDirections.put(Compass.EAST, null);

        //CityDoor
        cityDoorDirections.put(Compass.WEST, null);
        cityDoorDirections.put(Compass.SOUTH, woods);
        cityDoorDirections.put(Compass.NORTH, gardens);
        cityDoorDirections.put(Compass.EAST, null);

        //Woods
        woodsDirections.put(Compass.WEST, null);
        woodsDirections.put(Compass.SOUTH, null);
        woodsDirections.put(Compass.NORTH, cityDoor);
        woodsDirections.put(Compass.EAST, null);



        //INIZIALIZZAZIONE GIOCATORE
        Random dice = new Random();
        do {
            System.out.println("Scegli una categoria tra le suggerite");
            answer = console.readLine();
            if (answer.toLowerCase().equals("wizard")) {
                int intelligence = dice.nextInt(20);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(10);
                int stamina = dice.nextInt(10);
                Player player = new Wizard(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Wizard" );
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("paladin")) {
                int intelligence = dice.nextInt(5);
                int strength = dice.nextInt(20);
                int agility = dice.nextInt(5);
                int stamina = dice.nextInt(15);
                Player player = new Paladin(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Paladin");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("priest")) {
                int intelligence = dice.nextInt(15);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(5);
                int stamina = dice.nextInt(20);
                Player player = new Priest(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Priest");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);

            } else if (answer.toLowerCase().equals("thief")) {
                int intelligence = dice.nextInt(15);
                int strength = dice.nextInt(5);
                int agility = dice.nextInt(20);
                int stamina = dice.nextInt(5);
                Player player = new Thief(name, 10, 10, 1, 0, templeSquare, playerName, intelligence, strength, agility, stamina);
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Thief");
                System.out.printf(" intelligence: %d%n strength: %d%n agility: %d%n stamina %d%n", intelligence, strength, agility, stamina);
            }

        } while (!answer.toLowerCase().equals("wizard")
                && !answer.toLowerCase().equals("paladin")
                && !answer.toLowerCase().equals("priest")
                && !answer.toLowerCase().equals("thief"));

        System.out.println("La tua storia inizia qui: " + templeSquare.getNameRoom());
        templeSquare.printDescription();

        System.out.println();


    }
}
