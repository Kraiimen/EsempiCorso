package mud.rooms;

public class MarketSquare extends Room{
    public MarketSquare() {
        super("Market Square");
    }

    @Override
    public void addRandomNPC() {

    }

    @Override
    public void printEntrance() {
        System.out.println("You are in Market Square");
        getPresentEntities().forEach(e -> System.out.println(e.getName() + " the " + e.getClass()));

    }
}
