package sud.rooms;

import sud.items.*;
import sud.entity.*;
import java.util.*;

public class Room {
    private String name;
    private Room nordPath, sudPath, westPath, eastPath;
    private boolean hasItems, hasNPC, hasGuards, hasCritters, hasMOBS;
    private ArrayList<Item> itemsInRoom;
    private ArrayList<Entity> MOBSInRoom, guardsInRoom, crittersInRoom;
    private Set<Entity> NPCInRoom;
    private static Map<String, Room> roomMap = new HashMap();
    private String description;

    static {
        Room debugroom = new Room("debroom");

        Room castle = new Room("castle");
        roomMap.put("castle", castle);
        Room prison = new Room("prison");
        roomMap.put("prison", prison);
        Room temple = new Room("temple");
        roomMap.put("temple", temple);
        Room templeSq = new Room("templeSquare");
        Room tavern = new Room("tavern");
        roomMap.put("tavern", tavern);
        Room market = new Room("market");
        roomMap.put("market", market);
        Room forge = new Room("forge");
        roomMap.put("forge", forge);
        Room backery = new Room("backery");
        roomMap.put("backery", backery);
        Room alchemist = new Room("alchemist");
        roomMap.put("alchemist", alchemist);
        Room fieldsN = new Room("fieldsN");
        roomMap.put("fieldsN", fieldsN);
        Room fieldsS = new Room("fieldsS");
        roomMap.put("fieldsS", fieldsS);
        Room forest = new Room("forest");
        roomMap.put("forest", forest);
        Room bossRoom = new Room("bossRoom");
        roomMap.put("bossRoom", bossRoom);

        castle.setPaths(debugroom, templeSq, prison, debugroom);
        castle.setRoomProperties(false, true, true, false, false);

        prison.setPaths(debugroom, debugroom, debugroom, castle);
        prison.setRoomProperties(false, true, true, false, false);

        templeSq.setPaths(debugroom, market, debugroom, temple);
        templeSq.setRoomProperties(false, true, true, false, false);

        tavern.setPaths(debugroom, debugroom, templeSq, debugroom);
        tavern.setRoomProperties(true, true, false, false, false);

        temple.setPaths(debugroom, debugroom, templeSq, debugroom);
        temple.setRoomProperties(false, true, true, false, false);

        market.setPaths(templeSq, fieldsN, forge, backery);
        market.setRoomProperties(true, true, true, false, false);

        backery.setPaths(debugroom, debugroom, market, debugroom);
        backery.setRoomProperties(true, true, true, false, false);

        forge.setPaths(debugroom, alchemist, debugroom, market);
        forge.setRoomProperties(true, true, true, false, false);

        alchemist.setPaths(forge, debugroom, debugroom, debugroom);
        alchemist.setRoomProperties(true, true, true, false, false);

        fieldsN.setPaths(market, fieldsS, debugroom, debugroom);
        fieldsN.setRoomProperties(true, false, false, true, false);

        fieldsS.setPaths(fieldsN, forest, debugroom, debugroom);
        fieldsS.setRoomProperties(true, false, false, false, true);

        forest.setPaths(fieldsS, debugroom, debugroom, bossRoom);
        forest.setRoomProperties(true, false, false, false, true);

        bossRoom.setPaths(debugroom, debugroom, forest, debugroom);
        bossRoom.setRoomProperties(true, false, false, false, true);

        castle.setDescription("Un enorme sala del trono si presenta davanti a te, muri in marmo bianco, un lungo tappeto rosso che dalla porta indica la via per il trono ," +
                "4 guardie svettano fiere alla tua destra quando entri, e altr 4 sono appena arrivate dal cambio turno sulla tua sinistra " +
                "le mura della stanza sono ricoperte di arazzi e quadri, riesci tranquillamente a vedere che l'arazzo più grande raffigura l'attuale re, " +
                "alla fine della stanza puoi vedere una scalinata di circa 6-7 gradini, che alla sua sommità ha un lussuoso trono fatto d'oro e intarsiato in madre perla, " +
                "sul trono svetta una figura umanoide, un uomo grasso, dalle spalle larghe e dalla barba ben curata, sulla sua testa svetta una corona, lui è il re");
        prison.setDescription("Scendendo le scale ti ritrovi in un ambiente umido e illuminato da sole torce, l'aria e viziata e la polvere è molta, alla fine delle scale vedi una porta in legno" +
                "una guardia è seduta ad un tavolo li vicino,quando passi segna il tuo nome sul registro, la porta della prigione è aperta, da su un corridoio, riesci già a vedere una fila di celle con sbarre di metallo larghe quanto il manico di una scopa" +
                "le celle sono sporche, c'è puzza di urina e le facce al suo interno non sono amichevoli");
        templeSq.setDescription("La piazza del tempio è colma di persone, vedi bambini che giocano a campana, guardie che fanno la ronda, vecchie signore che danno da mangiare a dei piccioni" +
                "a nord il ponte levatoio che da sul entrata per il castello, dove 3 guardie fanno da sentinelle, riesci quasi a vedere la sala del trono in lontananza, " +
                "verso sud il gran mercato cittadino, con le sue bancarelle e empori, senti già il chiasso dei venditori che ti propongono \" il grande affare della tua vita\" provenire da quella direction " +
                "verso est invece sfoggia fiero il grande tempio degli dei, completamente fatto in marmo dei migliori al mondo, li potresti trovare l'aiuto dei sacerdoti, riconosciuti per le loro abilità curative e di potenziamento");
    }

