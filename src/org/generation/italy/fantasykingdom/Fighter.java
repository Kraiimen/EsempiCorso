package org.generation.italy.fantasykingdom;

public interface Fighter {

    public abstract void attack(Fighter target);

    public abstract boolean isAlive();

    public abstract void receiveAttack(int attackDamage);

}
