package mudgame.entities;

public class Npc extends Entity implements Talkable{

    public Npc(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void talk() {
        System.out.println("NPC sta parlando...");
    }
}
