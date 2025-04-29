import java.util.Comparator;
import java.util.List;

public class StreamExercises {
    public static void main(String[] args){
        List<String> words = List.of(
                "apple", "Banana", "avocado", "kiwi",
                "orange", "Grape", "peach", "Pear", "strawberry"
        );
        System.out.println( words.stream()
                .filter(word -> word.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList() );

        System.out.println(words.stream()
                .sorted((string1, string2) ->{
                    int lengthDifference = string1.length() - string2.length();
                    if(lengthDifference != 0) {
                        return lengthDifference;
                    }
                    return string1.compareTo(string2);
                } )
                .toList());
        System.out.println(words.stream()
                .sorted(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder())
                )
                .toList());
    }
}
