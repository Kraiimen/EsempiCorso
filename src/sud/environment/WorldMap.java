package sud.environment;

import sud.engine.mechanics.SpawnManager;
import sud.environment.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    private static Room spawnPosition;      //temple square
    private static List<Room> map = new ArrayList<>();

    public static void generateWorld() {
        generateMap();

    }

    public static void generateMap(){
//        Room wall = new Room("wall");
//        map.put(wall);
        Room templeSquare = new Room("temple square");
        Room temple = new Room("temple");
        Room marketSquare = new Room("market square");
        Room armory = new Room("armory");
        Room bakery = new Room("bakery");
        Room gardenNorth = new Room("garden north");
        Room gardenSouth = new Room("garden south");
        Room cityGates = new Room("city gates");
        Room woods = new Room("woods");
        map = new ArrayList<>(List.of(templeSquare, temple, marketSquare, armory, bakery, gardenNorth, gardenSouth, cityGates, woods));

        templeSquare.setDirections(null, temple, marketSquare, null);
        temple.setDirections(null, null, null, templeSquare);           //sud panettiere, ma non li metto collegati per ora
        marketSquare.setDirections(templeSquare, bakery, gardenNorth, armory);
        bakery.setDirections(null, null, null, marketSquare);     //nord tempio, ma non li metto collegati per ora
        armory.setDirections(null, marketSquare, null, null);
        gardenNorth.setDirections(marketSquare, null, gardenSouth, null);
        gardenSouth.setDirections(gardenNorth, null, cityGates, null);
        cityGates.setDirections(gardenSouth, null, woods, null);
        woods.setDirections(cityGates, null, null, null);

        temple.setResidents(SpawnManager.defaultTempleResidents());
        bakery.setResidents(SpawnManager.defaultBakeryResidents());
        armory.setResidents(SpawnManager.defaultArmoryResidents());

        spawnPosition = templeSquare;
    }

    public static Room getSpawnPosition() {
        return spawnPosition;
    }
    public static List<Room> getWorldMap(){
        return map;
    }

}
