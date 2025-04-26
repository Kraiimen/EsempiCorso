package edoardo.projectMud.rooms;


import edoardo.projectMud.Directions;

public class Armory extends Room {
    public Armory() {
        initialize();

    }

    public Armory(boolean isInTheInitialSetupOfTheDungeon) {
        super(isInTheInitialSetupOfTheDungeon);
        initialize();
    }

    public Armory(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }

    @Override
    protected void initialize() {
        setName("Armory");
        setDescription("""
                Nestled beneath a towering stone arch,
                the forge-lit armory hums with the ring of steel and the scent of smelted iron.
                Blades etched with runes, gleaming dragonbone bows, and armor forged from rare celestial ore
                await heroes and wanderers alike.
                Each piece holds a story — and perhaps, a destiny.""");

    }

}
