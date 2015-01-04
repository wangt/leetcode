package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author wangt
 *
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		if (s.length() % 2 == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		Map<Character, Character> pairs = new HashMap<Character, Character>();

		pairs.put(')', '(');
		pairs.put('}', '{');
		pairs.put(']', '[');

		for (char c : s.toCharArray()) {

			if (stack.isEmpty()) {
				stack.push(c);
			} else {

				char c1 = stack.peek();

				if (pairs.containsKey(c) && c1 == pairs.get(c)) {
					stack.pop();
				} else {
					stack.push(c);
				}

			}

		}

		return stack.isEmpty();

	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();

		System.out.println(vp.isValid("[]{[]}"));
	}
}
