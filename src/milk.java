
/*
ID: moser.e1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

class FarmerOffer {
	int price;
	int amountOfMilkPerDay;

	FarmerOffer(int price, int amountOfMilkPerDay) {
		this.price = price;
		this.amountOfMilkPerDay = amountOfMilkPerDay;
	}
}

class milk {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int desiredAmountOfMilk = Integer.parseInt(st.nextToken());
		int numberOfFarmers = Integer.parseInt(st.nextToken());
		List<FarmerOffer> farmerOffers = new ArrayList<FarmerOffer>(numberOfFarmers);

		for (int i = 0; i < numberOfFarmers; i++) {
			StringTokenizer stf = new StringTokenizer(f.readLine());
			FarmerOffer fo = new FarmerOffer(Integer.parseInt(stf.nextToken()), Integer.parseInt(stf.nextToken()));
			farmerOffers.add(fo);
		}

		int result = calculateMinimumCost(desiredAmountOfMilk, farmerOffers);

		out.println(result);

		out.close();
	}

	public static int calculateMinimumCost(int desiredAmountOfMilk, List<FarmerOffer> farmerOffers) {
		// we sort the list of farmer offers according to the price
		Collections.sort(farmerOffers, new Comparator<FarmerOffer>() {
			@Override
			public int compare(FarmerOffer o1, FarmerOffer o2) {
				return o1.price - o2.price;
			}
		});

		int cost = 0;
		
		for (int i = 0; i < farmerOffers.size() && desiredAmountOfMilk > 0; i++) {
			int amountOfMilkPerDay = farmerOffers.get(i).amountOfMilkPerDay;
			int pricePerUnit = farmerOffers.get(i).price;
			int amountToOrder = (desiredAmountOfMilk > amountOfMilkPerDay) ? amountOfMilkPerDay : desiredAmountOfMilk;
			int price = pricePerUnit * amountToOrder;
			cost += price;
			desiredAmountOfMilk -= amountToOrder;
		}
		
		return cost;
	}
}
