package org.generation.italy.edenGame.item;

import org.generation.italy.edenGame.entity.player.Player;

public class ChiaveDellePrigioni extends Item{
    public ChiaveDellePrigioni(String name) {
        super(name);
    }

    @Override
    public void use(Player player) {
        System.out.println("Ricatti il sommo sacerdote minacciando di aprire le prigioni con la tua chiave se non ti conferisce la più sacra delle benedizioni " +
                "(aumentano tutte le tue statistiche di molto)");
        player.setDamage(player.getDamage() + 10);
        player.setIntelligence(player.getIntelligence() + 20);
        player.setStrength(player.getStrength() + 20);
        player.setAgility(player.getAgility() + 20);
        player.setStamina(player.getStamina() + 20);
        player.setMaxHp(player.getMaxHp() + 10);
    }
    //TODO stampi che fai un ricatto e se il sacerdote non ti dà il doppio delle statistiche tu apri le prigioni, basta che le aumentiamo da qui
}
