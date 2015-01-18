package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle/
 * 
 * @author wangt
 *
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {

		if (numRows == 0) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> previous = Arrays.asList(1);

		result.add(previous);

		for (int i = 1; i < numRows; i++) {

			List<Integer> list = new ArrayList<Integer>();

			list.add(previous.get(0));

			for (int j = 0; j < previous.size(); j++) {

				if (j + 1 <= previous.size() - 1) {
					list.add(previous.get(j) + previous.get(j + 1));
				}

			}

			list.add(previous.get(previous.size() - 1));
			
			result.add(list);

			previous = list;

		}

		return result;

	}

	public static void main(String[] args) {

		PascalTriangle pt = new PascalTriangle();

		List<List<Integer>> result = pt.generate(5);

		for (List<Integer> list : result) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}

			System.out.println();
		}

	}
}
