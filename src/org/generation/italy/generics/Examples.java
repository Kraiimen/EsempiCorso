package org.generation.italy.generics;

import java.util.ArrayList;
import java.util.Random;

public class Examples {
    public static void main(String[] args) {
        ArrayList ar = new ArrayList();
        ar.add("Pippo");
        ar.add(new Random());
        ar.add(Integer.valueOf(3));
        String s = (String)ar.get(0);
        ArrayList<String> ss = new ArrayList<>();
        f1(ss);
        String z = ss.get(0);
    }
    public static void f1(ArrayList ar) {
        ar.add(new Random());
    }
}
