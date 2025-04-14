package sud.start;

import sud.entity.Entity;
import sud.entity.npc.Npc;
import sud.entity.player.Player;

public class BattleManager {
    Entity entity1;
    Entity entity2;

    public void startBattle(Entity entity1, Entity entity2) {
        while (entity1.isAlive() && entity2.isAlive()) {
            entity1.attack(entity2);
            if (entity2.isAlive()) {
                entity2.attack(entity1);
            }
        }
        Entity winner;
        Entity loser;
        if (entity1.isAlive()) {
            winner = entity1;
            loser = entity2;
        } else {
            winner = entity2;
            loser = entity1;
        }
        System.out.println(winner.getName() + " killed " + loser.getName());
        if (winner instanceof Player) {
            if (loser instanceof Npc) {
                ((Player) winner).obtainExperience(((Npc) loser).getExpOnKill());
            }
        }
    }
}
