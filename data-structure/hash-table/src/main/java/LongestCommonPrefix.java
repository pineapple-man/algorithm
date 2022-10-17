/**
 * @author pineapple-man
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int min = Integer.MAX_VALUE;
		String ans = strs[0];
		for (String str : strs) {
			int index = 0;
			while (index < str.length() && index < ans.length()) {
				if (str.charAt(index) != ans.charAt(index)) {
					break;
				}
				index++;
			}
			min = Math.min(min, index);
			if (min == 0) {
				return "";
			}
		}
		return ans.substring(0, min);
	}
}
