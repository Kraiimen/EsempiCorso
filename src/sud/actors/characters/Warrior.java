package sud.actors.characters;

import sud.Die;
import sud.actors.Actor;

public class Warrior extends Actor {


    public Warrior(String name) {
        super(name);
    }

    @Override
    public Die getConstitutionDice() {
        return null;
    }
}
