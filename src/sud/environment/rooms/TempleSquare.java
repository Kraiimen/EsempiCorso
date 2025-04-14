package sud.environment.rooms;

public class TempleSquare extends Room{
    private static String templeSquareDescription = "Ti trovi nella piazza del tempio";
    private static String templeSquareNpc = "";
    private static String templeSquareLoot = "";

    public TempleSquare() {
        super(templeSquareDescription, templeSquareNpc, templeSquareLoot);
    }

    public TempleSquare(Room north, Room east, Room south, Room west) {
        super(templeSquareDescription, templeSquareNpc, templeSquareLoot, north, east, south, west);
    }
}
