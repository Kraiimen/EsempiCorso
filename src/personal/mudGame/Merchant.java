package personal.mudGame;

public class Merchant extends NPC{
    //possibile array inventory del mercante?

    public Merchant (String name, int maxHP, int power, int expGiven, boolean isEnemy){
        super(name, 50, 15, 2, false);
    }
    @Override
    public void giveInstructions(Entity player){
        System.out.printf("Hey, %s, let me show you the best weapons in town... I'm sure a hero like you will be interested in buying some...", player.getName());
    }
}
