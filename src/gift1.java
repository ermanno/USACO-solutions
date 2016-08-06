
/*
ID: moser.e1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class gift1 {

	public LinkedHashMap<String, Integer> solve(BufferedReader f) throws IOException {
		int numberOfFriends = Integer.parseInt(f.readLine());

		LinkedHashMap<String, Integer> friendsAccounts = new LinkedHashMap<String, Integer>();

		for (int i = 0; i < numberOfFriends; i++) {
			friendsAccounts.put(f.readLine(), 0);
		}

		String giver;
		while ((giver = f.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int initialAmount = Integer.parseInt(st.nextToken());
			int numberOfReceivers = Integer.parseInt(st.nextToken());
			
			if (numberOfReceivers == 0)
				continue;
			
			int amountPerReceiver = initialAmount / numberOfReceivers;
			int remainder = initialAmount % numberOfReceivers;

			friendsAccounts.put(giver, friendsAccounts.get(giver) + remainder - initialAmount);
			
			for (int i = 0; i < numberOfReceivers; i++) {
				String receiver = f.readLine();
				friendsAccounts.put(receiver, friendsAccounts.get(receiver) + amountPerReceiver);
			}
		}

		return friendsAccounts;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		gift1 gift = new gift1();
		for(Entry<String, Integer> entry : gift.solve(f).entrySet())
			out.println(entry.getKey() + " " + entry.getValue());

		out.close();
	}

}
