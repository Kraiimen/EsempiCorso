package org.generation.italy.edenGame.entity.Enemies;

public class Monster extends Enemies{
    public Monster(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }

    @Override
    public void dead() {
        System.out.println("Hai ucciso una Mostro! Hai guadagnato: +50 exp");
    }
}
