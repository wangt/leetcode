package leetcode;

/**
 * https://leetcode.com/problems/h-index/
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index. 
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more 
 */
public class HIndex {

    public int hIndex(int[] citations) {
		
		int[] counts = new int[citations.length+1];

		for(int c: citations){
			if(c>citations.length){
				counts[citations.length]++;
			}else{
				counts[c]++;
			}
		}

		int total = 0;
		for(int i=counts.length-1; i>=0; i--){
			total += counts[i];

			if(total >= i){
				return i;
			}

		}

    }

}