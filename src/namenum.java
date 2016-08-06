
/*
  ID: moser.e1
  LANG: JAVA
  TASK: namenum
*/

import java.io.*;
import java.util.*;

class namenum {

	public String getBrandOfName(String name) {
		String ans = "";
		for (char c : name.toCharArray()) {
			if (c == 'A' || c == 'B' || c == 'C')
				ans += "2";
			if (c == 'D' || c == 'E' || c == 'F')
				ans += "3";
			if (c == 'G' || c == 'H' || c == 'I')
				ans += "4";
			if (c == 'J' || c == 'K' || c == 'L')
				ans += "5";
			if (c == 'M' || c == 'N' || c == 'O')
				ans += "6";
			if (c == 'P' || c == 'R' || c == 'S')
				ans += "7";
			if (c == 'T' || c == 'U' || c == 'V')
				ans += "8";
			if (c == 'W' || c == 'X' || c == 'Y')
				ans += "9";
		}
		return ans;
	}

	public boolean isNameAPossibleTranslationOfBrand(String name, String brand) {
		if (getBrandOfName(name).equals(brand))
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		ArrayList<String> allowed = new ArrayList<String>();
		String allowedString;
		while ((allowedString = dict.readLine()) != null) {
			allowed.add(allowedString);
		}
		
		namenum n = new namenum();

		String brand = f.readLine();
		
		List<String> translations = new ArrayList<String>();
		for (String a : allowed) {
			if (n.isNameAPossibleTranslationOfBrand(a, brand)) {
				translations.add(a);
				out.println(a);
			}
		}
		
		if (translations.isEmpty())
			out.println("NONE");

		out.close();
	}
}
