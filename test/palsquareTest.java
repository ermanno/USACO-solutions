import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class palsquareTest {

	@Test
	public void testIsAbbaPalindrome() {
		palsquare p = new palsquare();
		assertTrue(p.isPalindrome("abba"));
	}
	
	@Test
	public void testIsSingleLetterPalindrome() {
		palsquare p = new palsquare();
		assertTrue(p.isPalindrome("a"));
	}
	
	@Test
	public void testIsNotCadPalindrome() {
		palsquare p = new palsquare();
		assertFalse(p.isPalindrome("cad"));
	}

	@Test
	public void testRepr4Is4() throws Exception {
		palsquare p = new palsquare();
		assertEquals("4", p.repr(4));
	}

	@Test
	public void testRepr11IsB() throws Exception {
		palsquare p = new palsquare();
		assertEquals("B", p.repr(11));
	}

}
