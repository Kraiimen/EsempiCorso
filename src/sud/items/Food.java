package sud.items;

public class Food extends Item{
    private int healingFacotr;

    public Food(int price, String name, int healingFacotr) {
        super(price, ItemType.FOOD, name);
        this.healingFacotr = healingFacotr;
    }

    public int getHealingFacotr() {
        return healingFacotr;
    }

    public void setHealingFacotr(int healingFacotr) {
        this.healingFacotr = healingFacotr;
    }
}
