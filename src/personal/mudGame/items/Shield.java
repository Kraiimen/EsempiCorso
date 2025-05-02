package personal.mudGame.items;

public class Shield extends Item{
    private int plusProtection;

    public Shield(ItemType type, int plusProtection){
        super(ItemType.SHIELD);
        this.plusProtection = plusProtection;
    }

    public int getPlusProtection(){ return plusProtection; }
}
