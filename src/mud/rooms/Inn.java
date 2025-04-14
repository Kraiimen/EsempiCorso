package mud.rooms;

public class Inn extends Room {
    public Inn() {
        super("The Prancing Pony");
    }

    @Override
    public void printEntrance() {
        System.out.println("This is the Prancing Pony Inn, the perfect place to recharge after a long day of fighting!");
        printEntities();
    }
}
