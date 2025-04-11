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


        //TempleSquare
        templeSquareDirections.put(Compass.SOUTH, marketSquare.getNameRoom());
        templeSquareDirections.put(Compass.EAST, temple.getNameRoom());

        //Temple:
        templeDirections.put(Compass.WEST, templeSquare.getNameRoom());
        templeDirections.put(Compass.SOUTH, bakery.getNameRoom());

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

    // ho cambiato semplciemente nell'input del metodo move "direction" in "templeDirection" ecc
    //controllare il Map<Compass, String> delle varie Directions perchè probabilmente non comunica con la Room, per questo i problemi in Start dove va tutto bene fino a questo metodo
    //potremmo rimettere l'oggetto Room e trovare un modo per leggerlo e trasformarlo in String così da avere ( le vie percorribili EAST=The BAKERY, ecc)

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
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (templeSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeSquareDirections.get(newDirection)));
                }
            }
        } while (!a.contains("SOUTH") && !a.contains("EAST"));

    }

    public void moveFromTemple(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = temple;

        System.out.println("Queste sono le direzione dove andare:  " + templeDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (templeDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (templeDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (templeDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (templeDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(templeDirections.get(newDirection)));
                }
            }
        } while (!a.contains("SOUTH") && !a.contains("WEST"));

    }


    public void moveFromMarketSquare(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = marketSquare;

        System.out.println("Queste sono le direzione dove andare:  " + marketSquareDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (marketSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(marketSquareDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (marketSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(marketSquareDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (marketSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(marketSquareDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (marketSquareDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(marketSquareDirections.get(newDirection)));
                }
            }
        } while (!a.contains("NORTH") && !a.contains("SOUTH") && !a.contains("WEST") && !a.contains("EAST"));

    }

    public void moveFromBakery(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = bakery;

        System.out.println("Queste sono le direzione dove andare:  " + bakeryDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (bakeryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(bakeryDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (bakeryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(bakeryDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (bakeryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(bakeryDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (bakeryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(bakeryDirections.get(newDirection)));
                }
            }
        } while (!a.contains("NORTH") && !a.contains("WEST"));

    }

    public void moveFromArmory(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = armory;

        System.out.println("Queste sono le direzione dove andare:  " + armoryDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (armoryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(armoryDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (armoryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(armoryDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (armoryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(armoryDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (armoryDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(armoryDirections.get(newDirection)));
                }
            }
        } while (!a.contains("EAST"));

    }


    public void moveFromGardens(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = gardens;

        System.out.println("Queste sono le direzione dove andare:  " + gardensDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (gardensDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(gardensDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (gardensDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(gardensDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (gardensDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(gardensDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (gardensDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(gardensDirections.get(newDirection)));
                }
            }
        } while (!a.contains("NORTH") && !a.contains("SOUTH"));
    }

    public void moveFromCityDoor(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = cityDoor;

        System.out.println("Queste sono le direzione dove andare:  " + cityDoorDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (cityDoorDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(cityDoorDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (cityDoorDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(cityDoorDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (cityDoorDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(cityDoorDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (cityDoorDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(cityDoorDirections.get(newDirection)));
                }
            }
        } while (!a.contains("NORTH") && !a.contains("SOUTH"));
    }

    public void moveFromWoods(Player player, Map<Compass, String> directions, Map<String, Room> roomFinder){
        Console console = System.console();
        String a;
        Compass newDirection = null;
        Room currentRoom = woods;

        System.out.println("Queste sono le direzione dove andare:  " + woodsDirections);
        System.out.println("Scrivi NORTH, SOUTH, WEST, EAST in base a dove vuoi andare");
        do {
            System.out.println("Segli solo una delle direzioni alla volta");
            a = console.readLine().toUpperCase();
            if (a.contains("NORTH")) {
                newDirection = Compass.NORTH;
                if (woodsDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Nord: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(woodsDirections.get(newDirection)));
                }
            } else if (a.contains("SOUTH")) {
                newDirection = Compass.SOUTH;
                if (woodsDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Sud: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(woodsDirections.get(newDirection)));
                }
            } else if (a.contains("WEST")) {
                newDirection = Compass.WEST;
                if (woodsDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Ovest: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(woodsDirections.get(newDirection)));
                }
            } else if (a.contains("EAST")) {
                newDirection = Compass.EAST;
                if (woodsDirections.get(newDirection) == null) {
                    System.out.println("Questa via non la puoi percorrere");
                } else {
                    System.out.println("Ti sei spostato a Est: ");
                    System.out.println(" ");
                    player.setCurrentRoom(roomFinder.get(woodsDirections.get(newDirection)));
                }
            }
        } while (!a.contains("NORTH"));
    }

    //TODO nuovo metodo public void moveFromRoom, if(player.getCurrentRoom().equals(templeSquare)) {moveFromTempleSquare()}

    public void moveFromRoom(Player player) {

        if(player.getCurrentRoom().equals(templeSquare)) {
            moveFromTempleSquare(player, templeSquareDirections, roomFinder);

        } else if(player.getCurrentRoom().equals(temple)) {
            moveFromTemple(player, templeDirections, roomFinder);

        } else if(player.getCurrentRoom().equals(marketSquare)) {
            moveFromMarketSquare(player, marketSquareDirections, roomFinder);

        } else if(player.getCurrentRoom().equals(bakery)) {
            moveFromBakery(player, bakeryDirections, roomFinder);

        } else if(player.getCurrentRoom().equals(armory)) {
            moveFromArmory(player, armoryDirections, roomFinder);

        } else if(player.getCurrentRoom().equals(gardens)) {
            moveFromGardens(player, gardensDirections, roomFinder);

        } else if(player.getCurrentRoom().equals(cityDoor)) {
            moveFromCityDoor(player, cityDoorDirections, roomFinder);

        } else if(player.getCurrentRoom().equals(woods)) {
            moveFromWoods(player, woodsDirections, roomFinder);

        }
    }

    //GETTER E SETTER
    public Map<String, Room> getRoomFinder() {
        return roomFinder;
    }

    public Map<Compass, String> getTempleSquareDirections() {
        return templeSquareDirections;
    }

    public Room getTempleSquare() {
        return templeSquare;
    }

    public Map<Compass, String> getTempleDirections() {
        return templeDirections;
    }

    public Room getTemple() {
        return temple;
    }

    public Map<Compass, String> getMarketSquareDirections() {
        return marketSquareDirections;
    }

    public Room getMarketSquare() {
        return marketSquare;
    }

    public Map<Compass, String> getBakeryDirections() {
        return bakeryDirections;
    }

    public Room getBakery() {
        return bakery;
    }

    public Map<Compass, String> getArmoryDirections() {
        return armoryDirections;
    }

    public Room getArmory() {
        return armory;
    }

    public Map<Compass, String> getGardensDirections() {
        return gardensDirections;
    }

    public Room getGardens() {
        return gardens;
    }

    public Map<Compass, String> getWoodsDirections() {
        return woodsDirections;
    }

    public Room getWoods() {
        return woods;
    }

    public Map<Compass, String> getCityDoorDirections() {
        return cityDoorDirections;
    }

    public Room getCityDoor() {
        return cityDoor;
    }
}
