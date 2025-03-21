import java.io.*;
//DA FINIRE DI AGGIUSTARE
public class AsciiTree {
    private final char emptySpaceSymbol = ' ';
    private final char triangleSymbol = '*';
    private final String newLine = "\n";
    private final char trunkSymbol = '|';
    private final char groundSymbol = '_';

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
        System.out.println(triangleHight);
	}
    public static String buildAsciiChristmasTree(int hight){
        StringBuilder christmasTree = new StringBuilder();
        christmasTree.append(triangle + newLine + trunk + newLine + ground);
        return christmasTree;
    }
    public static StringBuilder AsciiTriangle(int hight){
        StringBuilder triangle = new StringBuilder();   //dovrebbe esseere uno StringBuilder ma non li abbiamo ancora fatti...
        int triangleBase = hight * 2;

        for(int i = 0; i < hight; ++i){
            StringBuilder triangleRow = new StringBuilder();
            int spacesToFill = i+1;
            int emptySpaces = hight - spacesToFill;
            int currentBase = triangleBase - (emptySpaces+1);
            boolean isLastRow = i == triangleHight-1;

            for(int j = 0; j < emptySpaces; ++j){
                triangleRow.add(emptySpaceSymbol);
            }
            for(int j = 0; j < spacesToFill*2 - 1; ++j){
                boolean isSpaceToFill = j % 2 == 0;
                if(isSpaceToFill){
                    triangleRow.add(triangleSymbol);
                }else{
                    triangleRow.add(emptySpaceSymbol);
                }
            }
            if(isLastRow == false){
                triangleRow.add(newLine);
            }

            triangle.add(triangleRow);
        }
        return triangle;
    }

    public static StringBuilder AsciiTreeTrunk(int hight){
        StringBuilder trunk = new StringBuilder();
        int trunkHight = triangleHight/2;
        //int trunkWidth = triangleHight / 5;
        //int emptySpaces = triangleHight - trunkWidth;

        for(int i = 0; i < trunkHight; ++i){
            StringBuilder trunkRow = new StringBuilder();
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

        for(int i = 0; i < triangleBase; ++i){
            ground += groundSymbol;
        }
    }
}