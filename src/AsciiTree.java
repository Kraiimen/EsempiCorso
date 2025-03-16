import java.io.*;

public class AsciiTree {
	public static void main(String[] args){
        Console console = System.console();

        int triangleHight = 10;

		// for(int i = 0; i < triangleHight; ++i){
        //     int spacesToFill = i+1;
        //     int emptySpaces = triangleHight - spacesToFill;

        //     for(int j = emptySpaces; j > 0; --j){
        //         System.out.print(" ");
        //     }
        //     for(int j = spacesToFill; j > 0; --j){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        String triangle = "";   //dovrebbe esseere uno StringBuilder ma non li abbiamo ancora fatti...
        int triangleBase = triangleHight * 2;
        char emptySpaceSymbol = ' ';
        char triangleSymbol = '*';
        String newLine = "\n";

        for(int i = 0; i < triangleHight; ++i){
            String triangleRow = "";
            int spacesToFill = i+1;
            int emptySpaces = triangleHight - spacesToFill;
            int currentBase = triangleBase - (emptySpaces+1);
            boolean isLastRow = i == triangleHight-1;

            for(int j = 0; j < emptySpaces; ++j){
                triangleRow += emptySpaceSymbol;
            }
            for(int j = 0; j < spacesToFill*2 - 1; ++j){
                boolean isSpaceToFill = j % 2 == 0;
                if(isSpaceToFill){
                    triangleRow += triangleSymbol;
                }else{
                    triangleRow += emptySpaceSymbol;
                }
            }
            if(isLastRow == false){
                triangleRow += newLine;
            }

            triangle += triangleRow;
        }
        //System.out.println(triangle);

        String cristmasTree = "";
        String trunk = "";
        int trunkHight = triangleHight/2;
        //int trunkWidth = triangleHight / 5;
        //int emptySpaces = triangleHight - trunkWidth;
        char trunkSymbol = '|';

        for(int i = 0; i < trunkHight; ++i){
            String trunkRow = "";
            boolean isLastRow = i == trunkHight-1;
            for(int j = 0; j < triangleHight-1; ++j){
                trunkRow += emptySpaceSymbol;
            }
            // for(int j = 0; j < trunkWidth; ++j){
            //     trunkRow += trunkSymbol;
            // }
            trunkRow += trunkSymbol;

            if(isLastRow == false){
                trunkRow += newLine;
            }

            trunk += trunkRow;
        }

        String ground = "";
        char groundSymbol = '_';

        for(int i = 0; i < triangleBase; ++i){
            ground += groundSymbol;
        }

        cristmasTree += (triangle + newLine + trunk + newLine + ground);

        System.out.println(cristmasTree);
	}	
}