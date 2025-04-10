package mud.items;

public class Food extends Item{
    private int hpGiven;

    public Food(String name, int hpGiven) {
        super(name);
        this.hpGiven = hpGiven;
    }

    public int getHpGiven() {
        return hpGiven;
    }
    public void setHpGiven(int hpGiven) {
        this.hpGiven = hpGiven;
    }
}
