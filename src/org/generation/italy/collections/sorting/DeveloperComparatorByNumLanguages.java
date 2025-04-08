package org.generation.italy.collections.sorting;

import java.util.Comparator;

public class DeveloperComparatorByNumLanguages implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) { //Voglio prima i developer che sanno meno linguaggi
        return o1.getNumLanguages() - o2.getNumLanguages();
    }
}
