package personal.mudGame;

public class Baker extends NPC{
    public Baker(String name, int maxHP, int power, int expGiven, boolean isEnemy){
        super(name, 50, 10, 1, false);
    }
    @Override
    public void giveInstructions(Entity player){
        System.out.printf("Hello adventurer %s! Would you like some bread?", player.getName());
    }
}
