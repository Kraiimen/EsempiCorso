package edoardo.projectMud.npc;

public class Guard extends Npc{
    public Guard(String name, int strength, int maxHp, double money) {
        super(name, strength, maxHp, money);
        setClassTipology("Guard");
        setName("Alfred");
    }

    public Guard() {
        super(13,16,120,170,40,100);
        setName("Carl");
    }


}
