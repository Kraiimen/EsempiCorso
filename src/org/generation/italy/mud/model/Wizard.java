package org.generation.italy.mud.model;

public class Wizard extends MagicalCreature{
    protected int intelligence;
    protected final static int maxIntelligence = 100;
    public Wizard(String name, String description, int hp, int maxHp, int xp, String playerName,
                  int mana, int maxMana, int intelligence) {
        super(name, description, hp, maxHp, xp, playerName, mana, maxMana);
        this.intelligence = intelligence;
    }

    public void throwFireball() {
        if(random.nextInt(intelligence) > 30) {
            System.out.printf("%s throws a fireball!%n", name);
        } else {
            System.out.printf("%s fails to throw a fireball!%n", name);
        }
    }
}
