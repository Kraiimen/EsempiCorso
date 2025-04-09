package mud.characters.fightable;

public class Paladin extends Character {
    private static int minIntelligence = 5;
    private static int minStrenght = 8;
    private static int minAgility = 10;
    private static int minStamina = 10;

    public Paladin(String name) {
        super(name, minIntelligence, minStrenght, minAgility, minStamina);
    }
}
