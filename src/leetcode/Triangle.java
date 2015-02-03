package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/triangle/
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * @author wangt
 *
 */
public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		int[] path = new int[triangle.get(triangle.size() - 1).size() + 1];

		for (int i = triangle.size() - 1; i >= 0; i--) {

			for (int j = 0; j <= i; j++) {

				path[j] = Math.min(path[j], path[j + 1]) + triangle.get(i).get(j);

			}

		}

		return path[0];

	}

	public static void main(String[] args) {

		Triangle t = new Triangle();

		List<List<Integer>> m = new ArrayList<List<Integer>>();

		m.add(Arrays.asList(-1));
		m.add(Arrays.asList(2, 3));
		m.add(Arrays.asList(1, -1, -3));

		System.out.println(t.minimumTotal(m));

	}

}
