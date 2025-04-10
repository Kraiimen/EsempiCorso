package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Thief extends Player {
    private boolean isInvisible;
    public Thief(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, maxHealth, maxDamage, currentRoom);
    }

    @Override
    protected void initializeStats() {
        this.strength = this.random.nextInt(21);
        this.intelligence =  this.random.nextInt(21);
        this.agility = 5 + this.random.nextInt(21);
        this.stamina = this.random.nextInt(21);
    }

    @Override
    public void attack(Entity target) {
        int damage = strength + intelligence + agility + stamina;
        isInvisible = this.random.nextInt(100) < 25;
        if(isInvisible){
            damage *= 2;
            System.out.println(playerName + "Attacco critico al nemico. Danno: " + damage);
        }else{
            System.out.println(playerName +"Attacco il nemico. Danno: " + damage);
        }
        target.takeDamage(damage);
    }

    @Override
    void openInventory() {

    }

}
