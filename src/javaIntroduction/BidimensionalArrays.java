package javaIntroduction;

public class BidimensionalArrays {
	public static void main(String[] args) {
		int[][] matrix = new int[4][6]; // Array di 4 array con ogni array di 6 elementi (matrice 4x6)
		int[][] matrix2 = {
			{3, 11, 28, 5, 3, 43},
			{4, 65, 34, 11, 13, 1},
			{1, 2, 3, 4, 5, 6},
			{12345, 345, 12, 11, 1, 1234}  // Anche in questo caso ho creato un array di 4 array da 6 elemnti
		};
		// Il primo caso è preferibile perché gli array sono tutti di uguale dimensione
		System.out.println(matrix2[2][3]); // Stampo un elemento specifico
		for (int i = 0; i < matrix2.length; i++) { // Vado a stampare tutti gli elementi
			System.out.print("[");
			for (int j = 0; j < matrix2[i].length; j++) { // Essendo gli array di uguale dimensione potrei anche usare matrix2[0], mentre matrix [i] mi permette di stampare tutti gli elementi anche in caso di Jagged array
				//System.out.println(matrix2[i][j]);
				System.out.printf("%5d", matrix2[i][j]);
			}
			System.out.println("]");
		}

		int[][] jagged = new int[10][];
		for (int i = 0; i < jagged.length; i++) {
			jagged[i] = new int[i];   // Ho creato un array di array crescenti, primo array interno 0 elementi, secondo 1 elemento, terzo 2 elementi, ecc.
		}

		for (int i = 0; i < jagged.length; i++) { // Vado a stampare tutti gli elementi
			System.out.print("[");
			for (int j = 0; j < jagged[i].length; j++) {
				System.out.printf("%5d", jagged[i][j]);
			}
			System.out.println("]");
		}

		int maxNum = findMax(matrix2);
		System.out.println(maxNum);
	}

	public static int findMax(int[][] numbs) {
		int max = numbs[0][0];
		for (int i = 0; i < numbs.length; i++) {
			for (int j = 0; j < numbs[i].length; j++) {
				if (numbs[i][j] > max) {
					max = numbs[i][j];
				}
			}
		}
		return max;
	}
}