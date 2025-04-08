package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Developer implements Comparable<Developer> {
    private String firstname;
    private String lastname;
    private List<String> languages;

    public Developer(String firstname, String lastname, String firstLanguage){
        this.firstname = firstname;
        this.lastname = lastname;
        languages = new ArrayList<>();
        languages.add(firstLanguage);
    }

    public void hitYourHead(){
        languages.clear();
    }

    public Optional<String> getFirstLanguage(){
        if(languages.size() > 0){
            return Optional.of(languages.get(0));
        }
        return Optional.empty();
    }

    public int getNumLanguages(){
        return languages.size();
    }

    public int getLenghtLastname(){
        return lastname.length();
    }

    @Override
    public int compareTo(Developer o) {
        return this.lastname.compareTo(o.lastname);
    }

    public void addLanguage(String newLanguage){
        languages.add(newLanguage);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

}
