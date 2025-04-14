package sud.entity.player;

import sud.entity.Entity;
import sud.exceptions.InvalidAttackException;

public class Wizard extends Player {


    public Wizard(String name, int maxHealth) {
        super(name, maxHealth, 4, getRandomIntValue(13, 21), getRandomIntValue(1, 7), getRandomIntValue(1, 10), getRandomIntValue(3, 11));

    }

    public void throwFireBall(Entity target) {

        if (!this.isAlive()) {
            throw new InvalidAttackException();
        } else if (!target.isAlive()) {
            System.out.println("Target is already dead");
            return;
        }
        System.out.println(this.getName() + " threw a fire ball");
        target.getDamaged((int) (damage * 1.5));

    }

    @Override
    public void attack(Entity target) {
        if (getRandomDoubleValue(0, 1) < 0.4) {
            throwFireBall(target);
            return;
        }
        super.attack(target);
    }
}
