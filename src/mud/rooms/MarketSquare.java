package mud.rooms;

public class MarketSquare extends Room{
    public MarketSquare() {
        super("Market Square");
    }


    @Override
    public void printEntrance() {
        System.out.println("You are in Market Square");
        printEntities();
    }
}
