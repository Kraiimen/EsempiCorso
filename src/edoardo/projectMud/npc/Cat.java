package edoardo.projectMud.npc;

public class Cat extends Npc{
    public Cat(String name, int strength, int maxHp, double money) {
        super(name, strength, maxHp, money);
    }

    public Cat() {
        super(0, 13, 0, 150, 0, 20);
        setName("GATTOOOO");

    }


}
