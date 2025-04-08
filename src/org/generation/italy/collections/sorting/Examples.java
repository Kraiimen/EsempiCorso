package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class Examples {
    public static void main(String[] args){
        Developer dev1 = new Developer("Mario", "Rossi", "Java");
        System.out.println(dev1.getFirstLanguage());
        dev1.hitYourHead();
        Optional<String> optFirst = dev1.getFirstLanguage();
        if(optFirst.isPresent()){
            String firstLanguage = optFirst.get();
            System.out.println(firstLanguage.toLowerCase());
        }

        Developer dev2 = new Developer("Carlo", "Bianchi","Python");
        Developer dev3 = new Developer("Lucia", "Brambila", "JavaScript");

        dev2.addLanguage("Assembly");

        ArrayList<Developer> developers = new ArrayList<>();
        developers.add(dev1);
        developers.add(dev2);
        developers.add(dev3);
        int x = dev1.compareTo(dev2);
        System.out.println(x);
        Comparable<Developer> c1 = (Comparable<Developer>) dev1;
        Comparable<Developer> c2 = (Comparable<Developer>) dev2;
        Collections.sort(developers);
        for(Developer d: developers){
            System.out.println(d.getFirstname());
        }
        Comparator<Developer> cd = new DeveloperComparatorByNumLanguages();
        Collections.sort(developers,cd);
        for(Developer d : developers){
            System.out.println(d.getFirstname());
        }

    }
}
