package sud;
import sud.entity.*;
import sud.entity.classes.*;
import sud.rooms.Room;
import sud.items.*;

import java.io.Console;

public class Game {
    public static Player player;
    public static Console console = System.console();
    public static Room playerCurrentRoom;

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
            case "WIZARD" ->{player = new Wizard(name,Entity.colorC,"player");}
            case "ROGUE" ->{player = new Rogue(name,Entity.colorP,"player");}
            case "FIGHTER" ->{player = new Fighter(name,Entity.colorW,"player");}
            case "BARBARIAN" ->{player = new Barbarian(name,Entity.colorR,"player");}
        }
        System.out.println();
        {
            System.out.printf(/*player.getEntityColor()*/
                    """
                            <Name: %s> \n
                            Class: %s \n
                            
                            ------------------------------------------------\
                            
                            Intelligence: %d (%d) \n
                            Strenght: %d (%d) \n
                            Dexterity: %d (%d) \n
                            Constitution: %d (%d) \n
                            HP: %d \n
                            CA: %d \n
                            Level: %d \n
                            Coins: %d \n
                            """
                    //+ Entity.resetColor
                    ,player.getName(),
                    chosenClass,
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
        Room north = player.getCurrentRoom().getNordPath();
        Room south = player.getCurrentRoom().getSudPath();
        Room west = player.getCurrentRoom().getWestPath();
        Room east = player.getCurrentRoom().getEastPath();
        if(north.getName().equalsIgnoreCase("debroom")){north.setName("");}
        System.out.println("(MORTH)-> " + north.getName());
        if(south.getName().equalsIgnoreCase("debroom")){south.setName("");}
        System.out.println("(SOUTH)-> " + south.getName());
        if(west.getName().equalsIgnoreCase("debroom")){west.setName("");}
        System.out.println("(WEST)-> " + west.getName());
        if(east.getName().equalsIgnoreCase("debroom")){east.setName("");}
        System.out.println("(EAST)-> " + east.getName());
    }
    private static void printAvailableNPC(){
        String NPCNames ="";
        for (Entity n : player.getCurrentRoom().getNPCInRoom().values()){
            Npc npc = (Npc)n;
            NPCNames = NPCNames +  npc.getWithColor(npc.getName())  +", ";
        }
        System.out.println(NPCNames);
    }


    public static void moveIntoRoom(Room room){
        player.setCurrentRoom(room);
        System.out.printf(player.getWithColor("%s walks to %S\n"), player.getName(), room.getName());
        System.out.println(room.getDescription());
        if(!room.isHasItems()){
            String items= "";
            for (Item i : player.getCurrentRoom().getItemsInRoom().values()){
                items = items + i.getName() + ", ";
            }
            System.out.println("<you notice: "+ items  + "scattered across the room>");
        }
        if(!room.isHasNPC()){
            System.out.println("< you notice: "+ room.getNPCInRoom().values() + " in the room>") ;
        }
    }


    private static void talkTo(String npc){
        switch (npc){
            case "THE KING" -> {
                try {

                    Npc king = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE KING");
                    System.out.println("King: "+ king.getWithColor(king.getRandomLine()));

                } catch (NullPointerException e) {
                    System.out.println("<The King is not in this room>");
                }
            }
            case "KING'S GUARD" -> {
                try {
                    Npc kingsG = (Npc) player.getCurrentRoom().getNPCInRoom().get("KING'S GUARD");
                    System.out.println("king's guard: "+ kingsG.getWithColor(kingsG.getRandomLine()));
                } catch (NullPointerException e) {
                    System.out.println("<The King's Guard is not in this room>");
                }
            }
            case "THE GUARD" -> {
                try {
                    Npc tQGuard = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE GUARD");
                    System.out.println("the guard: "+tQGuard.getWithColor(tQGuard.getRandomLine()));

                } catch (NullPointerException e) {
                    System.out.println("<The Temple Square Guard is not in this room>");
                }
            }
            case "THE TAVERN KEEPER" -> {
                try {
                    Npc tavernKeeper = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE TAVERN KEEPER");
                    System.out.println("\nthe tavern Keeper: "+tavernKeeper.getWithColor(tavernKeeper.getRandomLine()));
                    System.out.println("<What would you like to say to her?>");
                    System.out.println(player.getWithColor(
                            "(1) --> \" May i have some food?\""+
                            "\n(2) --> \" Can i rent a room?\""+
                            "\n(3) --> \" Nevermind\"")
                    );
                    switch( console.readLine(player.getWithColor("-->"))){
                        case "1" -> {
                            if(tavernKeeper.doesEntityhaveitemInInventoryOfType(ItemType.FOOD)){
                                System.out.println(tavernKeeper.getWithColor("\nthe tavern Keeper: Sure, that would be " + tavernKeeper.doesEntityHaveItem(ItemType.FOOD).getPrice() +" gold for this " +tavernKeeper.doesEntityHaveItem(ItemType.FOOD).getName()));
                                System.out.println("<You have: " + player.getCoins() + " gold coins>");
                                System.out.println(player.getWithColor(
                                        "(1) --> \" sure, i'll take it\"" +
                                        "\n(2) --> \" nah, i'm fine\""));
                                switch (console.readLine(player.getWithColor("-->"))){
                                    case "1" ->{
                                        if(player.pay(tavernKeeper.doesEntityHaveItem(ItemType.FOOD))){
                                            System.out.println(tavernKeeper.getWithColor("\nthe tavern Keeper: Thank you, here is your "+tavernKeeper.doesEntityHaveItem(ItemType.FOOD).getName()));
                                        }else {
                                            System.out.println(tavernKeeper.getWithColor("\nthe tavern Keeper: You don't have enough coins sweetie"));
                                        }

                                    }
                                    case "2" ->{
                                        System.out.println(tavernKeeper.getWithColor("\nthe tavern Keeper: Ok, come back later sweetie"));
                                    }
                                }

                            }
                        }
                        case "2" -> {
                            System.out.println(tavernKeeper.getWithColor("\nthe tavern Keeper: Sure, a room for a night is 5 gold coins sweetie"));
                            System.out.println(player.getWithColor(
                                    "(1) --> \" sure, i'll take it\"" +
                                            "\n(2) --> \" nah, i'm fine\""));
                            switch (console.readLine(player.getWithColor("-->"))){
                                case "1" ->{
                                    if(player.pay(tavernKeeper.doesEntityHaveItem(ItemType.FOOD))){
                                        System.out.println("<You have: " + player.getCoins() + " gold coins>");
                                        if(player.getCoins()>= 5){
                                            player.setCoins(player.getCoins()-5);
                                            System.out.println(tavernKeeper.getWithColor("the tavern Keeper: nighty night sweetie pie"));
                                            player.sleep();
                                            System.out.println(tavernKeeper.getWithColor("the tavern Keeper: Good morning"));

                                        }else {
                                            System.out.println("<She leans closer to you> "+ tavernKeeper.getWithColor("\nthe tavern Keeper: You don't have enough coins sweetie, i would suggest you sleep in my room, but my bed is too small for the both of us "));
                                        }
                                    }else {
                                        System.out.println(tavernKeeper.getWithColor("\nthe tavern Keeper: You don't have enough coins sweetie"));
                                    }

                                }
                                case "2" ->{
                                    System.out.println(tavernKeeper.getWithColor("\nthe tavern Keeper: Ok, come back another time then sweetie"));
                                }
                            }
                        }
                        case "3" -> {}
                    }

                } catch (NullPointerException e) {
                    System.out.println("<The Tavern Keeper is not in this room>");
                }
            }
            case "THE BAKER" -> {
                try {
                    Npc baker = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE BAKER");
                    System.out.println("the baker: "+baker.getWithColor(baker.getRandomLine()));
                } catch (NullPointerException e) {
                    System.out.println("<The Baker is not in this room>");
                }
            }
            case "THE ALCHEMIST" -> {
                try {
                    Npc alchemist = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE ALCHEMIST");
                    System.out.println("the alchemist: "+alchemist.getWithColor(alchemist.getRandomLine()));
                } catch (NullPointerException e) {
                    System.out.println("<The Alchemist is not in this room>");
                }
            }
            case "THE ASSISTANT" -> {
                try {
                    Npc blackSmithAssistant = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE ASSISTANT");
                    System.out.println("the blackSmith Assistant: "+blackSmithAssistant.getWithColor(blackSmithAssistant.getRandomLine()));
                } catch (NullPointerException e) {
                    System.out.println("<The Blacksmith Assistant is not in this room>");
                }
            }
            case "THE CLERIC" -> {
                try {
                    Npc cleric = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE CLERIC");
                    System.out.println("the cleric: "+cleric.getWithColor(cleric.getRandomLine()));
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
            System.out.println("-------------------------------------");
            System.out.println("\n<What would you like to do in the " + player.getCurrentRoom().getName() +"?>");
            System.out.println(
                    "\n<Choose one of the following:>" +
                            "\nMOVE (get in another room)," +
                            "\nTALK (talk with somebody) " +
                            Entity.colorR + "\nSTEAL (take something from the room, mind the guards)" +
                            "\nFIGHT (Attack something in the room)" + Entity.resetColor +
                            "\nCHARACTER MENU (Check your inventory and statistics)" +
                            "\nQUIT (Quit the game)"
            );
            decision = console.readLine("\n--> ");
            decision = decision.toUpperCase();
            switch (decision){
                case "MOVE" ->{
                    do {
                        System.out.println("<Where do you want to go?>");
                        printAvailablePaths();
                        wherePlayerWantToMove = console.readLine().toUpperCase();
                        switch (wherePlayerWantToMove){
                            case "NORTH" ->{
                                if(player.getCurrentRoom().getNordPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getNordPath());
                                }
                            }
                            case "SOUTH" ->{
                                if(player.getCurrentRoom().getSudPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getSudPath());
                                }
                            }
                            case "WEST" ->{
                                if(player.getCurrentRoom().getWestPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getWestPath());
                                }
                            }
                            case "EAST" ->{
                                if(player.getCurrentRoom().getEastPath().getName().equalsIgnoreCase("debroom")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getEastPath());
                                }
                            }
                        }
                    }while (!wherePlayerWantToMove.equalsIgnoreCase("NORTH") && !wherePlayerWantToMove.equalsIgnoreCase("SOUTH") && !wherePlayerWantToMove.equalsIgnoreCase("WEST") && !wherePlayerWantToMove.equalsIgnoreCase("EAST") );

                }
                case "TALK" ->{
                    if(player.getCurrentRoom().isHasNPC()){
                        System.out.println("<Who would you like to talk to?>");
                        printAvailableNPC();
                        whoPlayerWantToSpeackTo = console.readLine("--> ");
                        whoPlayerWantToSpeackTo= whoPlayerWantToSpeackTo.toUpperCase();
                        talkTo(whoPlayerWantToSpeackTo);
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
        moveIntoRoom(Room.getRoomPointerFromName("TAVERN"));
        interactMenu();

    }
}
