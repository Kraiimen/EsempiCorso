package sud;
import sud.entity.*;
import sud.entity.classes.*;
import sud.rooms.Room;

import java.io.Console;

public class Game {
    public static Player player;
    public static Console console = System.console();
    public static Room playerCurretnRoom;

    public static void createPlayerCharacter (){
        String name;
        String chosenClass;
        int count=0;
        System.out.println("Hello traveler, what is your name?");
        name = console.readLine("--> ");
        do {
            if(count != 0){
                System.out.println("Sorry I couldn't understand, what are you?");
            }else{
                System.out.println("And what you may be?");
            }
            chosenClass = console.readLine("<Answer with of the following: Wizard, Fighter, Barbarian, Rogue> --> ");
            count++;
        }while (!chosenClass.equalsIgnoreCase("rogue")
                &&!chosenClass.equalsIgnoreCase("wizard")
                &&!chosenClass.equalsIgnoreCase("barbarian")
                &&!chosenClass.equalsIgnoreCase("fighter"));
        chosenClass = chosenClass.toUpperCase();
        switch (chosenClass){
            case "WIZARD" ->{player = new Wizard(name,"player");}
            case "ROGUE" ->{player = new Rogue(name,"player");}
            case "FIGHTER" ->{player = new Fighter(name,"player");}
            case "BARBARIAN" ->{player = new Barbarian(name,"player");}
        }
        playerCurretnRoom = player.getCurrentroom();
        System.out.println();
        {
            System.out.printf(player.getEntityColor()+
                    """
                            <Name: %s>\
                            Class: %s\
                            
                            ------------------------------------------------\
                            
                            Intelligence: %d (+%d)\
                            Strenght: %d (+%d)\
                            Dexterity: %d (+%d)\
                            Constitution: %d (+%d)\
                            HP: %d\
                            CA: %d\
                            Level: %d\
                            Coins: %d\
                            """
                    + Entity.resetColor
                    ,player.getName(),
                    player.getClass(),
                    player.getIntelligence(), player.getIntMod(),
                    player.getStrength(), player.getStrMod(),
                    player.getDexterity(), player.getDexMod(),
                    player.getConstitution(), player.getConMod(),
                    player.getHealthPoints(),
                    player.getAc(),
                    player.getLevel(),
                    player.getCoins());
        }

    }

