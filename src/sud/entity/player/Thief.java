package sud.entity.player;

import sud.entity.Entity;
import sud.exceptions.InvalidAttackException;

public class Thief extends Player {

    public Thief(String name, int maxHealth) {
        super(name, maxHealth, 3, getRandomIntValue(7, 15), getRandomIntValue(3, 14), getRandomIntValue(7, 12), getRandomIntValue(6, 12));
    }

    public void throwSmokeBomb(Entity target) { //the bomb kills the target instantly
        if (!this.isAlive()) {
            throw new InvalidAttackException();
        } else if (!target.isAlive()) {
            System.out.println("Target is already dead");
            return;
        }
        System.out.println(this.getName() + " threw a smoke bomb");
        target.getDamaged((int) (target.getHealth() * 0.4));

    }

    @Override
    public void attack(Entity target) {
        if (getRandomDoubleValue(0, 1) < 0.2) {
            throwSmokeBomb(target);
            return;
        }
        super.attack(target);
    }
}
