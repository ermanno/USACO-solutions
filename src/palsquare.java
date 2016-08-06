
/*
  ID: moser.e1
  LANG: JAVA
  TASK: palsquare
*/

import java.io.*;
import java.util.*;

class palsquare {
	
	public boolean isPalindrome(String string) {
		int N = string.length();
		for (int i = 0; i < N; i++) {
			if (string.charAt(i) != string.charAt(N - 1 - i))
				return false;
		}
		return true;
	}
	
	// 'A', 'B' per 10, 11, etc.
	public String convertNumToBase(int num, int base) throws Exception {
		String numAsString = "";
		while (num > 0) {
			numAsString = repr(num % base) + numAsString;
			num = num / base;
		}
		return numAsString;
	}
	
	public String repr(int i) throws Exception {
		if (i < 10)
			return String.valueOf(i);
		switch (i) {
		case 10:
			return "A";
		case 11:
			return "B";
		case 12:
			return "C";
		case 13:
			return "D";
		case 14:
			return "E";
		case 15:
			return "F";
		case 16:
			return "G";
		case 17:
			return "H";
		case 18:
			return "I";
		case 19:
			return "J";
		default:
			throw new Exception("values can only be between integers in the [10, 20) range");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		palsquare p = new palsquare();
		
		int B = Integer.parseInt(f.readLine());
		
		for (int i = 1; i <= 300; i++) {
			String squareInBaseB = p.convertNumToBase(i*i, B);
			if (p.isPalindrome(squareInBaseB))
				out.println(p.convertNumToBase(i, B) + " " + squareInBaseB);
		}
		
		out.close();
	}
}
