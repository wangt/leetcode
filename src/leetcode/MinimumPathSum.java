package leetcode;

/**
 * https://oj.leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Note: if can change grid itself, then no extra space is needed. Use grid to
 * save the min value for each cell. Refer to https://oj.leetcode
 * .com/discuss/17111/my-java-solution-using-dp-and-no-extra-space
 * 
 * @author wangt
 *
 */
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int[][] m = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (i == 0 && j == 0) {
					m[i][j] = grid[0][0];
				} else if (i >= 1 && j >= 1) {
					m[i][j] = Math.min(m[i - 1][j], m[i][j - 1]) + grid[i][j];
				} else if (i == 0 && j >= 1) {
					m[i][j] = m[i][j - 1] + grid[i][j];
				} else if (i >= 1 && j == 0) {
					m[i][j] = m[i - 1][j] + grid[i][j];
				}

			}
		}

		return m[grid.length - 1][grid[0].length - 1];

	}

}
