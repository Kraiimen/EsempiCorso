package mud.characters.npcs;

import mud.Answer;
import mud.characters.Entity;
import mud.items.Food;
import mud.items.Weapon;
import mud.rooms.MagicMap;

import java.util.HashSet;
import java.util.Set;

import static mud.GameMap.console;
import static mud.GameUtil.player;
import static mud.GameUtil.toTitleCase;

public class Merchant extends Entity {
    private static final int MERCHANT_POSSIBLE_ROOM = 4;

    public Merchant(String name) {
        super(name);
        setActualRoom(MagicMap.getRooms().get(MERCHANT_POSSIBLE_ROOM));
        pickItem(new Food("Bread", 4));
        pickItem(new Weapon("Long sword"));
        pickItem(new Weapon("Shield"));
        pickItem(new Weapon("Dagger"));
        pickItem(new Weapon("Hammer"));
        pickItem(new Weapon("Axe"));
    }

    public void greet(){
        System.out.println(getName() + " says : Oy there! Looking a bit lost! I think I got what you need...");
        System.out.println("The best equipment in the whole realm... Wanna take a look?");
        Set<String> equip = new HashSet<>(getInventory().keySet());
        String ans;
        if(doesWantEquip()){
            do{
                System.out.println("Choose:");
                getInventory().keySet().forEach(System.out::println);
                ans = toTitleCase(console.readLine());
            } while (!equip.contains(ans));
            player.pickItem(getInventory().get(ans));
        }
    }

    public boolean doesWantEquip(){
        String ans = null;
        do{
            System.out.println("Answer Y or N: ");
            ans = console.readLine().toUpperCase();
        }while(!ans.equals(Answer.N.toString()) && !ans.equals(Answer.Y.toString()));
        if(ans.equals(Answer.Y.toString())){
            return true;
        } else if(ans.equals(Answer.N.toString())){
            System.out.println("Oh well, be careful out there then...");
        }
        return false;
    }

    @Override
    public void printInventory() {
    }
}
