package mud.characters.fightable;

import personal.mudGame.Player;

public class Wizard extends PlayerCharacter {
    private static final int MIN_INTEL = 15;
    private static final int MIN_STRENGTH = 8;
    private static final int MIN_AGIL = 5;

    public Wizard(String name){
        super(name, MIN_INTEL, MIN_STRENGTH, MIN_AGIL, MIN);
    }

    //l'attacco del mago dipenderà dalla stamina
    @Override
    public void attack(Character character) {
        int damage = getStrength();
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

}
