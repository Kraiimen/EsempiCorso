package org.generation.italy.edenGame.entity.player;

import org.generation.italy.edenGame.entity.Enemies.Enemies;
import org.generation.italy.edenGame.entity.Entity;
import org.generation.italy.edenGame.item.Item;
import org.generation.italy.edenGame.room.Room;
import org.generation.italy.edenGame.room.Temple;
import org.generation.italy.edenGame.room.Compass;

import java.util.HashMap;
import java.util.Map;


public class Player extends Entity {

    private String playerName;
    private int intelligence;
    private int strength;
    private int agility;
    private int stamina;
    private Room currentRoom;

    public Player(String name, int maxHp, int healthPoints, int damage, int exp, Room currentRoom, String playerName, int intelligence, int strength, int agility, int stamina) {

        super(name, maxHp, healthPoints, damage, exp);
        this.playerName = playerName;
        this.intelligence = intelligence;
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.currentRoom = currentRoom;
    }

    @Override
    public void dead() {
        System.out.println("Sei morto");
        setExp(getExp() - 1);

    }

    @Override
    public void attack(Entity target) {
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getStamina() {
        return stamina;
    }


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        System.out.println("--------/ " + currentRoom.getNameRoom()  + " /--------");
        currentRoom.printDescription();
        currentRoom.setCheckEnemies(true);
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void useErbaGatta (){
        System.out.println(" ");
        System.out.println("Mangi della deliziosa erba gatta🪴 e recuperi 20 hp");
        setHealthPoints(getMaxHp());
        System.out.println(" ");
    }
    public void useChiavePrigioni(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Ricatti il sommo sacerdote minacciando di aprire le prigioni con la tua chiave🔐 se non ti conferisce la più sacra delle benedizioni " +
                "(aumentano tutte le tue statistiche di molto🔧)");
        setDamage(getDamage() + 10);
        setIntelligence(getIntelligence() + 20);
        setStrength(getStrength() + 20);
        setAgility(getAgility() + 20);
        setStamina(getStamina() + 20);
        setMaxHp(getMaxHp() + 10);
        System.out.println(" ");
        System.out.println(" ");
    }
    public void useSpadaDiEden(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");
        System.out.println("🔥⚔️🔥 TROVI LA ✨LEGGENDARIA✨ SPADA DI EDEN LA IMPUGNI E TI SENTI INVINCIBILE 🔥⚔️🔥");
        System.out.println(" ");
        setDamage(300);
        setMaxHp(300);
        setHealthPoints(300);
        System.out.println("Questi sono i danni che infliggerai: " + getDamage() + "Questa è la grandezza della tua vita: "+ getMaxHp());
        System.out.println(" ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
