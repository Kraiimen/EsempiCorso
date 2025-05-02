package personal.mudGame.items;

public class Wand extends Weapon{
    int manaPlus;

    public Wand(int powerPlus, int manaPlus) {
        super(powerPlus);
        this.manaPlus = manaPlus;
    }

    public int getManaPlus(){
        return manaPlus;
    }
}
