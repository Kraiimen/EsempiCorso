package org.generation.italy.collections.sorting;

import java.util.Optional;

public class Examples {
    public static void main(String[] args){
        Developer dev = new Developer("Mario", "Rossi", "Java");
        System.out.println(dev.getFirstLanguage());
        dev.hitYourHead();
        Optional<String> optFirst = dev.getFirstLanguage();
        if(optFirst.isPresent()){
            String firstLanguage = optFirst.get();
            System.out.println(firstLanguage.toLowerCase());
        }

    }
}
