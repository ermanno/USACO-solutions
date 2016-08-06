import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class dualpalTest {

	@Test
	public void testDualpalCalculation() {
		int N = 15;
		int S = 9900;
		ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(new Integer[] { 9958, 10252, 10308,
				10658, 10794, 10858, 10922, 10986, 11253, 11314, 11757, 11898, 11950, 12291, 12355 }));
		dualpal d = new dualpal();

		ArrayList<Integer> result = d.calculateSolution(N, S);

		assertEquals(expectedResult, result);
	}

}
