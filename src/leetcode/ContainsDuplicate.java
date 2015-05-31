/**
* https://leetcode.com/problems/contains-duplicate/
*
**/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        
        Set<Integer> numSet = new HashSet<Integer>();
        
        for(int i : nums){
            if(numSet.contains(i)){
                return true;
            }else{
                numSet.add(i);
            }
        }
        
        return false;
    }
}
