package sud.inventory;

public class ItemFactory {

    public static HealingItem makePretzel() {
        return new HealingItem("Pretzel", 7, 1);
    }

    public static HealingItem makeBread() {
        return new HealingItem("Bread", 9, 2);
    }

    public static HealingItem makeHolyWater() {
        return new HealingItem("Holy water", 3, 3);
    }

    public static HealingItem makeMeatStew() {
        return new HealingItem("Meat stew", 20, 5);
    }
}
