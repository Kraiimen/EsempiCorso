package org.generation.italy.gryffindor.mud.game;

public class Entity {
    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    private String name;
    private int currentHealthPoint;
    private int maxHealthPoint;
    private int damage;

    // /-----------/ CONSTRUCTORS /-----------/
    public Entity(String name, int maxHealthPoint, int damage){
        this.name = name;
        this.maxHealthPoint = maxHealthPoint;
        this.currentHealthPoint = maxHealthPoint;
        this.damage = damage;
    }

    // /-----------/ METHODS /-----------/
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
        if(canNotAttack(target)) {
            return;
        }
        target.setCurrentHealthPoint(target.getCurrentHealthPoint() - getDamage());
        System.out.println(name +  " attacca " + target.name);

        if(target.isDead()){
            handleEnemyDeath(target);
        }
    }

    protected boolean canNotAttack(Entity target){
        return target == null || target.isDead();
    }

    public boolean isDead(){
        return currentHealthPoint <= 0;
    }
    protected void handleEnemyDeath(Entity target){
        target.death();
    }
    protected void death(){
        System.out.println(name + " è morto");
    }


    // /-----------/ METHODS - GETTER & SETTER /-----------/
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
    public int getDamage(){
        return damage;
    }

    public void setDamage(int dmg) {
        if(dmg >= 0){
            damage = dmg;
        }
    }
}
