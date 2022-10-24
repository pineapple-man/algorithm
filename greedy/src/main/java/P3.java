import java.util.Arrays;

/**
 * @author pineapple-man
 */
public class P3 {
	/*时间复杂度 O(N*logN)*/
	public static int solution(int[] ability, int k) {
		int ans = 0;
		boolean[] used = new boolean[ability.length];
		Arrays.sort(ability);
		int l, r;
		l = r = 0;
		while (r < ability.length) {
			if (used[l]) {
				l++;
				continue;
			}
			if (used[r]) {
				r++;
				continue;
			}
			if (l < r) {
				int distance = ability[r] - ability[l];
				if (distance == k) {
					used[r] = true;
					used[l] = true;
					ans++;
				} else if (distance < k) {
					r++;
				} else {
					l++;
				}
			} else {
				r++;
			}
		}
		return ans;
	}
}
