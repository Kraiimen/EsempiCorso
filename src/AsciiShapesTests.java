        public class AsciiShapesTests {
        public static void main(String[] args) {
          //DISEGNA VARIE FORME CON I CARATTERI ASCII

                    // 1) QUADRATO // 
        // for(int i = 0; i < 10; i++) {
        //     for(int j = 0; j < 10; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

                  // 2) TRIANGOLO //
            

                  //TENTATIVO 1//
        // for(int i = 0; i < 4; i++) {
             
        //     for(int spaziLinea = 4; spaziLinea > 0; spaziLinea--) {
        //         int asterischiMax = 0;
        //         int cicliAst = spaziLinea;
        //         int cicli = spaziLinea;
        //         while (cicli > 1) {
        //         System.out.print("1");
        //         cicli--;

        //         }
        //         for(int )
        //        while(asterischiMax < cicliAst) {
        //         int numeroAst = asterischiMax + 4;
        //         if(numeroAst == asterischiMax) {
        //             break;
        //         }
        //         else {}
        //         System.out.print("* ");
        //         asterischiMax++;
        //        }
        //        System.out.println(" ");
        //        }
            
               
        //     }
        // }
                    //TENTATIVO 2//
        for(int colonna = 0; colonna < 4; colonna++) {
            int asterischi = 0;
            while(asterischi < colonna) {
                System.out.print(" ");
                asterischi++;
            }
                for(int riga = 4; riga > colonna; riga--) {
                    System.out.print("* ");
                }
                System.out.println();
              
                
            
                

                }
        }
    }
    



