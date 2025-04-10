package mud.characters.fightable;

public class Priest extends PlayerCharacter {
    private static final int MIN_INTEL = 10;
    private static final int MIN_STRENGHT = 5;
    private static final int MIN_AGIL = 6;
    private static final int MAX_FAITH = 10;
    private int faith;

    public Priest(String name){
        super(name, MIN_INTEL, MIN_STRENGHT, MIN_AGIL, MIN);
        this.faith = dice.nextInt(MAX_FAITH);
    }

    //Nel prete l'attacco è influenzato dalla fede
    @Override
    public void attack(Character character) {
        int damage = checkFaith(getStrength());
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

    public int checkFaith(int damage){
        if(dice.nextInt(MAX_FAITH-faith) == 0){
            System.out.println("%s's intelligence makes his attack stronger!");
            return damage + 2;
        }
        return damage;
    }

}
