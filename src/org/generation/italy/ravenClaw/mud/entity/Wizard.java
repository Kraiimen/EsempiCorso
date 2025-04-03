package org.generation.italy.ravenClaw.mud.entity;

public class Wizard extends Player {

    private int intelligence;
    private int spellPoints;

    public Wizard (String name, int maxHp, int attackDamage,String playerName,int intelligence,String color){
        super(name, maxHp, attackDamage,playerName,color);
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
            System.out.printf("%s%s is Casting a fireball on %s for %d damage%s\n",getEntityColor(), this.getName(), attacked.getName(),damageMade,getResetColor());
        }else{
            damageMade *= 0;
            System.out.printf("%s%s tried to cast a fireball on %s but failed%s\n",getEntityColor(), this.getName(), attacked.getName(),getResetColor());
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
        System.out.printf("%syour name is %s the Wizard, you've got %d HP and your base damage is %d you have %d intelligence points%s\n",getEntityColor(), this.getName(),this.getHealthPoints(),this.getAttackDamage(),this.getIntelligence(),getResetColor());
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
