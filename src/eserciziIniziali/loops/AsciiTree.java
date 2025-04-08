package eserciziIniziali.loops;

import java.io.Console;

//DA FINIRE DI AGGIUSTARE
public class AsciiTree {
    //*
    private static final char emptySpaceSymbol = ' ';
    private static final char triangleSymbol = '*';
    private static final String newLine = "\n";
    private static final char trunkSymbol = '|';
    private static final char groundSymbol = '_';

    public static void main(String[] args){
        //Console console = System.console();

        int triangleHeight = 10;

        //prima versione del triangolo
        // for(int i = 0; i < triangleHeight; ++i){
        //     int spacesToFill = i+1;
        //     int emptySpaces = triangleHeight - spacesToFill;

        //     for(int j = emptySpaces; j > 0; --j){
        //         System.out.print(" ");
        //     }
        //     for(int j = spacesToFill; j > 0; --j){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        System.out.println(buildAsciiChristmasTree(triangleHeight));
    }
    public static String buildAsciiChristmasTree(int height){
        return AsciiTriangle(height) + newLine +
               AsciiTreeTrunk(height) + newLine +
               AsciiTreeGround(height);
    }
    public static StringBuilder AsciiTriangle(int height){
        StringBuilder triangle = new StringBuilder();
        //int triangleBase = height * 2;

        for(int i = 0; i < height; ++i){
            StringBuilder triangleRow = new StringBuilder();
            int spacesToFill = i+1;
            int emptySpaces = height - spacesToFill;
            //int currentBase = triangleBase - (emptySpaces+1);
            boolean isLastRow = i == height-1;

            triangleRow.append(String.valueOf(emptySpaceSymbol).repeat(emptySpaces));

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

    public static StringBuilder AsciiTreeTrunk(int height){
        StringBuilder trunk = new StringBuilder();
        int trunkHeight = height/2;
        //int trunkWidth = triangleHeight / 5;
        //int emptySpaces = triangleHeight - trunkWidth;

        for(int i = 0; i < trunkHeight; ++i){
            StringBuilder trunkRow = new StringBuilder();
            boolean isLastRow = i == trunkHeight-1;

            trunkRow.append(String.valueOf(emptySpaceSymbol).repeat(height - 1));

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

    private static StringBuilder AsciiTreeGround(int height){
        StringBuilder ground = new StringBuilder();

        ground.append(String.valueOf(groundSymbol).repeat(height * 2));
        return ground;
    }

    //*/
}
