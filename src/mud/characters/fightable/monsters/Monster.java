package mud.characters.fightable.monsters;

import mud.characters.fightable.Character;
import mud.characters.fightable.PlayerCharacter;
import mud.items.Item;
import mud.rooms.Room;

import java.util.List;

public abstract class Monster extends Character {
    private int expGiven;

    public Monster(String name) {
        super(name);
    }

    //funzione dell'attacco sempre uguale per i mostri, faccio un template con le descrizioni del combat da stampare
    //ci sono forza, agilità e intelligenza da sfruttare per calcolare il danno fatto, manca l'intelligenza
    @Override
    public void attack(Character character){
        int damage = getStrength();
        System.out.printf("%s is attacking %s for %d points%n", getName(), character.getName(), damage);
        if(character.tryToDodge()){
            damage = 0;
            System.out.println(character.getName() + " dodged the attack!");
        }
        character.hurt(damage);
        if(character.checkIfAlive()){
            System.out.printf("%s has now %d lives%n", character.getName(), character.getHp());
        }
    }

    @Override
    public void die(){
        setHp(MIN);
        setIsAlive(false);
        getActualRoom().getPresentEntities().remove(this.getName());
        getActualRoom().getPresentMonsters().remove(this);
        System.out.println(getName() + " is dead.");
        if(!getInventory().isEmpty()){
            List<Item> inventory = getInventory().values().stream().toList();
            inventory.forEach(i -> getActualRoom().getPresentItems().put(i.getName(), i));
            getInventory().clear();
            System.out.println(getName() + " lost all his belongings dying.");
        }
    }

    public int getExpGiven() {
        return expGiven;
    }
    public void setExpGiven(int expGiven) {
        this.expGiven = expGiven;
    }



}
