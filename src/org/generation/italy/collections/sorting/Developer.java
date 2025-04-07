package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Developer implements Comparable<Developer> {
    private String firstName;
    private String lastName;
    private List<String> languages;

    public Developer(String firstName, String lastname, String firstLanguage) {
        this.firstName = firstName;
        this.lastName = lastname;
        languages = new ArrayList<>();
        languages.add(firstLanguage);
    }

    public void addLanguage(String newLanguage) {
        languages.add(newLanguage);
    }
    public Optional<String> getFirstLanguage() {
        if(languages.size() > 0) {
            return Optional.of(languages.get(0));
        }
        return Optional.empty();
    }
    public void hitYourHead() {
        languages.clear();
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getNumLanguages() {
        return languages.size();
    }

    @Override
    public int compareTo(Developer o) {
        return this.lastName.compareTo(o.lastName);
    }
}
