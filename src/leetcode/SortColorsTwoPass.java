package leetcode;


/**
 * https://oj.leetcode.com/problems/sort-colors/
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white andblue. Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
**/
public class SortColorsTwoPass{

    public void sortColors(int[] A) {

        if(A == null || A.length == 0){
            return;
        }

        int[] counters = new int[3];

        for(int i=0; i<A.length; i++){
        
            counters[A[i]] += 1;
        
        }

        int j = 0;
        for(int i=0; i< counters.length; i++){

            for(int k = 0; k < counters[i]; k++){

                A[j++] = i;

            }

        }
        
    }

}
