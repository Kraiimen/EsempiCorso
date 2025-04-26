package edoardo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persona {

    private static List<Integer> numeri = new ArrayList<>();

    static{
        numeri.add(1);
        numeri.add(2);
        numeri.add(3);
        numeri.add(4);
        numeri.add(5);
        numeri.add(6);
    }
    private static List<String> parole = new ArrayList<>();
    static{
        parole.add("Albero");
        parole.add("Casa");
        parole.add("Auto");
        parole.add("Mela");
        parole.add("Aquila");

    }


    public static void main(String[] args){
        System.out.println(getSumEvenNumbers());
        System.out.println(filteredListByWordsThatStartsWithA());
        System.out.println(getListWithUppercaseWords());
        System.out.println(getSortedList());

    }
    public static int getSumEvenNumbers(){
         return numeri.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue).sum();

    }
    public static List<String> filteredListByWordsThatStartsWithA(){
        return parole.stream().filter(w->(w.toUpperCase().charAt(0) == 'A')).collect(Collectors.toList());
    }
    public static List<String> getListWithUppercaseWords(){
        return parole.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
    public static List<String> getSortedList(){
        return parole.stream().sorted().toList();
    }
}
