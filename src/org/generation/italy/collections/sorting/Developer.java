package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Developer implements Comparable<Developer> {
    private String firstname;
    private String lastname;
    private List<String> languages;
    private boolean male;
    private double salary;


    public Developer(String firstname, String lastname, String firstLanguage) { // Inizializzo il costruttore con nome e cognome del programmatore e gli passo il primo linguaggio conosciuto
        this(firstname, lastname, firstLanguage, false, 100); //Richiamo il costruttore di sotto, inizializzo le variabili non passate in input
    }

    public Developer(String firstname, String lastname, String firstLanguage, boolean male, double salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        languages = new ArrayList<>();
        languages.add(firstLanguage);
        this.male = male;
        this.salary = salary;
    }


    public void addLanguage(String newLanguage) {
        languages.add(newLanguage);
    }

    public Optional<String> getFirstLanguage() {
        if (languages.size() > 0) {
            return Optional.of(languages.get(0));
        }
        return Optional.empty();
    }
    public void hitYourHead() {
        languages.clear();
    }

    public int getNumLanguages() {
        return languages.size();
    }

    @Override
    public int compareTo(Developer o) {
        return this.lastname.compareTo(o.lastname);
    }

    // Metodo per vedere se un Developer conosce un linguaggio
    public boolean knowsLanguage(String language) {
        return languages.contains(language);
    }

    // Metodo che mi restituisce nome comnpleto del Developer
    public String getFullName() {
        return firstname + lastname;
    }

    //   /-----/-GETTER-&-SETTER-/-----/
    public boolean isMale() {
        return male;
    }
    public double getSalary() {
        return salary;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
}
