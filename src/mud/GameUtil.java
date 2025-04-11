package mud;

import mud.characters.Entity;
import mud.characters.fightable.*;
import mud.characters.fightable.Character;
import mud.characters.fightable.monsters.Guard;
import mud.characters.fightable.monsters.Monster;
import mud.characters.fightable.monsters.MonsterMap;
import mud.items.Weapon;
import mud.rooms.MagicMap;

import java.util.ArrayList;
import java.util.List;

import static mud.GameMap.console;
import static mud.characters.fightable.Character.dice;
import static mud.characters.fightable.PlayerCharacter.MAX_RESPAWN;
import static mud.characters.fightable.monsters.Guard.GUARD_POSSIBLE_ROOM;

public class GameUtil {
    public static PlayerCharacter player;
    public static List<String> choices = new ArrayList<>();
    public static List<String> directions = new ArrayList<>();
    static{
        choices.add("FIGHT");
        choices.add("MOVE");
        choices.add("PICK");
        choices.add("TALK");
        choices.add("Q");
        directions.add("NORTH");
        directions.add("WEST");
        directions.add("SOUTH");
        directions.add("EAST");
    }

    public static void createNewPlayer(){
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
        player.printStats();
        System.out.printf("Welcome %s! ********Messaggio di inizio**********%n", player.getName());
        //nel messaggio di inizio devo dire di andare al tempio a parlare con Elrond, che gli dirà di trovare l'anello,
        //elrond gli dirà di non uccidere gatti se ci sono guardie presenti.
    }

    //METODO PER CHIEDERE AL GIOCATORE CHE FARE APPENA ENTRA IN UNA STANZA
    //SCEGLI TRA: combattere, parlare con qualcuno e poi scegli chi, cambiare ancora stanza, cerca item, esci dal gioco
    public static void askWhatToDo() throws EndOfGameException {
        String ans;
        System.out.println("What do you want to do now?");
        do{
            System.out.println("Write 'FIGHT' if you want to fight some monsters.");
            System.out.println("Write 'MOVE' if you want to start moving.");
            System.out.println("Write 'PICK' if you want to pick an item.");
            System.out.println("Write 'TALK' if you want to talk to someone.");
            System.out.println("Write 'Q' if you want to end the game.");
            ans = console.readLine().toUpperCase().trim();
        }while(!choices.contains(ans));
        if(ans.equals("FIGHT")){
            checkForMonsters();
        } else if (ans.equals("MOVE")){
            askForDirections();
        } else if (ans.equals("PICK")){
            //mancano i metodi per gli oggetti e gli oggetti nelle stanze!
        } else if (ans.equals("TALK")){
            askWhoToTalk();
        } else {
            System.out.println("Thanks for playing. Goodbye!");
            throw new EndOfGameException("");
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
        List<Entity> monsters = player.getActualRoom().getPresentEntities().values()
                .stream().filter(entity -> entity instanceof Monster).toList();
        if (!monsters.isEmpty()) {
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

    //METODO PER FAR SPOSTARE LE GUARDIE ALLA FINE DI OGNI CICLO
    public static void randomizeTheGuards(){
        List<Monster> guards = MonsterMap.getGuards();
        guards.forEach(g -> g.getActualRoom().getPresentEntities().remove(g));
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
        }
    }

    //METODI UTIL
    public static String toTitleCase(String s){
        char first = s.charAt(0);
        char firstUpper = java.lang.Character.toUpperCase(first);
        String subString = s.substring(1);
        return firstUpper + subString;
    }

    //TODO IMPLEMENTARE METODI PER GLI ITEM (magari direttamente in entity?)
    //TODO AGGIUNGERE ELROND CHE TI DA LA MISSIONE
    //TODO FAR FINIRE IL GIOCO APPENA HAI L'ANELLO
    //TODO AGGIUNGERE I SOLDI PER COMPRARE LE COSE


}


