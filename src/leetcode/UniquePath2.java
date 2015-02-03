package leetcode;

/**
 * https://oj.leetcode.com/problems/unique-paths-ii/
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example, There is one obstacle in the middle of a 3x3 grid as illustrated
 * below.
 * 
 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * @author wangt
 *
 */
public class UniquePath2 {

	public int uniquePathsWithObstacles(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
			return 0;
		}

		int[][] paths = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 1) {
					paths[i][j] = 0;
				} else {

					if (i == 0 && j == 0) {
						paths[i][j] = 1;
					} else if (i == 0 && j > 0) {
						paths[i][j] = paths[i][j - 1];
					} else if (i > 0 && j == 0) {
						paths[i][j] = paths[i - 1][j];
					} else if (i > 0 && j > 0) {
						paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
					}
				}

			}

		}

		return paths[grid.length - 1][grid[0].length - 1];

	}

	public static void main(String[] args) {

		UniquePath2 up2 = new UniquePath2();

		System.out.println(up2.uniquePathsWithObstacles(new int[][] { { 0, 0 }, { 0, 0 } }));

	}

}
