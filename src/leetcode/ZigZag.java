package leetcode;

/**
 * https://oj.leetcode.com/problems/zigzag-conversion/
 * 
 * https://oj.leetcode.com/discuss/14105/what-does-zigzag-means
 * 
 * @author wangt
 *
 */
public class ZigZag {

	public String convert(String s, int nRows) {

		if (s == null || s.length() == 0) {
			return "";
		}

		if (nRows == 1) {
			return s;
		}

		if (s.length() <= nRows) {
			return s;
		}

		char[] chars = s.toCharArray();

		int len = chars.length;

		StringBuilder sb = new StringBuilder();

		int cols = (int) Math.ceil(len * 1.0 / (nRows - 1));

		int preIndex = -1;

		for (int row = 0; row < nRows; row++) {

			for (int col = 0; col < cols; col++) {

				int index = 0;
				if (col % 2 == 0) {
					index = col * (nRows - 1) + row;
				} else {
					index = (col + 1) * (nRows - 1) - row;
				}

				if (index >= chars.length) {
					break;
				}

				if (preIndex != index) {
					sb.append(chars[index]);
					preIndex = index;
				}
			}
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		ZigZag zz = new ZigZag();

		System.out.println(zz.convert("PAYPALISHIRING", 3));
	}
}
