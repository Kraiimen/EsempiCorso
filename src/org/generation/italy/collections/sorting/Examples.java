package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class Examples {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Pietro", "Scarcina", "Java");
        System.out.println(dev1.getFirstLanguage());
        dev1.hitYourHead(); // Svuoto l'ArrayList coi linguaggi
        Optional<String> optFirst = dev1.getFirstLanguage();
          //  System.out.println(firstLanguage.toLowerCase()); // Avrò NullPointerException, aggiungo un if e lo metto dentro
        if(optFirst.isPresent()) { // Se nella scatola Optional ho qualcosa
            String firstLanguage = optFirst.get();
            System.out.println(firstLanguage.toLowerCase());
        }
        Developer dev2 = new Developer("Antonio", "Rossi", "Python");
        Developer dev3 = new Developer("Marco", "Curcio", "JavaScript");

        dev2.addLanguage("Java");

        ArrayList<Developer> developers = new ArrayList<>();
        developers.add(dev1);
        developers.add(dev2);
        developers.add(dev3);
        int x = dev1.compareTo(dev3);
        System.out.println(x);
//        Comparable<Developer> c1 = (Comparable<Developer>)dev1; //Così compateTo compara due elementi
//        Comparable<Developer> c2 = (Comparable<Developer>)dev2;
        Collections.sort(developers);
        System.out.println("Ordinamento con Comparable");
        for(Developer d : developers) {
            System.out.println(d.getFirstname());
        }
        Comparator<Developer> cd = new DeveloperComparatorByNumLanguages();
        Collections.sort(developers, cd); // Ora il metodo sort ordinerà in base al Comparator
        Collections.sort(developers, (o1,o2) -> o1.getNumLanguages() - o2.getNumLanguages()); // Usando le lambda expression
        System.out.println("Ordinamento con Comparator");
        for(Developer d : developers) {
            System.out.println(d.getFirstname());
        }
        // Voglio usare una lambda expression per ordinarli tramite lunghezza del nome decrescente
        Collections.sort(developers, (o1, o2) -> o2.getFirstname().length() - o1.getFirstname().length());
        System.out.println("Ordinamento con Lambda");
        for(Developer d : developers) {
            System.out.println(d.getFirstname());
        }
        // E se ho già una funzione (Utilities) che fa quello che voglio?
        Collections.sort(developers, Utilities::compareDevsByNameLengthDesc);

    }
}
