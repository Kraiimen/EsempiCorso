import java.io.*;
//DA FINIRE DI AGGIUSTARE
public class AsciiTree {
    //*
    private static final char emptySpaceSymbol = ' ';
    private static final char triangleSymbol = '*';
    private static final String newLine = "\n";
    private static final char trunkSymbol = '|';
    private static final char groundSymbol = '_';

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
        System.out.println(buildAsciiChristmasTree(triangleHight));
	}
    public static String buildAsciiChristmasTree(int hight){
        StringBuilder christmasTree = new StringBuilder();
        christmasTree.append(AsciiTriangle(hight) + newLine + AsciiTreeTrunk(hight) + newLine + AsciiTreeGround(hight));
        return christmasTree.toString();
    }
    public static StringBuilder AsciiTriangle(int hight){
        StringBuilder triangle = new StringBuilder();   //dovrebbe esseere uno StringBuilder ma non li abbiamo ancora fatti...
        int triangleBase = hight * 2;

        for(int i = 0; i < hight; ++i){
            StringBuilder triangleRow = new StringBuilder();
            int spacesToFill = i+1;
            int emptySpaces = hight - spacesToFill;
            int currentBase = triangleBase - (emptySpaces+1);
            boolean isLastRow = i == hight-1;

            for(int j = 0; j < emptySpaces; ++j){
                triangleRow.append(emptySpaceSymbol);
            }
            for(int j = 0; j < spacesToFill*2 - 1; ++j){
                boolean isSpaceToFill = j % 2 == 0;
                if(isSpaceToFill){
                    triangleRow.append(triangleSymbol);
                }else{
                    triangleRow.append(emptySpaceSymbol);
                }
            }
            if(isLastRow == false){
                triangleRow.append(newLine);
            }

            triangle.append(triangleRow);
        }
        return triangle;
    }

    public static StringBuilder AsciiTreeTrunk(int hight){
        StringBuilder trunk = new StringBuilder();
        int trunkHight = hight/2;
        //int trunkWidth = triangleHight / 5;
        //int emptySpaces = triangleHight - trunkWidth;

        for(int i = 0; i < trunkHight; ++i){
            StringBuilder trunkRow = new StringBuilder();
            boolean isLastRow = i == trunkHight-1;
            for(int j = 0; j < hight-1; ++j){
                trunkRow.append(emptySpaceSymbol);
            }
            // for(int j = 0; j < trunkWidth; ++j){
            //     trunkRow += trunkSymbol;
            // }
            trunkRow.append(trunkSymbol);

            if(isLastRow == false){
                trunkRow.append(newLine);
            }

            trunk.append(trunkRow);
        }
        return trunk;
    }

    private static StringBuilder AsciiTreeGround(int hight){
        StringBuilder ground = new StringBuilder();

        for(int i = 0; i < hight*2; ++i){
            ground.append(groundSymbol);
        }
        return ground;
    }

     //*/
}