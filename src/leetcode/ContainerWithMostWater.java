package leetcode;

/**
 * https://oj.leetcode.com/problems/container-with-most-water/
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * Greedy
 * 
 * Solution:
 * https://oj.leetcode.com/discuss/11482/yet-another-way-to-see-what-happens
 * -in-the-o-n-algorithm
 * 
 * @author wangt
 *
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;

		int area = 0;

		while (i < j) {
			area = Math.max(area, Math.min(height[i], height[j]) * (j - i));

			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}

		}

		return area;
	}

}
