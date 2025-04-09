package mud.rooms;

import mud.CardinalPoints;

import java.util.ArrayList;
import java.util.List;

public class MagicMap {
    static private ArrayList<Room> rooms = new ArrayList<>();
    static{
        Room templeSquare = new TempleSquare();
        Room theTemple = new TheTemple();
        Room marketSquare = new MarketSquare();
        Room armory = new Armory();
        Room bakery = new Bakery();
        Room firstGarden = new Garden("The Magic Garden");
        Room secondGarden = new Garden("The Dark Garden");
        Room cityDoor = new CityDoor();
        Room woods = new Woods();

        templeSquare.getDirections().put(CardinalPoints.EAST, theTemple);
        templeSquare.getDirections().put(CardinalPoints.SOUTH, marketSquare);

        theTemple.getDirections().put(CardinalPoints.WEST, templeSquare);

        marketSquare.getDirections().put(CardinalPoints.NORTH, templeSquare);
        marketSquare.getDirections().put(CardinalPoints.EAST, bakery);
        marketSquare.getDirections().put(CardinalPoints.SOUTH, firstGarden);
        marketSquare.getDirections().put(CardinalPoints.WEST, armory);

        bakery.getDirections().put(CardinalPoints.WEST, marketSquare);

        armory.getDirections().put(CardinalPoints.EAST, marketSquare);

        firstGarden.getDirections().put(CardinalPoints.NORTH, marketSquare);
        firstGarden.getDirections().put(CardinalPoints.SOUTH, secondGarden);

        secondGarden.getDirections().put(CardinalPoints.NORTH, firstGarden);
        secondGarden.getDirections().put(CardinalPoints.SOUTH, cityDoor);

        cityDoor.getDirections().put(CardinalPoints.NORTH, secondGarden);
        cityDoor.getDirections().put(CardinalPoints.SOUTH, woods);

        woods.getDirections().put(CardinalPoints.NORTH, cityDoor);

        rooms.add(templeSquare);
        rooms.add(theTemple);
        rooms.add(marketSquare);
        rooms.add(bakery);
        rooms.add(armory);
        rooms.add(firstGarden);
        rooms.add(secondGarden);
        rooms.add(cityDoor);
        rooms.add(woods);
    }

    public static List<Room> getRooms(){
        return rooms;
    }
}
