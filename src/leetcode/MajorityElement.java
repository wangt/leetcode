package leetcode;

/**
 * https://oj.leetcode.com/problems/majority-element/
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Solution: https://oj.leetcode.com/problems/majority-element/solution/
 * 
 * @author wangt
 *
 */
public class MajorityElement {

	public int majorityElement(int[] num) {
		if (num.length <= 2) {
			return num[0];
		}

		Integer candidate = null;

		int times = 0;

		for (int i = 0; i < num.length; i++) {

			if (candidate == null || times == 0) {
				candidate = num[i];
				times++;
			} else if (candidate == num[i]) {
				times++;

				if (times > num.length / 2) {
					return candidate;
				}

			} else if (candidate != num[i]) {
				times--;
			}

		}

		return candidate;

	}

	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();

		System.out.println(me.majorityElement(new int[] { 1, 2 }));

	}
}
