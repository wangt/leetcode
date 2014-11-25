package leetcode.two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {

		int[] result = new int[2];

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {

			int n1 = numbers[i];

			Integer idx = map.get(target - n1);

			if (idx != null) {

				result[0] = idx > i ? i + 1 : idx + 1;
				result[1] = idx > i ? idx + 1 : i + 1;

				break;

			}

			map.put(n1, i);

		}

		return result;

	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		int[] result = solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println(result[0] + "," + result[1]);

	}
}