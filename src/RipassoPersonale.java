public class RipassoPersonale {
    static int global = 100;
    public static void main(String[] args){
    //     int x = 10;
    //     f1(x);
    //     int p = 22;
    //     //f1(p);
    //     //f1(35);
    //     System.out.println("All'interno di main: " + x); 
    //     System.out.println(global);
    //     int[] numeri = {1, 2, 3};
    //     int [] numeri2 = {4, 5, 6};
    //     System.out.println(numeri[0]);
    //     f2(numeri);
    //     System.out.println(numeri[0]);
    //     Integer i1 = 10; //Boxing: Inscatolamento. Il compilatore creerà un ogetto di tipo Integer e ci inserirà la primitiva.
    //     Integer i2 = Integer.valueOf(20);
    //     swap(i1, i2);
    //     System.out.println(i1);
    //     trySwap(numeri1, numeri2);
    //     String s1 = "pippo";
    //     String s2 = "pluto";
    //     swapStrings(s1,s2);
    //     System.out.printnl(s1);
    // }
    
    // public static void f1(int z){// Z è una copia di X
    //     z += 3;
    //     //x = x + 3 è la stessa operazione della stringa 7
    //     System.out.println("All'interno di f1: " + z);
    //     System.out.println(global);
    //     global++;
        
    // }
    // public static void f2(int [] ns){
    //     ns[0] = 100;
    //     ns = new int[]{1000, 2000, 3000, 4000};
    //     ns[0] = 200;

        
    // }
    // public static void swap(Integer z1, Integer z2){
    //     z1.setValue(100);
    //     Integer temp = z1;
    //     z1 = z2;
    //     z2 = temp;   
    // }
    // public static void trySwap(int[] ns1, int[] ns2){
    //     ns1 = ns2;
    //     ns1[0] = 100;
    // }
    // public static void swapStrings(String s1, String s2){
    //     //Non è possibile fare questo. s1[0] = 'x';
    //     String temp = s1;
    //     s1 = s2;
    //     s2 = temp;
    // }

        //BIDIMENTIONAL ARRAYS
        
        int[][] matrix = new int[4][6];//Array con 4 array dove ogni array è lungo 6 posti.
        int[][] matrix2 = {
            {3, 6, 11, 34, 66, 43},//Array di lunghezza 6
            {2, 4, 6, 7, 8, 15},
            {2, 4, 34, 77, 8, 39},
            {2, 4, 34, 66, 8, 70}
        };
            System.out.println(matrix2[2][3]);
            for(int i = 0; i < jagged.length; i++){//Primo ciclo con i che arriva a coprire la lunghezza dell'array
                System.out.print("[");
                for(int z = 0; z < matrix2[0].length; z++){//Vado a ciclare prendendo la lunghezza, tenendo conto della singola cella [i]
                    System.out.printf("%5d", jagged[i][z]);//% Simbolo da usare insieme a printf, 5 vuol dire uno spazio di 5 caratteri
                    //d serve per stampare gli interi, %n serve per andare a capo è proprio un termine della sintassi di printf

            }
            System.out.println("  ]");
            
        }

            int[][] jagged = new int[10][];
            for(int i = 0; i < jagged.length; i++){
                jagged[i] = new int[i+1];//Crea un array jagged con 0 come tutti valori
            

            public static findMax(int[][] numbers){
                int numbers = matrix[0][0];
                    for (int i = 0; i < matrix.lenght; i++){
                        for(int f = 0; f < matrix[i].lenght; f++){
                            if(matrix[i][f]){
                                max = matrix[i][f];
                            }
                            return max;
                        }  

                        }
                    }
                    
               

            }
        }                                    
                            
    }                        
                    

            

        

    
