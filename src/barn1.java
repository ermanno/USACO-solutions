
/*
ID: moser.e1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int maxNumBoards = Integer.parseInt(st.nextToken());
		int numStalls = Integer.parseInt(st.nextToken());
		int numCows = Integer.parseInt(st.nextToken());
		ArrayList<Integer> occupiedStallsIndexes = new ArrayList<Integer>(numCows);
		for (int i = 0; i < numCows; i++) {
			occupiedStallsIndexes.add(Integer.parseInt(f.readLine()));
		}

		int numOfBlockedStalls = calculateMinimumNumberOfBlockedStalls(maxNumBoards, numStalls, occupiedStallsIndexes);

		out.println(numOfBlockedStalls);
		out.close();
	}

	public static int calculateMinimumNumberOfBlockedStalls(
			int maxNumBoards, int numStalls, ArrayList<Integer> occupiedStallsIndexes) {

		// We want the indexes to be ordered.
		Collections.sort(occupiedStallsIndexes);

		// The idea is to split where we have the largest "empty" interval
		// between the starting and ending indexes.
		int numBlockedStalls = 1;
		int numUsedBoards = 1;
		ArrayList<Integer> spaces = new ArrayList<Integer>();
		for (int i = 1; i < occupiedStallsIndexes.size(); i++) {
			int firstIndex = occupiedStallsIndexes.get(i - 1);
			int secondIndex = occupiedStallsIndexes.get(i);

			// The first has already been accounted for (either outside the loop
			// or in the case of the current second, we account for it now,
			// but in the next iteration it will be the next "first" that we
			// will have already accounted for.
			numBlockedStalls += 1;

			int space = secondIndex - 1 - firstIndex;
			if (space > 0) {
				spaces.add(space);
			}
		}

		// We order the spaces by size.
		Collections.sort(spaces, Collections.reverseOrder());

		// We remove the stalls that are part of the "empty" section
		while (numUsedBoards < maxNumBoards && !spaces.isEmpty()) {
			numUsedBoards += 1;
			spaces.remove(0);
		}

		// We add to the total number of blocked stalls the rest of the empty stalls.
		for (Integer space : spaces) {
			numBlockedStalls += space;
		}

		return numBlockedStalls;
	}
}
