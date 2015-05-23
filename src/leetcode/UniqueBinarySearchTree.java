package leetcode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * https://leetcode.com
 * /discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
 * 
 * @author wangt
 *
 */
public class UniqueBinarySearchTree {

	public int numTrees(int n) {
		int[] nums = new int[n + 1];
		nums[0] = 1;
		nums[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				nums[i] += nums[j - 1] * nums[i - j];
			}
		}

		return nums[n];
	}
}
