package org.generation.italy.collections;

public class Employee {
    private String name;
    private String lastName;
    private String badgeNumber;

    //COSTRUTTORE
    public Employee(String name, String lastName, String badgeNumber){
        this.name = name;
        this.lastName = lastName;
        this.badgeNumber = badgeNumber;
    }

    @Override
    public boolean equals(Object obj){
        System.out.println("equals ");
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Employee other = (Employee)obj;
        return this.badgeNumber.equals(other.badgeNumber);
    }

    @Override
    public int hashCode(){
        return badgeNumber.hashCode();
    }

    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public String getBadgeNumber(){
        return badgeNumber;
    }
}
