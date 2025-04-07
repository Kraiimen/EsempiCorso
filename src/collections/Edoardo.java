package collections;

import java.util.ArrayList;
import java.util.List;

public class Edoardo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Edoardo", "Bognanni", "3edbo"));
        employees.add(new Employee("Elvis", "La fata", "1elfa"));
        employees.add(new Employee("Filippo", "Aresu", "2fiar"));
        employees.add(new Employee("Camilla", "Marchioro", "-2cama"));

        System.out.println(employees);
        //Collections.sort(employees);
        //Collections.sort(employees, new SortEmployeesByBadgeNumber());
        employees.sort(new SortEmployeesByBadgeNumber());
    }
}
