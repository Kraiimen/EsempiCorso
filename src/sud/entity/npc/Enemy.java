package sud.entity.npc;

import sud.entity.Attackable;

public class Enemy extends Npc implements Attackable {
    public Enemy(String name, int maxHealth, int position) {
        super(name, maxHealth, position);
    }

    @Override
    public boolean getAttacked() {
        return false;
    }

    @Override
    public void respondToAttack() {

    }
}
