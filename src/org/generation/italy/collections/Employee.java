package org.generation.italy.collections;

public class Employee {
    private String name;
    private String lastname;
    private String badgeNumber;

    public Employee(String name, String lastname, String budgeNumber) {
        this.name = name;
        this.lastname = lastname;
        this.badgeNumber = budgeNumber;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Equals");

        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return this.badgeNumber.equals(other.badgeNumber);
        }
        @Override
        public int hashCode () {
            return badgeNumber.hashCode();
        }
        public String getName () {
            return name;
        }

        public String getLastname () {
            return lastname;
        }

        public String getBudgeNumber () {
            return badgeNumber;
        }
    }

