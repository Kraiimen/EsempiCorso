package org.generation.italy.collections.sorting;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person p) {
        return  this.name.compareTo(p.name); // Ordinamento naturale, per le stirnghe utlizziamo compareTo
    }

    @Override
    public String toString() {
        return "Persone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
