package edoardo.projectMud;

import edoardo.projectMud.npc.Npc;
import edoardo.projectMud.player.*;
import edoardo.projectMud.rooms.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;



public class DungeonManager {
    public static final ArrayList<PossibleRooms> initialAvailableRooms = new ArrayList<>( Arrays.stream(PossibleRooms.values()).
                                                                                        filter(r ->! r.toString().startsWith("CITY") ).
                                                                                        filter(r->! r.toString().startsWith("WOODS")).
                                                                                        toList());

    public static void main(String[] args){

        Console c = System.console();
        String userInput;
        Player player = new Paladin("Alfredo", Genre.MALE);
        Room currentRoom = initializeDungeon().getFirst();

        HashSet<Room> visitedRooms = new HashSet<>(50);
        while (player.isAlive()) {
            currentRoom.randomizeRooms(visitedRooms);
            visitedRooms.add(currentRoom);
            System.out.println("\n" + currentRoom + "\n" + currentRoom.getNotNullPath());

            userInput = c.readLine("Insert the direction or EXIT to leave the game: ");

            if (userInput.equalsIgnoreCase("SUD") && currentRoom.getSudRoom() != null) {
                currentRoom = currentRoom.getSudRoom();
                Player.updateBackLogDirections(Directions.SUD);
                continue;

            }
            if (userInput.equalsIgnoreCase("NORD") && currentRoom.getNordRoom() != null) {
                currentRoom = currentRoom.getNordRoom();
                Player.updateBackLogDirections(Directions.NORD);

                continue;


            }
            if (userInput.equalsIgnoreCase("EST") && currentRoom.getEstRoom() != null) {
                currentRoom = currentRoom.getEstRoom();
                Player.updateBackLogDirections(Directions.EST);

                continue;

            }
            if (userInput.equalsIgnoreCase("OVEST") && currentRoom.getOvestRoom() != null) {
                currentRoom = currentRoom.getOvestRoom();
                Player.updateBackLogDirections(Directions.OVEST);

                continue;
            }
            if (userInput.equalsIgnoreCase("EXIT")) {
                break;
            }
            System.out.println("Invalid input");
            c.readLine("Press shift to continue: ");

        }


    }
    public static void battleCycle(Player a, Npc b){
        do {
            a.attack(b);
            if (!b.isAlive()){
                System.out.println("Victory, " + "you gained " + b.getExpToDeath() + " exp");
                a.setExp(a.getExp()+b.getExpToDeath());
                return;
            }
            b.attack(a);

        } while (a.isAlive() && b.isAlive());
        System.out.println("Noob, you died");
        System.out.println("\u001B[31m GAME OVER \u001B[0m");
    }
    static public  ArrayList<Room> initializeDungeon() {
        ArrayList<Room> startingRooms = new ArrayList<>();
        Room rMarket = new MarketSquare(true);
        Room tTemple = new Temple(true);
        Room currentRoom = new TempleSquare(null, tTemple, null, rMarket);
        tTemple.setOvestRoom(currentRoom);
        Room rBakery = new Bakery(true);

        Room rArmory = new Armory(true);
        Room rGardens = new Gardens();
        rMarket.setEstRoom(rBakery);
        rMarket.setSudRoom(rGardens);
        rMarket.setNordRoom(currentRoom);
        rMarket.setOvestRoom(rArmory);
        rArmory.setEstRoom(rMarket);
        rGardens.setNordRoom(rMarket);
        rBakery.setOvestRoom(rMarket);
        startingRooms.add(currentRoom);
        startingRooms.add(rMarket);
        startingRooms.add(rBakery);
        startingRooms.add(rArmory);
        startingRooms.add(tTemple);
        return startingRooms;


    }
}
