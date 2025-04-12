package mud.rooms;

import mud.CardinalPoints;
import mud.items.Tree;

import java.util.ArrayList;
import java.util.List;

import static mud.characters.fightable.Character.dice;

public class MagicMap {
    static private List<Room> rooms = new ArrayList<>();
    static{
        //creo le room
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

        //aggiungo gli alberi
        firstGarden.getPresentItems().put("Apple tree", new Tree("Apple tree", "Apple", 1));
        secondGarden.getPresentItems().put("Dark apple tree", new Tree("Dark apple tree", "Apple", 2));
        int magicNum;
        do{magicNum = dice.nextInt(-3,3);
        }while(magicNum == 0);
        secondGarden.getPresentItems().put("Misterious tree", new Tree("Misterious tree", "Mistery fruit", magicNum));


    }

    public static List<Room> getRooms(){
        return rooms;
    }
}
