package ProgettoEsercizio.model;

public class Dog {
    private String name;
    private String breed;
    private Owner owner;
    private int age;

    //                Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    //                Constructor
    public Dog(){
    }
    public Dog(String name,String breed,int age){
        this.name=name;
        this.breed=breed;
        this.age=age;
    }
    //                Methods
    public void sleep(){
        System.out.println(name + " is sleeping");
    }
    public void bark(){
        System.out.println(name + " is barking");
    }
    public int ageInHumanYears(){
        return this.age*7;
    }
    @Override
    public String toString() {
        return "Name:" + getName() + " " + "Breed: " + getBreed() + " " + "Age: " + getAge();
    }
}





