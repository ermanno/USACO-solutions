
/*
ID: moser.e1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

class beads {
	public int N;
	public char[] beads;

	public int prev(int pos) {
		assert (pos >= 0 && pos < N);
		if (pos == 0)
			return N - 1;
		else
			return pos - 1;
	}

	public int next(int pos) {
		assert (pos >= 0 && pos < N);
		if (pos == N - 1)
			return 0;
		else
			return pos + 1;
	}

	/**
	 * This function takes the length of the beads sequence and the beads
	 * sequence, and calculates the maximum result achievable by splitting the
	 * beads at position i.
	 * <p>
	 * In this implementation, splitting at position i means that we start
	 * looking backwards from beads[i] and forward from beads[next(i, N)]. Note
	 * that we do not use beads[i + 1] because i could be equal to N - 1, and
	 * beads[N] would be out of range.
	 * <p>
	 * One final observation to make is that N is at least equal to 3 (we do not
	 * have to deal with stuff like beads with length 0, 1 or 2).
	 * 
	 * @param N
	 *            the number of beads
	 * @param beads
	 *            the beads
	 * @return the maximum result obtainable by splitting the beads
	 */
	public int calculateMaxNumOfBeads() {
		int max = 0;

		for (int i = 0; i < N; i++) {
			int pos = i;
			int tempMax = 0;
			boolean[] visited = new boolean[N];
			char color = beads[pos];
			visited[pos] = true;
			tempMax++;
			while (!visited[prev(pos)] && (color == 'w' || beads[prev(pos)] == color || beads[prev(pos)] == 'w')) {
				pos = prev(pos);
				visited[pos] = true;
				tempMax++;

				if (color == 'w' && beads[pos] != 'w')
					color = beads[pos];
			}
			
			pos = next(i);
			if (!visited[pos]) {
				color = beads[pos];
				visited[pos] = true;
				tempMax++;
				while (!visited[next(pos)] && (color == 'w' || beads[next(pos)] == color || beads[next(pos)] == 'w')) {
					pos = next(pos);
					visited[pos] = true;
					tempMax++;

					if (color == 'w' && beads[pos] != 'w')
						color = beads[pos];
				}
			}
			
			max = Math.max(max, tempMax);
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

		beads b = new beads();
		b.N = Integer.parseInt(f.readLine());
		b.beads = f.readLine().toCharArray();

		out.println(b.calculateMaxNumOfBeads());

		out.close();
	}
}
