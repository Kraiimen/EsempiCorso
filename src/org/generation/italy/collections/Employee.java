package org.generation.italy.collections;

public class Employee {
    private String name;
    private String lastname;
    private String badgeNumber;

    public Employee(String name, String lastname, String badgeNumber){
        this.name = name;
        this.lastname = lastname;
        this.badgeNumber = badgeNumber;
    }
    @Override
    public boolean equals(Object obj){
        System.out.println("equals");
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
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }
}
