package org.generation.italy.collections.sorting;

import java.util.Comparator;

public class DeveloperComparatorByLastnameDesc implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        return o2.getLastname().length() - o1.getLastname().length(); // Così ordino per lunghezza cognome decrescente
   //   return o1.getLastname().length() - o2.getLastname().length(); così ordinerei in ordine crescente
    }

}
