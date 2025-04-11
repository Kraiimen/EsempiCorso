package sud.entity.classes;

import sud.dices;
import sud.entity.Entity;
import sud.entity.Player;

public class Barbarian extends Player {
    private String playerName;
    private int hpDiceFaces;

    public Barbarian(String name,String color ,String playerName) {
        super(name, 12, color, "Barbarian");
        this.playerName = playerName;
        this.hpDiceFaces = 12;
    }

    public void increseHp(){
        this.setHealthPoints(this.getConMod()+ dices.roll(hpDiceFaces));
    }
    @Override
    public void attack (Entity attacked) {
        int damage = 0;
        int roll = dices.rd20();
        if (roll == 20) {
            damage = this.getEquipedWeapon().rollDamage() * 2;
        } else if (roll == 1) {
            System.out.printf(this.getEntityColor() + "Your attack was soo weak %s uses the opportunity and attacks you" + resetColor, attacked.getName());
            attacked.attack(this);
            return;
        } else if (doesAttackRollHit(attacked, roll)) {
            damage = this.getEquipedWeapon().rollDamage();
        }

        System.out.printf(this.getEntityColor() + "%s is attacking %s for %d damage\n " + resetColor, this.getName(), attacked.getName(), damage);
        attacked.hurt(damage +this.getStrMod());
        if (attacked.isDead()) {
            System.out.println(this.getEntityColor() + attacked.getName() + " has died by that hit\n " + resetColor);
        }
    }

    @Override
    public void hurt (int recivedDamage){
        if(recivedDamage >= this.getHealthPoints()){
            this.setDead(true);
            this.setHealthPoints(0);
        }else{
            recivedDamage -=(this.getEquipedArmor().getDamageReducer()+(getConMod()*2));
            this.setHealthPoints(recivedDamage);
        }
    }

    @Override
    public void levelUp(){
        if (this.getXp() >= 50) {
            if (this.getLevel() < 2) {
                this.setLevel(2);
            }
        } else if (this.getXp() >= 100) {
            if (this.getLevel() < 3) {
                this.setLevel(3);
            }
        } else if (this.getXp() >= 200) {
            if (this.getLevel() < 4) {
                this.setLevel(4);
            }
        } else if (this.getXp() >= 400) {
            if (this.getLevel() < 5) {
                this.setLevel(5);
            }
        }
        increseHp();
    }
}
