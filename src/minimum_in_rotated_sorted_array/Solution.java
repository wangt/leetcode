package minimum_in_rotated_sorted_array;

public class Solution {

	// binary search
	public int findMin(int[] num) {

		if (num.length == 1) {
			return num[0];
		}

		int startIndex = 0;
		int endIndex = num.length - 1;

		while (true) {

			int idx = startIndex + (endIndex - startIndex) / 2;

			if (num[startIndex] <= num[idx] && num[idx + 1] <= num[endIndex]) {

				return num[startIndex] <= num[idx + 1] ? num[startIndex]
						: num[idx + 1];

			} else {

				if (num[startIndex] > num[idx]) {
					endIndex = idx;
				} else {
					startIndex = idx + 1;
				}

			}

		}

	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		int min = solution.findMin(new int[] { 4, 5, 6, 2, 3 });

		System.out.println(min);

	}
}
