package sud.inventory;

import sud.entity.Entity;

public class HealingItem extends Item implements UsableItem {
    int healAmount;
    int cost;

    public HealingItem(String name, int healAmount, int cost) {
        super(name, cost);
        this.healAmount = healAmount;
    }

    @Override
    public void use(Entity target) {
        System.out.println(target.getName() + " used 1 " + name);
        target.getHealed(healAmount);
    }
}
