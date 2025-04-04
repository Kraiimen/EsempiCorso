package org.generation.italy.collections;

import java.util.HashSet;
import java.util.Set;

public class HashExamples {
    public static void main(String[] args){
        Employee e1 = new Employee("Giorgio", "Vanni", "1");
        Employee e2 = new Employee("Giorgio", "Vanni", "2");
        Employee e3 = new Employee("Giorgio", "Vanni", "3");

        Set<Employee> emps = new HashSet<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);

        System.out.println(emps.size());
    }
}
