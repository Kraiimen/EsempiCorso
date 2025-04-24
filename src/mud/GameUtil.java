package mud;

import mud.characters.fightable.*;
import mud.characters.fightable.Character;
import mud.characters.fightable.monsters.Guard;
import mud.characters.fightable.monsters.Monster;
import mud.characters.fightable.monsters.MonsterMap;
import mud.items.Map;
import mud.items.Tree;
import mud.rooms.MagicMap;

import java.io.Console;
import java.util.*;

import static mud.GameMap.console;
import static mud.characters.fightable.Character.dice;
import static mud.characters.fightable.monsters.Guard.GUARD_POSSIBLE_ROOM;

public class GameUtil {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\033[0;33m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static PlayerCharacter player;
    public static List<String> choices = new ArrayList<>();
    public static List<String> directions = new ArrayList<>();
    static{
        choices.add("FIGHT");
        choices.add("MOVE");
        choices.add("PICK");
        choices.add("TALK");
        choices.add("STATS");
        choices.add("INVENTORY");
        choices.add("F");
        choices.add("M");
        choices.add("P");
        choices.add("T");
        choices.add("S");
        choices.add("I");
        choices.add("Q");
        directions.add("NORTH");
        directions.add("WEST");
        directions.add("SOUTH");
        directions.add("EAST");
    }

    public static void createNewPlayer() throws EndOfGameException {
        String answer = null;
        do{System.out.printf(PURPLE + "Hello! What kind of creature do you want to be?%n");
            System.out.printf("Choose between: Wizard, Thief, Paladin or Priest: %n");
            answer = console.readLine().toUpperCase().trim();
        } while (!answer.equals("WIZARD") && !answer.equals("PALADIN")  && !answer.equals("PRIEST")  && !answer.equals("THIEF"));
        System.out.printf("What's your name, hero?%n" + RESET);
        String answerName = console.readLine().trim();
        //chiediamo il nome
        if(answer.equals("WIZARD")){
            player = new Wizard(answerName);
        } else if (answer.equals("PALADIN")) {
            player = new Paladin(answerName);
        } else if (answer.equals("PRIEST")) {
            player = new Priest(answerName);
        } else {
            player = new Thief(answerName);
        }
        delay(800);
        System.out.printf("Initializing %s the %s...%n", player.getName(), player.getClass().getSimpleName());
        delay(800);
        player.printStats();
        delay(1000);
        System.out.println("PRESS ENTER TO CONTINUE READING.");
        delay(800);
        System.out.printf(BLUE + "Welcome %s!", player.getName());
        continueTheMessage();
        System.out.print("This city has been waiting for and adventurer like you to come to the rescue.");
        continueTheMessage();
        System.out.print("Strange monsters and ghosts coming from the dark woods have been creeping around the city entrance in the last days and the civilians are well preoccupied." );
        continueTheMessage();
        System.out.printf("Will you be the hero that's going to stop this menace?%n" +
                "If you think so, find the sacred Temple and talk to the wise Elf Elrond, he will show you the way to braveness%n" + RESET);
        continueTheMessage();
        System.out.println("You are now at the Temple Square.");
        player.getActualRoom().printEntities();
        System.out.println("Follow the MENU instructions to interact with this magic world, good luck!");
        askWhatToDo();
    }

    //METODO PER CHIEDERE AL GIOCATORE CHE FARE APPENA ENTRA IN UNA STANZA
    public static void askWhatToDo() throws EndOfGameException {
        String ans;
        System.out.printf(PURPLE + "What do you want to do now?%n" + RESET);
        do{
            System.out.println("Write 'FIGHT' or 'F' if you want to fight some monsters.");
            System.out.println("Write 'MOVE' or 'M' if you want to start moving.");
            System.out.println("Write 'PICK' or 'P' if you want to pick an item.");
            System.out.println("Write 'TALK' or 'T' if you want to talk to someone.");
            System.out.println("Write 'STATS' or 'S' to see you statistics");
            System.out.println("Write 'INVENTORY' or 'I' to see your inventory");
            System.out.printf("Write 'Q' if you want to end the game.%n");
            ans = console.readLine().toUpperCase().trim();
        }while(!choices.contains(ans));
        doAsAsked(ans);
    }

    public static void askWhatToDoWithoutMenu() throws EndOfGameException {
        String ans;
        System.out.printf(PURPLE + "What do you want to do now?%n" + RESET);
        do {
            System.out.println("Write what you want to do or write MENU to see the menu again.");
            ans = console.readLine().toUpperCase().trim();
        } while (!choices.contains(ans) && !ans.equals("MENU"));
        doAsAsked(ans);
    }

    public static void doAsAsked(String ans) throws EndOfGameException {
        if(ans.equals("FIGHT") || ans.equals("F")){
            checkForMonsters();
        } else if (ans.equals("MOVE") || ans.equals("M")){
            askForDirections();
        } else if (ans.equals("PICK") || ans.equals("P")){
            player.getActualRoom().printItems();
            pickChosenItem();
        } else if (ans.equals("TALK") || ans.equals("T")){
            askWhoToTalk();
        } else if (ans.equals("STATS") || ans.equals("S")){
            player.printStats();
        } else if (ans.equals("INVENTORY") || ans.equals("I")){
            player.printInventory();
            player.useItemInInventory();
        } else if (ans.equals("Q")){
            System.out.println("Thanks for playing. Goodbye!");
            throw new EndOfGameException("");
        } else {
            askWhatToDo();
        }

    }


    //METODI PER COMBATTERE


    public static void checkForMonsters() throws EndOfGameException {
        String ans;
        List<String> presentClasses = player.getActualRoom().getPresentMonsters().stream()
                .map(monster -> monster.getClass().getSimpleName()).distinct().toList();
        if (!player.getActualRoom().getPresentMonsters().isEmpty()) {
            do {
                System.out.println("These are the type of monsters present here: ");
                presentClasses.forEach(System.out::println);
                System.out.printf(PURPLE + "Are you ready to fight? Answer with Y or N: %n" + RESET);
                ans = console.readLine().toUpperCase();
            } while (!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
            if (ans.equals(Answer.Y.toString())) {
                fightChosenMonster(chooseMonster());
            } else if (ans.equals(Answer.N.toString())) {
                System.out.println("Rest is important too!");
                delay(400);
            }
        } else{
            System.out.println("There are no monsters to fight here!");
            delay(400);
        }
    }

    public static String chooseMonster() {
        String ans;
        List<String> presentClasses = player.getActualRoom().getPresentMonsters().stream()
                .map(monster -> monster.getClass().getSimpleName()).distinct().toList();
        do {
            System.out.printf(PURPLE + "What kind of monster do you want to fight?%n" + RESET);

            ans = toTitleCase(console.readLine());
        } while (!presentClasses.contains(ans));
        return ans;
    }

    public static void fightChosenMonster(String monsterClass) throws EndOfGameException {
        List<Monster> guardsPresent = player.getActualRoom().getPresentMonsters()
                .stream().filter(monster -> monster instanceof Guard).toList();
        List<Monster> monstersToFight = player.getActualRoom().getPresentMonsters().stream().
                filter(monster -> monster.getClass().getSimpleName().equals(monsterClass)).toList();
        checkForCombat(monstersToFight.getFirst());
        if (monsterClass.equals("Cat") && !guardsPresent.isEmpty()) {
            Guard guard = (Guard) guardsPresent.getFirst();
            guard.killForTheCat();
            player.askForRespawn();
        }
    }
//          PRIMA VERSIONE DI QUESTO METODO:
//        if(monsterClass.equals("CAT")){
//            Monster cat = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Cat")).findFirst().get();
//            checkForCombat(cat);
//            if(!guardsPresent.isEmpty()){
//                Guard guard = (Guard)guardsPresent.getFirst();
//                guard.killForTheCat();
//                askForRespawn();
//            }
//        } else if(monsterClass.equals("GOBLIN")){
//            Monster goblin = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Goblin")).findFirst().get();
//            checkForCombat(goblin);
//        } else if(monsterClass.equals("GHOST")){
//            Monster ghost = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Ghost")).findFirst().get();
//            checkForCombat(ghost);
//        } else if(monsterClass.equals("DRAGON")){
//            Monster dragon = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Dragon")).findFirst().get();
//            checkForCombat(dragon);
//        } else if(monsterClass.equals("GUARD")){
//            Monster guard = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Guard")).findFirst().get();
//            checkForCombat(guard);
//        }

    public static void checkForCombat(Character char2) throws EndOfGameException {
        if(player.getStamina()>0){
            combat(char2);
        } else {
            System.out.println("You don't have enough stamina to fight this monster! Go rest somewhere quiet...");
            delay(500);
        }
    }

    public static void combat(Character char2) throws EndOfGameException {
        while (player.checkIfAlive() && char2.checkIfAlive()){
            player.attack(char2);
            delay(500);
            if(!char2.checkIfAlive()){
                break;
            }
            char2.attack(player);
            delay(500);
        }
        if(player.checkIfAlive()){
            player.addKillsCounter();
            if(char2 instanceof Monster monster){
                player.addExp(monster.getExpGiven());
                monster.respawn();
                player.setStamina(player.getStamina()-1);
            }
        } else {
            if(player != null){
                player.askForRespawn();
            }
        }
    }

    //METODI PER MUOVERSI

    public static void askIfWantToRest(){
        String ans = null;
        do{
            System.out.println("It's so calm in here, do you want to rest? Answer with Y or N: ");
            ans = console.readLine().toUpperCase();
        }while(!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
        if(ans.equals(Answer.Y.toString())){
            System.out.println("You are falling asleep...");
            delay(1000);
            System.out.println("...dreaming of scary dragons...");
            delay(1000);
            System.out.println("...the deepness of the woods...");
            delay(1000);
            System.out.println("You woke up.");
            delay(1000);
            System.out.printf(YELLOW + "Resting gives + 2 stamina points%n" + RESET);
            player.sleep(2);
        }
    }
    public static void askForDirections(){
        String ans = null;
        do{
                System.out.printf(PURPLE + "Where do you want to go? Answer with: North or N, East or E, South or S or West or W, write Stop if you want to stop here.%n"+ RESET);
                ans = console.readLine().toUpperCase();
            if(ans.equals(CardinalPoints.NORTH.toString()) || ans.equals("N")){
                player.changeRoom(CardinalPoints.NORTH);
            } else if(ans.equals(CardinalPoints.EAST.toString()) || ans.equals("E")){
                player.changeRoom(CardinalPoints.EAST);
            } else if(ans.equals(CardinalPoints.SOUTH.toString()) || ans.equals("S")){
                player.changeRoom(CardinalPoints.SOUTH);
            } else if(ans.equals(CardinalPoints.WEST.toString()) || ans.equals("W")){
                player.changeRoom(CardinalPoints.WEST);
            }
        }while(!ans.equals("STOP"));
    }


    //metodi item

    public static boolean doesWantPick() {
        String ans = null;
        if (!player.getActualRoom().getPresentItems().isEmpty()) {
            do {
                System.out.println("Answer Y or N: ");
                ans = console.readLine().toUpperCase();
            } while (!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
            if (ans.equals(Answer.Y.toString())) {
                return true;
            }
        }
        return false;
    }

    public static void pickChosenItem(){
        Set<String> items = new HashSet<>(player.getActualRoom().getPresentItems().keySet());
        String ans;
        System.out.printf(PURPLE + "Do you want to pick anything?%n" + RESET);
        if(doesWantPick()){
            do{
                System.out.println("What do you want to pick? You can choose a tree to pick its fruits if they have any left.");
                ans = toTitleCase(console.readLine());
            } while (!items.contains(ans));
            if(player.getActualRoom().getPresentItems().get(ans) instanceof Tree tree){
                tree.pickFruit();
            } else{
                player.pickItem((player.getActualRoom().getPresentItems().get(ans)));
                player.getActualRoom().getPresentItems().remove(ans);
            }
        }
    }

    //METODO PER FAR SPOSTARE LE GUARDIE ALLA FINE DI OGNI CICLO
    public static void randomizeTheGuards(){
        List<Monster> guards = MonsterMap.getGuards();
        guards.forEach(g -> g.getActualRoom().getPresentEntities().remove(g.getName()));
        guards.forEach(g -> g.getActualRoom().getPresentMonsters().remove(g));
        guards.forEach(g -> g.setActualRoom(MagicMap.getRooms().get(dice.nextInt(GUARD_POSSIBLE_ROOM))));
    }

    //MESSO DIRETTAMENTE IN BAKER!
//    public static void interactWithTheBaker(){
//        Baker baker = (Baker)NPCMap.getNpcs().getFirst();
//        Set<String> food = new HashSet<>(baker.getInventory().keySet());
//        String ans = null;
//        baker.greet();
//        if(baker.doesWantFood()){
//            do{
//                System.out.println("Choose:");
//                baker.printInventory();
//                ans = toTitleCase(console.readLine());
//            } while (!food.contains(ans));
//            player.eat(baker.getInventory().get(ans));
//        }
//    }

    //METODO PER INTERAGIRE
    public static void askWhoToTalk(){
        String ans = null;
        List<String> names = player.getActualRoom().getPresentEntities().keySet().stream().toList();
        System.out.printf(PURPLE + "Who do you want to talk to? Write their name: %n" + RESET);
        ans = console.readLine();
        if(!(ans.isEmpty())){
            ans = toTitleCase(ans);
        }
        if(names.contains(ans)){
            player.getActualRoom().getPresentEntities().get(ans).greet();
        } else {
            System.out.println("They're not here right now.");
        }


    }

    //METODI UTIL
    public static String toTitleCase(String s){
        char first = s.charAt(0);
        char firstUpper = java.lang.Character.toUpperCase(first);
        String subString = s.substring(1);
        return firstUpper + subString;
    }
    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }
    public static void continueTheMessage(){
        Console console = System.console();
        console.readLine();
    }


    //TODO METODI PER L'INVENTORY
    //metodi item: mangiare le cose del mio stesso inventario
    //EQUIP LE WEAPON, EAT I FOOD E CHECK LA MAPPA

    //TODO FAR FINIRE IL GIOCO APPENA HAI L'ANELLO
    //TODO AGGIUNGERE I SOLDI PER COMPRARE LE COSE???
    //TODO SCRIVERE LE DESCRIZIONI BENE


}


