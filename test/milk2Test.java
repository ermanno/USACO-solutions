import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Test;

public class milk2Test {
				
	@Test
	public void integrationTestCalculationMaxOne() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		milk2 m = new milk2();
		int N = Integer.parseInt(f.readLine());
		List<Interval> intervals = m.getSortedInput(f, N);
		m.calculateMinMax(intervals);
		assertEquals(21790, m.maxOne);
	}

	@Test
	public void integrationTestCalculationMaxZero() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		milk2 m = new milk2();
		int N = Integer.parseInt(f.readLine());
		List<Interval> intervals = m.getSortedInput(f, N);
		m.calculateMinMax(intervals);
		assertEquals(8, m.maxZero);
	}
	
}
