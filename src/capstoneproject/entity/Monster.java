package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Monster extends Npc{
    private boolean hasRing;

    private static final int MAX_HEALTH = 80;
    private static final int MAX_DAMAGE = 40;

    public Monster(String name, Room currentRoom) {
        super(name,MAX_HEALTH, MAX_DAMAGE, currentRoom);
    }

    @Override
    protected void inizialateStatsNpc() {
        this.strength = 30;
        this.intelligence = 1;
        this.agility = 15;
        this.stamina = 20;
    }

    @Override
    public void attack(Entity target) {
        int damage = strength;
        System.out.println(getName() +"Attacca il player. Danno: " + damage);
        target.takeDamage(damage);
    }

}
