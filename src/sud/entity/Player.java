package sud.entity;

import sud.rooms.Room;

public class Player extends Entity{
    private int intelligence;
    private int strength;
    private int dexterity;
    private int Constitution;
    private int xp;
    private int coins;

    public Player(String name, int maxHp, int attackDamage, Room currentroom, String entityColor, int intelligence, int strength, int dexterity, int constitution) {
        super(name, maxHp, attackDamage, currentroom, entityColor);
        if(intelligence > 0 && intelligence <21){ this.intelligence = intelligence;}else{intelligence = 10;}
        if(strength > 0 && strength <21){ this.strength = strength;}else{strength = 10;}
        if(dexterity > 0 && dexterity <21){ this.dexterity = dexterity;}else{dexterity = 10;}
        if(Constitution > 0 && Constitution <21){ this.Constitution = Constitution;}else{intelligence = 10;}
    }
}
