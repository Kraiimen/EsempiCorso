package org.generation.italy.capstonProject.mudGame.entity.player;

import org.generation.italy.capstonProject.mudGame.entity.Entity;
import org.generation.italy.capstonProject.mudGame.entity.GameMenuUtils;
import org.generation.italy.capstonProject.mudGame.entity.Wallet;
import org.generation.italy.capstonProject.mudGame.entity.items.*;
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
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private boolean hasKilledKitties;
    private Wallet wallet;
    protected Console console = System.console();
    protected Scanner scanner = new Scanner(System.in);

    public Player(String charName, Room currentRoom, String playerName, PlayerRole role) {
        super(charName, 50, 5, currentRoom);
        this.playerName = playerName;
        experience = 1;
        maxExperience = 20;
        level = 1;
        this.role = role;
        this.setMaxHP(getMaxHP() + stamina);
        this.setMaxDamage(getMaxDamage() + (strength / 5));
        this.wallet = new Wallet(20);
    }

    @Override
    public void attack(Entity target){
        int damage = this.calculateDamage();
        System.out.println("\033[0;32m" + this.getCharName() + " attacks " + target.getCharName() + "\033[0m");
        target.hasTakenDamage(damage);
        target.manageInteraction(this);
    }

    public void gainExperience(int amount){
        experience += (int)(amount + Math.ceil(getTotalIntelligence() * 0.2));
        if(experience >= maxExperience){
            levelUp();
        }
        System.out.println("You gained experience! Your experience is now " + experience + "/" + maxExperience);
    }

    @Override
    public int calculateDamage() {
        int weaponBonusDamage = (equippedWeapon !=null) ? equippedWeapon.getBonusDamage() : 0;
        int baseDamage = rand.nextInt(getMaxDamage() + 1);
        damage = baseDamage + weaponBonusDamage;
        return damage;
    }

    public int getTotalAgility() {
        return agility + (equippedArmor != null ? equippedArmor.getBonusAgility() : 0);
    }

    public int getTotalStamina() {
        return stamina + (equippedArmor != null ? equippedArmor.getBonusStamina() : 0);
    }

    public int getTotalIntelligence() {
        return intelligence + (equippedArmor != null ? equippedArmor.getBonusIntelligence() : 0);
    }

    @Override
    public void manageInteraction(Entity target){}

    public void managePlayerInteraction(Entity target, Scanner scanner) {
        if (isDead()) {
            System.out.println("You died. Thanks for playing!");
            System.exit(0);
        }
        if (target instanceof Npc) {
            if (getIsUnderAttack()) {
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
                            if (canRunFast()) {
                                this.setIsUnderAttack(false);
                                runAway();
                                resolved = true;
                            } else {
                                System.out.println("Run away failed! Try again or choose another option");
                                int inflictedDamage = target.calculateDamage();
                                this.subtractHealthPoints(inflictedDamage);
                                System.out.println("You lost " + inflictedDamage + " HP.");
                            }
                            break;
                        case 3:
                            openInventory();
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                            break;
                    }
                }
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
            vendor.seeShop( this, scanner);
        } else if (entity instanceof Npc npc){
            System.out.println("\033[0;32m" + "Say something: " + "\033[0m");
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
                        System.out.println("\u001B[31m" + guard.getCharName() + " says: Revenge for the cat!" + "\033[0m");
                        guard.attack(this);
                        guard.setIsUnderAttack(true);
                        guard.manageInteraction(this);
                    }
                }
            }
            if(target.isDead()){
                if(target instanceof Cat){
                    hasKilledKitties = true;
                    gainExperience(1);
                }else{
                    gainExperience(3);
                }
                if(target instanceof Npc npc){
                    npc.dropCoins(this);
                }
                setIsUnderAttack(false);
                getCurrentRoom().removeEntityFromRoom(target);

                GameMenuUtils.displayRoomActions(this, scanner);
                break;
            }
        }
        if(getHealthPoints() < (getMaxHP()*0.1)){
            System.out.println("Health is too low to attack");
            String answer;
            boolean wrgAnswer = false;
            do {
                if(wrgAnswer){
                    System.out.println("Invalid answer. Try Again.");
                }
                answer = console.readLine("You can try running away in a random direction [a] or use an item from your inventory [b]");
                if (answer.equals("a")) {
                    if (canRunFast()){
                        System.out.println("\033[0;32m" + "You successfully ran away!");
                        this.setIsUnderAttack(false);
                        target.setIsUnderAttack(false);
                        target.restoreHP();
                        runAway();
                    } else {
                        System.out.println("Run away failed");
                        int inflictedDamage = target.calculateDamage();
                        this.subtractHealthPoints(inflictedDamage);
                        System.out.println("\033[0;32m" + "You lost " + inflictedDamage + " HP." + "\033[0m");
                        if (isDead()) {
                            System.out.println("\033[0;32m" + "You died. Thanks for playing!" + "\033[0m");
                            System.exit(0);
                        } else {
                            System.out.println("You can try again or choose another option");
                        }
                        wrgAnswer = false;
                    }
                } else if (answer.equals("b")) {
                    openInventory();
                    wrgAnswer = false;
                } else {
                    wrgAnswer = true;
                }
            } while (!canRunFast() || !answer.equals("b"));
        }
    }

    public boolean canRunFast(){
        int n = rand.nextInt(50);
        return n < getTotalAgility();
    }

    public void runAway(){
        int n = rand.nextInt(getCurrentRoom().getAllowedDirections().size());
        Direction randomDir = getCurrentRoom().getAllowedDirections().get(n);
        System.out.println("You runa in a random available direction.");
        move(randomDir);
    }

    public void openInventory(){
        GameMenuUtils.displayInventoryMenu(this, scanner);
    }

    public void useItem(Item item){
        if(inventory.hasItem(item)) {
            inventory.removeItem(item);
        } else {
            getCurrentRoom().removeItemFromRoom(item);
        }
        if(item instanceof Consumable consumable){
            consumable.consume(this);
        }
        if(item instanceof Equipable equipment){
            this.equip(equipment);
        }
    }

    public void sleep(){
        this.heal(0.2);
        System.out.println("Rest is important for your health! You slept and now have " + getHealthPoints() + "/" + getMaxHP());
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
            setMaxDamage(getMaxDamage() + 5);
            if(getIntelligence() < getMAX_INTELLIGENCE()) {
                setIntelligence(getIntelligence() + 2);
                if(getIntelligence() > getMAX_INTELLIGENCE()) {
                    setIntelligence(getMAX_INTELLIGENCE());
                }
            }
            if(getAgility() < getMAX_AGILITY()) {
                setAgility(getAgility() + 2);
                if(getAgility() > getMAX_AGILITY()) {
                    setAgility(getMAX_AGILITY());
                }
            }
            if(getStamina() < getMAX_STAMINA()) {
                setStamina(getStamina() + 2);
                if(getStamina() > getMAX_STAMINA()) {
                    setStamina(getMAX_STAMINA());
                }
            }
            if(getStrength() < getMAX_STRENGTH()) {
                setStrength(getStrength() + 2);
                if(getStrength() > getMAX_STRENGTH()) {
                    setStrength(getMAX_STRENGTH());
                }
            }
            System.out.println("Level up! You are now level " + level);
        }
        this.printStats();
    }

    public void pickUpItem(Item item){
        inventory.addItem(item);
        System.out.println(item.getName() + " has been added to your inventory.");
        getCurrentRoom().removeItemFromRoom(item);
        if(item.getName().equals("The One Ring")){
            System.out.println("That's it. You found the One Ring and now peace can be restored. Congratulation, you won the game!");
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }

    public void petCat(Cat cat){
        System.out.println("You are petting " + cat.getCharName());
        cat.showGratitude();
    }

    public void setEquippedWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
        System.out.println("You equipped " + equippedWeapon.getName());
        System.out.println("+ " + equippedWeapon.getBonusDamage() + "damage points.");
    }

    public void removeEquippedWeapon(){
        if(equippedWeapon != null){
            if(inventory.getMaxQuantity() < inventory.currentInventoryTotal()){
                System.out.println("This weapon will be moved to your inventory.");
                inventory.addItem(equippedWeapon);
            } else {
                System.out.println("Your inventory is full. This Weapon will be dropped.");
                getCurrentRoom().addItemToRoom(equippedWeapon);
            }
            System.out.println("You unequipped " + equippedWeapon.getName());
            equippedWeapon = null;
        } else {
            System.out.println("You don't have a weapon equipped.");
        }
    }

    public void unequipWeapon() {
        removeEquippedWeapon();
    }

    public void setEquippedArmor(Armor armor){
        this.equippedArmor = armor;
        System.out.println("You equipped " + equippedArmor.getName());
//        System.out.println("+ " + equippedArmor.getBonusDefence() + "damage points.");
    }

    public void removeEquippedArmor(){
        if(equippedArmor != null){
            if(!inventory.isFull()){
                System.out.println("This armor will be moved to your inventory.");
                inventory.addItem(equippedArmor);
            } else {
                System.out.println("Your inventory is full. This armor will be dropped.");
                getCurrentRoom().addItemToRoom(equippedArmor);
            }
            System.out.println("You unequipped " + equippedArmor.getName());
            equippedArmor = null;
        } else {
            System.out.println("You don't have a armor equipped.");
        }
    }

    public void unequipArmor() {
        removeEquippedArmor();
    }

    public void equip(Equipable equipment){
        if(equipment instanceof Weapon weapon){
            if(equippedWeapon != null && !inventory.isFull()){
                inventory.addItem(equippedWeapon);
            } else if (equippedWeapon != null && inventory.isFull()){
                System.out.println("Your inventory is full. Your old weapon will be dropped.");
                getCurrentRoom().addItemToRoom(equippedWeapon);
            }
            setEquippedWeapon(weapon);
        } else if (equipment instanceof Armor armor) {
            if(equippedArmor != null && !inventory.isFull()){
                inventory.addItem(equippedArmor);
            } else if (equippedArmor != null && inventory.isFull()){
                System.out.println("Your inventory is full. Your old armor will be dropped.");
                getCurrentRoom().addItemToRoom(equippedArmor);
            }
            setEquippedArmor(armor);
        }
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void pay(int amount){
        try {
            wallet.takeCoins(amount);
            System.out.println("-" + amount + " coins. You now have " + wallet.getBalance() + " coins left." );
        } catch (ArithmeticException e){
            System.out.println("Balance is too low." + e.getMessage());
        }
    }

    public void printStats(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Player{" +
                "\n   charName: '" + getCharName() + '\'' +
                ", \n   playerName: '" + playerName +
                ", \n   healthPoints: " + getHealthPoints() + "/" + getMaxHP() +
                ", \n   maxDamage: " + getMaxDamage() +
                ", \n   level: " + level +
                ", \n   experience: " + experience + "/" + maxExperience +
                ", \n   intelligence: " + intelligence +
                ", \n   strength: " + strength +
                ", \n   agility: " + agility +
                ", \n   stamina: " + stamina +
                ", \n   hasKilledKitties: " + hasKilledKitties +
                (equippedWeapon != null ? ", \n     equipped Weapon: " + equippedWeapon : "") +
                (equippedArmor != null ? ", \n      equipped Armor: " + equippedArmor : "") +
                ", \n   wallet: " + wallet.getBalance() + " coins" + inventory + '\'' +
                "\n}";
    }

    public int getMaxExperience() {
        return maxExperience;
    }

    public PlayerRole getRole() {
        return role;
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

    public void setExperience(int experience) {
        this.experience = experience;
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

    public Wallet getWallet() {
        return wallet;
    }
}
