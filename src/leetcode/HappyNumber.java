package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 * 
 * 
 * Solution 1:
 * https://leetcode.com/discuss/32829/java-hashset-solution-any-suggestions
 * 
 * 
 * Like circle detection in linkedlist, another solution:
 * 
 * https://leetcode.com/discuss/33055/my-solution-in-c-o-1-space-and-no-magic-
 * math-property-involved
 * 
 * @author wangt
 *
 */
public class HappyNumber {
	
	public boolean isHappy(int n) {
		Set<Integer> result = new HashSet<Integer>();
		int num = n;
		while (true) {
			int r = 0;
			for (char c : String.valueOf(num).toCharArray()) {
				r += Math.pow(c - '0', 2);
			}

			if (r == 1) {
				return true;
			}

			if (result.contains(r)) {
				return false;
			}

			result.add(r);
			num = r;
		}
	}
}
