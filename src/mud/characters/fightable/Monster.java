package mud.characters.fightable;

public abstract class Monster extends Character {
    private int minExpToFight;
    public Monster(String name, int minIntelligence, int minStrenght, int minAgility, int minStamina) {
        super(name, minIntelligence, minStrenght, minAgility, minStamina);
    }
}
