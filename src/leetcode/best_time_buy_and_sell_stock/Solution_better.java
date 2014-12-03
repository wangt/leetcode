package best_time_buy_and_sell_stock2;

public class Solution {
	public int maxProfit(int[] prices) {

		if (prices.length < 1) {
			return 0;
		}

		int maxProfit = 0;

		int[][] profits = new int[3][prices.length];

		for (int i = 0; i < prices.length; i++) {
			profits[0][i] = 0;
		}

		for (int i = 0; i < 3; i++) {

			profits[i][0] = 0;

		}

		for (int k = 1; k < 3; k++) {

			int tmpMaxProfit = profits[k - 1][0] - prices[0];

			for (int i = 1; i < prices.length; i++) {

				profits[k][i] = Math.max(profits[k][i - 1], prices[i]
						+ tmpMaxProfit);

				tmpMaxProfit = Math.max(tmpMaxProfit, profits[k - 1][i]
						- prices[i]);

				maxProfit = Math.max(maxProfit, profits[k][i]);

			}

		}

		return maxProfit;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		System.out.println(solution.maxProfit(new int[] { 3, 7, 5, 4, 2, 8, 9,
				10 }));

	}
}