package org.generation.italy.collections.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperRepository {
    private static List<Developer> devs = new ArrayList<>();
    static{
        devs.add(new Developer("Giacomino", "Er viscido", "Javascript",true,999));
        devs.add(new Developer("Gianna", "Nannini", "Malbolge"));
        devs.add(new Developer("Leo", "Prese", "C#",true,1200));
        devs.add(new Developer("Francesco", "Renga", "Java",true,1200));
        devs.add(new Developer("Peppina", "Lusuraia", "Python"));
    }

    public List<Developer> getMales(){
        return devs.stream().filter(Developer::isMale).toList();
    }

    public List<Developer> getFemale(){
        return devs.stream().filter(d -> !d.isMale()).toList();
    }

    public List<String> getDevsNameBySalaryAndLanguage(double salary, String language){
        return devs.stream().filter(a -> a.getSalary() >= salary && a.knowsLanguage(language))
                .map(Developer::getFullname).limit(3).toList();
    }

    public List<String> getDevsBySexSalaryAndLanguageNumber(boolean isMale, double salary, int numLanguages){
        Stream<Developer> sd = devs.stream()
                .filter(d -> d.isMale() == isMale)
                .filter(d -> d.getSalary() > salary)
                .filter(d -> d.getNumLanguages() > numLanguages);
        Stream<String> ss = sd.map(Developer::getFullname); //Senza un operatore terminale questo Stream sarà vuoto
        return ss.toList();
    }

    public double[] getTotalSalariesByLanguage(String language){
        Stream<Developer> dlan = devs.stream().filter(d -> d.knowsLanguage(language));
        double[] salaries = new double[2];
        List<Developer> dlanList = dlan.toList();
        salaries[0] = dlanList.stream().filter(Developer::isMale).mapToDouble(Developer::getSalary).sum();
        salaries[1] = dlanList.stream().filter(d -> !d.isMale()).mapToDouble(Developer::getSalary).sum();
        return salaries;
    }

    public boolean isPatriarchyReal(){ //Dobbiamo valutare se il minimo stipendio degli uomini è maggiore del massimo stipendio delle donne
        double minSalaryMen = devs.stream().filter(Developer::isMale).mapToDouble(Developer::getSalary).min().orElse(0);
        double maxSalaryWomen = devs.stream().filter(d -> !d.isMale()).mapToDouble(Developer::getSalary).max().orElse(0);
        return minSalaryMen > maxSalaryWomen;
    }
}
