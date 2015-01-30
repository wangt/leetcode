package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * @author wangt
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations(String digits) {

		if (digits == null || digits.trim().length() == 0) {
			return Arrays.asList("");
		}

		Map<Character, List<Character>> mapping = new HashMap<Character, List<Character>>();

		mapping.put('2', Arrays.asList('a', 'b', 'c'));
		mapping.put('3', Arrays.asList('d', 'e', 'f'));
		mapping.put('4', Arrays.asList('g', 'h', 'i'));
		mapping.put('5', Arrays.asList('j', 'k', 'l'));
		mapping.put('6', Arrays.asList('m', 'n', 'o'));
		mapping.put('7', Arrays.asList('p', 'q', 'r', 's'));
		mapping.put('8', Arrays.asList('t', 'u', 'v'));
		mapping.put('9', Arrays.asList('w', 'x', 'y', 'z'));
		// mapping.put(0, Arrays.asList(' '));

		List<String> result = new ArrayList<String>();

		char[] ds = digits.trim().toCharArray();
		List<Character> nums = new ArrayList<Character>();

		for (int i = 0; i < ds.length; i++) {

			if (mapping.containsKey(ds[i])) {
				nums.add(ds[i]);
			}

		}

		dfs(result, new Stack<Character>(), 0, nums, mapping);

		return result;

	}

	private void dfs(List<String> result, Stack<Character> stack, int index, List<Character> digits,
			Map<Character, List<Character>> mapping) {

		if (stack.size() == digits.size()) {
			StringBuilder sb = new StringBuilder();
			for (Character c : stack) {
				sb.append(c);
			}
			result.add(sb.toString());
		}

		if (index > digits.size() - 1) {
			return;
		}

		List<Character> chars = mapping.get(digits.get(index));

		for (Character c : chars) {
			stack.push(c);
			dfs(result, stack, index + 1, digits, mapping);
			stack.pop();
		}

	}

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();

		List<String> results = lc.letterCombinations("234");

		for (String s : results) {
			System.out.println(s);
		}
	}
}
