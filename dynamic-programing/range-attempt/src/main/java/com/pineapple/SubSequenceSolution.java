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
 * @date 2022/5/5 00:42
 */

public class SubSequenceSolution {
	/**
	 * 最长回文子序列
	 *
	 * @param str
	 * 		输入字符串
	 * @return 根据输入字符串，返回其对应的 最长回文字符串长度
	 */
	public static int longestPalindromeSubsequenceRecursive(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		if (str.length() == 1) {
			return 1;
		}
		return rangeAttempt(str.toCharArray(), 0, str.length() - 1);
		
	}
	
	public static int longestPalindromeSubsequenceDp(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		if (str.length() == 1) {
			return 1;
		}
		int n = str.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			dp[i][i] = 1;
			dp[i][i + 1] = str.charAt(i) == str.charAt(i + 1) ? 2 : 1;
		}
		dp[n - 1][n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				int p1 = dp[i + 1][j - 1];
				int p2 = dp[i + 1][j];
				int p3 = dp[i][j - 1];
				int p4 = str.charAt(i) == str.charAt(j) ? p1 + 2 : 0;
				dp[i][j] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
			}
		}
		return dp[0][n - 1];
	}
	
	/**
	 * 在 str[l...r]的范围上最长回文子序列的长度
	 *
	 * @param chars
	 * 		输入字符串
	 * @param l
	 * 		左边界
	 * @param r
	 * 		右边界
	 * @return 在 str[l...r] 上最长回文子序列的长度
	 */
	private static int rangeAttempt(char[] chars, int l, int r) {
		//最长回文子序列是奇数的情况，落到中间元素
		if (l == r) {
			return 1;
		}
		//最长回文子序列是偶数的情况，检查中间两个元素
		if (l == r - 1) {
			return chars[l] == chars[r] ? 2 : 1;
		}
		//str[l] str[r] 均不是当前最长回文子序列的贡献者
		int p1 = rangeAttempt(chars, l + 1, r - 1);
		//str[l] 不是当前回文子序列的贡献者
		int p2 = rangeAttempt(chars, l + 1, r);
		//str[r] 不是当前回文子序列的贡献者
		int p3 = rangeAttempt(chars, l, r - 1);
		int p4 = chars[l] == chars[r] ? p1 + 2 : 0;
		return Math.max(Math.max(p1, p2), Math.max(p3, p4));
	}
}
