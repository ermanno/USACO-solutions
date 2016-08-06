/*
ID: moser.e1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride {

	public int hash(char[] stringa) {
		int code = 1; // safe because we have at least 1 letter
		for (char c : stringa) {
			code *= (c - (int)'A' + 1);
		}
		return code % 47;
	}
	
	public String solve(char[] comet, char[] group) throws IOException {
		if (hash(comet) == hash(group))
			return("GO");
		else
			return("STAY");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		char[] comet = f.readLine().toCharArray();
		char[] group = f.readLine().toCharArray();
		ride r = new ride();
		out.println(r.solve(comet, group));
		out.close();
	}
}
