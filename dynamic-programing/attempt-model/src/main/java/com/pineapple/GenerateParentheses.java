package com.pineapple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pineapple-man
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		char[] ch = new char[n << 1];
		List<String> ans = new ArrayList<>();
		f(ch, 0, 0, n, ans);
		return ans;
	}
	
	/**
	 * @param leftMinusRightParenthesesNumber
	 * 		在已经做的决定中，左括号与右括号数目相减等于多少
	 * @param leftRest
	 * 		还剩下多少个左括号可以填
	 *
	 * @author pineapple-man
	 * @date 2022/10/19
	 */
	public void f(char[] ch, int index, int leftMinusRightParenthesesNumber, int leftRest,
	              List<String> ans) {
		if (index == ch.length) {
			ans.add(new String(ch));
		} else {
			if (leftRest > 0) {
				ch[index] = '(';
				f(ch, index + 1, leftMinusRightParenthesesNumber + 1,
						leftRest - 1, ans);
			}
			if (leftMinusRightParenthesesNumber > 0) {
				ch[index] = ')';
				f(ch, index + 1, leftMinusRightParenthesesNumber - 1,
						leftRest, ans);
			}
		}
	}
}
