
/*
ID: moser.e1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday {

	private boolean isLeap(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
	
	int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private int monthLength(int month, int year) {
		if (month == 1 && isLeap(year))
			return daysInMonth[month] + 1;
		else
			return daysInMonth[month];
	}
	
	public int[] computeSolution(int N) {
		int[] daysOfTheWeek = new int[7];

		int thirteenth = 0;
		for (int year = 1900; year < 1900 + N; year++) {
			for (int month = 0; month < 12; month++) {
				daysOfTheWeek[thirteenth]++;
				thirteenth = (thirteenth + monthLength(month, year)) % 7;
			}
		}

		return daysOfTheWeek;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

		int N = Integer.parseInt(f.readLine());
		
		friday fri = new friday();
		int[] solution = fri.computeSolution(N);
		for(int i = 0; i < 6; i++)
			out.print(solution[i] + " ");
		out.print(solution[6] + "\n");

		out.close();
	}
}
