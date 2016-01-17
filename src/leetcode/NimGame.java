package leetcode;

/**
 * https://leetcode.com/problems/nim-game/
 * @author wangtao
 *
 */
public class NimGame {

	// f(n) = !f(n-1) || !f(n-2) || !f(n-3)
	// f(1) = true
	// f(2) = true
	// f(3) = true
	// f(4) = !f(1) || !f(2) || !f(3) = false
	// f(5) = true
	// f(6) = true
	// f(7) = true
	// f(8) = false
	
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}

	public static void main(String[] args) {
		NimGame game = new NimGame();
		System.out.println(game.canWinNim(3));
	}
}
