package mud.rooms;

public class CityDoor extends Room{
    public CityDoor() {
        super("The City Door");
    }


    @Override
    public void printEntrance() {
        System.out.println("This is the entrance to the city! Check beyond these walls and be prepared, adventurer!");
        printEntities();
    }
}
