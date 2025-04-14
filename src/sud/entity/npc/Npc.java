package sud.entity.npc;

import sud.entity.Entity;

public abstract class Npc extends Entity {
    protected int expOnKill;

    public Npc(String name, int maxHealth, int damage) {
        super(name, maxHealth, damage);
    }

    public int getExpOnKill() {
        return expOnKill;
    }
}
