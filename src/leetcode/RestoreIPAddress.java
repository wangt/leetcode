package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 * 
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author wangt
 *
 */
public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {

		List<String> result = new ArrayList<String>();

		Stack<Integer> stack = new Stack<Integer>();

		backtrack(s, result, 0, stack, 0);

		return result;

	}

	public void backtrack(String s, List<String> result, int index,
			Stack<Integer> stack, int curIndex) {

		if ((s.length() - curIndex) > 3 * (4 - stack.size())) {
			return;
		}

		if (stack.size() == 4 && curIndex != s.length()) {
			return;
		}

		if (stack.size() == 4) {

			StringBuilder sb = new StringBuilder();

			for (int d : stack) {
				sb.append(d + "").append(".");
			}

			String ips = sb.toString();

			result.add(ips.substring(0, ips.length() - 1));

		}

		for (int i = 1; i < 4; i++) {

			int nextCurIndex = curIndex + i;

			if (nextCurIndex > s.length()) {
				break;
			}

			String seg = s.substring(curIndex, nextCurIndex);

			if (seg.startsWith("0") && seg.length() > 1) {
				break;
			}

			int d = Integer.parseInt(seg);

			if (d > 255) {
				break;
			}

			stack.push(d);

			backtrack(s, result, i, stack, nextCurIndex);

			stack.pop();

		}

	}

	public static void main(String[] args) {

		RestoreIPAddress ip = new RestoreIPAddress();

		List<String> result = ip.restoreIpAddresses("25525511135");

		for (String s : result) {
			System.out.println(s);
		}

	}
}
