package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/count-and-say/
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * @author wangt
 *
 */
public class CountAndSay {

	public String countAndSay(int n) {

		char[] chars = new char[] { '1' };

		for (int i = 0; i < n-1; i++) {

			StringBuilder sb = new StringBuilder();

			int counter = 0;
			char preChar = ' ';

			for (int j = 0; j < chars.length; j++) {
				if (preChar != chars[j]) {
					if (counter > 0) {
						sb.append(counter).append(preChar);
						counter = 0;
					}

					preChar = chars[j];
					counter++;
				} else {
					counter++;
				}
			}

			sb.append(counter).append(preChar);
			
			chars = sb.toString().toCharArray();

		}

		return new String(chars);
	}

	public static void main(String[] args) {

		CountAndSay cas = new CountAndSay();

		System.out.println(cas.countAndSay(5));

	}
}
