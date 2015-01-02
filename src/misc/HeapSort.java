package misc;

public class HeapSort {

	public static void sort(int[] nums) {

		for (int start = 0; start < nums.length - 1; start++) {

			for (int i = start; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}

			System.out.println();

			boolean printed = false;

			for (int i = (nums.length - start) / 2 - 1; i >= 0; i--) {

				if (!printed) {
					System.out.println("start i=" + i);
					printed = true;
				}

				int left = (i + 1) * 2 - 1 + start;

				int right = (i + 1) * 2 + start;

				int min = i + start;

				if (left < nums.length && nums[left] < nums[min]) {
					min = left;
				}

				if (right < nums.length && nums[right] < nums[min]) {
					min = right;
				}

				if (min != i + start) {
					int n = nums[i + start];
					nums[i + start] = nums[min];
					nums[min] = n;
				}

			}

			for (int i = start; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}

			System.out.println("\n\n\n");

		}

	}

	public static void main(String[] args) {

		int[] nums = new int[] { 888888, 23, 44, 22, 12, 55, 1, 66, 3, 7, 8, 4, -3 };

		HeapSort.sort(nums);

		for (int n : nums) {
			System.out.println(n);
		}

	}

}
