package edoardo.projectMud.rooms;

import edoardo.projectMud.Directions;

public class TempleSquare extends Room {

    public TempleSquare(){
       initialize();
    }

    public TempleSquare(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }
    public TempleSquare(boolean isInTheInitialSetupOfTheDungeon) {
        super(isInTheInitialSetupOfTheDungeon);
        initialize();
    }
    public TempleSquare(Room nordRoom, Room estRoom, Room ovestRoom, Room sudRoom) {
        super(nordRoom, estRoom, ovestRoom, sudRoom);
        initialize();
    }

    @Override
    protected void initialize() {
        setName("Temple Square");
        setDescription("""
       A quiet, empty square stretches out before the ancient temple, its stone tiles bathed in soft sunlight.
       The silence is broken only by the distant rustle of leaves,
       as shadows from the towering columns fall gently across the ground.
       Time seems to slow here, in the stillness of this sacred place.
      """);
    }

}
