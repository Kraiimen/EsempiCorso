package edoardo.projectMud.rooms;

import edoardo.projectMud.Directions;

public class MarketSquare extends Room {

    public MarketSquare() {
        initialize();

    }

    public MarketSquare(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }
    public MarketSquare(boolean isInTheInitialSetupOfTheDungeon) {
        super(isInTheInitialSetupOfTheDungeon);
        initialize();
    }
    public MarketSquare(Room nordRoom, Room estRoom, Room ovestRoom, Room sudRoom) {
        super(nordRoom, estRoom, ovestRoom, sudRoom);

    }
    @Override
    protected void initialize(){
        setName("Market Square");
        setDescription("""
                The market square is a lively and welcoming open space, 
                where locals and visitors gather to enjoy fresh produce,handmade crafts, and a vibrant atmosphere.
                Surrounded by charming buildings and cafés, it's the heart of the community and a hub of social and cultural life.""");
    }
    //public void showItems(){
        itemsToSell.forEach(item -> System.out.println(item + " " + item.getValue()));
    }

}
