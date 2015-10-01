package leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note: You must do this in-place without making a copy of the array.
 * 		Minimize the total number of operations.
 */
public class MoveZeros {
	public void moveZeroes(int[] nums) {

		int p1 = 0, p2 = 0;
		while(p2<nums.length){
			
			if(p1 == p2){
				if(nums[p1] != 0){
					p1++;
				}

			}else{
				if(nums[p2] != 0){
					nums[p1++] = nums[p2];
					nums[p2] = 0;
				}
			}

			p2++;

		}
	}
}