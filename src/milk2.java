
/*
ID: moser.e1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
	long beginning;
	long end;
	
	public Interval(long beginning, long end) {
		this.beginning = beginning;
		this.end = end;
	}
	
	public long getLength() {
		return this.end - this.beginning;
	}

	@Override
	public int compareTo(Interval interval) {
		/*
		 * Nota che in realta` potremmo ritornare qualsiasi numero positivo o negativo,
		 * non necessariamente +1 o -1
		 */
		if (this.beginning > interval.beginning)
			return 1;
		else if (this.beginning == interval.beginning)
			return 0;
		else
			return -1;
	}
}

class milk2 {
	
	long maxOne = 0;
	long maxZero = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		
		milk2 m = new milk2();
		int N = Integer.parseInt(f.readLine());
		
		List<Interval> intervals = m.getSortedInput(f, N);
		
		m.calculateMinMax(intervals);
		
		out.println(m.maxOne + " " + m.maxZero);
		out.close();
	}

	public List<Interval> getSortedInput(BufferedReader f, int N) throws IOException {
		List<Interval> intervals = new ArrayList<Interval>();		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			long beginning = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			intervals.add(new Interval(beginning, end));
		}
		Collections.sort(intervals);
		return intervals;
	}

	public void calculateMinMax(List<Interval> intervals) {
		Interval firstInterval = intervals.get(0);
		long tmpOne = firstInterval.getLength();
		this.maxOne = tmpOne;
		long s = firstInterval.beginning;
		long e = firstInterval.end;
		for (Interval i : intervals) {
			if (i.beginning > e) {
				long t = i.beginning - e;
				this.maxZero = Math.max(this.maxZero, t);
				s = i.beginning;
				e = i.end;
				tmpOne = e - s;
				this.maxOne = Math.max(this.maxOne, tmpOne);
			} else if (i.end > e) {
				e = i.end;
				tmpOne = e - s;
				this.maxOne = Math.max(this.maxOne, tmpOne);
			}
		}
	}

}