    private static void printAvailablePaths(){
        Room noth = playerCurretnRoom.getNordPath();
        Room sud = playerCurretnRoom.getSudPath();
        Room west = playerCurretnRoom.getWestPath();
        Room est = playerCurretnRoom.getEastPath();
        if(noth.getName().equalsIgnoreCase("debroom")){noth.setName("");}
        System.out.println("(NORD)-> " + noth);
        if(noth.getName().equalsIgnoreCase("debroom")){noth.setName("");}
        System.out.println("(SUD)-> " + sud);
        if(noth.getName().equalsIgnoreCase("debroom")){noth.setName("");}
        System.out.println("(WEST)-> " + west);
        if(noth.getName().equalsIgnoreCase("debroom")){noth.setName("");}
        System.out.println("(EAST)-> " + est);
    }
    private static void printAvailableNPC(){
        String NPCNames ="";
        for (Entity n : playerCurretnRoom.getNPCInRoom().values()){
            Npc npc = (Npc)n;
            NPCNames = NPCNames +  npc.getWithColor(npc.getName())  +", ";
        }
        System.out.println(NPCNames);
    }
    public static void moveIntoRoom(Room room){
        player.setCurrentroom(room);
        System.out.printf(player.getEntityColor()+ "%s walks to %S", player.getName(), room.getName());
        System.out.println(room.getDescription());
        if(!room.isHasItems()){
            System.out.println("< you notice: "+ room.getItemsInRoom().values() + " scattered across the room>") ;
        }
        if(!room.isHasNPC()){
            System.out.println("< you notice: "+ room.getNPCInRoom().values() + " in the room>") ;
        }
        printAvailablePaths();
    }
    private static void talkTo(Npc talker){
        switch (talker.getName()){
            case "The King" -> {
                try {
                    Npc king = (Npc) playerCurretnRoom.getNPCInRoom().get("King");
                } catch (NullPointerException e) {
                    System.out.println("<The King is not in this room>");
                }
            }
            case "Kind's Guard" -> {
                try {
                    Npc kingsG = (Npc) playerCurretnRoom.getNPCInRoom().get("Kings Guard");
                } catch (NullPointerException e) {
                    System.out.println("<The King's Guard is not in this room>");
                }
            }
            case "The Guard" -> {
                try {
                    Npc tQGuard = (Npc) playerCurretnRoom.getNPCInRoom().get("TQ Guard");
                } catch (NullPointerException e) {
                    System.out.println("<The Temple Square Guard is not in this room>");
                }
            }
            case "The Tavern Keeper" -> {
                try {
                    Npc tavernKeeper = (Npc) playerCurretnRoom.getNPCInRoom().get("TavernK");
                } catch (NullPointerException e) {
                    System.out.println("<The Tavern Keeper is not in this room>");
                }
            }
            case "The Baker" -> {
                try {
                    Npc baker = (Npc) playerCurretnRoom.getNPCInRoom().get("Baker");
                } catch (NullPointerException e) {
                    System.out.println("<The Baker is not in this room>");
                }
            }
            case "The Alchemist" -> {
                try {
                    Npc alchemist = (Npc) playerCurretnRoom.getNPCInRoom().get("Alchemist");
                } catch (NullPointerException e) {
                    System.out.println("<The Alchemist is not in this room>");
                }
            }
            case "The Assistant" -> {
                try {
                    Npc blackSmithAssistant = (Npc) playerCurretnRoom.getNPCInRoom().get("Assistant");
                } catch (NullPointerException e) {
                    System.out.println("<The Blacksmith Assistant is not in this room>");
                }
            }
            case "The Cleric" -> {
                try {
                    Npc cleric = (Npc) playerCurretnRoom.getNPCInRoom().get("Cleric");
                } catch (NullPointerException e) {
                    System.out.println("<The Cleric is not in this room>");
                }
            }
            default -> {
                System.out.println("<This Person does not exist>");
            }
        }
    }
    public static void interactMenu(){
        String whoPlayerWantToSpeackTo;
        String decision;
        String wherePlayerWantToMove;
        do {
            System.out.println("<What would you like to do?");
            decision = console.readLine(
                    "<Chose one of the following: " +
                    "\nMove (get in another room)," +
                    "\nTalk (talk with somebody) " +
                    "\n"+Entity.colorR+ "STEAL (take something from the room, mind the guards) " +
                    "\nFight (Attack something in the room)"+ Entity.resetColor +
                    "\nCharacter Menu (Check your inventory and statistics)"+
                    "\nQuit(Quit the game>)"+
                    "\n--> ");
            decision = decision.toUpperCase();
            switch (decision){
                case "MOVE" ->{
                    do {
                        System.out.println("<Where do you want to go?>");
                        wherePlayerWantToMove = console.readLine().toUpperCase();
                        switch (wherePlayerWantToMove){
                            case "NOTH" ->{
                                if(playerCurretnRoom.getNordPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(playerCurretnRoom.getNordPath());
                                }
                            }
                            case "SUD" ->{
                                if(playerCurretnRoom.getNordPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(playerCurretnRoom.getSudPath());
                                }
                            }
                            case "WEST" ->{
                                if(playerCurretnRoom.getNordPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(playerCurretnRoom.getWestPath());
                                }
                            }
                            case "EAST" ->{
                                if(playerCurretnRoom.getNordPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(playerCurretnRoom.getEastPath());
                                }
                            }
                        }
                    }while (!wherePlayerWantToMove.equalsIgnoreCase("NORTH") && !wherePlayerWantToMove.equalsIgnoreCase("SUD") && !wherePlayerWantToMove.equalsIgnoreCase("WEST") && !wherePlayerWantToMove.equalsIgnoreCase("EAST") );

                }
                case "TALK" ->{
                    if(playerCurretnRoom.isHasNPC()){
                        System.out.println("<Who would you like to talk to?>");
                        printAvailableNPC();
                        whoPlayerWantToSpeackTo = console.readLine("--> ");
                    }
                }
                case "STEAL" ->{}
                case "FIGHT" ->{}
                case "CHARACTER MENU" ->{}
                case "QUIT" ->{}

            }
        }while (!decision.equalsIgnoreCase("MOVE")&&!decision.equalsIgnoreCase("TALK")&&!decision.equalsIgnoreCase("STEAL")&&!decision.equalsIgnoreCase("FIGHT")&&!decision.equalsIgnoreCase("QUIT")&&!decision.equalsIgnoreCase("CHARACTER MENU"));
    }
    public static void start(){
        //@todo intro
        moveIntoRoom(Room.getRoomPointerFromName("castle"));
        interactMenu();

    }
}
