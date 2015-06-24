package leetcode;

/**
* https://leetcode.com/problems/minimum-size-subarray-sum/
* https://leetcode.com/discuss/35464/c-simple-o-n-solution
**/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        
        if(nums == null || nums.length == 0){
    		return 0;
    	}

    	int p0 = 0;
    	int p1 = -1;

    	int minLen = 0;
    	int sum = 0;
    	for(int i=0; i<nums.length; i++){

    		p1++;
    		sum += nums[i];
    		if(sum >= s){

    			while(p0<p1){
	    			if((sum - nums[p0]) >= s){
	    				sum -= nums[p0];
	    				p0++;
	    			}else{
	    				break;
	    			}
    			}

    			if(minLen == 0 || (p1-p0+1) < minLen){
    				minLen = p1-p0+1;
    			}
    		}
    	}

    	return minLen;
        
    }
}
