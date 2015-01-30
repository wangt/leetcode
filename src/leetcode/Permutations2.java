package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://oj.leetcode.com/problems/permutations/
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author wangt
 *
 */
public class Permutations2 {

	public List<List<Integer>> permuteUnique(int[] num) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		populate(map, num);
		permuteUnique(map, new ArrayList<Integer>(), result, num.length);

		return result;
	}

	private void populate(Map<Integer, Integer> map, int[] num) {
		for (int n : num) {
			if (map.containsKey(n))
				map.put(n, map.get(n) + 1);
			else
				map.put(n, 1);
		}
	}

	private void permuteUnique(Map<Integer, Integer> map, List<Integer> cur, List<List<Integer>> result, int total) {
		if (cur.size() == total) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == 0)
				continue;

			map.put(e.getKey(), e.getValue() - 1);
			cur.add(e.getKey());

			permuteUnique(map, cur, result, total);

			map.put(e.getKey(), e.getValue() + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {

		Permutations2 permutations = new Permutations2();
		List<List<Integer>> result = permutations.permuteUnique(new int[] { 1, 1, 2 });

		for (List<Integer> r : result) {
			for (int i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
