package mudgame.entities;

public class Player extends Entity implements Talkable{
    private String playerCharName;

    public Player(String name, int hp, String playerCharName) {
        super(name, hp);
        this.playerCharName = playerCharName;
    }

    @Override
    public void talk() {
        System.out.println("Player sta parlando...");
    }

    public void attackPlayer(Player playerToAtk){
        System.out.println(getName() + " vuole combattere con " + playerToAtk.getName());
        System.out.println(playerCharName + " sta attaccando " + playerToAtk.playerCharName);
    }
}
