package org.generation.italy.collections;

import java.util.HashSet;
import java.util.Set;

public class HashExamples {
    public static void main(String[] args){
    Employee e1 = new Employee("Alessio", "Basili", "1");
    Employee e2 = new Employee("Alessio", "Basili", "2");
    Employee e3 = new Employee("Alessio", "Basili", "1");


        Set<Employee> emps = new HashSet<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);

        System.out.println(emps.size());
    }
}
