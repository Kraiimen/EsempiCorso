package capstoneproject;

public class Room {
    private String name;
    private String description;
    private Room north, south, east, west;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setNorth(Room north) { this.north = north; }
    public void setSouth(Room south) { this.south = south; }
    public void setEast(Room east) { this.east = east; }
    public void setWest(Room west) { this.west = west; }

    public Room getNorth() { return north; }
    public Room getSouth() { return south; }
    public Room getEast() { return east; }
    public Room getWest() { return west; }

    public String getName() { return name; }

    public void describe() {
        System.out.println("You are in: " + name);
        System.out.println(description);
    }
}
