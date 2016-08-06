import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;

import org.junit.Test;

public class rideTest {

	@Test
	public void rideSolve() throws IOException {
		// Arrange
		char[] comet = "COMETQ".toCharArray();
		char[] group = "HVNGAT".toCharArray();
		ride r = new ride();
		
		// Act
		String action = r.solve(comet, group);
		
		// Assert
		assertEquals(action, "GO");
	}

}
