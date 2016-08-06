
/*
ID: moser.e1
LANG: JAVA
TASK: dualpal
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class dualpal {
	public char[] convertNumToBase(int num, int base) {
		String numRepresentation = "";
		while (num > 0) {
			numRepresentation = (num % base) + numRepresentation;
			num = num / base;
		}
		return numRepresentation.toCharArray();
	}

	public boolean isNumPalindromic(char[] numRepresentation) {
		int N = numRepresentation.length;
		for (int i = 0; i < N; i++) {
			if (numRepresentation[i] != numRepresentation[N - 1 - i])
				return false;
		}
		return true;
	}

	public boolean isNumPalindromicInBase(int num, int base) {
		char[] numInBase = convertNumToBase(num, base);
		return isNumPalindromic(numInBase);
	}

	public boolean isNumPalindromicInAtLeastTwoBases(int num) {
		int counter = 0;
		for (int base = 2; base <= 10; base++) {
			if (isNumPalindromicInBase(num, base))
				counter++;
			if (counter == 2)
				return true;
		}
		return false;
	}

	public ArrayList<Integer> calculateSolution(int N, int S) {
		ArrayList<Integer> numbersPalindromicInAtLeastTwoBases = new ArrayList<Integer>();
		int counter = 0;
		int num = S + 1;
		while (counter < N) {
			if (isNumPalindromicInAtLeastTwoBases(num)) {
				numbersPalindromicInAtLeastTwoBases.add(num);
				counter++;
			}
			num++;
		}
		return numbersPalindromicInAtLeastTwoBases;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		dualpal d = new dualpal();
		for (Integer i : d.calculateSolution(N, S)) {
			out.println(i);
		}
		
		out.close();
	}
}
