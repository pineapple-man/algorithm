/*
 * Copyright (c) 2022. pineapple-man
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pineapple;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/16 14:36
 */

public class BracketEffectiveMatching {
	/**
	 * 使用动态规划获取能够匹配的最长括号子串的长度
	 */
	public static int Solution(String str) {
		int[] dp = new int[str.length()];
		char[] chars = str.toCharArray();
		int ans = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == ')') {
				int pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chars[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
	
	/**
	 * 问题二，获取有效括号的最大嵌套层数
	 */
	public static int Solution2(String str) {
		char[] chars = str.toCharArray();
		int maxCount = 0;
		int cnt = 0;
		for (char c : chars) {
			if (c == '(') {
				cnt++;
			} else if (c == ')') {
				cnt--;
			}
			maxCount = Math.max(maxCount, cnt);
		}
		return maxCount;
	}
	
}
