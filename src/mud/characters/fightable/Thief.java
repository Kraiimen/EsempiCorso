package mud.characters.fightable;

public class Thief extends PlayerCharacter {
    private static int minIntelligence = 12;
    private static int minStrenght = 7;
    private static int minAgility = 13;
    private static int minStamina = 8;

    public Thief(String name){
        super(name, minIntelligence, minStrenght, minAgility, minStamina);
    }

}
