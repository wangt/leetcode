package leetcode.find_peak_element;

import java.util.Stack;

public class Solution {
	public int findPeakElement(int[] num) {

		if (num.length == 0) {
			return -1;
		}

		if (num.length == 1) {
			return 0;
		}

		Stack<int[]> stack = new Stack<int[]>();

		stack.push(new int[] { 0, num.length - 1 });

		while (!stack.isEmpty()) {

			int[] array = stack.pop();
			int start = array[0];
			int end = array[1];

			if ((end - start) == 1) { // only two elements in array

				if (start == 0 && num[start] > num[end]) {
					return start;
				}

				else if (end == num.length - 1 && num[start] < num[end]) {
					return end;
				}
			}

			int mid = (end - start) / 2 + start;

			if (num[mid - 1] < num[mid] && num[mid] > num[mid + 1]) {
				return mid;
			} else if (num[mid - 1] < num[mid] && num[mid] < num[mid + 1]) {
				stack.push(new int[] { mid, end });
			} else if (num[mid - 1] > num[mid] && num[mid] > num[mid + 1]) {
				end = mid;
				stack.push(new int[] { start, mid });
			} else {
				stack.push(new int[] { mid, end });
				stack.push(new int[] { start, mid });
			}

		}

		return -1; // do not found any peak point

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int peak = solution.findPeakElement(new int[] { 2, 1 });
		System.out.println(peak);

	}
}
