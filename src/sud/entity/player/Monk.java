package sud.entity.player;

import sud.entity.Entity;
import sud.exceptions.InvalidAttackException;

public class Monk extends Player {


    public Monk(String name, int maxHealth) {
        super(name, maxHealth, 3, getRandomIntValue(10, 21), getRandomIntValue(1, 13), getRandomIntValue(1, 6), getRandomIntValue(3, 7));
    }

    public void doubleStrike(Entity target) {
        if (!this.isAlive()) {
            throw new InvalidAttackException();
        } else if (!target.isAlive()) {
            System.out.println("Target is already dead");
            return;
        }
        System.out.println(this.getName() + " will hit " + target.getName() + " twice");
        target.getDamaged(damage);
        target.getDamaged(damage);
    }

    @Override
    public void attack(Entity target) {
        if (getRandomDoubleValue(0, 1) < 0.15) {
            doubleStrike(target);
            return;
        }
        super.attack(target);

    }
}
