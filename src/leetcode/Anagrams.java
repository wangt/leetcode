package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {

		if (strs == null || strs.length == 0) {
			return Collections.emptyList();
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {

			String key = hash(s);

			List<String> value = map.get(key);

			if (value == null) {
				value = new ArrayList<String>();
				map.put(key, value);
			}

			value.add(s);

		}

		List<String> ret = new ArrayList<String>();

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {

			if (entry.getValue().size() > 1) {
				ret.addAll(entry.getValue());
			}

		}

		return ret;

	}

	private String hash(String str) {

		int[] counts = new int[26];

		for (char c : str.toCharArray()) {

			counts[c - 'a']++;

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < counts.length; i++) {

			if (counts[i] != 0) {
				sb.append(counts[i]).append((char) (i + 'a'));
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {

		Anagrams anagram = new Anagrams();

		List<String> result = anagram.anagrams(new String[] { "boo", "bob", "pup", "pup" });

		for (String s : result) {
			System.out.print(s + " ");
		}

	}

}
