package misc;

public class QuickSort {

	public void sort(int[] nums, int start, int end) {

		if (start > end) {
			return;
		}

		int r = partition(nums, start, end);
		sort(nums, start, r - 1);
		sort(nums, r + 1, end);

	}

	public int partition(int[] nums, int start, int end) {

		int r = start - 1;

		for (int i = start; i < end - 1; i++) {

			if (nums[i] <= nums[end]) {
				r++;
				exchange(nums, i, r);
			}

		}

		r++;

		exchange(nums, r, end);

		return r;
	}

	public void exchange(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {

		QuickSort sorter = new QuickSort();

		int[] nums = { 3, 2, 53, 23, 56, 65, 10 };
		sorter.sort(nums, 0, nums.length - 1);

		for (int n : nums) {
			System.out.println(n);
		}

	}

}
