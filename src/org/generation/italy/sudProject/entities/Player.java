package org.generation.italy.sudProject.entities;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.Spawner;
import org.generation.italy.sudProject.itemManagement.Equipment;
import org.generation.italy.sudProject.itemManagement.Inventory;
import org.generation.italy.sudProject.items.Item;
import org.generation.italy.sudProject.items.itemTypes.Food;
import org.generation.italy.sudProject.items.itemTypes.Weapon;
import org.generation.italy.sudProject.map.Room;
import org.generation.italy.sudProject.map.WorldMap;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static org.generation.italy.sudProject.map.Room.*;
import static org.generation.italy.sudProject.map.WorldMap.world;

public class Player extends Entity{
    // /--ATTRIBUTES--/
    private static final int HP_FIRST_SPAWN = 3;
    private static final int HP_MAX_FIRST_SPAWN = 10;
    private static final int STARTING_MONEY = 0;
    private static final int STARTING_XP = 0;
    public static final int STARTING_MAX_XP = 200;

    public static int numberOfPlayers;
    private static Room playerPosition = world.getFirst();

    private String firstName;
    private String lastName;
    private HashMap<String, String> credentials = new HashMap<>();
    private String playerName;
    private LocalDate creationDate = LocalDate.now();
    private int playerLevel = 1;
    private int xp = STARTING_XP;
    private int maxXp = STARTING_MAX_XP;
    Equipment playerEquipment = new Equipment();


    // /--CONSTRUCTORS--/
    public Player(String firstName, String lastName, String email, String password, String playerName, int indexClassStat, int classStat){
        super(playerName, MIN_ATTRIBUTE_P_VALUE, MAX_ATTRIBUTE_P_VALUE, indexClassStat, classStat, HP_FIRST_SPAWN, HP_MAX_FIRST_SPAWN,
                2, playerPosition, -1, true, 10, STARTING_MONEY, STARTING_XP);
        this.firstName = firstName;
        this.lastName = lastName;
        credentials.put(email, password);
        this.playerName = playerName;
        numberOfPlayers++;
    }
    // /--METHODS--/

    //NORD 0, SUD 1, EST 2, OVEST 3
    private void playerMove() {
        System.out.println("Luogo attuale: ");
        playerPosition.printMapOutput();
        System.out.println("Dove vuoi andare? : (NORD) (SOUTH) (EAST) (WEST)");
        String direction = console.readLine();
        switch (direction.toUpperCase().trim()) {
            case "NORD":
                if (playerPosition.getNorthRoom() != null) {
                    playerPosition = playerPosition.getNorthRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                    playerPosition.printMapOutput();
                }
                break;
            case "SOUTH":
                if (playerPosition.getSouthRoom() != null) {
                    playerPosition = playerPosition.getSouthRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                    playerPosition.printMapOutput();
                }
                break;
            case "EAST":
                if (playerPosition.getEastRoom() != null) {
                    playerPosition = playerPosition.getEastRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                    playerPosition.printMapOutput();
                }
                break;
            case "WEST":
                if (playerPosition.getWestRoom() != null) {
                    playerPosition = playerPosition.getWestRoom();
                    Spawner.resetGuardsInRoom(playerPosition);
                    playerPosition.printMapOutput();
                }
                break;
            default:
                System.out.println("INSERISCI LA DIREZIONE!");
                break;
        }
        System.out.println("Luogo attuale: "+playerPosition.getRoomName());
        System.out.println(playerPosition.getRoomDescription());
        playerPosition.showEntitiesInRoom();
    }
    @Override
    public void attack(Entity target) {
        if(target.getIndexEntityPosition() == CAT_INDEX) {
            if (playerPosition.getRoomEntities().get(GUARD_INDEX) != null) {
                target.setHp(target.getHp() - this.getAtk() + this.getAtkBonusFromStat());
            } else {
                System.out.println("Ci sono guardie nei dintorni, non puoi attaccare");
            }
        } else {
            if (target.isCanBeAttacked()) {
                target.setHp(target.getHp() - this.getAtk());
            }
        }
        if(isDead(target)){
            xpUp(target.getXp());
            this.earnMoney(target.getMoney());
            target.die();
        }
    }
    private void eat(Food food){
        regenerateHp(food.getHpValue());
    }
    private void buy(Npc seller){
        seller.getEntityInventory().showItemsInInventory();
        System.out.println("SELECT ITEM TO BUY:");
        String input = console.readLine();
        if(seller.getEntityInventory().getItemFromInventory(input) != null
                && seller.getEntityInventory().getItemFromInventory(input).getValue() < this.money){
            Item i = seller.getEntityInventory().getItemFromInventory(input);
            this.entityInventory.addItemToInventory(i);
            this.pay(i.getValue());
            seller.earnMoney(i.getValue());
        }else{
            System.out.println("Non puoi comprare quest'oggetto");
        }
    }
    private void pickFromCorpse(Room room){
        room.showCorpses();
        System.out.println("SELECT CORPSE: ");
        String input = console.readLine();
        int result = room.getCorpseIndex(input);
        if(result != -1){
            //se ha trovato il cadavere
            Object obj = room.getRoomEntities().get(CORPSE_INDEX).get(result);
            Entity corpse = (Entity)obj;
            corpse.getEntityInventory().showItemsInInventory();
            addFromInventoryToInventory(corpse.getEntityInventory());
        }else{
            System.out.println("Nessun entità cadavere ha questo nome");
        }
    }
    private void pickEnvironmentItems(Room room){
        room.getRoomObjects().showItemsInInventory();
        addFromInventoryToInventory(room.getRoomObjects());
    }
    private void addFromInventoryToInventory(Inventory inventory){
        Item i = selectItemFromInventory(inventory);
        if(i != null){
            this.entityInventory.addItemToInventory(i);
            inventory.deleteItemFromInventory(i.getItemName());
        }else{
            System.out.println("Non è presente alcun item con questo nome");
        }
    }

