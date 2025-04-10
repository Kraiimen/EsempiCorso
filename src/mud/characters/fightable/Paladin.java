package mud.characters.fightable;

import mud.characters.Entity;
import mud.characters.npcs.Civilian;
import personal.mudGame.Player;

public class Paladin extends PlayerCharacter {
    private static final int MIN_INTEL = 3;
    private static final int MIN_STRENGTH = 8;
    private static final int MIN_AGIL = 10;
    private boolean isVirgin = true;

    public Paladin(String name) {
        super(name, MIN_INTEL, MIN_STRENGTH, MIN_AGIL,MIN);
    }

    //Nel paladino, l'attacco è influenzato dal suo essere vergine o meno e dalla sua intelligenza
    @Override
    public void attack(Character character) {
        int damage = checkPaladin(getStrength());
        System.out.printf("%s is attacking %s for %d points%n", getName(), character.getName(), damage);
        if(character.tryToDodge()){
            damage = 0;
            System.out.println(character.getName() + " dodged the attack!");
        }
        character.hurt(damage);
        if(character.checkIfAlive()){
            System.out.printf("%s has now %d lives%n", character.getName(), character.getHp());
        }
    }

    public int checkPaladin(int damage) {
        if (!isVirgin && (dice.nextInt(getIntelligence()) == 0)){
            System.out.println(getName() + "'s attack is weaker, because his heart is corrupted!");
            return damage/2;
        }
            return damage;
    }

    public void loseVirginity(Entity entity){
        isVirgin = false;
        System.out.println(getName() + " lost his virginity with " + entity.getName());
    }
}
