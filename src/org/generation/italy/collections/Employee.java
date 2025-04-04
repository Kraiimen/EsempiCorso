package org.generation.italy.collections;

public class Employee {
    private String name;
    private String lastname;
    private String badgeNumber;

    public Employee(String name, String lastname, String badgeNumber) {
        this.name = name;
        this.lastname = lastname;
        this.badgeNumber = badgeNumber;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Chiamato equals!"); // Per vedere quando chiamo equals
        if(obj == null) {
            return false;
        }
        if(obj.getClass() != this.getClass()) { // Se l'oggetto che mi hai passato non è della stessa classe dell'oggetto su cui l'ho chiamata tornami false
            return false;
        }
        Employee other = (Employee)obj; // Creo una variabile (other) per puntare l'Object come Employee
        return this.badgeNumber.equals(other.badgeNumber); // Vedo se è vero che la mia badge è uguale a quella dell'altro e nel caso torno vero

    }

    @Override
    public int hashCode() {
        //return 1; // Pongo tutti gli hashcode degli Employee uguali a 1
        return badgeNumber.hashCode(); // Così è più efficiente
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
