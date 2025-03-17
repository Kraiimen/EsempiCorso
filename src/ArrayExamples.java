import java.util.*;

public class ArrayExamples<T> {
	public static void main(String[] args){
        ArrayExamples<Integer> ae = new ArrayExamples<Integer>();

		int[] numbers = new int[5];
        /*
        System.out.println(numbers[0]);
        System.out.println(numbers[4]);
        System.out.println(numbers);
        numbers[1] = 100;
        numbers[4] = 200;

        for(int i = 0; i < 5; ++i){
            System.out.println("indice: " + i + " valore: " + numbers[i]);
        }

        for(int n : numbers){   //foreach
            System.out.println(n);
        }
        //*/

        for(int i = 0; i < numbers.length; ++i){
            numbers[i] = (i+1) * (i+1);
        }
        /*
        for(int i = 0; i < 5; ++i){
            System.out.println(numbers[i]);
        }
        
        int sum = 0;
        for(int i = 0; i < numbers.length; ++i){
            sum += numbers[i];
        }
        System.out.println(sum);
        
        int average = sum/numbers.length;
        System.out.println(average);
        
        int max = numbers[0];
        for(int i = 1; i < numbers.length; ++i){
            if(max < numbers[i]){
                max = numbers[i];
            }
        }
        System.out.println(max);

        int evenNumbers = 0;
        int oddNumbers = 0;
        for(int i = 0; i < numbers.length; ++i){
            oddNumbers += numbers[i] % 2;
        }
        evenNumbers = numbers.length - oddNumbers;
        System.out.println(evenNumbers);

        int z = 4;
        int zCounter = 0;
        for(int i = 0; i < numbers.length; ++i){
            if(z == numbers[i]){
                zCounter++;
            }
        }
        System.out.println(zCounter);

        boolean isSorted = true;
        for(int i = 0; i < numbers.length-1; ++i){
            if(numbers[i] > numbers[i+1]){
                isSorted = false;
                System.out.println("non è ordinato");
                break;
            }
        }
        if(isSorted){
            System.out.println(" è ordinato");
        }

        String arreyString = "[";
        for(int i = 0; i < numbers.length; ++i){
            arreyString += numbers[i].toString();
            if(i == numbers.length-1){
                arreyString += "]"
            }else{
                arreyString += "; "
            }
        }
        System.out.println(arreyString);
        //*/

        int[] reverseNumbers = new int[numbers.length];
        for(int i = 0; i < numbers.length; ++i){
            reverseNumbers[i] = numbers[numbers.length-i-1];
        }
        // for(int i = 0, j = reverseNumbers.length-1; i < numbers.length; ++i, --j){
        //     reverseNumbers[i] = numbers[j];
        // }
        // for(int i = 0; i < reverseNumbers.length; ++i){
        //     System.out.println(reverseNumbers[i]);
        // }
        // var stream = Arrays.stream(reverseNumbers);
        // var boxed = stream.boxed();
        // //var boxedToArray = boxed.toArray();
        // var boxedToArray = boxed.toArray(Integer[]::new );

        // System.out.println(stream);
        // System.out.println(boxed);
        // System.out.println(boxedToArray);

        ae.stampaArrey(Arrays.stream(reverseNumbers).boxed().toArray(Integer[]::new ));

        for(int i = 0, j = reverseNumbers.length-1; i <= j; ++i, --j){
            int temp = numbers[i];
            numbers[i] = reverseNumbers[j];
            numbers[j] = temp;
        }
        
        //dato un int x, capire quante volte 2 numeri consecutivi nell'array danno come somma x

        //verificare se esiste almeno un caso in cui 3 numeri consecutivi nell'array hanno somma maggiore di 12

        //stampare il numero con più occorrenze nell'array (a parità non ha importanza quale stampo)

	}

    // To print an array without writing the for every time
    public void stampaArrey (T[] arrey){
        for(int i = 0; i < arrey.length; ++i){
            System.out.println(arrey[i]);
        }
    }
}