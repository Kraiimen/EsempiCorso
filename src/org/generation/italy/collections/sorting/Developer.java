package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Developer implements Comparable<Developer>{
    private String firstname;
    private String lastname;
    private List<String> languages;
    private boolean male;
    private double salary;

    public Developer(String firstname, String lastname, String firstLanguage){
        this(firstname,lastname,firstLanguage,false,100);

    }
    public Developer(String firstname, String lastname, String firstLanguage, boolean isMale, double salary){
        this.firstname = firstname;
        this.lastname = lastname;
        languages = new ArrayList<>();
        languages.add(firstLanguage);
        this.male = isMale;
        this.salary = salary;
    }

    public void addLanguage(String newLanguage){
        languages.add(newLanguage);
    }

    public Optional<String> getFirstLanguage() {
        if(languages.size() > 0){
            return Optional.of(languages.get(0));
        }
        return Optional.empty();
    }

    public void hitYourHead() {
        languages.clear();
    }

    @Override
    public int compareTo(Developer o) {
        return this.lastname.compareTo(o.lastname);
    }
    public boolean knowsLanguage(String language){
        return languages.contains(language);
    }
    public String getFullname(){
        return firstname + " " + lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public int getNumLanguages() {
        return languages.size();
    }
    public boolean isMale(){
        return male;
    }
    public double getSalary(){
        return salary;
    }

}
