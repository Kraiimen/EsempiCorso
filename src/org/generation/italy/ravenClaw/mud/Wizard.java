package org.generation.italy.ravenClaw.mud;

public class Wizard extends Player {

    private int intelligence;

    public Wizard (String name, int maxHp, int attackDamage,String playerName,int intelligence ){
        super(name, maxHp, attackDamage,playerName);
        if(intelligence >=0 && intelligence<=100){
            this.intelligence = intelligence;
        }
    }

    public void castFireball(Entity attacked){
        int damageModifier = 4;
        System.out.printf("%s is Casting a fireball on %s for %d damage", this.getName(), attacked.getName(),attack(attacked,damageModifier));
    }

    public int attack(Entity attacked, int damageModifier){
        int damageMade = getAttackDamage() * damageModifier;  //variabile modificabile che prende come minimo il danno dell'attaccante
        attacked.hurt(damageMade);
        return damageMade;

    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
