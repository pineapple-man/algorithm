/**
 * @author pineapple-man
 */
public class Reg {
	public static boolean isValid(char[] str, char[] pattern) {
		for (char c : str) {
			if (c == '.' || c == '*') {
				return false;
			}
		}
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '*' && (i == 0 || pattern[i - 1] == '*')) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean f(char[] str, char[] pattern, int si, int pi) {
		// 如果 si 到达了结尾
		if (si >= str.length) {
			//同时 Pi也到达了结尾，匹配成功
			if (pi == pattern.length) {
				return true;
			}
			// make the pattern[pi...pi+1] to be "" to match
			if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
				return f(str, pattern, si, pi + 2);
			}
			return false;
		}
		// 如果 pi 到达了结尾，si 没有到达结尾匹配失败
		if (pi >= pattern.length) {
			return false;
		}
		// 如果 si 和 pi 都没有到达结尾,pattern[pi+1] 不是 *
		if (pi + 1 >= pattern.length || pattern[pi + 1] != '*') {
			return (str[si] == pattern[pi] || pattern[pi] == '.') &&
					f(str, pattern, si + 1, pi + 1);
		}
		// pattern[pi+1] 是 *,但是 pattern[pi] 与 str[si] 不匹配
		if (pattern[pi] != '.' && str[si] != pattern[pi]) {
			return f(str, pattern, si, pi + 2);
		}
		// ?* 是零份匹配
		if (f(str, pattern, si, pi + 2)) {
			return true;
		}
		// 如果 si 和 pi 都没有到达结尾, pattern[pi+1] 是 *
		while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')) {
			if (f(str, pattern, si + 1, pi + 2)) {
				return true;
			}
			si++;
		}
		return false;
	}
	
	public static boolean g(char[] str, char[] pattern, int si, int pi, int[][] dp) {
		if (dp[si][pi] != 0) {
			return dp[si][pi] == 1;
		}
		// 如果 si 到达了结尾
		if (si >= str.length) {
			//同时 Pi也到达了结尾，匹配成功
			if (pi == pattern.length) {
				dp[si][pi] = 1;
				return dp[si][pi] == 1;
			}
			// make the pattern[pi...pi+1] to be "" to match
			if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
				dp[si][pi] = g(str, pattern, si, pi + 2, dp) ? 1 : -1;
				return dp[si][pi] == 1;
			}
			dp[si][pi] = -1;
			return dp[si][pi] == 1;
		}
		// 如果 pi 到达了结尾，si 没有到达结尾匹配失败
		if (pi == pattern.length) {
			dp[si][pi] = -1;
			return dp[si][pi] == 1;
		}
		// 如果 si 和 pi 都没有到达结尾,pattern[pi+1] 不是 *
		if (pi + 1 >= pattern.length || pattern[pi + 1] != '*') {
			dp[si][pi] = ((str[si] == pattern[pi] || pattern[pi] == '.') &&
					g(str, pattern, si + 1, pi + 1, dp)) ? 1 : -1;
			return dp[si][pi] == 1;
		}
		// pattern[pi+1] 是 *,但是 pattern[pi] 与 str[si] 不匹配
		if (pattern[pi] != '.' && str[si] != pattern[pi]) {
			dp[si][pi] = g(str, pattern, si, pi + 2, dp) ? 1 : -1;
			return dp[si][pi] == 1;
		}
		// ?* 作为 ""匹配
		if (g(str, pattern, si, pi + 2, dp)) {
			dp[si][pi] = 1;
			return true;
		}
		// 如果 si 和 pi 都没有到达结尾, pattern[pi+1] 是 *
		while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')) {
			if (g(str, pattern, si + 1, pi + 2, dp)) {
				dp[si][pi] = 1;
				return true;
			}
			si++;
		}
		dp[si][pi] = -1;
		return dp[si][pi] == 1;
	}
	
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();
		int[][] dp = new int[str.length + 1][pattern.length + 1];
		return isValid(str, pattern) && g(str, pattern, 0, 0, dp);
	}
	
	public static void main(String[] args) {
		String a = "aa";
		String b = "a*";
		System.out.println(isMatch(a, b));
	}
}
