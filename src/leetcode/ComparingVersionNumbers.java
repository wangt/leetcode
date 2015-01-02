package leetcode;

/**
 * 
 * https://oj.leetcode.com/problems/compare-version-numbers/
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author wangt
 *
 */
public class ComparingVersionNumbers {

	public int compareVersion(String version1, String version2) {

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int len = v1.length > v2.length ? v1.length : v2.length;

		for (int i = 0; i < len; i++) {

			int n1 = 0, n2 = 0;

			if (i < v1.length) {
				n1 = Integer.valueOf(v1[i]);
			}

			if (i < v2.length) {
				n2 = Integer.valueOf(v2[i]);
			}

			int r = n1 - n2;
			if (r < 0) {
				return -1;
			} else if (r > 0) {
				return 1;
			}

		}

		return 0;

	}

	public static void main(String[] args) {
		ComparingVersionNumbers cv = new ComparingVersionNumbers();

		System.out.println(cv.compareVersion("1.0", "1"));
	}

}
