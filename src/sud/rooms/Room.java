package sud.rooms;


import sud.entity.npc.Npc;
import sud.inventory.Item;
import sud.typewriter.TypeWriter;

import java.util.*;

public class Room {
    protected int index;
    protected String name;
    protected String description;
    protected List<Npc> npcContent;
    protected List<Item> itemContent;
    protected Map<Npc, Double> contentToAppearanceChance;
    protected Map<Direction, Room> directionToAdjacentRoom;


    public Room(int index, String name) {
        this.index = index;
        this.name = name;
        this.npcContent = new ArrayList<>();
        this.contentToAppearanceChance = new HashMap<>();
        this.directionToAdjacentRoom = new HashMap<>();
        this.itemContent = new ArrayList<>();
    }

    public void addAdjacentRoom(Direction direction, Room adjacentRoom) {
        directionToAdjacentRoom.put(direction, adjacentRoom);
    }

    public void onRoomEntered() { //changes the current content
        updateNpcContent();
        TypeWriter.byLetter("Welcome to " + name + ".\n" + description + "\n");
//        System.out.println("Welcome to " + name + ".");
//        System.out.println(description);
        System.out.println("Characters in this room :" + npcContent.stream()
                .map(npc -> npc.isAlive() ? npc.getName() : npc.getName() + " (dead)")
                .toList());
        System.out.println("Items in this room: " + itemContent);
        System.out.println("Adjacent rooms: ");
        for (Map.Entry<Direction, Room> entry : directionToAdjacentRoom.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue().getName());
        }
        System.out.println();
    }

    private void updateNpcContent() {
        npcContent.clear();
        Random random = new Random();
        for (Map.Entry<Npc, Double> entry : contentToAppearanceChance.entrySet()) {
            if (!entry.getKey().isAlive()) {
                npcContent.add(entry.getKey());
                continue;
            }
            if (random.nextDouble(1) < entry.getValue()) {
                npcContent.add(entry.getKey());
            }
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void addNpcContent(Npc npc, double chanceOfAppearance) {
        contentToAppearanceChance.put(npc, chanceOfAppearance);
    }

    public void addItemContent(Item item) {
        itemContent.add(item);
    }

    public void removeItemContent(Item item) {
        itemContent.remove(item);
    }

    public String getName() {
        return name;
    }

    public List<Npc> getNpcContent() {
        return npcContent;
    }

    public List<Item> getItemContent() {
        return itemContent;
    }

    @Override
    public String toString() {
        String result = "Name:" + name +
                "\nDescription: " + description;

        for (Map.Entry<Npc, Double> entry : contentToAppearanceChance.entrySet()) { //for each entry of the map
            result += "\n" + entry.getKey().getName() + " " + (entry.getValue() * 100) + "%";
        }
        result += "\nAdjacent rooms: ";
        for (Map.Entry<Direction, Room> entry : directionToAdjacentRoom.entrySet()) {
            result += "\n" + entry.getKey() + "-->" + entry.getValue().getName();
        }

        result += "\n";
        return result;
    }

    public Optional<Room> getAdjacentRoom(Direction direction) {
        if (!directionToAdjacentRoom.containsKey(direction)) {
            return Optional.empty();
        }
        return Optional.of(directionToAdjacentRoom.get(direction));
    }

}
