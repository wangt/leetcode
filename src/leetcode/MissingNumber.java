package leetcode;

/**
 * https://leetcode.com/problems/missing-number/
 * https://leetcode.com/discuss/56174/3-different-ideas-xor-sum-binary-search-java-code
 *
 * xor / binary search / sum
 */
public class MissingNumber {

	public int missingNumber(int[] nums) {
		int sum = (0 +nums.length) * (nums.length + 1) / 2;
		for(int i:nums){ sum -= i; }
		return sum;
	}

}