    public Room(String name, Room nordPath, Room sudPath, Room westPath, Room eastPath,
                boolean hasItems, boolean hasNPC, boolean hasGuards, boolean hasCritters, boolean hasMOBS,
                ArrayList<Item> itemsInRoom, ArrayList<Entity> MOBSInRoom, ArrayList<Entity> guardsInRoom,
                ArrayList<Entity> crittersInRoom, Set<Entity> NPCInRoom, String description) {
        this.name = name;
        this.nordPath = nordPath;
        this.sudPath = sudPath;
        this.westPath = westPath;
        this.eastPath = eastPath;
        this.hasItems = hasItems;
        this.hasNPC = hasNPC;
        this.hasGuards = hasGuards;
        this.hasCritters = hasCritters;
        this.hasMOBS = hasMOBS;
        this.itemsInRoom = itemsInRoom;
        this.MOBSInRoom = MOBSInRoom;
        this.guardsInRoom = guardsInRoom;
        this.crittersInRoom = crittersInRoom;
        this.NPCInRoom = NPCInRoom;
        this.description = description;
    }

    public Room(String name) {
        this.name = name;
        this.itemsInRoom = new ArrayList<>();
        this.MOBSInRoom = new ArrayList<>();
        this.guardsInRoom = new ArrayList<>();
        this.crittersInRoom = new ArrayList<>();
        this.NPCInRoom = new HashSet<>();
        this.description = "";
    }

    public void setPaths(Room nord, Room sud, Room west, Room east) {
        this.nordPath = nord;
        this.sudPath = sud;
        this.westPath = west;
        this.eastPath = east;
    }

    public void setRoomProperties(boolean hasItems, boolean hasNPC, boolean hasGuards, boolean hasCritters, boolean hasMOBS) {
        this.hasItems = hasItems;
        this.hasNPC = hasNPC;
        this.hasGuards = hasGuards;
        this.hasCritters = hasCritters;
        this.hasMOBS = hasMOBS;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Room getNordPath() {
        return nordPath;
    }
    public void setNordPath(Room nordPath) {
        this.nordPath = nordPath;
    }

    public Room getSudPath() {
        return sudPath;
    }
    public void setSudPath(Room sudPath) {
        this.sudPath = sudPath;
    }

    public Room getWestPath() {
        return westPath;
    }
    public void setWestPath(Room westPath) {
        this.westPath = westPath;
    }

    public Room getEastPath() {
        return eastPath;
    }
    public void setEastPath(Room eastPath) {
        this.eastPath = eastPath;
    }

    public boolean isHasItems() {
        return hasItems;
    }
    public void setHasItems(boolean hasItems) {
        this.hasItems = hasItems;
    }

    public boolean isHasNPC() {
        return hasNPC;
    }
    public void setHasNPC(boolean hasNPC) {
        this.hasNPC = hasNPC;
    }

    public boolean isHasGuards() {
        return hasGuards;
    }
    public void setHasGuards(boolean hasGuards) {
        this.hasGuards = hasGuards;
    }

    public boolean isHasCritters() {
        return hasCritters;
    }
    public void setHasCritters(boolean hasCritters) {
        this.hasCritters = hasCritters;
    }

    public boolean isHasMOBS() {
        return hasMOBS;
    }
    public void setHasMOBS(boolean hasMOBS) {
        this.hasMOBS = hasMOBS;
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }
    public void setItemsInRoom(ArrayList<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public ArrayList<Entity> getMOBSInRoom() {
        return MOBSInRoom;
    }
    public void setMOBSInRoom(ArrayList<Entity> MOBSInRoom) {
        this.MOBSInRoom = MOBSInRoom;
    }

    public ArrayList<Entity> getGuardsInRoom() {
        return guardsInRoom;
    }
    public void setGuardsInRoom(ArrayList<Entity> guardsInRoom) {
        this.guardsInRoom = guardsInRoom;
    }

    public ArrayList<Entity> getCrittersInRoom() {
        return crittersInRoom;
    }
    public void setCrittersInRoom(ArrayList<Entity> crittersInRoom) {
        this.crittersInRoom = crittersInRoom;
    }

    public Set<Entity> getNPCInRoom() {
        return NPCInRoom;
    }
    public void setNPCInRoom(Set<Entity> NPCInRoom) {
        this.NPCInRoom = NPCInRoom;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    static public Room getRoomPointerFromName(String name) {
        return roomMap.get(name);
    }
}
