package sud.entity.npc;

import sud.entity.Attackable;
import sud.entity.Entity;


public class Cat extends Npc implements Attackable {

    public Cat() {
        super("cat", getRandomIntValue(5, 10), getRandomIntValue(1, 2));
        this.expOnKill = 2;
    }

    @Override
    public boolean getAttacked() {
        return true;
    }

    @Override
    public void respondToAttack() {
        System.out.println("Mmmmeow you bastard!");
    }

    @Override
    public void attack(Entity target) {
//        if (!isAlive()) {
//            throw new InvalidAttackException();
//        } else if (!target.isAlive()) {
//            System.out.println("Target is already dead");
//            return;
//        } else {

        if (getRandomIntValue(1, 10) < 6) {
            System.out.println(this.getName() + " scratched " + target.getName());
            target.getDamaged(damage);
        } else {
            System.out.println(this.getName() + " is purring");
        }
    }
}
