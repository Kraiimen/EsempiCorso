package sud.environment.rooms;

public class Market extends Room {
    private static String templeDescription = "Ti trovi nel mercato";
    private static String templeNpc = "";
    private static String templeLoot = "";
    public Market() {
        super(templeDescription, templeNpc, templeLoot);
    }

    public Market(Room north, Room east, Room south, Room west) {
        super(templeDescription, templeNpc, templeLoot, north, east, south, west);
    }
}
