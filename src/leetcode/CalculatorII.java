package leetcode;

import java.util.Stack;

/**
* Reverse polish notation
* https://leetcode.com/problems/basic-calculator-ii/
**/
public class CalculatorII {
	public int calculate(String s) {

		if (s == null || s.trim().length() == 0) {
			return 0;
		}

		int i = 0;

		Stack<String> rpn = new Stack<String>();
		Stack<Character> operators = new Stack<Character>();

		int digitStartIndex = -1;

		do {

			char c = s.charAt(i);

			if (c == ' ') {

				if (digitStartIndex != -1) {
					rpn.push(s.substring(digitStartIndex, i));
					digitStartIndex = -1;
				}

				continue;
			}

			if (c == '*' || c == '/') {

				if (digitStartIndex != -1) {
					rpn.push(s.substring(digitStartIndex, i));
					digitStartIndex = -1;
				}

				while (!operators.isEmpty()) {
					char op = operators.peek();

					if (op == '*' || op == '/') {
						rpn.push(String.valueOf(operators.pop()));
					} else {
						break;
					}
				}

				operators.push(c);
				continue;
			}

			if (c == '+' || c == '-') {

				if (digitStartIndex != -1) {
					rpn.push(s.substring(digitStartIndex, i));
					digitStartIndex = -1;
				}

				while (!operators.isEmpty()) {

					rpn.push(String.valueOf(operators.pop()));

				}

				operators.push(c);

				continue;
			}

			if (c >= '0' && c <= '9') {
				if (digitStartIndex == -1) {
					digitStartIndex = i;
				}

				continue;
			}

		} while (++i < s.length());

		if (digitStartIndex != -1) {
			rpn.push(s.substring(digitStartIndex, s.length()));
		}

		while (!operators.isEmpty()) {
			rpn.push(String.valueOf(operators.pop()));
		}

		Stack<Long> result = new Stack<Long>();

		for (String e : rpn) {

			if (e.equals("+")) {
				result.push(result.pop() + result.pop());
			} else if (e.equals("-")) {
				result.push(0 - (result.pop() - result.pop()));
			} else if (e.equals("*")) {
				result.push(result.pop() * result.pop());
			} else if (e.equals("/")) {
				long numerator = result.pop();
				result.push(result.pop() / numerator);
			} else {
				result.push(Long.parseLong(e));
			}

		}

		return result.pop().intValue();

	}

	public static void main(String args[]) {
		CalculatorII solution = new CalculatorII();
		System.out.println(solution.calculate("1000/1/2"));
	}
}
