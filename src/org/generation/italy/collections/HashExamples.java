package org.generation.italy.collections;

import java.util.HashSet;
import java.util.Set;

public class HashExamples {
    public static void main(String[] args) {
        Employee e1 = new Employee("Piero", "Scarcina", "12345");
        Employee e2 = new Employee("Piero", "Scarcina", "23849");
        Employee e3 = new Employee("Piero", "Scarcina", "12345");

        Set<Employee> emps = new HashSet<>(); // Uso set per essere più generale possibile, lo punto con l'interfaccia perché tra programmatori si usa per essere più eleganti
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
        System.out.println(emps.size()); // Voglio vedere chi ci sia dentro, stamperà 3 perché ognuno ha un indirizzo diverso e hashcode diverso
        // Se per me e1 e e3 sono uguali perché hanno stessa matricola vado a fare override di equals
        //Avrò ancora 3. Perché gli hashcode sono ancora diversi
        // Devo andare a overridare anche hashcode, perché hashcode fa ancora riferimento a quello di Object che dipende dalla reference
        // Ho violato il contratto che esiste tra equals e hashcode
        // Due oggetti uguali per Java (equals overridato) possono essere diversi
        // Vado a overridare anche hashcode mettendo return 1 (tutti gli hashcode uguali a 1)
        // Se ora vado a stampare esce 2, perché gli hashcode sono uguali e fa equals, e chiama equals 2 volte
        // Se voglio maggiore efficienza devo overridare hashcode con altro, per esempio posso ritornare l'hashcode del badgeNumber





    }
}
