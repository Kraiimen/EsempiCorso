package sud.items;

import sud.entity.Entity;

import static sud.entity.Entity.resetColor;

public class HealingPotion extends Potion{
    private int healingFactor;

    public HealingPotion(int price, String name, int healingFactor) {
        super(price, name);
        this.healingFactor = healingFactor;
    }

    public void use(Entity drinker){

        System.out.printf(drinker.getEntityColor()+"%s drinks the %s, and regains %d health points\n"+ resetColor, drinker.getName(),this.getName(),healingFactor);
        drinker.heal(healingFactor);
    }

    public int getHealingFactor() {
        return healingFactor;
    }

    public void setHealingFactor(int healingFactor) {
        this.healingFactor = healingFactor;
    }
}
