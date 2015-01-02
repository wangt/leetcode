package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author wangt
 *
 */
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {

		List<Integer> result = new ArrayList<Integer>();

		int r = n;
		int m = n;
		while (true) {
			r = m - (m / 26) * 26;
			m = m / 26;
			if (r == 0 && m > 0) {
				m = m - 1;
				r = 26;
			}
			result.add(r);

			if (m <= 0) {
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = result.size() - 1; i >= 0; i--) {
			sb.append((char) ('A' + result.get(i) - 1));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle esc = new ExcelSheetColumnTitle();

		System.out.println(esc.convertToTitle(27));
	}
}
