import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class beadsTest {

	@Test
	public void testPrev() {
		// Arrange
		beads b = new beads();
		b.N = 29;

		// Act
		int next = b.next(28);

		// Assess
		assertEquals(0, next);
	}

	@Test
	public void testNext() {
		// Arrange
		beads b = new beads();
		b.N = 29;

		// Act
		int prev = b.prev(0);

		// Assess
		assertEquals(28, prev);
	}

	@Test
	public void calculateMaxNumOfBeadsTest() throws IOException {
		// Arrange
		beads b = new beads();
		b.N = 29;
		b.beads = "wwwbbrwrbrbrrbrbrwrwwrbwrwrrb".toCharArray();

		// Act
		int result = b.calculateMaxNumOfBeads();

		// Assess
		assertEquals(11, result);
	}

}
