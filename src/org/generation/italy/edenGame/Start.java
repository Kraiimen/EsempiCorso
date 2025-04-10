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
        Map<Compass, String> templeDirections = new HashMap<Compass, String>();
        Room temple = new Temple("Temple", templeDirections);

        Map<Compass, String> templeSquareDirections = new HashMap<Compass, String>();
        Room templeSquare = new TempleSquare("Temple Square", templeSquareDirections);

        Map<Compass, String> marketSquareDirections = new HashMap<Compass, String>();
        Room marketSquare = new MarketSquare("Market Square", marketSquareDirections);

        Map<Compass, String> bakeryDirections = new HashMap<Compass, String>();
        Room bakery = new Bakery("The Bakery", bakeryDirections);

        Map<Compass, String> armoryDirections = new HashMap<Compass, String>();
        Room armory = new Armory("The Armory", armoryDirections);

        Map<Compass, String> gardensDirections = new HashMap<Compass, String>();
        Room gardens = new Gardens("The Gardens", gardensDirections);

        Map<Compass, String> woodsDirections = new HashMap<Compass, String>();
        Room woods = new Woods("Woods", woodsDirections);

        Map<Compass, String> cityDoorDirections = new HashMap<Compass, String>();
        Room cityDoor = new CityDoor("City Door", cityDoorDirections);

        //BLOCCO DIRECTIONS

        //Temple:
        templeDirections.put(Compass.WEST, templeSquare.getNameRoom());
        templeDirections.put(Compass.SOUTH, bakery.getNameRoom());

        //TempleSquare
        templeSquareDirections.put(Compass.SOUTH, marketSquare.getNameRoom());
        templeSquareDirections.put(Compass.EAST, temple.getNameRoom());

        //MarketSquare
        marketSquareDirections.put(Compass.WEST, armory.getNameRoom());
        marketSquareDirections.put(Compass.SOUTH, gardens.getNameRoom());
        marketSquareDirections.put(Compass.NORTH, templeSquare.getNameRoom());
        marketSquareDirections.put(Compass.EAST, bakery.getNameRoom());

        //Bakery
        bakeryDirections.put(Compass.WEST, marketSquare.getNameRoom());
        bakeryDirections.put(Compass.NORTH, temple.getNameRoom());


        //Armory
        armoryDirections.put(Compass.EAST, marketSquare.getNameRoom());

        //Gardens
        gardensDirections.put(Compass.SOUTH, cityDoor.getNameRoom());
        gardensDirections.put(Compass.NORTH, marketSquare.getNameRoom());


        //CityDoor
        cityDoorDirections.put(Compass.SOUTH, woods.getNameRoom());
        cityDoorDirections.put(Compass.NORTH, gardens.getNameRoom());


        //Woods
        woodsDirections.put(Compass.NORTH, cityDoor.getNameRoom());


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
                System.out.println("Ottimo, il tuo giocatore si chiama " + name + " ed è un Wizard");
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

        System.out.println("La tua storia inizia qui: --------/ " + templeSquare.getNameRoom() + "/--------");
        templeSquare.printDescription();
        System.out.println("Queste sono le direzione dove andare:  " + templeSquareDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        String a;
        Compass newDirection = null;

        //DIREZIONI DI TEMPLESQUARE
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: " + templeSquareDirections.get(newDirection));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: " + templeSquareDirections.get(newDirection));
//                    player.setCurrentRoom(templeSquareDirections.get(newDirection));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: " + templeSquareDirections.get(newDirection));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: " + templeSquareDirections.get(newDirection));
                }
            }
        } while (!a.contains("SOUTH") && !a.contains("EAST"));





    }

}
