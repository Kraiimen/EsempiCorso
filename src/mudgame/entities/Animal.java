package mudgame.entities;

public class Animal extends Entity{
    public Animal(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void eat(){
        System.out.println("Sto sbranando...");
    }
}
