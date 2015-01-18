package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * Refer to: http://en.wikipedia.org/wiki/Pascal%27s_triangle
 * 
 * For example, to calculate row 5, the fractions are \tfrac{5}{1},
 * \tfrac{4}{2}, \tfrac{3}{3}, \tfrac{2}{4} and \tfrac{1}{5}, and hence the
 * elements are \tbinom{5}{0}=1, \tbinom{5}{1}=1\times\tfrac{5}{1}=5,
 * \tbinom{5}{2}=5\times\tfrac{4}{2}=10, etc. (The remaining elements are most
 * easily obtained by symmetry.)
 * 
 * @author wangt
 *
 */
public class PascalTriangle2 {

	public List<Integer> getRow(int rowIndex) {

		List<Integer> result = new ArrayList<Integer>();
		result.add(1);

		long lastValue = 1;

		for (int i = 1; i <= rowIndex; i++) {

			lastValue = lastValue * (rowIndex - i + 1) / i;

			result.add((int) lastValue);
		}

		return result;

	}

	public static void main(String[] args) {

		PascalTriangle2 pt = new PascalTriangle2();

		List<Integer> result = pt.getRow(30);

		for (Integer i : result) {
			System.out.println(i);
		}

	}

}
