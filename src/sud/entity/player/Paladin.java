package sud.entity.player;

import sud.entity.Entity;
import sud.exceptions.InvalidAttackException;

public class Paladin extends Player {

    public Paladin(String name, int maxHealth) {
        super(name, maxHealth, 2, getRandomIntValue(6, 16), getRandomIntValue(10, 18), getRandomIntValue(1, 10), getRandomIntValue(12, 20));
    }

    public void HolyStrike(Entity target) {
        if (!this.isAlive()) {
            throw new InvalidAttackException();
        } else if (!target.isAlive()) {
            System.out.println("Target is already dead");
            return;
        }
        System.out.println(this.getName() + " hit " + target.getName() + " with his holy powers");
        target.getDamaged((int) (damage * 1.75));
    }

    @Override
    public void attack(Entity target) {
        if (getRandomDoubleValue(0, 1) < 0.2) {
            HolyStrike(target);
            return;
        }
        super.attack(target);
    }
}
