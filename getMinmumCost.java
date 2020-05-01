package Company.Test;

import java.util.*;

public class getMinmumCost {

	/*
	 *  Function to return the minimum cost
	 */
	static long minimumCost(long price[], int n) {

		// Sort the price array
		Arrays.sort(price);

		long totalCost = 0;

		/*
		 * Calcualte minimum price of n-2 most costly person
		 */
		for (int i = n - 1; i > 1; i -= 2) {
			if (i == 2) {
				totalCost += price[2] + price[0];
			} else {

				long price_first = price[i] + price[0] + 2 * price[1];
				long price_second = price[i] + price[i - 1] + 2 * price[0];
				totalCost += Math.min(price_first, price_second);
			}
		}

		/*
		 *  Calculate the minimum price of the two cheapest person
		 */
		
		if (n == 1) {
			totalCost += price[0];
		} else {
			totalCost += price[1];
		}

		return totalCost;
	}

	// Driver code
	public static void main(String[] args) {

		/*
		 *  Arrray to Pass inputs
		 */
		
		//Sample Inputs
		// long price[] = { 300,400,600,700 };
		long price[] = { 500, 123, 873 };
		// long price[] = { 1321, 2450 };
		// long price[] = { 1321, 2450 };

		int n = price.length;

		System.out.println("Input Array:" + Arrays.toString(price));
		System.out.println("Minimum Cost:" + minimumCost(price, n));
	}
}