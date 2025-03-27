package org.generation.italy.gryffindor.mud.game;

public class Entity {

   //       /-----/-VARIABLES-/-----/
    private String name;
    private int currentHealthPoint;
    private int maxHealthPoint;

    //       /-----/-CONSTRUCTORS-/-----/
    public Entity(String name, int maxHealthPoint) {
        this.name = name;
        this.maxHealthPoint = maxHealthPoint;
        currentHealthPoint = maxHealthPoint;
    }



    //       /-----/-METHODS-/-----/
    public void sleep() {
        regenHP(0.2);
    }
    public void eat() {
        regenHP(0.3);
    }
    private void regenHP(double percent) {
        int missingHP = maxHealthPoint - currentHealthPoint;
        int regenHP = (int)(missingHP * percent);
        currentHealthPoint += regenHP;
    }
    public void attack(Entity target) {
        if (target != null) {  // Altrimenti se gli passassi un target null sarebbe un problema
            System.out.println(name + " attacca " + target.name);
        }
    }




    //       /--------/ METHODS-/--------/GETTER & SETTER/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }
    public void setCurrentHealthPoint(int currentHealthPoint) {
        if (currentHealthPoint <= maxHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }
    }
    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }
    public void setMaxHealthPoint(int maxHealthPoint) {
        if(maxHealthPoint > 0) {
            this.maxHealthPoint = maxHealthPoint;
        }
    }
}
