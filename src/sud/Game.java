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

    public static void createPlayerCharacter (){
        String name;
        String chosenClass;
        int count=0;
        System.out.println(Entity.colorG+"Hello traveler, what is your name?"+Entity.resetColor);
        name = console.readLine("--> ");
        if(name.equalsIgnoreCase("d")||name.equalsIgnoreCase("deb")|| name.equalsIgnoreCase("debug")){
            player = new Rogue();
        }else{
            do {
                if(count != 0){
                    System.out.println(Entity.colorG+"Sorry I couldn't understand, what are you?"+Entity.resetColor);
                }else{
                    System.out.println(Entity.colorG+"And what you may be?"+Entity.resetColor);
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
            System.out.print(player.getWithColor("|-->"));
            console.readLine();
        }


    }

    public static void start() throws GameClosingExeption {
        //@todo intro
        System.out.println("<Hi, this is the Narrator speaking, i'll be your guide, for now, i just want you to know>");
        System.out.println("<My presence will be marked by the \"<>\">");
        System.out.println("<When you see this symbol \"|-->\" it means to just give any input to the game, it's just there to give you time to read>");
        System.out.println("<When you see this symbol \"-->\" it means that you, the player will say/do the thing next to it >");
        System.out.println("<When you see this symbol \"( TEXT )->)\" you can write the full name of the action, like NORTH or just the initial like N  >");
        createPlayerCharacter();
        moveIntoRoom(Room.getRoomPointerFromName("CASTLE"),true);
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
        System.out.println("(STAY)-> NEVERMIND" );
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
        System.out.println("\n--------------------------------");
        for (Item i : player.getInventory()){
            System.out.printf(player.getWithColor("\n(%d) %s"), counter, i.getName());
            counter++;
        }
        System.out.printf(player.getWithColor("\n(%d)[Equipped Armor] %s\n"), counter, player.getEquipedArmor().getName());
        counter++;
        System.out.printf(player.getWithColor("(%d)[Equipped Weapon] %s\n"), counter, player.getEquipedWeapon().getName());
        counter++;
        System.out.printf(player.getWithColor("(%d)-> Nevermind\n"),counter);
        System.out.println("-------------------------------");
    }

    private static void printSheet(){
        System.out.printf(player.getEntityColor()+
                        "----------------------------------------\n" +
                        "Name: %s\n" +
                        "Class: %s\n" +
                        "----------------------------------------\n" +
                        "Intelligence: %d (%d)\n" +
                        "Strength: %d (%d)\n" +
                        "Dexterity: %d (%d)\n" +
                        "Constitution: %d (%d)\n" +
                        "HP: %d\n" +
                        "AC: %d\n" +
                        "Level: %d\n" +
                        "Coins: %d\n"+
                        "----------------------------------------\n" +
                        Entity.resetColor
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
    private static void trade(Entity npcInput, String escapeChoice, String successfulTrade, String failedTrade){
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
            npc.speak(successfulTrade);
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
        int choiceI=player.askPlayerIntInput(player.getInventory().size()+1);
        if(choiceI==counter){
            npc.speak(escapeLine);
        }else{
            Item itemSold= player.getInventory().get(choiceI-1);
            if(player.getCoins()-(int)(itemSold.getPrice()*0.8)==0){
                System.out.println("The item has now resell value");
            }else{
                player.setCoins(player.getCoins()-(int)(itemSold.getPrice()*0.8));
                npc.getInventory().add(itemSold);
                player.getInventory().remove(choiceI-1);
                System.out.printf("<You sold the %s for %d >",itemSold.getName(), player.getCoins()-(int)(itemSold.getPrice()*0.8));
            }
        }
    }
    public static void moveIntoRoom(Room room,Boolean printDesc)throws GameClosingExeption{
        player.setCurrentRoom(room);
        System.out.printf(player.getWithColor("%s walks to %S\n"), player.getName(), room.getName());
        if(printDesc){
            System.out.println(room.getDescription());
        }
        room.RandomizeGuards(room);
        if(player.getCurrentRoom().getName().equalsIgnoreCase("PRISON")){
            System.out.printf("<And like this, the quest %s got from the king was given to another adventurer, since %s is now in a cell in the prison>\n",player.getName(),player.getName());
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
                            player.printCoins();
                            System.out.println(player.getWithColor(
                                    "(1) --> \" sure, i'll take it\"" +
                                            "\n(2) --> \" nah, i'm fine\""));
                            switch (player.askPlayerInput()){
                                case "1" ->{

                                    if(player.getCoins()>= 5){
                                        player.setCoins(player.getCoins()-5);
                                        tavernKeeper.speak("nighty night sweetie pie");
                                        player.sleep();
                                        tavernKeeper.speak("\nGood morning");
                                    }else {
                                        tavernKeeper.speak("<She leans closer to you> "+ tavernKeeper.getWithColor("\nthe tavern Keeper: You don't have enough coins sweetie, i would suggest you sleep in my room, but my bed is too small for the both of us "));
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
                                        player.eat((Food)Item.itemMap.get("tea"));
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

    public static void interactMenu() throws GameClosingExeption {
        String decision;
        int choice; //decision ma int
        String whoPlayerWantToSpeackTo;
        String wherePlayerWantToMove;
        Item itemPlayerWantToSteal;
        boolean escape =false;
        System.out.print(player.getWithColor("|-->"));
        console.readLine();
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
                        wherePlayerWantToMove = player.askPlayerInput().toUpperCase();
                        switch (wherePlayerWantToMove){
                            case "NORTH","N" ->{
                                if(player.getCurrentRoom().getNordPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getNordPath(),true);
                                }
                            }
                            case "SOUTH","S" ->{
                                if(player.getCurrentRoom().getSudPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getSudPath(),true);
                                }
                            }
                            case "WEST","W" ->{
                                if(player.getCurrentRoom().getWestPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getWestPath(),true);
                                }
                            }
                            case "EAST","E" ->{
                                if(player.getCurrentRoom().getEastPath().getName().equalsIgnoreCase("")){
                                    System.out.println("<You have no interest in going that way, so you decide to stay where you are>");
                                }else {
                                    moveIntoRoom(player.getCurrentRoom().getEastPath(),true);
                                }
                            }case "STAY","ST","STA" ->{

                            }
                        }
                    }while (
                            !wherePlayerWantToMove.equalsIgnoreCase("NORTH") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("N") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("SOUTH") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("S") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("WEST") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("W") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("EAST")&&
                            !wherePlayerWantToMove.equalsIgnoreCase("E")&&
                            !wherePlayerWantToMove.equalsIgnoreCase("STAY") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("ST") &&
                            !wherePlayerWantToMove.equalsIgnoreCase("STA") );

                }
                case "TALK","T" ->{
                    if(player.getCurrentRoom().isHasNPC()){
                        System.out.println("<Who would you like to talk to?>");
                        printAvailableNPC();
                        choice = player.askPlayerIntInput(player.getCurrentRoom().getNPCInRoom().size()+1);
                        if(choice !=player.getCurrentRoom().getNPCInRoom().size()+1){
                            ArrayList npcinroom = new ArrayList();
                            npcinroom.addAll(player.getCurrentRoom().getNPCInRoom().values());
                            Npc npc = (Npc) npcinroom.get(choice-1);
                            whoPlayerWantToSpeackTo = npc.getName() ;
                            talkTo(whoPlayerWantToSpeackTo.toUpperCase());
                        }else{}

                    }
                    else {
                        System.out.println("<There is nobody to talk to>");
                    }
                }
                case "STEAL","S" ->{

                    if(player.getCurrentRoom().isHasItems()){
                        if (player.getCurrentRoom().isHasGuards()){
                            System.out.println("<Stealing is illegal... and there are guards nearby, are you sure you are sneaky enough>");
                        }else {
                            System.out.println("<Stealing is illegal... but if nobody sees you>");

                        }
                        while (!escape)
                        {
                            printAvailableItems();
                            ArrayList<Item> itemsInRoom = new ArrayList<>(player.getCurrentRoom().getItemsInRoom().values());
                            choice = player.askPlayerIntInput(itemsInRoom.size() + 1);
                            if (!(choice == (itemsInRoom.size() + 1))) {
                                itemPlayerWantToSteal = (Item) itemsInRoom.get(choice - 1);
                                int stealDc = 0;
                                if (itemPlayerWantToSteal.getPrice() < 10) {
                                    stealDc = 5;
                                } else if (itemPlayerWantToSteal.getPrice() >= 10 && itemPlayerWantToSteal.getPrice() < 50) {
                                    stealDc = 10;
                                } else if (itemPlayerWantToSteal.getPrice() >= 50 && itemPlayerWantToSteal.getPrice() < 100) {
                                    stealDc = 15;
                                } else if (itemPlayerWantToSteal.getPrice() >= 100 && itemPlayerWantToSteal.getPrice() < 10000) {
                                    stealDc = 20;
                                }
                                int roll = dices.rd20() + player.getDexMod();
                                if (player.getCurrentRoom().isHasGuards()) {

                                    if ( roll >= stealDc) {
                                        if (itemPlayerWantToSteal.getType() == ItemType.ARMOR || itemPlayerWantToSteal.getType() == ItemType.WEAPON) {
                                            System.out.printf("<Do you want to equip %S>\n", itemPlayerWantToSteal.getName());
                                            System.out.println(player.getWithColor(
                                                    "(1) --> \" YES\"" +
                                                            "\n(2) --> \" NO\"")
                                            );
                                            switch (player.askPlayerIntInput(2)) {
                                                case 1 -> {
                                                    player.pickUpItem(itemPlayerWantToSteal, true);
                                                    player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                                    if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
                                                        player.getCurrentRoom().setHasItems(false);
                                                    }
                                                }
                                                case 2 -> {
                                                    player.pickUpItem(itemPlayerWantToSteal, false);
                                                    player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                                    if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
                                                        player.getCurrentRoom().setHasItems(false);
                                                    }
                                                    ;
                                                }
                                            }
                                        }
                                        else if(itemPlayerWantToSteal.getName().equalsIgnoreCase("Gold Coins")){
                                            player.setCoins(player.getCoins()+itemPlayerWantToSteal.getPrice());
                                            player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                        }else {
                                            player.pickUpItem(itemPlayerWantToSteal, false);
                                            player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                            if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
                                                player.getCurrentRoom().setHasItems(false);
                                            }
                                        }
                                        System.out.printf("<You swiftly grab the %s>\n",itemPlayerWantToSteal.getName());
                                    } else {
                                        if (player.getCurrentRoom().getName().equalsIgnoreCase("castle")){

                                            Npc guard = (Npc) player.getCurrentRoom().getNPCInRoom().get("KING'S GUARD");
                                            System.out.println("\n");
                                            guard.speak("...Scum...");
                                            moveIntoRoom(Room.getRoomPointerFromName("PRISON"), false);
                                            escape = true;
                                            throw new GameClosingExeption();
                                        }else {
                                            Npc guard = (Npc) player.getCurrentRoom().getNPCInRoom().get("THE GUARD");
                                            guard.speak("\n\nHey, i saw you, now you and I are going to prison");
                                            moveIntoRoom(Room.getRoomPointerFromName("PRISON"), false);
                                            escape = true;
                                            throw new GameClosingExeption();
                                        }
                                    }
                                } else {
                                    if (itemPlayerWantToSteal.getType() == ItemType.ARMOR || itemPlayerWantToSteal.getType() == ItemType.WEAPON) {
                                        System.out.printf("<Do you want to equip %S>\n", itemPlayerWantToSteal.getName());
                                        System.out.println(player.getWithColor(
                                                "(1) --> \" YES\"" +
                                                        "\n(2) --> \" NO\"")
                                        );
                                        switch (player.askPlayerIntInput(2)) {
                                            case 1 -> {
                                                player.pickUpItem(itemPlayerWantToSteal, true);
                                                player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                                if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
                                                    player.getCurrentRoom().setHasItems(false);
                                                }
                                            }
                                            case 2 -> {
                                                player.pickUpItem(itemPlayerWantToSteal, false);
                                                player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                                if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
                                                    player.getCurrentRoom().setHasItems(false);
                                                }
                                            }
                                        }
                                    } else {
                                        player.pickUpItem(itemPlayerWantToSteal, false);
                                        player.getCurrentRoom().getItemsInRoom().remove(itemPlayerWantToSteal.getName().toUpperCase());
                                        if (player.getCurrentRoom().getItemsInRoom().isEmpty()) {
                                            player.getCurrentRoom().setHasItems(false);
                                        }
                                    }
                                }
                            }
                            else {
                                escape =true;
                            }
                        }

                    }
                    else{
                        System.out.println("<There's nothing to steal>");

                    }
                }
                case "FIGHT","F" ->{
                    if(player.getCurrentRoom().isHasMOBS()){

                    }else{
                        System.out.println("<There are no enemies to fight>");
                    }
                }
                case "CHARACTER MENU","CM","C" ->{

                    boolean escapeInv =false;
                    while (!escape){
                        System.out.println(player.getWithColor(
                                """
                                        (1) --> " VIEW INVENTORY"\
                                        
                                        (2) --> " VIEW CHARACTER SHEET"\
                                        
                                        (3) --> " Nevermind\"""")
                        );
                        int choice2 = player.askPlayerIntInput(3);
                        switch(choice2){
                            case 1->{
                                while (!escapeInv){
                                    printInventory();
                                    choice = player.askPlayerIntInput(player.getInventory().size()+3);

                                    if(choice == player.getInventory().size()+3){
                                        escapeInv =true;
                                    }else{
                                        if(!player.getInventory().isEmpty()){
                                            Item itemPlayerWantToUse = (player.getInventory().get(choice-1));
                                            if(choice == player.getInventory().size()+1){
                                                System.out.printf("<What Do you want to unequip: %S>",itemPlayerWantToUse.getName());
                                                System.out.println("(1)-> YES" +
                                                        "(2)-> NO");
                                                if(player.askPlayerIntInput(2)==1) {
                                                    if(player.getEquipedWeapon().getName().equalsIgnoreCase("Nothing")){
                                                        System.out.println("<You can't do that>");
                                                    }else {
                                                        player.setEquipedArmor(Entity.baseArmor);
                                                    }
                                                }
                                            }else
                                            if(choice == player.getInventory().size()+2){
                                                System.out.printf("<What Do you want to unequip: %S>",itemPlayerWantToUse.getName());
                                                System.out.println("(1)-> YES" +
                                                        "(2)-> NO");
                                                if(player.askPlayerIntInput(2)==1) {
                                                    if(player.getEquipedWeapon().getName().equalsIgnoreCase("Nothing")){
                                                        System.out.println("<You can't do that>");
                                                    }else {
                                                        player.setEquipedWeapon(Entity.baseWeapon);
                                                    }
                                                }
                                            }else{
                                                switch (itemPlayerWantToUse.getType()){
                                                    case FOOD->{
                                                        System.out.printf("<Do you want to eat the %S>\n",itemPlayerWantToUse.getName());
                                                        System.out.println("(1)-> YES\n" +
                                                                "(2)-> NO");

                                                        if(player.askPlayerIntInput(2)==1){
                                                            player.eat((Food)itemPlayerWantToUse);
                                                            player.getInventory().remove(choice-1);
                                                        }
                                                    }
                                                    case POTION -> {
                                                        Potion potion = (Potion) itemPlayerWantToUse;
                                                        System.out.printf("<Do you want to drink the %S>\n",itemPlayerWantToUse.getName());
                                                        System.out.println("(1)-> YES\n" +
                                                                "(2)-> NO");

                                                        if(player.askPlayerIntInput(2)==1){
                                                            if(potion instanceof HealingPotion healingP){
                                                                healingP.use(player);
                                                            }else if(potion instanceof ManaPotion manaP){
                                                                manaP.use(player);
                                                            }else if(potion instanceof TeleportPotion tpP){
                                                                tpP.tepelortToSafety(player);
                                                            }
                                                        }
                                                        player.getInventory().remove(choice-1);
                                                    }
                                                    case ARMOR,WEAPON -> {
                                                        System.out.printf("<What Do you want to do with the %S>",itemPlayerWantToUse.getName());
                                                        System.out.println("(1)-> Equip" +
                                                                "(2)-> Nvermind");
                                                        if(player.askPlayerIntInput(2)==1){
                                                            player.equipItem(itemPlayerWantToUse);
                                                        }

                                                    }
                                                    case JUNK -> {
                                                        System.out.println("<You can't do anything with this>");
                                                    }
                                                }

                                            }
                                        }else {

                                            if(choice == player.getInventory().size()+1){
                                                System.out.printf("<Do you want to unequip: %S>",player.getEquipedArmor().getName());
                                                System.out.println("\n(1)-> YES" +
                                                        "\n(2)-> NO");
                                                if(player.askPlayerIntInput(2)==1) {
                                                    if(player.getEquipedWeapon().getName().equalsIgnoreCase("Nothing")){
                                                        System.out.println("<You can't do that>");

                                                    }else {
                                                        player.setEquipedArmor(Entity.baseArmor);
                                                    }
                                                }
                                            }else
                                            if(choice == player.getInventory().size()+2){
                                                System.out.printf("<What Do you want to unequip: %S>",player.getEquipedWeapon().getName());
                                                System.out.printf("\n(1)-> YES\n" +
                                                        "(2)-> NO");
                                                if(player.askPlayerIntInput(2)==1) {
                                                    if(player.getEquipedWeapon().getName().equalsIgnoreCase("Nothing")){
                                                        System.out.println("<You can't do that>");
                                                    }else {
                                                        player.setEquipedWeapon(Entity.baseWeapon);
                                                    }
                                                }
                                            }
                                        }

                                    }

                                }

                            }
                            case 2->{
                                printSheet();

                            }
                            case 3->{
                                escape = true;
                            }
                        }

                    }

                }
                case "QUIT","Q" ->{
                    throw new GameClosingExeption();
                }

            }
        }while (
                !decision.equalsIgnoreCase("MOVE")&&
                !decision.equalsIgnoreCase("M")&&
                        !decision.equalsIgnoreCase("TALK")&&
                        !decision.equalsIgnoreCase("T")&&
                        !decision.equalsIgnoreCase("STEAL")&&
                        !decision.equalsIgnoreCase("S")&&
                        !decision.equalsIgnoreCase("FIGHT")&&
                        !decision.equalsIgnoreCase("F")&&
                        !decision.equalsIgnoreCase("QUIT")&&
                        !decision.equalsIgnoreCase("Q")&&
                        !decision.equalsIgnoreCase("CHARACTER MENU")&&
                        !decision.equalsIgnoreCase("C")&&
                        !decision.equalsIgnoreCase("CM"));
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


}

