/*
ID: moser.e1
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

class transform {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		int N = Integer.parseInt(f.readLine());
		
		char[][] original = new char[N][N];
		char[][] transformed = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			char[] row = f.readLine().toCharArray();
			original[i] = row;
		}
		
		for(int i = 0; i < N; i++) {
			char[] row = f.readLine().toCharArray();
			transformed[i] = row;
		}
		
		transform t = new transform();
		int minNumbefOfTransformations = t.calculateMinNumOfTransformations(N, original, transformed);

		out.println(minNumbefOfTransformations);
		out.close();
	}

	/**
	 * We go from the 1 to 7, so that we get the first transformation that works.
	 * 
	 * @return minimum index of the transformation [1-7]
	 */
	public int calculateMinNumOfTransformations(int N, char[][] original, char[][] transformed) {
		if (areEqual(N, transformed, rotate90degrees(N, original))) {
			return 1;
		} else if (areEqual(N, transformed, rotate180degrees(N, original))) {
			return 2;
		} else if (areEqual(N, transformed, rotate270degrees(N, original))) {
			return 3;
		} else if (areEqual(N, transformed, reflect(N, original))) {
			return 4;
		} else if (areEqual(N, transformed, rotate90degrees(N, reflect(N, original)))
				   || areEqual(N, transformed, rotate180degrees(N, reflect(N, original)))
				   || areEqual(N, transformed, rotate270degrees(N, reflect(N, original)))) {
			return 5;
		} else if (areEqual(N, transformed, original)) {
			return 6;
		} else {
			return 7;
		}
	}

	public boolean areEqual(int N, char[][] original, char[][] transformed) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (original[i][j] != transformed[i][j])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * 90 degree rotation is:
	 * (i, j) -> (j, N - 1 - i)
	 * 
	 * @param N
	 * @param original
	 * @return
	 */
	public char[][] rotate90degrees(int N, char[][] original) {
		char[][] transformed = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				transformed[j][N - 1 - i] = original[i][j];
			}
		}
		return transformed;
	}

	/**
	 * 180 degree rotation, simply 2 90 degree rotations
	 * 
	 * @param N
	 * @param original
	 * @return
	 */
	public char[][] rotate180degrees(int N, char[][] original) {
		return rotate90degrees(N, rotate90degrees(N, original));
	}

	/**
	 * 270 degree rotation, simply 3 90 degree rotations
	 * 
	 * @param N
	 * @param original
	 * @return
	 */
	public char[][] rotate270degrees(int N, char[][] original) {
		return rotate90degrees(N, rotate90degrees(N, rotate90degrees(N, original)));
	}

	/**
	 * Reflection is:
	 * (i, j) -> (i, N - 1 - j)
	 * 
	 * @param N
	 * @param original
	 * @return
	 */
	public char[][] reflect(int N, char[][] original) {
		char[][] transformed = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				transformed[i][N - 1 - j] = original[i][j];
			}
		}
		return transformed;
	}
}
