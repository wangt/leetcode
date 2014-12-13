package leetcode.best_time_buy_and_sell_stock;

public class Solution {
	public int maxProfit(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}

		int[] profits = new int[prices.length];

		int lowestPrice = prices[0];

		profits[0] = 0;

		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {

			int p1 = prices[i] - lowestPrice;

			if (p1 > profits[i - 1]) {
				profits[i] = p1;
			} else {
				profits[i] = profits[i - 1];
			}

			if (profits[i] > maxProfit) {
				maxProfit = profits[i];
			}

			if (lowestPrice > prices[i]) {

				lowestPrice = prices[i];

			}

		}

		return maxProfit;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		System.out.println(solution.maxProfit(new int[] { 3, 7 }));

		System.out.println(solution.maxProfit(new int[] { 3, 7, 5, 4, 2, 8, 9,
				10 }));

	}
}