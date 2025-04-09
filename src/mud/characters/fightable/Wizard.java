package mud.characters.fightable;

public class Wizard extends Character {
    private static int minIntelligence = 15;
    private static int minStrenght = 8;
    private static int minAgility = 5;
    private static int minStamina = 12;

    public Wizard(String name){
        super(name, minIntelligence, minStrenght, minAgility, minStamina);
    }

}
