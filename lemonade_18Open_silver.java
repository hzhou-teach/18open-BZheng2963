/*
Bill Zheng
Time: 3 min
USACO Test Cases: **********
1-10 Difficulty: 1
Reflection: Easiest silver problem in the history of USACO in my opinion. Such a simple concept, solution, and code.
 */

import java.io.*;
import java.util.*;

public class lemonade_18Open_silver {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("lemonade.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = scan.nextInt();
		}
		Arrays.sort(cows); //sorting the cows, we just want the most patient cows to come first
//--------------------------------------------------------------------------------------------------------------------------
		int length = 0;
		int count = 0;
		for (int i = N-1; i >= 0; i--) {
			if (cows[i] >= length) {
				length++;
				count++;
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		out.println(count);

		out.close();
		scan.close();
	}
}
