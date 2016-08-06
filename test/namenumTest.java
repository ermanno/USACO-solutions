import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class namenumTest {
	private ArrayList<String> allowed;
	private namenum n;

	@Before
	public void setup() throws IOException {
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		allowed = new ArrayList<String>();
		String allowedString;
		while ((allowedString = dict.readLine()) != null) {
			allowed.add(allowedString);
		}
		
		n = new namenum();
	}
	
	@Test
	public void testGreg() {
		String brand = "4734";
		boolean actualResult = n.isNameAPossibleTranslationOfBrand("GREG", brand);
		assertTrue(actualResult);
	}

}
