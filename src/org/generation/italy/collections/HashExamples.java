package org.generation.italy.collections;

import org.generation.italy.collections.sorting.Person;
import org.generation.italy.collections.sorting.SortByName;

import java.util.*;

public class HashExamples {
    public static void main(String[] args){
        Employee e1 = new Employee("Giorgio", "Vanni", "1");
        Employee e2 = new Employee("Giorgio", "Vanni", "2");
        Employee e3 = new Employee("Giorgio", "Vanni", "1");

        Set<Employee> emps = new HashSet<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);

        System.out.println(emps.size());
        Person p1 = new Person("Marcello" , 29);
        Person p2 = new Person("Stefano" , 26);
        Person p3 = new Person("Marta" , 49);
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        Collections.sort(people);
        people.sort(null);
        people.forEach(System.out::println);

        //Utlizzo di Comparator
        SortByName cp = new SortByName();
        Collections.sort(people , cp);
        people.sort(cp);
        Collections.sort(people , (o1 , o2) -> o2.getAge() - o1.getAge());
        Collections.sort(people , (o1 , o2) -> o2.getName().compareTo(o1.getName()));
        people.forEach(System.out::println);


        System.out.println(getNameByAge(people , 49));

    }

//    public static List<String> getNameByAge(List<Person> personList, int age){
//        return personList.stream()
//                .filter(pe -> pe.getAge() == age)
//                .map(Person::getName).toList();
//    }

    public static String getNameByAge(List<Person> personList, int age){
        return personList.stream()
                .filter(pe -> pe.getAge() == age)
                .map(Person::getName).findFirst().orElse("Nome non trovato");
    }
}
