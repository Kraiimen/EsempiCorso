package edoardo.projectMud.items;

import java.util.Random;

public class Weapon extends Item{
    private int bonusPhysicalAttack;
    private int bonusMagicAttack;
    static private Random r = new Random();
    static final public int MAX_BONUS_ATTACK = 10;

    public Weapon(double value, String name) {
        super(value, name);
    }

    public int getBonusMagicAttack() {
        return bonusMagicAttack;
    }
    public int getBonusPhysicalAttack(){
        return bonusPhysicalAttack;
    }


}
