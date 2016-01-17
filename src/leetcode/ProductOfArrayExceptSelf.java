package leetcode;
/**
* https://leetcode.com/problems/product-of-array-except-self/
*
**/
public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums;
        }
        
        int[] results = new int[nums.length];
        results[results.length - 1] = nums[nums.length - 1];
        
        for(int i = nums.length - 2; i>=0; i--) {
            results[i] = nums[i] * results[i+1];
        }
        
        // start to calculate
        // result[n] = (nums[0]*nums[1]***nums[n-1] * results[n+1])
        results[0] = results[1];
        int n = nums[0];
        for(int i = 1; i < nums.length - 1; i++) {
            results[i] = n * results[i+1];
            n = n * nums[i];
        }
        
        results[results.length - 1] = n;
        
        return results;
    }
	
	
	public static void main(String[] args) {
		ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
		int[] results = p.productExceptSelf(new int[]{1,0});
		for(int i = 0; i<results.length; i++) {
			System.out.println(results[i]);
		}
	}
	
}
