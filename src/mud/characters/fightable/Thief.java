package mud.characters.fightable;

public class Thief extends PlayerCharacter {
    private static int minIntelligence = 12;
    private static int minAgility = 16;

    public Thief(String name){
        super(name, minIntelligence, minAgility, MIN);
    }

    //l'attacco del ladro dipenderà dall'intelligenza
    @Override
    public void attack(Character character) {
        int damage = checkBrain(getStrength());
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

    public int checkBrain(int damage){
        if(dice.nextInt(MAX-getIntelligence()) == 0){
            return damage *2;
        }
        return damage;
    }

}
