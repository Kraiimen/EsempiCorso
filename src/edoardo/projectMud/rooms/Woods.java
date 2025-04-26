package edoardo.projectMud.rooms;

import edoardo.projectMud.Directions;

public class Woods extends Room {
    public Woods() {
       initialize();
    }

    public Woods(Directions dir, Room r) {
        super(dir, r);
        initialize();
    }

    @Override
    protected void initialize() {
        setName("Woods");
        setDescription("""
                The forest stretches out like a sea of shadows beyond the castle gates,
                its dense canopy blotting out the sun. Twisted trees and tangled undergrowth create a maze of silence,
                broken only by distant growls and the rustle of unseen creatures.
                Locals call it the Wildwood — a place where few dare venture, and even fewer return.
                It's said the deeper you go, the darker it gets — not just in light, but in presence""");
    }
}
