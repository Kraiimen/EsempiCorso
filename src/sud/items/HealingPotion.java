package sud.items;

import sud.entity.Entity;

import static sud.entity.Entity.resetColor;

public class HealingPotion extends Potion{
    private int healingFactor;

    public HealingPotion(int price, ItemType type, String name, int healingFactor) {
        super(price, type, name);
        this.healingFactor = healingFactor;
    }

    public void use(Entity drinker){
        drinker.heal(healingFactor);
        System.out.printf(drinker.getEntityColor()+"%s drinks the %s, and regains %d health points"+ resetColor, drinker.getName(),this.getName(),healingFactor);
    }

    public int getHealingFactor() {
        return healingFactor;
    }

    public void setHealingFactor(int healingFactor) {
        this.healingFactor = healingFactor;
    }
}
