package mud.rooms;

public class CityDoor extends Room{
    public CityDoor() {
        super("The City Door");
    }


    @Override
    public void printEntrance() {

        getPresentEntities().forEach(e -> System.out.println(e.getName() + " the " + e.getClass().getSimpleName()));

    }
}
