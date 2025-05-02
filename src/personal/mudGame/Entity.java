package personal.mudGame;

public abstract class Entity {
    private String name;
    private int hP;
    private int power;
    private int maxHP;
    private int lostHP = maxHP - hP;

    public Entity(String name, int maxHP, int power){
        this.name = name;
        this.maxHP = maxHP;
        this.power = power;
        hP = maxHP;
    }

    public void heal(int healPoints){
        if(healPoints < lostHP) {
            hP += healPoints;
        }else{
            hP = maxHP;
        }
    }
    public void hurt(int hurtPoints){
        hP -= hurtPoints;
    }
    public void eat(){
        heal((int)(lostHP*0.3));
    }
    public void sleep(){
        heal((int)(lostHP*0.2));
    }
    public void attack(Entity attacked){
        int damageMade = power;
        attacked.hurt(damageMade);
        System.out.printf("%s is attacking %s for %d damage.%n", this.name, attacked.getName(), damageMade);
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public int getHP(){ return hP; }
    public void setHP(int hP){ this.hP = hP; }

    public int getPower(){ return power; }
    public void setPower(int power){ this.power = power; }

    public int getMaxHP(){ return maxHP; }
    public void setMaxHP(int maxHP){ this.maxHP = maxHP; }

    public int getLostHP(){ return lostHP; }
    public void setLostHP(int lostHP){ this.lostHP = lostHP; }


}
