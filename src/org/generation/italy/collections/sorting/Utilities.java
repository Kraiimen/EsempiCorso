package org.generation.italy.collections.sorting;

public class Utilities {

    public static int compareDevsByNameLengthDesc(Developer d1, Developer d2) {
        return d2.getFirstname().length() - d1.getFirstname().length();
    }
}
