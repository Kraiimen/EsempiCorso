package edoardo.projectMud.rooms;

import edoardo.projectMud.Directions;

//in futuri upgrade aggiungere la possibilità di cura dal sacerdote
public class Temple extends Room {
    public Temple() {
        initialize();

    }
    public Temple(boolean isInTheInitialSetupOfTheDungeon) {
        super(isInTheInitialSetupOfTheDungeon);
        initialize();
    }

    public Temple(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }

    @Override
    protected void initialize() {
        setName("Temple");
        setDescription( """
                The temple stands tall and serene, its weathered stones radiating a quiet strength. 
                Inside, the air is cool and calm, filled with the faint scent of incense and the soft glow of candlelight.
                At the heart of the sanctuary, a healer-priest moves with gentle purpose, his hands glowing faintly with restorative magic.
                Known for his wisdom and compassion, he tends to the weary and wounded, offering solace beneath the temple’s sacred arches.
                """);
    }

}
