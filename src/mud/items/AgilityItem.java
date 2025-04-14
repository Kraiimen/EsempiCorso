package mud.items;

public class AgilityItem extends Item{
    private int agilityGiven;
    public AgilityItem(String name, int agilityGiven) {
        super(name);
        this.agilityGiven = agilityGiven;
    }

    public int getAgilityGiven() {
        return agilityGiven;
    }

    public void setAgilityGiven(int agilityGiven) {
        this.agilityGiven = agilityGiven;
    }
}
