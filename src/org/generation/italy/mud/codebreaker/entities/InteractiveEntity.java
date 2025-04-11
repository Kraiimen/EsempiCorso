package org.generation.italy.mud.codebreaker.entities;

import java.util.Random;

public abstract class InteractiveEntity extends Entity {
    private int stamina;
    private int strength;
    private int agility;
    private int intelligence;

    private int attack;
    private int defend;


    private boolean isAlive;
    private Random random = new Random();

    public InteractiveEntity(int agility,int stamina, int strength, int intelligence){
        this.stamina = stamina;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        this.attack = strength;
        this.defend = stamina;
        setMaxHp(stamina * 3);
        isAlive = true;
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
        isAlive = true;
    }




    public void attack(InteractiveEntity target){
        if(isDodging(this)){
            System.out.println(target.getCharacterName() + "ha schivato l'attacco!");
        } else {
            double damage = (int)(this.attack * (100.0 / (100.0 + target.defend)));
            target.suffer((int)damage);
            System.out.println(target.getCharacterName() + " ha subito " + damage + " danni" );
            target.isAlive();
        }
    }

    public void getAttacked(InteractiveEntity attacker){
        if(isDodging(attacker)){
            System.out.println(getCharacterName() + " è riuscito a schivare l'attacco");
            return;
        }
        int damage = (int) (attack * (100.0 / (100 + defend)));
        this.suffer(damage);
    }

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
    public boolean isAlive(){
        return getCurrentHealth() > 0;

    }
    public void engageFight(InteractiveEntity target){
        System.out.println("Hai attaccato " + target.getCharacterName() + " furtivamente.");
        int dodge = random.nextInt(target.agility);
        System.out.println("Hai rollato " + dodge + " su " +agility+ " in base alla tua agilità.");
        int hit = random.nextInt(target.agility);
        System.out.println(target.getCharacterName() + " ha rollato " + hit + " su " + target.agility +".");

        if(hit > dodge){
            attack(target);
        }
        while(isAlive && target.isAlive){
            attack(target);
            target.isAlive = isAlive();
            if(!target.isAlive){
                break;
            }
            getAttacked(this);
            isAlive = isAlive();
        }
        if(!isAlive){
            System.out.println("Il Garbage collector è passato ed ha spazzato via la tua anima.");
        }
        if(!target.isAlive)
            System.out.println("Hai rimosso un file.class da CodeTopia");
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
    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    }
