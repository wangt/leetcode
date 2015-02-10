package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/repeated-dna-sequences/ All DNA is composed
 * of a series of nucleotides abbreviated as A, C, G, and T, for example:
 * "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated
 * sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * Solutions:
 * 
 * http://blog.csdn.net/xudli/article/details/43666725
 * 
 * https://oj.leetcode.com/discuss/24478/i-did-it-in-10-lines-of-c
 * 
 * Reference:
 * 
 * http://en.wikipedia.org/wiki/Bit_manipulation
 * 
 * @author wangt
 *
 */
public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {

		if (s == null || s.length() == -1) {
			return Collections.emptyList();
		}

		Map<Character, Integer> mapping = new HashMap<Character, Integer>();

		mapping.put('A', 0);
		mapping.put('C', 1);
		mapping.put('G', 2);
		mapping.put('T', 3);

		Map<Integer, Integer> sequences = new HashMap<Integer, Integer>();

		List<String> result = new ArrayList<String>();

		int hash = 0;

		for (int i = 0; i < s.length(); i++) {

			if (i < 9) {
				hash = hash << 2 | mapping.get(s.charAt(i));
			} else {
				hash = hash << 2 | mapping.get(s.charAt(i));
				hash = hash & ((1 << 20) - 1);

				Integer count = sequences.get(hash);

				if (count != null && count.equals(1)) {
					result.add(s.substring(i - 9, i + 1));
					sequences.put(hash, count + 1);
				} else if (count == null) {
					sequences.put(hash, 1);
				}
			}

		}

		return result;

	}

	public static void main(String[] args) {

		RepeatedDNASequences rs = new RepeatedDNASequences();

		List<String> result = rs.findRepeatedDnaSequences("AAAAAAAAAAAA");

		for (String s : result) {
			System.out.println(s);
		}

	}

}
