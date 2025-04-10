package capstoneproject.rooms;

import capstoneproject.Directions;
import capstoneproject.entity.Paladin;
import capstoneproject.entity.Player;

public class World {
    private Room start;
    private Player player;

     public World(){
         start = new Room("Temple Square" , "Una piazza ampia ed elegante, circondata con edifici costruiti in archittetura classica");
         player = new Paladin(100,20,"Aladino Il Puro", start);
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
}
