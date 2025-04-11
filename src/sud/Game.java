package sud;
import sud.entity.*;
import sud.entity.classes.*;
import sud.rooms.Room;
import sud.items.*;

import java.io.Console;
import java.util.ArrayList;

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
        printSheet();
    }

    public static void start(){
        //@todo intro
        moveIntoRoom(Room.getRoomPointerFromName("TEMPLESQ"));
        interactMenu();

    }

    private static void printAvailablePaths(){
        Room north = player.getCurrentRoom().getNordPath();
        Room south = player.getCurrentRoom().getSudPath();
        Room west = player.getCurrentRoom().getWestPath();
        Room east = player.getCurrentRoom().getEastPath();
        if(north.getName().equalsIgnoreCase("debroom")){north.setName("");}
        System.out.println("(NORTH)-> " + north.getName());
        if(south.getName().equalsIgnoreCase("debroom")){south.setName("");}
        System.out.println("(SOUTH)-> " + south.getName());
        if(west.getName().equalsIgnoreCase("debroom")){west.setName("");}
        System.out.println("(WEST)-> " + west.getName());
        if(east.getName().equalsIgnoreCase("debroom")){east.setName("");}
        System.out.println("(EAST)-> " + east.getName());
    }
    private static void printAvailableNPC(){
        int counter =1;
        for (Entity n : player.getCurrentRoom().getNPCInRoom().values()){
            System.out.printf(n.getWithColor("(%d)-> %s\n") ,counter,n.getName());
            counter++;
        }
        System.out.printf("(%d)-> Nevermind\n",counter);
    }
    private static void printAvailableItems(){
        int counter =1;
        for (Item i : player.getCurrentRoom().getItemsInRoom().values()){
            System.out.printf("(%d)-> %s\n" ,counter,i.getName());
            counter++;
        }
        System.out.printf("(%d)-> Nevermind\n",counter);
    }
    private static void printInventory(){
        int counter =1;
        for (Item i : player.getInventory()){
            System.out.printf(player.getWithColor("(%d) %s\n"), counter, i.getName());
            counter++;
        }
        System.out.printf(player.getWithColor("(%d)-> Nevermind\n"),counter);
    }
    private static void printSheet(){
        System.out.println();
        {
            System.out.printf(/*player.getEntityColor()*/
                    """
                            Name: %s \
                            Class: %s \
                            
                            ------------------------------------------------\
                            
                            Intelligence: %d (%d) \
                            Strenght: %d (%d) \
                            Dexterity: %d (%d) \
                            Constitution: %d (%d) \
                            HP: %d \
                            CA: %d \
                            Level: %d \
                            Coins: %d \
                            """
                    //+ Entity.resetColor
                    ,player.getName(),
                    player.getClassName(),
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

    public static void moveIntoRoom(Room room){
        player.setCurrentRoom(room);
        System.out.printf(player.getWithColor("%s walks to %S\n"), player.getName(), room.getName());
        System.out.println(room.getDescription());
        if(player.getCurrentRoom().getName()== "PRISON"){
            System.out.printf("<And like this, the quest %s got from the king was given to another adventurer, since %s is now in a cell in the prison>");
        }
    }

    private static void talkTo(String npc){
        switch (npc){
            case "THE KING" -> {
                try {

                    Npc king = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE KING");
                    king.speak(king.getRandomLine());

                } catch (NullPointerException e) {
                    System.out.println("<The King is not in this room>");
                }
            }
            case "KING'S GUARD" -> {
                try {
                    Npc kingsG = (Npc) player.getCurrentRoom().getNPCInRoom().get("KING'S GUARD");
                    kingsG.speak(kingsG.getRandomLine());
                } catch (NullPointerException e) {
                    System.out.println("<The King's Guard is not in this room>");
                }
            }
            case "THE GUARD" -> {
                try {
                    Npc guard = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE GUARD");
                    guard.speak(guard.getRandomLine());

                } catch (NullPointerException e) {
                    System.out.println("<The Temple Square Guard is not in this room>");
                }
            }
            case "THE TAVERN KEEPER" -> {
                try {
                    Npc tavernKeeper = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE TAVERN KEEPER");
                    tavernKeeper.speak(tavernKeeper.getRandomLine());
                    System.out.println("<What would you like to say to her?>");
                    System.out.println(player.getWithColor(
                            "(1) --> \" May i have some food?\""+
                            "\n(2) --> \" Can i rent a room?\""+
                            "\n(3) --> \" Nevermind\"")
                    );
                    switch(player.askPlayerInput()){
                        case "1" -> {
                            if(tavernKeeper.doesEntityhaveitemInInventoryOfType(ItemType.FOOD)){
                                tavernKeeper.speak("Sure, that would be " + tavernKeeper.doesEntityHaveItem(ItemType.FOOD).getPrice() +" gold for this " +tavernKeeper.doesEntityHaveItem(ItemType.FOOD).getName());
                                System.out.println("<You have: " + player.getCoins() + " gold coins>");
                                System.out.println(player.getWithColor(
                                        "(1) --> \" sure, i'll take it\"" +
                                        "\n(2) --> \" nah, i'm fine\""));
                                switch (player.askPlayerInput()){
                                    case "1" ->{
                                        if(player.pay(tavernKeeper.doesEntityHaveItem(ItemType.FOOD))){
                                            tavernKeeper.speak("Thank you, here is your "+tavernKeeper.doesEntityHaveItem(ItemType.FOOD).getName());
                                        }else {
                                            tavernKeeper.speak("You don't have enough coins sweetie");
                                        }

                                    }
                                    case "2" ->{
                                        tavernKeeper.speak("Ok, do come back later sweetie");
                                    }
                                }

                            }
                        }
                        case "2" -> {
                            tavernKeeper.speak("Sure, a room for a night is 5 gold coins sweetie");
                            System.out.println(player.getWithColor(
                                    "(1) --> \" sure, i'll take it\"" +
                                            "\n(2) --> \" nah, i'm fine\""));
                            switch (player.askPlayerInput()){
                                case "1" ->{
                                    if(player.pay(tavernKeeper.doesEntityHaveItem(ItemType.FOOD))){
                                        player.printCoins();
                                        if(player.getCoins()>= 5){
                                            player.setCoins(player.getCoins()-5);
                                            tavernKeeper.speak("nighty night sweetie pie");
                                            player.sleep();
                                            tavernKeeper.speak("Good morning");
                                        }else {
                                            tavernKeeper.speak("<She leans closer to you> "+ tavernKeeper.getWithColor("\nthe tavern Keeper: You don't have enough coins sweetie, i would suggest you sleep in my room, but my bed is too small for the both of us "));
                                        }
                                    }else {
                                        tavernKeeper.speak("You don't have enough coins sweetie");
                                    }
                                }
                                case "2" ->{
                                    tavernKeeper.speak("Ok, come back another time then sweetie");
                                }
                            }
                        }
                        case "3" -> {
                            tavernKeeper.speak("Ok sweeatie promise you'll be back!");
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("<The Tavern Keeper is not in this room>");
                }
            }
            case "THE BAKER" -> {
                try {
                    Npc baker = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE BAKER");
                    ArrayList<Item> inventory = new ArrayList<>();
                    baker.speak(baker.getRandomLine());
                    System.out.println("<What would you like to say to him?>");
                    System.out.println(player.getWithColor(
                            "(1) --> \" Can i see your wares?\""+
                            "\n(2) --> \" Can you make me a cup of tea?\""+
                            "\n(3) --> \" Can i sell you some food i found?\""+
                            "\n(4) --> \" Nevermind\"")
                    );
                    switch(player.askPlayerInput()){
                        case "1" ->{
                            System.out.println(baker.getWithColor("Sure here are my little creations: "));
                            trade(baker,"No problem, come back whenever","Here you go Sugar","Sorry sugar, seams you don't have enough coins");
                        }
                        case "2" -> {
                            baker.speak("Sure that will be 5 gold coins is that ok?");
                            player.printCoins();
                            System.out.println(player.getWithColor(
                                    "(1) --> \" sure, i'll take it\"" +
                                    "\n(2) --> \" nah, i'm fine\""));
                            switch (player.askPlayerInput())
                            {
                                case "1" ->
                                {
                                    if(player.getCoins()>= 5)
                                    {
                                        player.setCoins(player.getCoins() - 5);
                                        baker.speak("Sit down in the sofà, i'll bring it to you in a moment");
                                        player.eat(Item.itemMap.get("tea"));
                                    }else {
                                        baker.speak("You don't have enough coins sugar, i'd give it to you, but i need the funds to make more");
                                    }
                                }
                                case "2" ->
                                {
                                    baker.speak("Ok, i'll be here if you change idea sugar");
                                }
                            }
                        }
                        case "3" ->{
                            sell(baker,ItemType.FOOD,"Its ok sugar, come back another time");
                        }
                        case "4"-> {
                            System.out.println(baker.getWithColor("The Baker: Bye sugar"));
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("<The Baker is not in this room>");
                }
            }
            case "THE ALCHEMIST" -> {
                try {
                    Npc alchemist = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE ALCHEMIST");
                    alchemist.speak(alchemist.getRandomLine());
                    System.out.println("<What would you like to say to him?>");
                    System.out.println(player.getWithColor(
                            "(1) --> \" Can i see your wares?\""+
                            "\n(2) --> \" Can i sell you some things i found?\""+
                            "\n(3) --> \" Nevermind\"")
                    );
                    switch (player.askPlayerInput()){
                        case "1"->{
                            alchemist.speak("oK, i GoT SoMe MiXeS i CaN SeLL");
                            trade(alchemist,"Ok IS nOT LiKe I WANteD To SeLl YOU AnYTHinG AnYWAy","ALL YoURs!","No CoINs HuH?");
                        }
                        case "2"->{
                            alchemist.speak("LeT's SeE wHaT JuNk YoU PiCkEd uP FrOm tHe GrOuNd");
                            sell(alchemist,ItemType.JUNK,"foRGoT wHaT YoU wAnTeD tO SeLL HuH?, HaPpeNs tO tHe BeST oF uS");
                        }
                        case "3"->{
                            alchemist.speak("OK ByE RaTbRAin");
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("<The Alchemist is not in this room>");
                }
            }
            case "THE ASSISTANT" -> {
                try {
                    Npc blackSmithAssistant = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE ASSISTANT");
                    blackSmithAssistant.speak(blackSmithAssistant.getRandomLine());
                } catch (NullPointerException e) {
                    System.out.println("<The Blacksmith Assistant is not in this room>");
                }
            }
            case "THE CLERIC" -> {
                try {
                    Npc cleric = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE CLERIC");
                    cleric.speak(cleric.getRandomLine());
                    System.out.println("<What would you like to say to him?>");
                    System.out.println(player.getWithColor(
                            "(1) --> \" I would like to rest here for a bit?\""+
                            "\n(2) --> \" Nevermind\"")
                    );
                    switch (player.askPlayerInput()){
                        case "1"->{
                            if(player.levelUp()){
                                cleric.speak("May the gods bless you");
                            }
                        }
                        case "2"->{
                            cleric.speak("May the gods be with you");
                        }
                    }

                } catch (NullPointerException e) {
                    System.out.println("<The Cleric is not in this room>");
                }
            }
            case "₍^. .^₎⟆" ->{

            }
            default -> {
                System.out.println("<This Person isn't here>");
            }
        }
    }

    public static void interactMenu(){
        String decision;
        String whoPlayerWantToSpeackTo;
        String wherePlayerWantToMove;
        Item itemPlayerWantToSteal;
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
            decision = player.askPlayerInput();
            decision = decision.toUpperCase();
            switch (decision){
                case "MOVE","M" ->{
                    do {
                        System.out.println("<Where do you want to go?>");
                        printAvailablePaths();
                        wherePlayerWantToMove = console.readLine().toUpperCase();
                        switch (wherePlayerWantToMove){
                            case "NORTH","N" ->{
                                if(player.getCurrentRoom().getNordPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getNordPath());
                                }
                            }
                            case "SOUTH","S" ->{
                                if(player.getCurrentRoom().getSudPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getSudPath());
                                }
                            }
                            case "WEST","W" ->{
                                if(player.getCurrentRoom().getWestPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getWestPath());
                                }
                            }
                            case "EAST","E" ->{
                                if(player.getCurrentRoom().getEastPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getEastPath());
                                }
                            }
                        }
                    }while (!wherePlayerWantToMove.equalsIgnoreCase("NORTH") && !wherePlayerWantToMove.equalsIgnoreCase("SOUTH") && !wherePlayerWantToMove.equalsIgnoreCase("WEST") && !wherePlayerWantToMove.equalsIgnoreCase("EAST") );

                }
                case "TALK","T" ->{
                    if(player.getCurrentRoom().isHasNPC()){
                        System.out.println("<Who would you like to talk to?>");
                        printAvailableNPC();
                        whoPlayerWantToSpeackTo = console.readLine("--> ");
                        talkTo(getNameOfNpcFromNumberInTalkList(whoPlayerWantToSpeackTo));
                    }
                }
                case "STEAL","S" ->{
                    System.out.println("Guardie?: "+player.getCurrentRoom().isHasGuards());
                    if(player.getCurrentRoom().isHasItems()){
                        printAvailableItems();
                        int choice = player.askPlayerIntInput(player.getCurrentRoom().getItemsInRoom().size())-1;
                        ArrayList<Item> itemsInRoom = new ArrayList<>(player.getCurrentRoom().getItemsInRoom().values());
                        itemPlayerWantToSteal = (Item)itemsInRoom.get(choice);
                        if(player.getCurrentRoom().isHasGuards()){
                            Npc guard = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE GUARD");
                            if(dices.rd20()+player.getDexMod()>= 15){
                                if(itemPlayerWantToSteal.getType() == ItemType.ARMOR ||itemPlayerWantToSteal.getType() == ItemType.WEAPON ){
                                    System.out.printf("<Do you want to equip %S>\n",itemPlayerWantToSteal.getName());
                                    System.out.println(player.getWithColor(
                                            "(1) --> \" YES\""+
                                                    "\n(2) --> \" NO\"")
                                    );
                                    switch (player.askPlayerIntInput(2)){
                                        case 1 ->{
                                            player.pickUpItem(itemPlayerWantToSteal,true);
                                            player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                            if(player.getCurrentRoom().getItemsInRoom().isEmpty()){
                                                player.getCurrentRoom().setHasItems(false);
                                            }
                                        }
                                        case 2 ->{
                                            player.pickUpItem(itemPlayerWantToSteal,false);
                                            player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                            if(player.getCurrentRoom().getItemsInRoom().isEmpty()){
                                                player.getCurrentRoom().setHasItems(false);
                                            };
                                        }
                                    }
                                }
                                else{
                                    player.pickUpItem(itemPlayerWantToSteal,false);
                                    player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                    if(player.getCurrentRoom().getItemsInRoom().isEmpty()){
                                        player.getCurrentRoom().setHasItems(false);
                                    }
                                }
                            }else{
                                guard.speak("Hey, i saw you, now you and I are going to prison");
                                moveIntoRoom(Room.getRoomPointerFromName("PRISON"));
                            }
                        }else {
                            if(itemPlayerWantToSteal.getType() == ItemType.ARMOR ||itemPlayerWantToSteal.getType() == ItemType.WEAPON ){
                                System.out.printf("<Do you want to equip %S>\n",itemPlayerWantToSteal.getName());
                                System.out.println(player.getWithColor(
                                        "(1) --> \" YES\""+
                                                "\n(2) --> \" NO\"")
                                );
                                switch (player.askPlayerIntInput(2)){
                                    case 1 ->{
                                        player.pickUpItem(itemPlayerWantToSteal,true);
                                        player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                        if(player.getCurrentRoom().getItemsInRoom().isEmpty()){
                                            player.getCurrentRoom().setHasItems(false);
                                        }
                                    }
                                    case 2 ->{
                                        player.pickUpItem(itemPlayerWantToSteal,false);
                                        player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                        if(player.getCurrentRoom().getItemsInRoom().isEmpty()){
                                            player.getCurrentRoom().setHasItems(false);
                                        }
                                    }
                                }
                            }
                            else{
                                player.pickUpItem(itemPlayerWantToSteal,false);
                                player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                if(player.getCurrentRoom().getItemsInRoom().isEmpty()){
                                    player.getCurrentRoom().setHasItems(false);
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("<There's nothing to steal>");
                    }

                }
                case "FIGHT","F" ->{}
                case "CHARACTER MENU","CH" ->{
                    System.out.println(player.getWithColor(
                            "(1) --> \" VIEW INVENTORY\""+
                            "\n(2) --> \" VIEW CHARACTER SHEET\""+
                            "\n(3) --> \" Nevermind\"")
                    );
                    switch(player.askPlayerIntInput(3)){
                        case 1->{
                            printInventory();
                            player.askPlayerInput();
                        }
                        case 2->{
                            printSheet();
                        }
                        case 3->{}
                    }
                }
                case "QUIT" ->{}

            }
        }while (!decision.equalsIgnoreCase("MOVE")&&!decision.equalsIgnoreCase("TALK")&&!decision.equalsIgnoreCase("STEAL")&&!decision.equalsIgnoreCase("FIGHT")&&!decision.equalsIgnoreCase("QUIT")&&!decision.equalsIgnoreCase("CHARACTER MENU"));
    }

    private static String getNameOfNpcFromNumberInTalkList(String choice){
        ArrayList<Entity> npcs = new ArrayList<>();
        int choiceI = Integer.parseInt(choice);
        npcs.addAll(player.getCurrentRoom().getNPCInRoom().values());
        try{
            return npcs.get(choiceI-1).getName().toUpperCase();
        }catch (IndexOutOfBoundsException e){
            return "₍^. .^₎⟆";
        }

    }

    private static void trade(Entity npcInput, String escapeChoice, String successfullTrade, String failedTrade){
        int counter =1;
        Npc npc = (Npc)npcInput;
        System.out.println("<You have: " + player.getCoins() + " gold coins>");
        for(Item item : npc.getInventory()){
            System.out.printf(npc.getWithColor("(%d)-> %s (%d gold coins)\n"), counter, item.getName(), item.getPrice());
            counter++;
        }
        System.out.printf(npc.getWithColor("(%d)-> \"Nevermind\"\n"), counter);
        String choice=console.readLine("-->");
        int choiceI = Integer.parseInt(choice);
        if(choiceI==counter){
            npc.speak(escapeChoice);
        }else if(player.pay(npc.getInventory().get(choiceI))){
            npc.speak(successfullTrade);
        }else{
            npc.speak(failedTrade);
        }
    }

    private static void sell (Npc npc, ItemType sellableType,String escapeLine){
        int counter =1;
        for(Item item : player.getInventory()){
            if(item.getType() == sellableType){
                System.out.printf(player.getWithColor("(%d)-> %s (%d gold coins)\n"), counter, item.getName(), item.getPrice());
                counter++;
            }
        }
        System.out.printf(player.getWithColor("(%d)-> \"Nevermind\"\n"), counter);
        String choice=player.askPlayerInput();
        int choiceI = Integer.parseInt(choice);
        if(choiceI==counter){
            npc.speak(escapeLine);
        }else{
            Item itemSold= player.getInventory().get(choiceI);
            if(player.getCoins()-(int)(itemSold.getPrice()*0.8)==0){
                System.out.println("The item has now resell value");
            }else{
                player.setCoins(player.getCoins()-(int)(itemSold.getPrice()*0.8));
                npc.getInventory().add(itemSold);
                player.getInventory().remove(choiceI);
            }
        }
    }

}

