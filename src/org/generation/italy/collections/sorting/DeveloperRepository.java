package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DeveloperRepository {

    private static List<Developer> devs = new ArrayList<>();

    // Blocco statico, aggiungo alla List 5 Developer
    static {
        devs.add(new Developer("Piero", "Scarcina", "Java", true, 2000));
        devs.add(new Developer("Camilla", "Mazzanti", "JavaScript", false, 1800));
        devs.add(new Developer("Pietro", "Curcio", "Java", true, 2600));
        devs.add(new Developer("Alessandro", "Rossi", "Java", true, 1600));
        devs.add(new Developer("Maria", "Esposito", "Cobol", false, 4000));
    }

    // Metodo che mi restituisca tutti i Developer maschi
    public List<Developer> getMales() {
//        return devs.stream().filter(d -> d.isMale()).toList(); // Senza method reference
        return devs.stream().filter(Developer::isMale).toList(); // Qui uso il method reference poiché ho il metodo che fa già questo
    }

    // Metodo che mi restituisca tutti le Developer femmine
    public List<Developer> getFemales() {
        return devs.stream().filter(d -> !d.isMale()).toList();
    }

    // Metodo che mi ritorna una List di Stringhe che saranno nome e cognome di tutti gli sviluppatori che prendono più di un tot di euro e conoscono un determinato linguaggio
    public List<String> getDevsNameBySalaryAndLanguage(double salary, String language) {
        return devs.stream()
                .filter(d -> d.getSalary() >= salary)
                .filter(d -> d.knowsLanguage(language))
                .map(Developer::getFullName) // Trasformo in stringa usando una method reference al metodo che mi dà una stringa col nome completo
                .toList();
    }

    // Voglio un metodo che mi dia tutti i developer di un dato sesso, dato salario minimo e che conoscono un dato linguaggio
    public List<String> getDevsBySexSalaryAndLanguageNumber(boolean isMale, double salary, int numLanguages) {
        Stream<Developer> sd = devs.stream()
                .filter(d -> d.isMale() == isMale)
                .filter(d -> d.getSalary() >= salary)
                .filter((d -> d.getNumLanguages() > numLanguages)); // posso continuare dopo lo stream, se non continuo stream non lavora perché non ho una conclusione

        Stream<String> ss = sd.map(Developer::getFullName); //Ottengo i nomi e cognomi degli sviluppatori ottenuti prima, ma per ora nessuno viene processato, perché stream è lazy e non ho una conclusione
        return ss.toList(); // Dò un operatore terminale, ora lo stream eseguirà
    }

    // Metodo che mi torna un array con le due somme dei salari maschili e femminili di chi conosce un linguaggio
    public double[] getTotalSalariesByLanguage(String language) {
        Stream<Developer> dlan = devs.stream()
                .filter(d -> d.knowsLanguage(language));
        double[] salaries = new double[2];
//        salaries[0] = dlan.filter(Developer::isMale)
//                .mapToDouble(Developer::getSalary).sum(); // mapToDouble mi fa lavorare su una stream di double, così posso lavorare con le primitive in uno stream, e usare il metodo sum
//        salaries[1] = dlan.filter(d -> !d.isMale())
//                .mapToDouble(Developer::getSalary).sum();  // Mi darà eccezione perché uno Stream non è riutilizzabile, e non posso rifare il calcolo sulle donne
        // Uso una List intermedia
        List<Developer> dlanList = dlan.toList();
        salaries[0] = dlanList.stream()
                .filter(Developer::isMale)
                .mapToDouble(Developer::getSalary).sum(); // mapToDouble mi fa lavorare su una stream di double, così posso lavorare con le primitive in uno stream, e usare il metodo sum
        salaries[1] = dlanList.stream()
                .filter(d -> !d.isMale())
                .mapToDouble(Developer::getSalary).sum();
        return salaries;
    }

    // Facciamo un metodo che torna true se il minimo stipendio dei developer maschi è maggiore del massimo stipendio dei developer femmina
    public boolean isPatriarchyReal() {
        double minMaleSalary = devs.stream()
                .filter(Developer::isMale)
                .mapToDouble(Developer::getSalary).min()/*getAsDouble()*/ // Usando mapToDouble posso usare il metodo min(), che mi ritorna un Optional double, perché potrei non avere nessun elemento nello stream e ottenere null, per cui userò getAsDouble per ottenerlo in double, dando per scontato che ci siano sempre maschi, o utilizzo un orElse per dare un valore nel caso sia null
                .orElse(0);

        double maxFemaleSalary = devs.stream()
                .filter((d -> !d.isMale()))
                .mapToDouble(d -> d.getSalary()).min().orElse(0);

        return minMaleSalary > maxFemaleSalary; // Torna true se il salario minimo degli uomini è maggiore del massimo delle donne
    }

}
