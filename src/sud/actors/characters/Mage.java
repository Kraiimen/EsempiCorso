package sud.actors.characters;

import sud.Die;
import sud.actors.Actor;

public class Mage extends Actor {


    public Mage(String name) {
        super(name);
    }

    @Override
    public Die getConstitutionDice() {
        return null;
    }
}
