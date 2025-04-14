package sud.actors.characters;

import sud.Die;
import sud.actors.Actor;

public class Paladin extends Actor {


    public Paladin(String name) {
        super(name);
    }

    @Override
    public Die getConstitutionDice() {
        return null;
    }
}
