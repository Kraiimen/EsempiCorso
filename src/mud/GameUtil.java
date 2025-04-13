package mud;

import mud.characters.Entity;
import mud.characters.fightable.*;
import mud.characters.fightable.Character;
import mud.characters.fightable.monsters.Guard;
import mud.characters.fightable.monsters.Monster;
import mud.characters.fightable.monsters.MonsterMap;
import mud.items.Tree;
import mud.items.Weapon;
import mud.rooms.MagicMap;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static mud.GameMap.console;
import static mud.characters.fightable.Character.dice;
import static mud.characters.fightable.PlayerCharacter.MAX_RESPAWN;
import static mud.characters.fightable.monsters.Guard.GUARD_POSSIBLE_ROOM;

public class GameUtil {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
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
        choices.add("Q");
        directions.add("NORTH");
        directions.add("WEST");
        directions.add("SOUTH");
        directions.add("EAST");
    }

    public static void createNewPlayer() throws EndOfGameException {
        String answer = null;
        do{System.out.println("Hello! What kind of creature do you want to be?");
            System.out.println("Choose between: Wizard, Thief, Paladin or Priest: ");
            answer = console.readLine().toUpperCase().trim();
        } while (!answer.equals("WIZARD") && !answer.equals("PALADIN")  && !answer.equals("PRIEST")  && !answer.equals("THIEF"));
        System.out.println("What's your name, hero?");
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
        delay(1000);
        player.printStats();
        delay(1500);
        System.out.println("PRESS ENTER TO CONTINUE READING.");
        delay(800);
        System.out.printf(BLUE + "Welcome %s!%n", player.getName());
        continueTheMessage();
        System.out.println("This city has been waiting for and adventurer like you to come to the rescue.");
        continueTheMessage();
        System.out.println("Strange monsters and ghosts coming from the dark woods have been creeping around the city entrance in the last days and the civilians are well preoccupied." );
        continueTheMessage();
        System.out.printf("Will a hero like you be the answer to stop this menace?%n" +
                "If you think so, find the sacred Temple and talk to the wise Elf Elrond, he will show you the way to braveness%n" + RESET);
        continueTheMessage();
        System.out.println("Follow the MENU instructions to interact with this magic world, good luck!");
        delay(1000);
        askWhatToDo();
    }

    //METODO PER CHIEDERE AL GIOCATORE CHE FARE APPENA ENTRA IN UNA STANZA
    public static void askWhatToDo() throws EndOfGameException {
        String ans;
        System.out.println("What do you want to do now?");
        do{
            System.out.println("Write 'FIGHT' if you want to fight some monsters.");
            System.out.println("Write 'MOVE' if you want to start moving.");
            System.out.println("Write 'PICK' if you want to pick an item.");
            System.out.println("Write 'TALK' if you want to talk to someone.");
            System.out.println("Write 'STATS' to see you statistics");
            System.out.println("Write 'INVENTORY' to see your inventory");
            System.out.println("Write 'Q' if you want to end the game.");
            ans = console.readLine().toUpperCase().trim();
        }while(!choices.contains(ans));
        if(ans.equals("FIGHT")){
            checkForMonsters();
        } else if (ans.equals("MOVE")){
            askForDirections();
        } else if (ans.equals("PICK")){
            player.getActualRoom().printItems();
            pickChosenItem();
        } else if (ans.equals("TALK")){
            askWhoToTalk();
        } else if (ans.equals("STATS")){
            player.printStats();
        } else if (ans.equals("INVENTORY")){
            player.printInventory();
        } else {
            System.out.println("Thanks for playing. Goodbye!");
            throw new EndOfGameException("");
        }
    }

    public static void askWhatToDoWithoutMenu() throws EndOfGameException {
        String ans;
        System.out.println("What do you want to do now?");
        do{
            System.out.println("Write what you want to do or write MENU to see the menu again.");
            ans = console.readLine().toUpperCase().trim();
        }while(!choices.contains(ans) && !ans.equals("MENU"));
        if(ans.equals("FIGHT")){
            checkForMonsters();
        } else if (ans.equals("MOVE")){
            askForDirections();
        } else if (ans.equals("PICK")){
            player.getActualRoom().printItems();
            pickChosenItem();
        } else if (ans.equals("TALK")){
            askWhoToTalk();
        } else if (ans.equals("STATS")){
            player.printStats();
        } else if (ans.equals("INVENTORY")){
            player.printInventory();
        } else if (ans.equals("Q")){
            System.out.println("Thanks for playing. Goodbye!");
            throw new EndOfGameException("");
        } else {
            askWhatToDo();
        }

    }

    //METODI PER COMBATTERE

    public static void askForRespawn() throws EndOfGameException {
        String ans = null;
        if(player.getRespawnCounter() < MAX_RESPAWN){
            do{
                System.out.printf("You have %d possibilities to respawn left. Do you want to respawn? Answer Y or N :%n",
                        MAX_RESPAWN- player.getRespawnCounter());
                ans = console.readLine().toUpperCase();

            }while(!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
            if(ans.equals(Answer.Y.toString())){
                player.respawn();
            } else if(ans.equals(Answer.N.toString())){
                System.out.println("Thanks for playing. Goodbye!");
                throw new EndOfGameException("");
            }
        } else{
            System.out.println("You can't respawn anymore. End of the game. Goodbye!");
            throw new EndOfGameException("");
        }
    }

    public static void checkForMonsters() throws EndOfGameException {
        String ans;
        if (!player.getActualRoom().getPresentMonsters().isEmpty()) {
            do {
                System.out.println("Looks like there are some Monsters here! Are you ready to fight? Answer with Y or N: ");
                ans = console.readLine().toUpperCase();
            } while (!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
            if (ans.equals(Answer.Y.toString())) {
                fightChosenMonster(chooseMonster());
            } else if (ans.equals(Answer.N.toString())) {
                System.out.println("Rest is important too!");
            }
        } else{
            System.out.println("There are no monsters to fight here!");
        }
    }

    public static String chooseMonster() {
        String ans;
        List<String> presentClasses = player.getActualRoom().getPresentMonsters().stream()
                .map(monster -> monster.getClass().getSimpleName()).distinct().toList();
        do {
            System.out.println("What kind of monster do you want to fight?");
            System.out.println("These are the types present here: ");
            presentClasses.forEach(System.out::println);
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
            askForRespawn();
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
        if(player.getStamina() >= char2.getStamina()){
            combat(char2);
        } else {
            System.out.println("You don't have enough stamina to fight this monster! Go train some more.");
        }
    }

    public static void combat(Character char2) throws EndOfGameException {
        while (player.checkIfAlive() && char2.checkIfAlive()){
            player.attack(char2);
            if(!char2.checkIfAlive()){
                break;
            }
            char2.attack(player);
        }
        if(player.checkIfAlive()){
            player.addKillsCounter();
            if(char2 instanceof Monster monster){
                player.addExp(monster.getExpGiven());
                monster.respawn();
            }
        } else {
            if(player != null){
                askForRespawn();
            }
        }
    }

    //METODI PER MUOVERSI

//    public static void askIfWantToMove(){
//        String ans = null;
//        do{
//            System.out.println("Do you want to change room? Answer with Y or N: ");
//            ans = console.readLine().toUpperCase();
//        }while(!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
//        if(ans.equals(Answer.Y.toString())){
//            askForDirections();
//        } else if(ans.equals(Answer.N.toString())){
//            System.out.printf("You are still at %s%n", player.getActualRoom().getName());
//        }
//
//    }
    public static void askForDirections(){
        String ans = null;
        do{
                System.out.println("Where do you want to go? Answer with: North, East, South or West, write Stop if you want to stop here.");
                ans = console.readLine().toUpperCase();
            if(ans.equals(CardinalPoints.NORTH.toString())){
                player.changeRoom(CardinalPoints.NORTH);
            } else if(ans.equals(CardinalPoints.EAST.toString())){
                player.changeRoom(CardinalPoints.EAST);
            } else if(ans.equals(CardinalPoints.SOUTH.toString())){
                player.changeRoom(CardinalPoints.SOUTH);
            } else if(ans.equals(CardinalPoints.WEST.toString())){
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
        System.out.println("Do you want to pick anything?");
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
        List<String> names = player.getActualRoom().getPresentEntities().keySet().stream().toList();
        System.out.println("Who do you want to talk to? Write their name: ");
        String ans = toTitleCase(console.readLine());
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


    //TODO IMPLEMENTARE METODI PER GLI ITEM (magari direttamente in entity?)
    //metodi item: mangiare le cose del mio stesso inventario

    //TODO FAR FINIRE IL GIOCO APPENA HAI L'ANELLO
    //TODO AGGIUNGERE I SOLDI PER COMPRARE LE COSE???
    //TODO SCRIVERE LE DESCRIZIONI BENE


}


