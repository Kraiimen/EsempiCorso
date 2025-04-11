package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Guards extends Npc{
    private static final int MAX_HEALTH = 20;
    private static final int MAX_DAMAGE = 20;

    public Guards(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, MAX_HEALTH, MAX_DAMAGE, currentRoom);
    }

    @Override
    protected void inizialateStatsNpc() {
        this.strength = 10;
        this.intelligence = 10;
        this.agility = 10;
        this.stamina = 10;
    }
    @Override
    public void attack(Entity target) {
        if (!isRage) {
            System.out.println(getName() + " è calma e non attacca.");
            return;
        }

        int damage = 100;
        System.out.println(getName() + " è furiosa! Attacca il player. Danno: " + damage);
        target.takeDamage(damage);
    }

    public void sawCatDie(Entity target) {
        if (!this.isDead()) { // Se la guardia è viva
            if (!isRage) { // Se non è già arrabbiata
                isRage = true;  // La guardia entra in rage
                System.out.println(getName() + " è arrabbiata e attacca subito!");
                this.attack(target); // La guardia attacca il player automaticamente
            }
        }
    }
}
