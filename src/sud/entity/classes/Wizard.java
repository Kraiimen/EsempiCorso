package sud.entity.classes;

import sud.Spell;
import sud.dices;
import sud.entity.Entity;
import sud.entity.Player;

public class Wizard extends Player {
    private String playerName;
    private int hpDiceFaces;
    private int manaPoints;
    private int maxMana;




    public Wizard(String name, String color,String playerName) {
        super(name, 6, color, "wizard");
        this.playerName = playerName;
        this.hpDiceFaces = 6;
        this.maxMana = this.getIntMod()*2;
        this.manaPoints =maxMana;
    }

    public void increseHp(){
        this.setHealthPoints(this.getConMod()+ dices.roll(hpDiceFaces));
    }

    public void restoreMana(int restoreAmmount){
        if((maxMana - manaPoints)> restoreAmmount){
            manaPoints += restoreAmmount;
            System.out.printf(this.getEntityColor()+"%s healed %d"+resetColor,this.getName(),restoreAmmount);
        }else {
            manaPoints = maxMana;
            System.out.printf(this.getEntityColor()+"%s has fully healed"+resetColor,this.getName());
        }
    }

    @Override
    public void sleep(){
        heal(10000000);
        restoreMana(1000);
        System.out.printf(this.getEntityColor()+"%s sleeps"+resetColor,this.getName());
    }

    @Override
    public void attack (Entity attacked) {
        int damage = 0;
        int roll = dices.rd20();
        if (roll == 20) {
            damage = this.getEquipedWeapon().rollDamage() * 2;
        } else if (roll == 1) {
            System.out.printf(this.getEntityColor() + "<Your attack was soo weak %s uses the opportunity and attacks you>" + resetColor, attacked.getName());
            attacked.attack(this);
            return;
        } else if (doesAttackRollHit(attacked, roll)) {
            damage = this.getEquipedWeapon().rollDamage()+ this.getStrMod();
            System.out.printf(this.getEntityColor() + "<%s is attacking %s with the the %s for %d damage\n> " + resetColor, this.getName(), attacked.getName(),this.getEquipedWeapon().getName(), damage);
            attacked.hurt(damage );
        }
        if (attacked.isDead()) {
            System.out.println(this.getEntityColor() + attacked.getName() + " <has died by that hit\n> " + resetColor);
            System.out.printf("<You gain %d Xp>",attacked.getXpOnDeath());
            this.setXp(this.getXp()+attacked.getXpOnDeath());
        }
    }

    public void cast(Entity attacked){
        int damage = 0;
        Spell spell = new Spell();
        switch (getLevel()){
            case 1 ->{ spell = new Spell("Firebolt",1,6); }
            case 2 ->{spell = new Spell("Ice sphere",2,8);}
            case 3 ->{spell = new Spell("Wind blast",3,6);}
            case 4 ->{spell = new Spell("Fireball",4,10);}
            case 5 ->{spell = new Spell("Lightning bolt",5,12);}
        }
        int roll = dices.rd20();
        if (roll == 20) {
            damage = spell.getDamage()*2;
        } else if (roll == 1) {
            System.out.printf(this.getEntityColor() + "Your spell fails to hit %s he uses the opportunity and attacks you" + resetColor, attacked.getName());
            attacked.attack(this);
            return;
        } else if (doesAttackRollHit(attacked, roll)) {
            damage = spell.getDamage();
        }
        System.out.printf(this.getEntityColor() + "%s casts %s on %s for %d damage\n " + resetColor, this.getName(),spell.getName(), attacked.getName(), damage);
        attacked.hurt(damage + this.getStrMod());
        if (attacked.getHealthPoints()<1) {
            System.out.println(this.getEntityColor() + attacked.getName() + " <has died by that hit\n> " + resetColor);
            System.out.printf("<You gain %d Xp>",attacked.getXpOnDeath());
            this.setXp(this.getXp()+attacked.getXpOnDeath());

        }
    }
    @Override
    public boolean levelUp(){

        if(this.getXp() <50){
            System.out.println("<You don't have enough xp to level up>");
            return false;
        }else if (this.getXp() >= 50) {
            if (this.getLevel() < 2) {
                this.setLevel(2);
                this.sleep();
                return true;
            }else {
                System.out.println("<You don't have enough xp to level up>");

            }
            return false;
        } else if (this.getXp() >= 100) {
            if (this.getLevel() < 3) {
                this.setLevel(3);
                this.sleep();
                return true;

            }else {
                System.out.println("<You don't have enough xp to level up>");

            }
            return false;
        } else if (this.getXp() >= 200) {
            if (this.getLevel() < 4) {
                this.setLevel(4);
                this.sleep();
                return true;

            }else {
                System.out.println("<You don't have enough xp to level up>");

            }
            return false;
        } else if (this.getXp() >= 400) {
            if (this.getLevel() < 5) {
                this.setLevel(5);
                this.sleep();
                return true;

            }else {
                System.out.println("<You don't have enough xp to level up>");
            }
            return false;
        }
        increseHp();
        return false;

    }

}
