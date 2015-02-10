package leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13",
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author wangt
 *
 */
public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {

		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < tokens.length; i++) {

			if (isOperator(tokens[i])) {
				stack.push(String.valueOf(calculate(stack.pop(), stack.pop(), tokens[i])));
			} else {
				stack.push(tokens[i]);
			}

		}

		return Integer.parseInt(stack.pop());

	}

	private int calculate(String s1, String s2, String operator) {

		Integer n1 = Integer.parseInt(s2);

		Integer n2 = Integer.parseInt(s1);

		switch (operator.charAt(0)) {

		case '+':
			return n1 + n2;

		case '-':
			return n1 - n2;

		case '*':
			return n1 * n2;

		case '/':
			return n1 / n2;

		}

		return -1;
	}

	private boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	public static void main(String[] args) {

		EvaluateReversePolishNotation er = new EvaluateReversePolishNotation();

		System.out.println(er.evalRPN(new String[] { "2", "1", "+", "3", "*" }));

	}

}
