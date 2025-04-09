package sud.items;

public class HealingPotion extends Potion{
    private int healingFactor;

    public HealingPotion(int price, ItemType type, String name, int healingFactor) {
        super(price, type, name);
        this.healingFactor = healingFactor;
    }

    public int getHealingFactor() {
        return healingFactor;
    }

    public void setHealingFactor(int healingFactor) {
        this.healingFactor = healingFactor;
    }
}
