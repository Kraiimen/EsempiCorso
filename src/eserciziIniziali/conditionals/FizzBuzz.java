package eserciziIniziali.conditionals;

// stampa i numeri da 1 a 100 (compresi)
// se il numero è multiplo di 3 stampa Fizz al posto del numero
// se è un multiplo di 5 stampa Buzz
// se è multiplo sia di 3 sia di 5 stampa FizzBuzz

public class FizzBuzz {
    public static void main (String[] args){
        for (int i = 1; i <= 100; ++i){ // cicla tutti i numeri da 1 fino a 100 compresi
            boolean isFizz = i % 3 == 0;
            boolean isBuzz = i % 5 == 0;
            if(isFizz){//se multiplo di e stampa Fizz
                System.out.print("Fizz");
            }
            if (isBuzz) { //se multiplo di 5 stampa Buzz
                System.out.print("Buzz");//non ci sono else, quindi se multiplo di 3 e 5 stampa entrambi (FizzBuzz)
            }
            if(!(isFizz || isBuzz)){ //se non è nè Fizz, nè Buzz, stampa i
                System.out.println(i);
            }
        }
    }
}
