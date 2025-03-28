package org.generation.italy.ravenClaw.mud;

public class Wizard extends Player {

    private int intelligence;
    private int spellPoints;

    public Wizard (String name, int maxHp, int attackDamage,String playerName,int intelligence ){
        super(name, maxHp, attackDamage,playerName);
        if(intelligence >=0 && intelligence<=100){
            this.intelligence = intelligence;
        }
        spellPoints = (int)intelligence/2;
    }

    public int castFireball(Entity attacked){
        int damageMade= this.getAttackDamage();
        if(spellPoints>=5){
            spellPoints-=5;
            damageMade *= 4;
            System.out.printf("%s is Casting a fireball on %s for %d damage", this.getName(), attacked.getName(),damageMade);
        }else{
            damageMade *= 0;
            System.out.printf("%s tried to cast a fireball on %s but failed", this.getName(), attacked.getName());
        }

        return damageMade;
    }
    @Override
    public void attack(Entity attacked){
        int damageMade = castFireball(attacked);
        attacked.hurt(damageMade);

    }
    @Override
    public void printSheet(){
        System.out.printf("your name is %s a Wizard, you've got %d HP and your base damage is %d you have %d intelligence points", this.getName(),this.getHealthPoints(),this.getAttackDamage(),this.getIntelligence());
    }
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSpellPoints() {
        return spellPoints;
    }

    public void setSpellPoints(int spellPoints) {
        this.spellPoints = spellPoints;
    }
}
