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
 * @date 2022/5/3 15:45
 */

public class SubsequencesSolution {
	
	/**
	 * 求出 s1 和 s2 的最长公共子序列,递归版本，非常耗时
	 *
	 * @param s1
	 * 		序列 1
	 * @param s2
	 * 		序列 2
	 * @return 最长工厂子序列
	 */
	public static int longestCommonSubsequence(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		return longestCommonSubsequenceRecursive(s1.toCharArray(), s2.toCharArray(),
				s1.length() - 1, s2.length() - 1);
	}
	
	/**
	 * 最长公共子序列 Dp 版本
	 */
	public static int longestCommonSubsequenceDp(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int[][] dp = new int[s1.length()][s2.length()];
		dp[0][0] = (ch1[0] == ch2[0] ? 1 : 0);
		for (int i = 1; i < s2.length(); i++) {
			dp[0][i] = ch1[0] == ch2[i] ? 1 : dp[0][i - 1];
		}
		for (int i = 1; i < s1.length(); i++) {
			dp[i][0] = ch1[i] == ch2[0] ? 1 : dp[i - 1][0];
		}
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				int p1 = dp[i - 1][j - 1];
				int p2 = dp[i][j - 1];
				int p3 = dp[i - 1][j];
				int p4 = 0;
				if (ch1[i] == ch2[j]) {
					p4 = p1 + 1;
				}
				dp[i][j] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
			}
		}
		return dp[s1.length() - 1][s2.length() - 1];
	}
	
	private static int longestCommonSubsequenceRecursive(char[] s1, char[] s2, int i, int j) {
		if (i == 0 && j == 0) {
			return s1[i] == s2[j] ? 1 : 0;
		} else if (i == 0) {
			if (s1[i] == s2[j]) {
				return 1;
			} else {
				return longestCommonSubsequenceRecursive(s1, s2, i, j - 1);
			}
		} else if (j == 0) {
			if (s1[i] == s2[j]) {
				return 1;
			} else {
				return longestCommonSubsequenceRecursive(s1, s2, i - 1, j);
			}
		}
		int p1 = longestCommonSubsequenceRecursive(s1, s2, i - 1, j - 1);
		int p2 = longestCommonSubsequenceRecursive(s1, s2, i, j - 1);
		int p3 = longestCommonSubsequenceRecursive(s1, s2, i - 1, j);
		int p4 = 0;
		if (s1[i] == s2[j]) {
			p4 = p1 + 1;
		}
		return Math.max(Math.max(p1, p2), Math.max(p3, p4));
	}
	
}
