package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * @author wangt
 *
 */
public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums == null || nums.length <= 1) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {

			int num = nums[i];

			Integer idx = map.get(num);

			if (idx == null) {
				map.put(num, i);
			} else {

				if (Math.abs(idx - i) <= k) {
					return true;
				} else {
					map.put(num, i);
				}

			}
		}

		return false;

	}

	public static void main(String[] args) {
		ContainsDuplicateII cd = new ContainsDuplicateII();

		System.out.println(cd.containsNearbyDuplicate(new int[] { -1, -1 }, 1));
	}

}
