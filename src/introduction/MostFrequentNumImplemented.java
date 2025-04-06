package introduction;

import java.util.HashMap;

public class MostFrequentNumImplemented {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 2, 2, 1, 2, 3, 3};
        System.out.println(getMostFrequentNum(numbers));
        System.out.println(getMostFrequentNumOneLoop(numbers));
    }

    public static int getMostFrequentNum(int[] numbers) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>(); //key=number, value=frequency
        int mostFrequentNum = numbers[0];
        int frequencyCounter;
        int mostFrequentNumCounter = 0;

        for (int number : numbers) {
            frequencyCounter = 0;
            if (frequencyMap.containsKey(number)) {
                frequencyCounter = frequencyMap.get(number);
            }
            frequencyMap.put(number, frequencyCounter + 1);

            if (frequencyMap.get(number) > mostFrequentNumCounter) {
                mostFrequentNum = number;
                mostFrequentNumCounter = frequencyMap.get(number);
            }


        }
        return mostFrequentNum;
    }

    public static int getMostFrequentNumOneLoop(int[] numbers) {
        int mostFrequentNum = numbers[0];
        int mostFrequentNumFrequency = 0;

        for (int i = 0; i < numbers.length; i++) {
            int frequencyCounter = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    frequencyCounter++;
                }
            }
            if (frequencyCounter > mostFrequentNumFrequency) {
                mostFrequentNum = numbers[i];
                mostFrequentNumFrequency = frequencyCounter;
            }
        }
        return mostFrequentNum;
    }
}
