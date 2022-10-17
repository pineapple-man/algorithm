/**
 * @author pineapple-man
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left, right;
		int area = Integer.MIN_VALUE;
		left = 0;
		right = height.length - 1;
		while (left < right) {
			int tempArea = (right - left) * Math.min(height[left], height[right]);
			area = Math.max(area, tempArea);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return area;
	}
}
