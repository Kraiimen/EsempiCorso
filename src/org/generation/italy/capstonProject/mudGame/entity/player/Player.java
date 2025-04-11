package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.GameMenuUtils;
import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.npc.Cat;
import org.generation.italy.capstonProject.mudGame.entity.npc.Guard;
import org.generation.italy.capstonProject.mudGame.entity.npc.Vendor;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Direction;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;
import org.generation.italy.capstonProject.mudGame.entity.npc.Npc;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public abstract class Player extends Entity {
    private static final int MAX_INTELLIGENCE = 20;
    private static final int MAX_STRENGTH = 20;
    private static final int MAX_AGILITY = 20;
    private static final int MAX_STAMINA = 20;
    private int maxExperience;
    private String playerName;
    private int experience;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;
    private int level;
    private PlayerRole role;
    protected Console console = System.console();
    private boolean hasKilledKitties;
    protected Scanner scanner = new Scanner(System.in);

    public Player(String charName, Room currentRoom, String playerName, PlayerRole role) {
        super(charName, 50, 5, currentRoom);
        this.playerName = playerName;
        experience = 1;
        maxExperience = 20;
        level = 1;
        this.role = role;
        this.setMaxHP(getMaxHP() + getStamina());
        this.setMaxDamage(getMaxDamage() + (getStrength() / 5));
    }

    @Override
    public void attack(Entity target){
        int damage = this.calculateDamage();
        System.out.println(this.getCharName() + " attacks " + target.getCharName());
        target.hasTakenDamage(damage);
        target.manageInteraction(this);
        experience++;
    }

    public void gainExperience(int amount){
        experience += (int)(amount + Math.ceil(getIntelligence() * 0.2));
        if(experience >= maxExperience){
            levelUp();
        }
    }

    @Override
    public void manageInteraction(Entity target){}

    public void managePlayerInteraction(Entity target, Scanner scanner) {
        if (target instanceof Npc) {
            if (getIsUnderAttack()) {
                System.out.println(target.getCharName() + " is attacking you!");

                boolean resolved = false;
                while(!resolved){
                    System.out.println("What do you want to do?");

                    List<String> options = List.of("Fight back", "Run away", "Use item from your inventory");
                    Integer action = GameMenuUtils.showAndChooseMenu(options, scanner);

                    switch (action) {
                        case 1:
                            manageAttack(target);
                            resolved = true;
                            break;
                        case 2:
                            this.setIsUnderAttack(false);
                            runAway();
                            resolved = true;
                            break;
                        case 3:
                            openInventory();
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                            break;
                    }
                }
                manageAttack(target);
            } else {
                boolean resolved = false;
                while(!resolved) {
                    System.out.println("Choose your next action");
                    List<String> options = List.of("Interact", "Attack");
                    Integer action = GameMenuUtils.showAndChooseMenu(options, scanner, "x");
                    if(action == null){
                        GameMenuUtils.displayRoomActions(this, scanner);
                        resolved = true;
                    }
                    switch (action) {
                        case 1:
                            speakWith(target, scanner);
                            resolved = true;
                            break;
                        case 2:
                            manageAttack(target);
                            resolved = true;
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                            break;
                    }
                }
            }
        }
    }

    public void speakWith(Entity entity, Scanner scanner){
        if (entity instanceof Cat cat){
            cat.manageInteraction(this);
            petCat(cat);
        } else if (entity instanceof Vendor vendor){
            vendor.manageInteraction(this);
            vendor.seeShop();
        } else if (entity instanceof Npc npc){
            System.out.println("Say something: ");
            String input = scanner.nextLine();
            npc.manageInteraction(this);
        } else {
            System.out.println("Nothing interesting happens.");
        }
        GameMenuUtils.displayRoomActions(this, scanner);
    }

    public void manageAttack(Entity target){
        while(getHealthPoints() > (getMaxHP()*0.1) && !target.isDead()){
            attack(target);
            if(target instanceof Cat){
                for(Entity entity : getCurrentRoom().getEntities()){
                    if(entity instanceof Guard guard){
                        System.out.println("A guard saw you attacking a cat!");
                        System.out.println(guard.getCharName() + " says: Revenge for the cat!");
                        guard.attack(this);
                        guard.setIsUnderAttack(true);
                        guard.manageInteraction(this);
                    }
                }
            }
            if(target.isDead()){
                if(target instanceof Cat){
                    hasKilledKitties = true;
                }
                setIsUnderAttack(false);
                getCurrentRoom().removeEntityFromRoom(target);
                gainExperience(3);
                GameMenuUtils.displayRoomActions(this, scanner);
                break;
            }
        }
        if(getHealthPoints() < (getMaxHP()*0.1)){
            System.out.println("Health is too low to attack");
            int n = 0;
            String answer;
            boolean wrgAnswer = false;
            do {
                if(wrgAnswer){
                    System.out.println("Invalid answer. Try Again.");
                }
                answer = console.readLine("You can try running away in a random direction [a] or use an item from your inventory [b]");
                if (answer.equals("a")) {
                    n = rand.nextInt(50);
                    if (n < getAgility()){
                        this.setIsUnderAttack(false);
                        target.setIsUnderAttack(false);
                        target.restoreHP();
                        runAway();
                        System.out.println("You successfully ran away!");
                    } else {
                        System.out.println("Run away failed");
                    }
                } else if (answer.equals("b")) {
                    openInventory();
                } else {
                    wrgAnswer = true;
                }
            } while (n != 4 || !answer.equals("b"));
        }
    }

    public void runAway(){
        int n = rand.nextInt(getCurrentRoom().getAllowedDirections().size());
        Direction randomDir = getCurrentRoom().getAllowedDirections().get(n);
        move(randomDir);
    }

    public void openInventory(){
        GameMenuUtils.displayInventoryMenu(this, scanner);
    }

    public void useItem(Item item){
        if(inventory.hasItem(item)){
            item.applyEffect(this);
            inventory.removeItem(item);
        }
    }

    public void handleMovement(){
        GameMenuUtils.displayMovementOptions(this, scanner);
    }

    public void move(Direction direction){
        if(this.getCurrentRoom().getAllowedDirections().contains(direction)){
            Room nextRoom = getCurrentRoom().getNextRooms().get(direction);
            if (nextRoom != null) {
                if(getIsUnderAttack()){
                    setIsUnderAttack(false);
                }
                setCurrentRoom(nextRoom);
                System.out.println("You moved to: " + nextRoom.getName());
                getCurrentRoom().playerHasEntered(this);
            } else {
                System.out.println("There's no room in that direction.");
            }
        } else {
            System.out.println("You can't go in that direction.");

        }
    }

    public void levelUp(){
        if(experience >= maxExperience){
            level++;
            maxExperience += 20;
            System.out.println("Level up! You are now level " + level);
        }
    }

    public void pickUpItem(Item item){
        inventory.addItem(item);
        getCurrentRoom().removeItemFromRoom(item);
    }

    public void petCat(Cat cat){
        cat.showGratitude();
    }

    @Override
    public String toString() {
        return "Player{" +
                "charName: '" + getCharName() + '\'' +
                ", playerName='" + playerName +
                ", healthPoints: " + getHealthPoints() + "/" + getMaxHP() +
                ", maxDamage: " + getMaxDamage() +
                ", level=" + level +
                ", experience=" + experience + "/" + maxExperience +
                ", intelligence=" + intelligence +
                ", strength=" + strength +
                ", agility=" + agility +
                ", stamina=" + stamina +
                ", hasKilledKitties=" + hasKilledKitties +
                ", inventory: " + inventory + '\'' +
                '}';
    }



    public int getMaxExperience() {
        return maxExperience;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getExperience() {
        return experience;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getStamina() {
        return stamina;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getLevel() {
        return level;
    }

    public boolean isHasKilledKitties() {
        return hasKilledKitties;
    }

    public int getMAX_INTELLIGENCE() {
        return MAX_INTELLIGENCE;
    }

    public int getMAX_STRENGTH() {
        return MAX_STRENGTH;
    }

    public int getMAX_AGILITY() {
        return MAX_AGILITY;
    }

    public int getMAX_STAMINA() {
        return MAX_STAMINA;
    }
}
