package personal;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExercises {
    public static void main(String[] args){
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numeriEven = numeri.stream().filter(i -> i % 2 == 0).toList();

        List<Integer> numerielli = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> numerielliSenzaDoppi = numerielli.stream().distinct().toList();
        for(Integer i : numerielliSenzaDoppi){
            System.out.println(i);
        }
        List<String> parole = Arrays.asList("elefante", "cane", "gatto", "ippopotamo");
        List<String> paroleLunghe = parole.stream().filter(s -> s.length() > 5).toList();
        System.out.println(paroleLunghe);
        List<String> parole2 = Arrays.asList("Albero", "Casa", "Auto", "Mela", "Aquila");
        List<String> paroleConA = parole2.stream().filter(s -> s.contains("l")).toList();
        System.out.println(paroleConA);



    }

}
