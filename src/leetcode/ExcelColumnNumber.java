package leetcode;

/**
 * 
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 * 
 * @author wangt
 *
 */
public class ExcelColumnNumber {

	public int titleToNumber(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int sum = 0;

		for (int i = 0; i < s.length(); i++) {

			int n = (s.charAt(i) - 'A' + 1) * (int) Math.pow(26, s.length() - i - 1);
			sum += n;
		}

		return sum;

	}
	
	public static void main(String[] args) {
		
		ExcelColumnNumber ecn = new ExcelColumnNumber();
		
		System.out.println(ecn.titleToNumber("AB"));
		
	}

}
