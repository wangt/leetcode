package leetcode;

/**
 * https://leetcode.com/problems/reverse-bits/
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 * 
 * https://leetcode.com/discuss/27328/java-solution-and-optimization
 * 
 * @author wangt
 *
 */
public class ReverseBits {
	/**
	 * For performance tuning under frequent calling scenario, split the 32 bits
	 * into 4 segments, using a cache which length is 2^8 = 256 to save all
	 * possible result for the 4 bits, combine 4 segments into the final result
	 * 
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {
		int r = 0;
		int one = 1;

		for (int i = 0; i < 32; i++) {
			int t = n & one << i;
			if (t != 0) {
				r |= 1 << (31 - i);
			}
		}

		return r;

	}
}
