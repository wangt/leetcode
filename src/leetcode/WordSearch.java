package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-search/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
 * "SEE", -> returns true, word = "ABCB", -> returns false.
 * 
 * Solution: https://oj.leetcode.com/discuss/6618/ac-in-84ms-by-using-dfs
 * 
 * @author wangt
 *
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {

		if (word == null || word.length() == 0) {
			return false;
		}

		if (board.length == 0 || board[0].length == 0) {
			return false;
		}

		char[] chars = word.toCharArray();
		char c = chars[0];

		int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == c) {
					if (dfs(chars, board, i, j, 0, directions, new HashSet<String>())) {
						return true;
					}
				}

			}

		}

		return false;

	}

	private boolean dfs(char[] chars, char[][] board, int x, int y, int idx, int[][] directions, Set<String> visited) {

		String key = x + "-" + y;

		if (visited.contains(key)) {
			return false;
		}

		if (board[x][y] != chars[idx]) {
			return false;
		}

		visited.add(key);

		if (idx == chars.length - 1) {
			return true;
		}

		for (int i = 0; i < directions.length; i++) {

			int[] d = directions[i];

			int newX = x + d[0];
			int newY = y + d[1];

			if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length
					|| visited.contains(newX + "-" + newY)) {
				continue;
			}

			if (dfs(chars, board, newX, newY, idx + 1, directions, visited)) {
				return true;
			}

		}

		visited.remove(key);

		return false;

	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();

		// System.out.println(ws.exist(new char[][] { { 'A', 'B', 'C', 'E' }, {
		// 'S', 'F', 'C', 'S' },
		// { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(ws.exist(new char[][] { { 'a', 'b' }, { 'c', 'd' } }, "cdba"));
	}
}
