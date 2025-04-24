package VideoGame.Rooms;

import java.util.HashMap;

public class Mappe {
    private HashMap<String, Rooms> rooms = new HashMap<>();

    public Mappe() {

        Rooms templeSquare = new Rooms("temple square", "", "the temple", "", "market square");
        Rooms marketSquare = new Rooms("market square", "temple square","bakery", "armory", "gardens");
        Rooms theTemple = new Rooms("the temple", "","","temple square","");
        Rooms bakery = new Rooms("bakery", " temple","","market square","");
        Rooms armory = new Rooms("armory", "","market square","","");
        Rooms gardens = new Rooms("gardens", "market square","","","garden");
        Rooms garden2 = new Rooms("garden", "gardens","","","");
        Rooms garden3 = new Rooms("garden","garden2","","","");
        Rooms citydoors = new Rooms("city doors","garden3","","","");
        Rooms thewoods = new Rooms("the woods","","","","");

        String currentRooms = "";
        String spawnRooms = "temple square";

        rooms.put(templeSquare.getNome(), templeSquare);
        rooms.put(marketSquare.getNome(), marketSquare);
        rooms.put(theTemple.getNome(), theTemple);
        rooms.put(bakery.getNome(), bakery);
        rooms.put(armory.getNome(), armory);
        rooms.put(gardens.getNome(), gardens);
        rooms.put(garden2.getNome(), garden2);
        rooms.put(garden3.getNome(), garden3);
        rooms.put(citydoors.getNome(), citydoors);
        rooms.put(thewoods.getNome(),thewoods);
    }
}
