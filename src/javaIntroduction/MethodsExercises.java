package javaIntroduction;

public class MethodsExercises {
	public static void main(String[] args) {
		//String lastLetterUpperCase = lastLetterUpperCase("HAjajiajjaim");
		System.out.println(MethodsExercises.lastLetterUpperCase("HAjajiajjaib")); //Ex 01 test

		System.out.println(shorterString("Bella zio", "Bella zioneeee", "Bella zio!!!")); //Ex 02 test
		
		String[] strings = {"", " ", "zione", "jbjibi", "Bella ziooooooo"};
		System.out.println(longerString(strings));     //Ex 03 test

		int x = 5;
		int z = 6;
		System.out.println(switchNums(x, z)); //Non funziona perchè non posso fare 2 return, per cui la funzione cambia i parametri, non gli argomenti

		int[] numbers = {2, 4, 645, 3, 2};
		System.out.println(higherNum(numbers)); //Ex 05 test

		int[] nums = {1, 2, 2, 55};
		System.out.println(sumNums(nums)); //Ex 06 test

		String s = "bgdsad";
		System.out.println(noVowelsTF(s)); //Ex 07 test

		String str2 = "abcdedcba";
		System.out.println(strPalindrome(str2));  //Ex 08 test

	}

// 1) creare una funzione che prende in input una stringa e mi ritorna il suo ultimo carattere in maiuscolo
	public static char lastLetterUpperCase(String str) {

		char lastLetter = str.charAt(str.length() - 1);
		char lastUpper = Character.toUpperCase(lastLetter);
		return lastUpper;
	}

	// 2) creare una funzione che prende in input tre stringhe e mi ritorna la piu piccola delle tre. Se ad essere la piu' piccola sono in piu' di una, me ne ritorna una qualsiasi delle piu' piccole
	public static String shorterString(String str1, String str2, String str3) {
		String shortestString = str1;
		if (str2.length() < shortestString.length()) {
			shortestString = str2;
		}
		else if (str3.length() < shortestString.length()) {
			shortestString = str3;
		}
		return shortestString;
	}

	// 3) creare una funzione che prende in input un array di stringhe, e mi ritorna la stringa piu' lunga dell array. Se sono piu' di una, me ne ritorna una qualsiasi delle piu' lunghe.
	public static String longerString(String[] strings) {
		if (strings.length == 0) {
			return "";
		}
		String longerStr = strings[0];
		for (int i = 1; i < strings.length; i++) {
			if (strings[i].length() > longerStr.length()){					
				longerStr = strings[i];
			}
		}
		return longerStr;
	}

	// 4) creare una funzione che scambia i valori di due numeri interi
	public static int switchNums(int x, int y) {
		int tmp = x;
		x = y;
		y = tmp;
		return x; //non posso comunque tornare il risultato per la differenza tra argomenti e parametri, dovrei fare 2 return
	}

	// 5) creare una funzione che riceve in input un array di numeri interi positivi e mi restituisce il suo massimo. Se l array e' vuoto restituisce 0.
	public static int higherNum(int[] numbers) {
		int maxNum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > maxNum) {
				maxNum = numbers[i];
			}
		}
		return maxNum;
	}

	// 6) creare una funzione che riceve in input un array di numeri interi e mi restituisce la loro somma. Se l array e' vuoto mi restituisce -1
	public static int sumNums(int[] numbers) {
		int sum = -1;
		for (int i = 0; i < numbers.length; i++) {
			if (i == 0) {
				sum += 1;
			}
			sum += numbers[i];
		}
		return sum;
	}

	// 7) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa non contiene vocali, false altrimenti
	public static boolean noVowelsTF(String str) {
		boolean noVowels = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				noVowels = false;
				break;
			}
		}
		return noVowels;
	}

	// 8) creare una funzione che riceve in input una stringa e mi restituisce una booleana true se la stringa e' palindroma, false altrimenti
	public static boolean strPalindrome(String str) {
		boolean palindrome = false;
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			char a = str.charAt(i);
			char b = str.charAt(j);
			if (a != b) {
				palindrome = false;
				break;
			}
			else if (a == b) {
				palindrome = true;
			}
		}
		return palindrome;
	}


}