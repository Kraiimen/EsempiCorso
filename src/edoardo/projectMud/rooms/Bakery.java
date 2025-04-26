package edoardo.projectMud.rooms;

import edoardo.projectMud.Directions;

public class Bakery extends Room {
    public Bakery() {
       initialize();
    }

    public Bakery(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }
    public Bakery(boolean isInTheInitialSetupOfTheDungeon) {
        super(isInTheInitialSetupOfTheDungeon);
        initialize();
    }
    @Override
    protected void initialize() {
        setName("Bakery");
        setDescription("""
                this cozy bakery fills the air with the scent of cinnamon and enchanted flour.
                Elven pastries, dwarven stonebread, and magical moonberry tarts line the shelves,
                each bite said to carry a hint of ancient spells and hearth-warm comfort.""");
    }
}
