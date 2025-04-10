package mud;

import mud.characters.Entity;
import mud.characters.fightable.*;
import mud.characters.fightable.Character;
import mud.characters.fightable.monsters.Guard;
import mud.characters.fightable.monsters.Monster;
import mud.characters.fightable.monsters.MonsterMap;
import mud.rooms.MagicMap;

import java.util.List;

import static mud.GameMap.console;
import static mud.characters.fightable.Character.dice;
import static mud.characters.fightable.PlayerCharacter.MAX_RESPAWN;
import static mud.characters.fightable.monsters.Guard.GUARD_POSSIBLE_ROOM;

public class GameUtil {
    public static PlayerCharacter player;

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
        System.out.printf("Welcome %s! ********Messaggio di inizio**********%n", player.getName());
    }

    public static void checkForCombat(Character char2){
        if(player.getStamina() >= char2.getStamina()){
            combat(char2);
        } else {
            System.out.println("You don't have enough stamina to fight this monster! Go train some more.");
        }
    }

    public static void combat(Character char2){
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
                monster.setIsAlive();
            }
        } else {
            if(player != null){
                player.respawn();
            }
        }
    }
//    public static void askForRespawn(){
//        String ans = null;
//        if(player.getRespawnCounter() < MAX_RESPAWN){
//            do{
//                System.out.printf("You have %d possibilities to respawn left. Do you want to respawn? Answer Y or N :",
//                        MAX_RESPAWN- player.getRespawnCounter());
//                ans = console.readLine().toUpperCase();
//                if(ans.equals(Answer.Y.toString())){
//                    player.respawn();
//                } else if(ans.equals(Answer.N.toString())){
//                    System.out.println("Goodbye!");
//                }
//            }while(!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
//
//        }
//        System.out.println("You can't respawn anymore. End of the game. Goodbye!");
//    }

    public static void askIfWantToMove(){
        String ans = null;
        do{
            System.out.println("Do you want to change room? Answer with Y or N: ");
            ans = console.readLine().toUpperCase();
            if(ans.equals(Answer.Y.toString())){
                askForDirections();
            } else if(ans.equals(Answer.N.toString())){
                System.out.printf("You are still at %s%n", player.getActualRoom().getName());
            }

        }while(!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));

    }
    public static void askForDirections(){
        String ans = null;
        do{
            System.out.println("Where do you want to go? Answer with: North, East, South or West: ");
            ans = console.readLine().toUpperCase();
        }while(!ans.equals(CardinalPoints.NORTH.toString()) && !ans.equals(CardinalPoints.EAST.toString()) &&
                ans.equals(CardinalPoints.SOUTH.toString()) && ans.equals(CardinalPoints.WEST.toString()));
        if(ans.equals(CardinalPoints.NORTH.toString())){
            player.changeRoom(CardinalPoints.NORTH);
        } else if(ans.equals(CardinalPoints.EAST.toString())){
            player.changeRoom(CardinalPoints.EAST);
        } else if(ans.equals(CardinalPoints.SOUTH.toString())){
            player.changeRoom(CardinalPoints.SOUTH);
        } else if(ans.equals(CardinalPoints.WEST.toString())){
            player.changeRoom(CardinalPoints.WEST);

        }
    }

    public static void randomizeTheGuards(){
        List<Monster> guards = MonsterMap.getGuards();
        guards.forEach(g -> g.getActualRoom().getPresentEntities().remove(g));
        guards.forEach(g -> g.setActualRoom(MagicMap.getRooms().get(dice.nextInt(GUARD_POSSIBLE_ROOM))));
    }

    public static void checkForMonsters() {
        String ans;
        List<Entity> monsters = player.getActualRoom().getPresentEntities()
                .stream().filter(entity -> entity instanceof Monster).toList();
        if (!monsters.isEmpty()) {
            do {
                System.out.println("Looks like there are some Monsters here! Do you feel like fighting? Answer with Y or N: ");
                ans = console.readLine().toUpperCase();
                if (ans.equals(Answer.Y.toString())) {
                    fightChosenMonster(chooseMonster());
                } else if (ans.equals(Answer.N.toString())) {
                    System.out.println("Rest is important too!");
                }
            } while (!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
        }
    }

    public static String chooseMonster() {
        String ans;
        List<Entity> monsters = player.getActualRoom().getPresentEntities()
                .stream().filter(entity -> entity instanceof Monster).toList();
        List<String> monstersClasses;
        do {
            System.out.println("What kind of monster do you want to fight?");
            System.out.println("These are the types present here: ");
            List<String> allMonstersClasses = monsters.stream().map(entity -> entity.getClass().getSimpleName()).toList();
            monstersClasses = allMonstersClasses.stream().distinct().toList();
            monstersClasses.forEach(System.out::println);
            monstersClasses.forEach(s -> s = s.toUpperCase());
            ans = console.readLine().toUpperCase();
        } while (monstersClasses.contains(ans));
        return ans;
    }

    public static void fightChosenMonster(String monsterClass){
        List<Entity> monsters = player.getActualRoom().getPresentEntities()
                .stream().filter(entity -> entity instanceof Monster).toList();
        if(monsterClass.equals("CAT")){
            Monster cat = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Cat")).findFirst().get();
            checkForCombat(cat);
        } else if(monsterClass.equals("GOBLIN")){
            Monster goblin = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Goblin")).findFirst().get();
            checkForCombat(goblin);
        } else if(monsterClass.equals("GHOST")){
            Monster ghost = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Ghost")).findFirst().get();
            checkForCombat(ghost);
        } else if(monsterClass.equals("DRAGON")){
            Monster dragon = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Dragon")).findFirst().get();
            checkForCombat(dragon);
        } else if(monsterClass.equals("GUARD")){
            Monster guard = (Monster)monsters.stream().filter(m -> m.getClass().getSimpleName().equals("Guard")).findFirst().get();
            checkForCombat(guard);
        }
    }

}


