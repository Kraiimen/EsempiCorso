package org.generation.italy.mud.codebreaker.entities;

import java.util.Random;

public abstract class InteractiveEntity extends Entity {
    private int stamina;
    private int strength;
    private int agility;
    private int intelligence;
    private int attack;
    private int defend;

    private Random random = new Random();

    public InteractiveEntity(int agility,int stamina, int strength, int intelligence){
        this.stamina = stamina;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        this.attack = strength;
        this.defend = stamina;
        setMaxHp(stamina * 4);
    }

    public InteractiveEntity(String characterName,  int agility,int stamina, int strength, int intelligence){
        super(characterName);

        this.stamina = stamina;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        this.attack = strength;
        this.defend = stamina;
        setMaxHp(stamina * 3);
    }




    public void attack(InteractiveEntity target){
        if(isDodging(this)){
            System.out.println(target.getCharacterName() + " \u001B[32mha schivato l'attacco!\u001B[0m");

        } else {
            int damage = (int)(this.attack * (100.0 / (100.0 + target.defend)));
            target.suffer(damage);
            System.out.println(target.getCharacterName() + " ha subito \u001B[31m" + damage + " danni\u001B[0m");

            System.out.println(target.printHpBar());
            target.checkAlive();
        }
    }

//    public void getAttacked(InteractiveEntity attacker){
//        if(isDodging(this)){
//            System.out.println(this.getCharacterName() + " è riuscito a schivare l'attacco");
//            return;
//        }
//        int damage = (int) (attack * (100.0 / (100 + defend)));
//        this.suffer(damage);
//    }

    public boolean isDodging(InteractiveEntity attacker){
        boolean miss = false;
        int attackerAccuracy = random.nextInt(attacker.agility);
        int targetDodgeRate = random.nextInt(this.agility);
        if(targetDodgeRate > attackerAccuracy){
           miss = Math.random() < 0.3 + 0.02 * (targetDodgeRate - attackerAccuracy);
        }
        return miss;
    }

    public void suffer(int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
    }

    public void healing(int heal){
        setCurrentHealth(getCurrentHealth() + heal);
        if(getCurrentHealth() > getMaxHp()){
            setCurrentHealth(getMaxHp());
        }
    }
    public boolean checkAlive(){
        return getCurrentHealth() > 0;

    }
    public void engageFight(InteractiveEntity attacker){
        try {
            System.out.println(attacker.getCharacterName() + " Ha attaccato " + getCharacterName() + " furtivamente.");
            int dodge = random.nextInt(agility);
            Thread.sleep(500);
            System.out.println(getCharacterName() + " ha rollato " + dodge + " su " +attacker.agility+ " in base alla sua agilità.");
            Thread.sleep(500);
            int hit = random.nextInt(attacker.agility);
            System.out.println(attacker.getCharacterName() + " ha rollato " + hit + " su " + attacker.agility +" in base alla sua agilità.");
            Thread.sleep(500);

            if(hit > dodge){
                attacker.attack(this);
                Thread.sleep(500);
            }
            while(this.checkAlive() && attacker.checkAlive()){
                attacker.attack(this);
                Thread.sleep(500);
                if(!this.checkAlive()){
                    break;
                }
                attack(attacker);
                Thread.sleep(500);
            }
            if(!attacker.checkAlive()){
                System.out.println("Il Garbage collector è passato ed ha spazzato via la tua anima.");
            }
            if(!this.checkAlive())
                System.out.println("Hai rimosso un file.class da CodeTopia");
                System.out.println("--------------------------------------");
        }catch (InterruptedException e){
            System.out.println("Qualcosa è andato storto durante il combattimento");
            System.out.println("-------------------------------------------------");
        }
    }



    public void getAttacked(InteractiveEntity target){
        try {
            System.out.println(getCharacterName() + " Ha attaccato " + target.getCharacterName() + " furtivamente.");
            int dodge = random.nextInt(target.agility);
            Thread.sleep(500);
            System.out.println(getCharacterName() + "Ha rollato " + dodge + " su " + agility + " in base alla sua agilità.");
            Thread.sleep(500);
            int hit = random.nextInt(target.agility);
            System.out.println(target.getCharacterName() + " ha rollato " + hit + " su " + target.agility +".");
            Thread.sleep(500);

            if(hit > dodge){
                attack(target);
                Thread.sleep(500);
            }
            while(this.checkAlive() && target.checkAlive()){
                attack(target);
                Thread.sleep(500);
                if(!target.checkAlive()){
                    break;
                }
                target.attack(this);
                Thread.sleep(500);
            }
            if(!target.checkAlive()){
                System.out.println("Il Garbage collector è passato ed ha spazzato via la tua anima.");
            }
            if(!this.checkAlive())
                System.out.println("Hai rimosso un file.class da CodeTopia");
        }catch (InterruptedException e){
            System.out.println("Qualcosa è andato storto durante il combattimento");
        }
    }


    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getAgility(){
        return agility;
    }
    public void setAgility(int agility){
        this.agility = agility;
    }
    public void setDefend(int defend){
        this.defend = defend;
    }
    public int getDefend(){
        return defend;
    }
    public int getStamina(){
        return stamina;
    }
    public int getStrength(){
        return strength;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public void setStamina(int stamina){
        this.stamina = stamina;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }

    }
