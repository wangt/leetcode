package leetcode;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s. 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if(s.length() == 0 && t.length() == 0){
			return true;
		}

		Map<Character, Integer> stats = new HashMap<Character, Integer>();

		for(Character c:s.toCharArray()){

			Integer n = stats.get(c);
			if(n == null) { n = 0; }
			
			stats.put(c, ++n);
		}

		for(Character c: t.toCharArray()){

			Integer n = stats.get(c);

			if(n == null || n <= 0) { return false; }

			if(--n == 0){
				stats.remove(c);
			}else{
				stats.put(c, n);
			}

		}

		return stats.size() == 0;
	}

}