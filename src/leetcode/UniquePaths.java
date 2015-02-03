package leetcode;

/**
 * https://oj.leetcode.com/problems/unique-paths/
 * 
 * Optimization1:
 * https://oj.leetcode.com/discuss/17530/java-dp-solution-with-complexity-o-n-m
 * 
 * Math way:
 * https://oj.leetcode.com/discuss/15539/trickily-solve-the-problem-with
 * -math-code-is-simple
 * 
 * This problem can be trickily solved with math, the principle is simple: In
 * total the robot should walk m + n - 2 steps, m - 1 steps to right and n - 1
 * steps to bottom, so all what we should do is to select which m - 1 steps to
 * be right, therefore the problem is actually a combination problem, then we
 * just need to calculate (n + m - 2)! / ((m - 1)! * (n - 1)!), here is the
 * code:
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author wangt
 *
 */
public class UniquePaths {

	public int uniquePaths(int m, int n) {

		if (m <= 0 || n <= 0) {
			return 0;
		}

		if (m == 1 || n == 1) {
			return 1;
		}

		int[][] paths = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 || j == 0) {
					paths[i][j] = 1;
				} else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}

			}
		}

		return paths[m - 1][n - 1];

	}

}
