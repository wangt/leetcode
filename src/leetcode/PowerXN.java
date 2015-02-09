package leetcode;

/**
 * https://oj.leetcode.com/problems/powx-n/
 * 
 * Implement pow(x, n).
 * 
 * @author wangt
 *
 */
public class PowerXN {

	public double pow(double x, int n) {

		if (n == 0) {
			return 1;
		}

		else if (n == 1) {
			return x;
		}

		else if (n == -1) {
			return 1 / x;
		}

		double r = pow(x, n / 2);

		if (n % 2 == 0) {
			return r * r;
		} else {

			return r * r * pow(x, n - 2 * (n / 2));
		}
	}

}
