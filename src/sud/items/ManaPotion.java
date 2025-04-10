package sud.items;

import sud.entity.Entity;
import sud.entity.classes.*;
import static sud.entity.Entity.resetColor;

public class ManaPotion extends Potion{
    private int manaPointsRestore;

    public ManaPotion(int price, ItemType type, String name, int manaPointsRestore) {
        super(price, type, name);
        this.manaPointsRestore = manaPointsRestore;
    }

    public void use(Entity drinker){
        try{
            Wizard wiz = (Wizard)drinker;
            wiz.restoreMana(manaPointsRestore);
            System.out.printf(drinker.getEntityColor()+"%s drinks the %s, and regains %d mana points"+ resetColor, drinker.getName(),this.getName(),manaPointsRestore);
        }catch(ClassCastException e){
            System.out.printf(drinker.getEntityColor()+"%s drinks the %s, but nothing happens"+ resetColor, drinker.getName(),this.getName());
        }

    }

    public int getHealingFactor() {
        return manaPointsRestore;
    }

    public void setHealingFactor(int manaPointsRestore) {
        this.manaPointsRestore = manaPointsRestore;
    }
}
