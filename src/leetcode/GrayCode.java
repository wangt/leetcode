package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/gray-code/
 * 
 * @author wangt
 *
 */
public class GrayCode {

	public List<Integer> grayCode(int n) {
		
		List<Integer> result = new ArrayList<Integer>();

		result.add(0);

		for (int i = 0; i < n; i++) {

			List<Integer> list = new ArrayList<Integer>();

			for (int j = result.size() - 1; j >= 0; j--) {
				list.add(result.get(j) + (int)Math.pow(2, i));
			}

			result.addAll(list);
		}

		return result;

	}

	public static void main(String[] args) {

		GrayCode gc = new GrayCode();

		List<Integer> result = gc.grayCode(0);

		for (Integer n : result) {
			System.out.println(n);
		}

	}

}
