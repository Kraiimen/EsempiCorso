package mud.characters.fightable;

public class Priest extends Character {
    private static int minIntelligence = 10;
    private static int minStrenght = 5;
    private static int minAgility = 6;
    private static int minStamina = 10;

    public Priest(String name){
        super(name, minIntelligence, minStrenght, minAgility, minStamina);
    }

}
