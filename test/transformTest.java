import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class transformTest {
	int N;
	char[][] original;
	char[][] transformed;

	BufferedReader f;
	
	@Before
	public void prepareTables() throws IOException {
		f = new BufferedReader(new FileReader("transform.in"));
		N = Integer.parseInt(f.readLine());
		
		original = new char[N][N];
		transformed = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			char[] row = f.readLine().toCharArray();
			original[i] = row;
		}
		
		for(int i = 0; i < N; i++) {
			char[] row = f.readLine().toCharArray();
			transformed[i] = row;
		}
	}
	
	@Test
	public void testMinTransformation() {
		// Arrange
		transform t = new transform();
		int expectedResult = 1;
		
		// Act
		int minNumbefOfTransformations = t.calculateMinNumOfTransformations(N, original, transformed);

		// Assert
		assertEquals(expectedResult, minNumbefOfTransformations);
	}
	
	@Test
	public void test90DegRotation() {
		// Arrange
		transform t = new transform();
		int N = 3;
		char[][] original = {{'@', '-', '@'}, 
						     {'-', '-', '-'}, 
						     {'@', '@', '-'}};
		char[][] expectedResult = {{'@', '-', '@'}, 
								   {'@', '-', '-'}, 
								   {'-', '-', '@'}};
		
		// Act
		char[][] transformed = t.rotate90degrees(N, original);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(transformed[i][j]);
			}
			System.out.print("\n");
		}
		
		// Assert
		assertTrue(t.areEqual(N, expectedResult, transformed));
	}

	@After
	public void closeFileReader() throws IOException {
		f.close();
	}
	
}
