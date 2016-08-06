import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;
import java.util.*;

public class gift1Test {

	@Test
	public void gift1Test() throws IOException {
		// Arrange
		String input = String.join("\n"
								   ,"5"
								   ,"dave"
								   ,"laura"
								   ,"owen"
								   ,"vick"
								   ,"amr"
								   ,"dave"
								   ,"200 3"
								   ,"laura"
								   ,"owen"
								   ,"vick"
								   ,"owen"
								   ,"500 1"
								   ,"dave"
								   ,"amr"
								   ,"150 2"
								   ,"vick"
								   ,"owen"
								   ,"laura"
								   ,"0 2"
								   ,"amr"
								   ,"vick"
								   ,"vick"
								   ,"0 0\n");
		
		BufferedReader f = 
				new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));

		// Act
		gift1 gift = new gift1();
		LinkedHashMap<String, Integer> output = gift.solve(f);
		
		// Assess
		assertEquals(new Integer(302), output.get("dave"));
		assertEquals(new Integer(66), output.get("laura"));
		assertEquals(new Integer(-359), output.get("owen"));
		assertEquals(new Integer(141), output.get("vick"));
		assertEquals(new Integer(-150), output.get("amr"));
	}

}
