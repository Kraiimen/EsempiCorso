package ProgettoEsercizio.model;

public class Dog extends Animal{

    private String breed;

    public Dog(String name,String sound,String breed){
        super(name,sound);
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void makeSound(){
        System.out.println(getName() + " says " +getSound());
    }
}
