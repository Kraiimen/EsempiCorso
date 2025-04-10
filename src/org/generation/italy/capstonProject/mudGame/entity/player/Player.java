package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.Inventory;
import org.generation.italy.capstonProject.mudGame.entity.items.Item;
import org.generation.italy.capstonProject.mudGame.entity.npc.Cat;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Direction;
import org.generation.italy.capstonProject.mudGame.entity.rooms.Room;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static org.generation.italy.capstonProject.mudGame.entity.Utilities.readIntInputOrExit;

public class Player extends Entity {
    private final int MAX_INTELLIGENCE = 20;
    private final int MAX_STRENGTH = 20;
    private final int MAX_AGILITY = 20;
    private final int MAX_STAMINA = 20;
    private int maxExperience;

    private String playerName;
    private int experience;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;
    private int level;
    protected Console console = System.console();
    private boolean hasKilledKitties;
    protected Scanner scanner = new Scanner(System.in);

    public Player(String charName, int maxHP, int maxDamage, Room currentRoom, String playerName, int intelligence, int strength, int agility, int stamina) {
        super(charName, maxHP, maxDamage, currentRoom);
        this.playerName = playerName;
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
        this.stamina = stamina;
        experience = 1;
        maxExperience = 20;
        level = 1;
        inventory = new Inventory(10);
    }

    @Override
    public void attack(Entity target){
        target.hasTakenDamage(this.getDamage());
        target.manageInteraction(this);
        experience ++;
    }

    @Override
    public void manageInteraction(Entity target) {
        if(getIsUnderAttack()){
            System.out.println(target.getCharName() + " is attacking you.");
            manageAttack(target);
        } else {
            System.out.println("Choose your next action");
            String answer = scanner.nextLine();
        }
    }

    public void manageAttack(Entity target){
        while(getHealthPoints() > (getMaxHP()*0.1) && !target.isDead()){
            attack(target);
            if(target.isDead()){
                if(target instanceof Cat){
                    hasKilledKitties = true;
                }
                setIsUnderAttack(false);
                experience += 3;
                break;
            }
        }
        if(getHealthPoints() < (getMaxHP()*0.1)){
            System.out.println("Health is too low to attack");
            int n = 0;
            String answer;
            do {
                answer = console.readLine("You can try running away(a) or use an item from your inventory(b)");
                if (answer.equals("a")) {
                    n = rand.nextInt(1, 6);
                    if ((n == 4)) {
                        target.setIsUnderAttack(false);
                        target.restoreHP();
                        runAway();
                    } else {
                        System.out.println("run away failed");
                    }
                } else if (answer.equals("b")) {
                    openInventory();
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
        Map<Item, Integer> inventoryCopy = inventory.getAll();

        AtomicInteger index = new AtomicInteger(1);
        List<Item> inventoryItems = new ArrayList<>();

        if(inventoryItems.isEmpty()){
            System.out.println("Your inventory is empty.");
        }

        boolean running = true;

        while(running) {
            System.out.println("\n-------INVENTARIO-------");
            inventoryCopy.forEach((item, quantity) -> {
                System.out.println(index.get() + ") " + item.getName() + " x" + quantity);
                inventoryItems.add(item);
                index.getAndIncrement();
            });

            System.out.println("Choose an item by its index or press 'x' to esc:");

            Integer answer = readIntInputOrExit(scanner, 1, inventoryItems.size(), "x");

            if (answer == null) {
                System.out.println("Closing inventory menu.");
                running = false;
            }
            Item selectedItem = inventoryItems.get(answer);
            boolean selecting = true;

            while (selecting) {
                System.out.println("\nYou selected: " + selectedItem.getName());
                System.out.println("""
                        1. Use Item
                        2. Remove Item
                        3. Go back to Inventory""");
                System.out.print("Choose an option or press 'x' to exit: ");

                Integer action = readIntInputOrExit(scanner, 1, 3, "x");

                if (action == null) {
                    System.out.println("Closing inventory menu.");
                    running = false;
                }

                switch (action) {
                    case 1:
                        useItem(selectedItem);
                        selecting = false;
                        break;
                    case 2:
                        inventory.removeItem(selectedItem);
                        selecting = false;
                        break;
                    case 3:
                        selecting = false;
                        break;
                }
            }
        }
    }

    public void useItem(Item item){
        if(inventory.hasItem(item)){
            item.applyEffect(this);
            inventory.removeItem(item);
        }
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

    public int levelUp(){
        if(experience >= maxExperience){
            level++;
            maxExperience += 20;
        }
        return level;
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

    public int getLevel() {
        return level;
    }

    public boolean isHasKilledKitties() {
        return hasKilledKitties;
    }
}
