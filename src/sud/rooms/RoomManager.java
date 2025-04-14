package sud.rooms;

import sud.entity.npc.Baker;
import sud.entity.npc.Cat;
import sud.entity.npc.Guard;
import sud.entity.npc.Metalsmith;
import sud.inventory.ItemFactory;

import java.util.Optional;
import java.util.Scanner;

public class RoomManager {
    Room templeSquare;
    Room temple;
    Room marketSquare;
    Room bakery;
    Room armory;
    Room garden1;
    Room garden2;
    Room garden3;
    Room cityGate;
    Room woods;
    Room currentRoom;


    public RoomManager() {
        this.templeSquare = createTempleSquare();
        this.temple = createTemple();
        this.marketSquare = createMarketSquare();
        this.bakery = createBakery();
        this.armory = createArmory();
        this.garden1 = createGarden();
        this.garden2 = createGarden();
        this.garden3 = createGarden();
        this.cityGate = createCityGate();
        this.woods = createWoods();
        currentRoom = templeSquare;

        assignAdjacentRoom();
    }

    public void assignAdjacentRoom() {
        templeSquare.addAdjacentRoom(Direction.EAST, temple);
        templeSquare.addAdjacentRoom(Direction.SOUTH, marketSquare);
        temple.addAdjacentRoom(Direction.WEST, templeSquare);
        temple.addAdjacentRoom(Direction.SOUTH, bakery);
        marketSquare.addAdjacentRoom(Direction.NORTH, templeSquare);
        marketSquare.addAdjacentRoom(Direction.WEST, armory);
        marketSquare.addAdjacentRoom(Direction.EAST, bakery);
        marketSquare.addAdjacentRoom(Direction.SOUTH, garden1);
        armory.addAdjacentRoom(Direction.EAST, marketSquare);
        bakery.addAdjacentRoom(Direction.WEST, marketSquare);
        bakery.addAdjacentRoom(Direction.NORTH, temple);
        garden1.addAdjacentRoom(Direction.NORTH, marketSquare);
        garden1.addAdjacentRoom(Direction.SOUTH, garden2);
        garden2.addAdjacentRoom(Direction.NORTH, garden1);
        garden2.addAdjacentRoom(Direction.SOUTH, garden3);
        garden3.addAdjacentRoom(Direction.NORTH, garden2);
        garden3.addAdjacentRoom(Direction.SOUTH, cityGate);
        cityGate.addAdjacentRoom(Direction.NORTH, garden3);
        cityGate.addAdjacentRoom(Direction.SOUTH, woods);
        woods.addAdjacentRoom(Direction.NORTH, cityGate);


    }

