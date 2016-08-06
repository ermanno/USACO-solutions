import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class fridayTest {

	@Test
	public void test() {
		//Arrange
		friday f = new friday();
		int[] expectedResult = {36, 33, 34, 33, 35, 35, 34};
		
		//Act
		int[] solution = f.computeSolution(20);
		
		//Assess
		Assert.assertArrayEquals(expectedResult, solution);
	}

}
