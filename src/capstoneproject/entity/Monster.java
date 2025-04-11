package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Monster extends Npc{
    private boolean hasRing;
    public Monster(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, maxHealth, maxDamage, currentRoom);
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
        int damage = strength + intelligence + agility + stamina;
        System.out.println(getName() +"Attacca il player. Danno: " + damage);
        target.takeDamage(damage);
    }

}
