package eserciziRipassoArgomenti.Kitchen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static eserciziRipassoArgomenti.Kitchen.Grade.CHEF;
import static eserciziRipassoArgomenti.Kitchen.Grade.CHEF_ASSISTANT;

public class ChefManagement extends Chef{
    public ChefManagement(String name, String lastName, Grade grade, boolean isFemale, int performanceLevel) {
        super(name, lastName, grade, isFemale, performanceLevel);
    }

    public static void main(String[] args) {
        List<Chef> chefs = new ArrayList<>();

//        Chef ch1 = new Chef {"Carlo", "Cracco",CHEF, false, 10;}
//        Chef ch2 = new Chef {"Riccardo", "Barilla",CHEF_ASSISTANT, false, 8;}

    }
//    public List<Chef> sortChefs(List<Chef> chefs) {
//        return chefs.stream().sorted((c1, c2) -> c1.getPerformanceLevel() - c2.getPerformanceLevel()).toList();
//    }
    public void sortChefsInPlace(List<Chef> chefs) {
//        chefs.sort((c1, c2) -> c1.getPerformanceLevel() - c2.getPerformanceLevel());
        chefs.sort(Comparator.comparingInt(Chef::getPerformanceLevel));
    }
    public void upgradeChef(List<Chef> chefs) {
        sortChefsInPlace(chefs);
        Chef bestChef = chefs.get(chefs.size() - 1);
        switch(bestChef.getGrade()) {
            case GUAP -> {bestChef.setGrade(Grade.CHEF_ASSISTANT);}
            case CHEF_ASSISTANT -> {bestChef.setGrade(CHEF);}
            case CHEF -> System.out.println("grande sei già al top riposati");

        }
    }
}
