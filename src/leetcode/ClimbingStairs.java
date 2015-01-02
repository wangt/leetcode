package leetcode;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * @author wangt
 *
 */
public class ClimbingStairs {

	public int climbStairs(int n) {

		int steps[] = new int[n + 1];

		for (int i = 0; i <= n; i++) {

			if (i == 0) {
				steps[i] = 1;
			} else if (i == 1) {
				steps[i] = 1;
			} else if (i == 2) {
				steps[i] = 2;
			} else {
				steps[i] = steps[i - 1] + steps[i - 2];
			}
		}

		return steps[n];

	}

	public static void main(String[] args) {

		ClimbingStairs cs = new ClimbingStairs();

		System.out.println(cs.climbStairs(4));

	}
}