    private void xpUp(int amount){
        xp += amount;
    }
    public boolean xpOverCap(){
        return xp >= maxXp;
    }
    public void rest(){
        String roomName = getPlayerPosition().getRoomName();
        if(roomName.toUpperCase().equals("TEMPLE")){
            regenerateHp(this.getMaxHp());
            System.out.println("Ti senti di nuovo in forze");
            Spawner.respawnEntities();
        }else{
            System.out.println("Non puoi riposare qui");
        }
    }
    private void equip(){
        this.entityInventory.showItemsInInventory();
        Item i = selectItemFromInventory(this.entityInventory);
        if(i != null){
            System.out.println("Scegli dove equipaggiare l'item: ");
            playerEquipment.showEquip();
            String input = console.readLine().toUpperCase().trim();
            switch(input){
                case "LEFTHAND":
                    if(i instanceof Weapon && playerEquipment.getLeftHand() != null){
                        playerEquipment.setLeftHand(i);
                    }else{
                        System.out.println("Impossibile equipaggiare");
                    }
                    break;
                case "RIGHTHAND":
                    if(i instanceof Weapon && playerEquipment.getRightHand() != null){
                        playerEquipment.setRightHand(i);
                    }else{
                        System.out.println("Impossibile equipaggiare");
                    }
                    break;
                default:
                    System.out.println("Non puoi equipaggiarlo qui");
                    break;
            }
        }else{
            System.out.println("Non è presente alcun item con questo nome");
        }
    }
    private void removeFromEquipment(){
        System.out.println("Seleziona la parte dell'equipaggiamento da togliere: ");
        playerEquipment.showEquip();
        String input = console.readLine().toUpperCase().trim();
        switch(input){
            case "HEAD":
                if(playerEquipment.getHead() != null){
                    this.entityInventory.addItemToInventory(playerEquipment.getHead());
                    playerEquipment.setHead(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in HEAD");
                }
                break;
            case "BODY":
                if(playerEquipment.getBody() != null){
                    this.entityInventory.addItemToInventory(playerEquipment.getBody());
                    playerEquipment.setBody(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in BODY");
                }
                break;
            case "ARMS":
                if(playerEquipment.getArms() != null){
                    this.entityInventory.addItemToInventory(playerEquipment.getArms());
                    playerEquipment.setArms(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in ARMS");
                }
                break;
            case "LEGS":
                if(playerEquipment.getLegs() != null){
                    this.entityInventory.addItemToInventory(playerEquipment.getLegs());
                    playerEquipment.setLegs(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in HEAD");
                }
                break;
            case "LEFTHAND":
                if(playerEquipment.getLeftHand() != null){
                    this.entityInventory.addItemToInventory(playerEquipment.getLeftHand());
                    playerEquipment.setLeftHand(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in LEFT HAND");
                }
                break;
            case "RIGHTHAND":
                if(playerEquipment.getRightHand() != null){
                    this.entityInventory.addItemToInventory(playerEquipment.getRightHand());
                    playerEquipment.setRightHand(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in RIGHT HAND");
                }
                break;
            default:
                System.out.println("Non hai selezionato alcuna parte");
                break;
        }
    }

    private Item selectItemFromInventory(Inventory inventory){
        System.out.println("Seleziona l'oggetto da aggiungere: ");
        String input = console.readLine();
        Item i = inventory.getItemFromInventory(input);
        return i;
    }

    // /--GETTER-&-SETTER--/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HashMap getCredentials() {
        return credentials;
    }

    public void setCredentials(HashMap<String, String> credentials) {
        this.credentials = credentials;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public Room getPlayerPosition() {
        return playerPosition;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public void setMaxXp(int maxXp) {
        this.maxXp = maxXp;
    }

    public static void setPlayerPosition(Room playerPosition) {
        Player.playerPosition = playerPosition;
    }
}
