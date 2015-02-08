package leetcode;

/**
 * https://oj.leetcode.com/problems/edit-distance/
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * https://oj.leetcode.com/discuss/10426/my-o-mn-time-and-o-n-space-solution-
 * using-dp-with-explanation
 * 
 * http://blog.csdn.net/pickless/article/details/9972325
 * 
 * Note that f[i][j] only depends on f[i-1][j-1], f[i-1][j] and f[i][j-1],
 * therefore we can reduce the space to O(n) by using only the (i-1)th array and
 * previous updated element(f[i][j-1]).
 * 
 * 
 */
public class EditDistance {

	public int minDistance2(String word1, String word2) {

		if (word1 == null || word1.equals("")) {
			return word2.length();
		}

		if (word2 == null || word2.equals("")) {
			return word1.length();
		}

		int[][] A = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i <= word1.length(); i++) {
			A[i][0] = i;
		}

		for (int i = 0; i <= word2.length(); i++) {
			A[0][i] = i;
		}

		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {

				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					A[i][j] = A[i - 1][j - 1];
				} else {
					A[i][j] = A[i - 1][j - 1] + 1;
				}

				A[i][j] = Math.min(A[i][j], Math.min(A[i - 1][j], A[i][j - 1]) + 1);

			}
		}

		return A[word1.length()][word2.length()];
	}

	/**
	 * O(n) space
	 * 
	 * Note that f[i][j] only depends on f[i-1][j-1], f[i-1][j] and f[i][j-1],
	 * therefore we can reduce the space to O(n) by using only the (i-1)th array
	 * and previous updated element(f[i][j-1]).
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {

		if (word1 == null || word1.equals("")) {
			return word2.length();
		}

		if (word2 == null || word2.equals("")) {
			return word1.length();
		}

		int[] A = new int[word2.length() + 1];

		for (int i = 0; i <= word2.length(); i++) {
			A[i] = i;
		}

		for (int i = 1; i <= word1.length(); i++) {

			int pre = i;

			for (int j = 1; j <= word2.length(); j++) {

				int cur = 0;
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					cur = A[j - 1];
				} else {
					cur = Math.min(A[j - 1], Math.min(A[j], pre)) + 1;
				}

				A[j - 1] = pre;
				pre = cur;

			}

			A[word2.length()] = pre;
		}

		return A[word2.length()];

	}

	public static void main(String[] args) {

		EditDistance ed = new EditDistance();

		System.out.println(ed.minDistance("ab", "a"));

	}
}
