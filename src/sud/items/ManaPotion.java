package sud.items;

import sud.entity.Entity;
import sud.entity.classes.*;
import static sud.entity.Entity.resetColor;

public class ManaPotion extends Potion{
    private int manaPointsRestore;

    public ManaPotion(int price, String name, int manaPointsRestore) {
        super(price, name);
        this.manaPointsRestore = manaPointsRestore;
    }

    public void use(Entity drinker){
        try{
            Wizard wiz = (Wizard)drinker;

            System.out.printf(drinker.getEntityColor()+"%s drinks the %s, and regains %d mana points\n"+ resetColor, drinker.getName(),this.getName(),manaPointsRestore);
            wiz.restoreMana(manaPointsRestore);
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
