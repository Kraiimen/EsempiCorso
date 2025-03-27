package org.generation.italy.gryffindor.mud.game;

public class Entity {
    private String name;
    private int currentHealthPoint;
    private int maxHealthPoint;


    public Entity(String name, int maxHealthPoint){
        this.name = name;
        this.maxHealthPoint = maxHealthPoint;
        this.currentHealthPoint = maxHealthPoint;
    }

    public void sleep(){
        regenHP(0.2);
    }
    public void eat(){
        regenHP(0.3);
    }
    private void regenHP(double percent){
        int missingHP = maxHealthPoint - currentHealthPoint;
        int regenHP = (int)(missingHP * percent);
        currentHealthPoint = currentHealthPoint + regenHP;
    }
    public void attack(Entity target){
        if(target != null){
            System.out.println(name +  " attacca " + target.name);
        }
    }



    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    public int getCurrentHealthPoint(){
        return currentHealthPoint;
    }
    public void setCurrentHealthPoint(int hp){
        if(hp <= maxHealthPoint ){
            currentHealthPoint = hp;
        }
    }
    public int getMaxHealthPoint(){
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxhp) {
        if(maxhp > 0){
            maxHealthPoint = maxhp;
        }
    }
}
