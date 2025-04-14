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
        Room inn = new Inn();

        templeSquare.addPath(CardinalPoints.EAST, theTemple);
        templeSquare.addPath(CardinalPoints.SOUTH, marketSquare);
        templeSquare.addPath(CardinalPoints.WEST, inn);

        theTemple.addPath(CardinalPoints.WEST, templeSquare);

        marketSquare.addPath(CardinalPoints.NORTH, templeSquare);
        marketSquare.addPath(CardinalPoints.EAST, bakery);
        marketSquare.addPath(CardinalPoints.SOUTH, firstGarden);
        marketSquare.addPath(CardinalPoints.WEST, armory);


        bakery.addPath(CardinalPoints.WEST, marketSquare);

        armory.addPath(CardinalPoints.EAST, marketSquare);

        firstGarden.addPath(CardinalPoints.NORTH, marketSquare);
        firstGarden.addPath(CardinalPoints.SOUTH, secondGarden);

        secondGarden.addPath(CardinalPoints.NORTH, firstGarden);
        secondGarden.addPath(CardinalPoints.SOUTH, cityDoor);

        cityDoor.addPath(CardinalPoints.NORTH, secondGarden);
        cityDoor.addPath(CardinalPoints.SOUTH, woods);

        woods.addPath(CardinalPoints.NORTH, cityDoor);

        inn.addPath(CardinalPoints.EAST, templeSquare);

        rooms.add(templeSquare);
        rooms.add(theTemple);
        rooms.add(marketSquare);
        rooms.add(bakery);
        rooms.add(armory);
        rooms.add(firstGarden);
        rooms.add(secondGarden);
        rooms.add(cityDoor);
        rooms.add(woods);
        rooms.add(inn);

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
