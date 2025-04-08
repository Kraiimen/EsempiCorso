package mudgame.entities;

public abstract class Entity {
    private String name;
    private int hp;

    public Entity(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    public void eat(){
        System.out.println("Sto mangiando...");
    }

    public String getName() {
        return name;
    }
}
