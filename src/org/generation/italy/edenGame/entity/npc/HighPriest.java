package org.generation.italy.edenGame.entity.npc;

import org.generation.italy.edenGame.entity.player.Player;

public class HighPriest extends Npc{
    public HighPriest(String name, int maxHp, int healthPoints, int damage, int exp) {
        super(name, maxHp, healthPoints, damage, exp);
    }
    @Override
    public void speak(Player player) {
        System.out.println("Ricevi la benedizione del Sacerdote per aumentare le tue abilità");
        player.setExp(player.getExp() - 10);
        player.setDamage(player.getDamage() + 5);
        player.setIntelligence(player.getIntelligence() + 10);
        player.setStrength(player.getStrength() + 10);
        player.setAgility(player.getAgility() + 10);
        player.setStamina(player.getStamina() + 10);
        player.setMaxHp(player.getMaxHp() + 5);
        player.setHealthPoints(player.getMaxHp());
    }

}
