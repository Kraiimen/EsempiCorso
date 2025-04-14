package sud.environment.rooms;

public class Temple extends Room {
    private static String templeDescription = "Ti trovi nel tempio";
    private static String templeNpc = "";
    private static String templeLoot = "";
    public Temple() {
        super(templeDescription);
    }

    public Temple(Room north, Room east, Room south, Room west) {
        super(templeDescription, north, east, south, west);
    }
}
