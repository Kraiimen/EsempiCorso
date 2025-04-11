package capstoneproject.entity;

import capstoneproject.rooms.Room;

public class Wizard extends Player {

    private boolean isBeardLong;

    public Wizard(String name, int maxHealth, int maxDamage, Room currentRoom) {
        super(name, maxHealth, maxDamage, currentRoom);


    }

    @Override
    public void initializeStats() {
        this.strength = this.random.nextInt(21);
        this.intelligence = this.random.nextInt(5,21);
        this.agility = this.random.nextInt(21);
        this.stamina = this.random.nextInt(21);
        System.out.println("Statistiche iniziali generate:");
        System.out.println("Forza: " + strength);
        System.out.println("Intelligenza: " + intelligence);
        System.out.println("Agilità: " + agility);
        System.out.println("Resistenza: " + stamina);
    }

    @Override
    public void attack(Entity target) {
        int damage = strength + intelligence + agility + stamina;
        isBeardLong = this.random.nextInt(100) <= 25;
        if(isBeardLong){
            damage *= 2;
            System.out.println(getName() + "Attacco critico al nemico. Danno: " + damage);
        }else{
            System.out.println(getName() +"Attacco il nemico. Danno: " + damage);
        }
        target.takeDamage(damage);
    }


    @Override
    void openInventory() {

    }

}
