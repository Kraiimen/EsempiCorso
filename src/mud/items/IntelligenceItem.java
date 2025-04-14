package mud.items;

public class IntelligenceItem extends Item {
    private int intelligenceGiven;
    private String message;
    public IntelligenceItem(String name, int intelligenceGiven, String message) {
        super(name);
        this.intelligenceGiven = intelligenceGiven;
        this.message = message;
    }

    public int getIntelligenceGiven() {
        return intelligenceGiven;
    }

    public void setIntelligenceGiven(int intelligenceGiven) {
        this.intelligenceGiven = intelligenceGiven;
    }
}
