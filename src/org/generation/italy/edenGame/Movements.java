package org.generation.italy.edenGame;

import org.generation.italy.edenGame.entity.player.Player;
import org.generation.italy.edenGame.room.*;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class Movements {

    //ROOMs
    Map<Compass, String> templeSquareDirections = new HashMap<Compass, String>();
    Room templeSquare = new TempleSquare("Temple Square", templeSquareDirections);

    Map<Compass, String> templeDirections = new HashMap<Compass, String>();
    Room temple = new Temple("Temple", templeDirections);

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

    //ROOM FINDER
    Map<String, Room> roomFinder = new HashMap<>();

    //BLOCCO DIRECTIONS
    public Movements() {

        roomFinder.put("Temple", temple);
        roomFinder.put("Temple Square", templeSquare);
        roomFinder.put("Market Square", marketSquare);
        roomFinder.put("The Bakery", bakery);
        roomFinder.put("The Armory", armory);
        roomFinder.put("The Gardens", gardens);
        roomFinder.put("Woods", woods);
        roomFinder.put("City Door", cityDoor);

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
    }



    public void moveFromTempleSquare(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = templeSquare;

        System.out.println("Queste sono le direzione dove andare:  " + templeSquareDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            }
        } while (!a.contains("SOUTH") && !a.contains("EAST"));

    }
}
