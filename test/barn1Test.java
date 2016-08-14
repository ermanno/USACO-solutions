import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import org.junit.Test;

public class barn1Test {

	@Test
	public void testCollectionReversal() {
		ArrayList<Integer> spaces = new ArrayList<Integer>(Arrays.asList(3, 4, 2, 1));
		Collections.sort(spaces, Collections.reverseOrder());
		assertEquals(new ArrayList<Integer>(Arrays.asList(4,3,2,1)), spaces);
	}
	
	@Test
	public void testCalculateMinimumNumberOfBlockedStalls() throws IOException {
		barn1 b = new barn1();
		
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
		
		int numOfBlockedStalls = b.calculateMinimumNumberOfBlockedStalls(
				maxNumBoards, numStalls, occupiedStallsIndexes);
		
		out.close();
		
		assertEquals(25, numOfBlockedStalls);
	}

}
