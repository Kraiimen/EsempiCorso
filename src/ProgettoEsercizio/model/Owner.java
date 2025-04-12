package ProgettoEsercizio.model;

public class Owner {
    private String name;
    private String surname;

    //Getter and Setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private int age;
    //Constructor
    public Owner(){
    }
    public String toString(){
        return ("Name: "+name+" "+"Surname: "+surname);
    }
}
