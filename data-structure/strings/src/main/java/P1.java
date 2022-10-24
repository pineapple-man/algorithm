import java.util.HashSet;
import java.util.Set;

/**
 * @author pineapple-man
 */
public class P1 {
	public static int solution(String[] arr) {
		Set<Integer> ans = new HashSet<>();
		for (String s : arr) {
			ans.add(filter(s));
		}
		return ans.size();
	}
	
	/** 使用 bit-map 的思想，很经典 */
	public static int filter(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			ans |= 1 << index;
		}
		return ans;
	}
}
