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

			for (int i = 1; i < prices.length; i++) {

				int tmpMaxProfit = 0;

				for (int n = 0; n < i; n++) {

					int profit = profits[k - 1][n] + prices[i] - prices[n];

					if (profit > tmpMaxProfit) {
						tmpMaxProfit = profit;
					}

				}

				if (tmpMaxProfit > profits[k][i - 1]) {
					profits[k][i] = tmpMaxProfit;
				} else {
					profits[k][i] = profits[k][i - 1];
				}

				if (profits[k][i] > maxProfit) {
					maxProfit = profits[k][i];
				}

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