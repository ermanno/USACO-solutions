import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

public class milkTest {

	@Test
	public void testComputation() throws IOException {
		// setup
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int desiredAmountOfMilk = Integer.parseInt(st.nextToken());
		int numberOfFarmers = Integer.parseInt(st.nextToken());
		List<FarmerOffer> farmerOffers = new ArrayList<FarmerOffer>(numberOfFarmers);

		for (int i = 0; i < numberOfFarmers; i++) {
			StringTokenizer stf = new StringTokenizer(f.readLine());
			FarmerOffer fo = new FarmerOffer(Integer.parseInt(stf.nextToken()), Integer.parseInt(stf.nextToken()));
			farmerOffers.add(fo);
		}
		
		// calculate
		int result = milk.calculateMinimumCost(desiredAmountOfMilk, farmerOffers);
		
		// assess
		assertEquals(630, result);
	}

}
