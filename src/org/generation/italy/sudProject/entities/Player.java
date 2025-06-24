package org.generation.italy.sudProject.entities;

import org.generation.italy.sudProject.Entity;
import org.generation.italy.sudProject.Spawner;
import org.generation.italy.sudProject.itemManagement.Equipment;
import org.generation.italy.sudProject.itemManagement.Inventory;
import org.generation.italy.sudProject.items.Item;
import org.generation.italy.sudProject.items.itemTypes.Food;
import org.generation.italy.sudProject.items.itemTypes.Weapon;
import org.generation.italy.sudProject.map.MapFrame;
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

    private static MapFrame mapFrame;
    public static int numberOfPlayers;
    private static Room playerPosition = world.getFirst();

    private String firstName;
    private String lastName;
    private HashMap<String, String> credentials = new HashMap<>();
    private String playerName;
    private LocalDate creationDate = LocalDate.now();
    private int playerLevel = 1;
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
    public void playerMove() {
        System.out.println("Luogo attuale: "+playerPosition.getRoomName());
        System.out.println("Dove vuoi andare? : (NORTH) (SOUTH) (EAST) (WEST)");
        boolean directionSwitch = false;
        String direction = console.readLine();
        switch (direction.toUpperCase().trim()) {
            case "NORTH":
                if (playerPosition.getNorthRoom() != null) {
                    playerPosition = playerPosition.getNorthRoom();
                    directionSwitch = true;
                }
                break;
            case "SOUTH":
                if (playerPosition.getSouthRoom() != null) {
                    playerPosition = playerPosition.getSouthRoom();
                    directionSwitch = true;
                }
                break;
            case "EAST":
                if (playerPosition.getEastRoom() != null) {
                    playerPosition = playerPosition.getEastRoom();
                    directionSwitch = true;
                }
                break;
            case "WEST":
                if (playerPosition.getWestRoom() != null) {
                    playerPosition = playerPosition.getWestRoom();
                    directionSwitch = true;
                }
                break;
            default:
                System.out.println("INSERISCI LA DIREZIONE!");
                break;
        }
        if(directionSwitch){
            Spawner.resetGuardsInRoom(playerPosition);
            mapFrame.updateMap(printRoomAndDesc() + playerPosition.getMapOutput());
            printRoomAndDesc();
        }
    }
    public String printRoomAndDesc(){
        StringBuilder sb = new StringBuilder();
        sb.append("Luogo attuale: ")
                .append(playerPosition.getRoomName())
                .append("\n")
                .append(playerPosition.getRoomDescription())
                .append("\n\n");
        return sb.toString();

//        playerPosition.showEntitiesInRoom();
//        System.out.println();
//        playerPosition.getRoomObjects().showItemsInInventory();
    }

    @Override
    public void attack(Entity target) {
        if (target.isCanBeAttacked()) {
                target.setHp(target.getHp() - (this.getAtk() + this.getAtkBonusFromStat()));
        }
        if(isDead(target)){
            this.xpUp(target.getXp());
            System.out.println("XP GUADAGNATI: " + target.getXp());
            this.earnMoney(target.getMoney());
            System.out.println("SOLDI GUADAGNATI: " + target.getMoney());
        }
    }

    public void eat(Item item){
        if(item instanceof Food){
            regenerateHp(((Food) item).getHpValue());
            entityInventory.deleteItemFromInventory(item.getItemName());
        }else{
            System.out.println("Quest'oggetto non si può mangiare");
        }
    }
    public void buy(Npc seller){
        seller.getEntityInventory().showItemsInInventory();
        System.out.println("SELECT ITEM TO BUY:");
        String input = console.readLine();

        Item item = seller.getEntityInventory().viewItemFromInventory(input);

        if (item != null && item.getValue() <= this.money) {
            entityInventory.addItemToInventory(item);
            seller.getEntityInventory().deleteItemFromInventory(input);
            pay(item.getValue());
            seller.earnMoney(item.getValue());
        } else {
            System.out.println("Non puoi comprare quest'oggetto");
        }
    }

    public void pickFromCorpse(Room room){
        room.showCorpses();
        System.out.println("SELECT CORPSE: ");
        String input = console.readLine().trim().toUpperCase();
        int result = room.getCorpseIndex(input);
        if(result != -1){
            //se ha trovato il cadavere
            Object obj = room.getRoomEntities().get(CORPSE_INDEX).get(result);
            Entity corpse = (Entity)obj;
            corpse.getEntityInventory().showItemsInInventory();
            addFromInventoryToInventory(corpse.getEntityInventory());
            room.getRoomEntities().get(CORPSE_INDEX).remove(result);
        }else{
            System.out.println("Nessun entità cadavere ha questo nome");
        }
    }
    public void pickEnvironmentItems(Room room){
        room.getRoomObjects().showItemsInInventory();
        addFromInventoryToInventory(room.getRoomObjects());
    }
    private void addFromInventoryToInventory(Inventory inventory){
        Item i = selectItemFromInventory(inventory);
        if(i != null){
            entityInventory.addItemToInventory(i);
            if(i.isDropped()){
                System.out.println("Hai preso l'oggetto selezionato da terra");
            }
            inventory.deleteItemFromInventory(i.getItemName());
        }else{
            System.out.println("Non è presente alcun item con questo nome");
        }
    }

    private void xpUp(int amount){
        this.setXp(this.getXp() + amount);
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
    public void equip(Item item){
        System.out.println("Scegli dove equipaggiare l'item: ");
        playerEquipment.showEquip();
        String input = console.readLine().toUpperCase().trim();
        switch(input){
            case "LEFTHAND":
                if(item instanceof Weapon && playerEquipment.getLeftHand() == null){
                    playerEquipment.setLeftHand(item);
                    entityInventory.deleteItemFromInventory(item.getItemName());
                }else{
                    System.out.println("Impossibile equipaggiare");
                }
                break;
            case "RIGHTHAND":
                if(item instanceof Weapon && playerEquipment.getRightHand() == null){
                    playerEquipment.setRightHand(item);
                    entityInventory.deleteItemFromInventory(item.getItemName());
                }else{
                    System.out.println("Impossibile equipaggiare");
                }
                break;
            default:
                System.out.println("Non puoi equipaggiarlo qui");
                break;
        }
    }
    public void removeFromEquipment(){
        System.out.println("Seleziona la parte dell'equipaggiamento da togliere: ");
        playerEquipment.showEquip();
        String input = console.readLine().toUpperCase().trim();
        switch(input){
            case "HEAD":
                if(playerEquipment.getHead() != null){
                    entityInventory.addItemToInventory(playerEquipment.getHead());
                    playerEquipment.setHead(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in HEAD");
                }
                break;
            case "BODY":
                if(playerEquipment.getBody() != null){
                    entityInventory.addItemToInventory(playerEquipment.getBody());
                    playerEquipment.setBody(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in BODY");
                }
                break;
            case "ARMS":
                if(playerEquipment.getArms() != null){
                    entityInventory.addItemToInventory(playerEquipment.getArms());
                    playerEquipment.setArms(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in ARMS");
                }
                break;
            case "LEGS":
                if(playerEquipment.getLegs() != null){
                    entityInventory.addItemToInventory(playerEquipment.getLegs());
                    playerEquipment.setLegs(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in HEAD");
                }
                break;
            case "LEFTHAND":
                if(playerEquipment.getLeftHand() != null){
                    entityInventory.addItemToInventory(playerEquipment.getLeftHand());
                    playerEquipment.setLeftHand(null);
                }else{
                    System.out.println("Nessun oggetto equipaggiato in LEFT HAND");
                }
                break;
            case "RIGHTHAND":
                if(playerEquipment.getRightHand() != null){
                    entityInventory.addItemToInventory(playerEquipment.getRightHand());
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
    public void dropItemFromInventory(Inventory inventory, Item item){
        item.setDropped(true);
        playerPosition.getRoomObjects().addItemToInventory(item);
        System.out.println("hai lasciato cadere l'oggetto " + item.getItemName());
        inventory.deleteItemFromInventory(item.getItemName());
    }

    public void openInventory(){
        entityInventory.showItemsInInventory();
        System.out.println("seleziona l'oggetto con cui interagire: (Nome oggetto)");
        String input = console.readLine();
        Item item = entityInventory.viewItemFromInventory(input);
        if(item != null){
            System.out.println("Seleziona l'azione da compiere: (DROP) (EAT) (EQUIP) (DESCRIPTION)");
            String input2 = console.readLine().trim().toUpperCase();
            switch (input2){
                case "DROP" -> dropItemFromInventory(entityInventory, item);
                case "EAT" -> eat(item);
                case "EQUIP" -> equip(item);
                case "DESCRIPTION" -> System.out.println("Descrizione oggetto:\n" + item.getItem_description() + "\n");
                default -> System.out.println("Non hai selezionato alcuna azione");
            }
        }else{
            System.out.println("Non esiste alcun oggetto con questo nome");
        }
    }

    private Item selectItemFromInventory(Inventory inventory){
        System.out.println("Seleziona l'oggetto: ");
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

    public static void setMapFrame(MapFrame mapFrame) {
        Player.mapFrame = mapFrame;
    }
}