    public void move(Direction direction) {
        Optional<Room> nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom.isEmpty()) {
            System.out.println("There's no room to the " + direction.toString().toLowerCase());
            return;
        }
        currentRoom = nextRoom.get();
        currentRoom.onRoomEntered();
    }

    public Direction getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "north":
                return Direction.NORTH;
            case "south":
                return Direction.SOUTH;
            case "west":
                return Direction.WEST;
            case "east":
                return Direction.EAST;
            default:
                System.out.println("This direction is incorrect. Try again");
        }
        return null;
    }

    Room createTempleSquare() {
        Room templeSquare = new Room(1, "Temple Square");
        templeSquare.setDescription("""
                The Temple Square is a serene, stone-paved plaza\s
                surrounded by crumbling columns and moss-covered statues.\s
                Golden light filters through high arches, casting shifting patterns on the ground.\s
                The air hums with ancient power and whispered prayers.""");

        Cat cat = new Cat();
        templeSquare.addNpcContent(cat, 0.8);
        return templeSquare;
    }

    Room createTemple() {
        Room temple = new Room(2, "Temple");
        temple.setDescription(""" 
                The Temple looms in silent majesty, \s
                its towering doors etched with forgotten runes. \s
                Inside, flickering braziers cast long shadows across cracked marble floors. \s
                A sense of reverence—and something watching—lingers in the still air.""");
        Guard guard1 = new Guard("Evan the Guard", 33, 4);
        temple.addItemContent(ItemFactory.makeHolyWater());
        temple.addNpcContent(guard1, 1);
        return temple;
    }

    Room createMarketSquare() {
        Room marketSquare = new Room(3, "Market square");
        marketSquare.setDescription("""
                The Market Square bustles with life, \s
                its stalls overflowing with spices, trinkets, and whispered rumors. \s
                Merchants haggle beneath colorful canopies, their voices weaving through the crowd. \s
                Laughter and tension mix in the air like smoke and sunlight.""");
        Guard guard1 = new Guard("Bob the Guard", 25, 2);
        Guard guard2 = new Guard("Dink the Guard", 28, 3);
        Cat cat = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Baker baker = new Baker("Jo the Pretzel seller");
        baker.getInventory().addItem(ItemFactory.makePretzel(), 3);
        marketSquare.addNpcContent(guard1, 0.4);
        marketSquare.addNpcContent(guard2, 0.2);
        marketSquare.addNpcContent(baker, 1);
        marketSquare.addNpcContent(cat, 1);
        marketSquare.addNpcContent(cat2, 0.8);
        marketSquare.addNpcContent(cat3, 0.5);
        return marketSquare;
    }

    Room createArmory() {
        Room armory = new Room(4, "Armory");
        armory.setDescription(""" 
                The Armory stands solid and stern, \s
                its walls lined with racks of worn blades and gleaming new steel. \s
                The scent of oil and metal fills the air, mingling with the echo of distant hammer strikes. \s
                A silent readiness hangs in every corner.""");
        Metalsmith metalsmith = new Metalsmith("Aeren the Metalsmith", 38, 0);
        armory.addNpcContent(metalsmith, 1);
        return armory;
    }

    Room createBakery() {
        Room bakery = new Room(5, "Bakery");
        bakery.setDescription("""
                The Bakery is warm and inviting, \s
                its air rich with the scent of fresh bread and sweet spice. \s
                Loaves line the shelves in neat rows, golden and crusty. \s
                A gentle clatter of trays and quiet humming fills the cozy space.
                """);
        Baker baker = new Baker("Giovanni the Baker");
        bakery.addNpcContent(baker, 1);
        return bakery;
    }

    Room createGarden() {
        Room garden = new Room(6, "Garden");
        garden.setDescription("""
                The Garden is a quiet haven, where wildflowers \s
                bloom between ancient stone paths and ivy climbs sunlit walls. \s
                A small fountain murmurs softly at the center. \s
                The air is rich with the scent of earth, petals, and peace.
                """);
        Cat cat = new Cat();
        Guard guard1 = new Guard("Bert the Guard", 29, 4);
        Guard guard2 = new Guard("Crispus the Guard", 29, 4);
        garden.addNpcContent(cat, 1);
        garden.addNpcContent(guard1, 0.7);
        garden.addNpcContent(guard2, 0.65);
        return garden;
    }

    Room createCityGate() {
        Room cityGate = new Room(7, "City Gate");
        cityGate.setDescription("""
                The City Gate rises tall and weathered, \s
                its ironbound doors flanked by vigilant guards and towering stone walls. \s
                Beyond lies the open road, dust swirling in the wind. \s
                The air hums with the promise of danger—and freedom.
                """);
        Guard guard1 = new Guard("Drudo the Guard", 21, 3);
        Guard guard2 = new Guard("Justus the Guard", 24, 3);
        cityGate.addNpcContent(guard1, 1);
        cityGate.addNpcContent(guard2, 1);
        return cityGate;
    }

    Room createWoods() {
        Room woods = new Room(8, "Wood");
        woods.setDescription("""
                The Woods are dense and shadowed, \s
                where twisted trees loom and sunlight barely pierces the thick canopy. \s
                Leaves rustle with unseen movement, and the scent of moss and damp earth clings to the air.\s
                Every path feels both ancient and uncertain.
                """);
        return woods;
    }


    void printRoom(Room room) {

        System.out.println(room.toString());
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}