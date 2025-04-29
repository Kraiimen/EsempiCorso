package org.generation.italy.mud.model;

public class Berserker extends Player {
    protected boolean isRaging;

    public Berserker(String name, String description, int hp, int maxHp, int xp, String playerName) {
        super(name, description, hp, maxHp, xp, playerName);

    }

    public void berserk() {
        if(random.nextInt(10) == 0) {
            isRaging = true;
            System.out.printf("%s is raging!%n", name);
        } else {
            System.out.printf("%s is not feeling it...%n", name);
        }

    }
}
