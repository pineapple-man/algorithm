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

import com.pineapple.generator.NumericalGenerator;
import com.pineapple.generator.StringGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/3 15:46
 */

class SubsequencesSolutionTest {
	private static int epoch;
	
	@BeforeAll
	public static void init() {
		epoch = NumericalGenerator.getLittleRandomPositiveInt();
	}
	
	/**
	 * 最长公共子序列问题
	 *
	 * @author pineapple-man
	 * @date 2022/5/5
	 */
	@Test
	void longestCommonSubsequenceDp() {
		for (int i = 0; i < epoch; i++) {
			String s1 = StringGenerator.getRandomLengthLowerCaseString(1000);
			String s2 = StringGenerator.getRandomLengthLowerCaseString(1000);
			int i1 = longestCommonSubsequence(s1, s2);
			int i2 = SubsequencesSolution.longestCommonSubsequenceDp(s1, s2);
			Assertions.assertEquals(i1, i2);
		}
	}
	
	/**
	 * Longest common subsequence 递归版本,由于非常耗时，所以仅进行五个样本的测试
	 */
	@Test
	void longestCommonSubsequence() {
		for (int i = 0; i < 5; i++) {
			String s1 = StringGenerator.getRandomLengthLowerCaseString(20);
			String s2 = StringGenerator.getRandomLengthLowerCaseString(20);
			int i1 = longestCommonSubsequence(s1, s2);
			int i2 = SubsequencesSolution.longestCommonSubsequence(s1, s2);
			Assertions.assertEquals(i1, i2);
		}
	}
	
	public static int longestCommonSubsequence(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int N = str1.length;
		int M = str2.length;
		int[][] dp = new int[N][M];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int j = 1; j < M; j++) {
			dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
		}
		for (int i = 1; i < N; i++) {
			dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				int p1 = dp[i - 1][j];
				int p2 = dp[i][j - 1];
				int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
				dp[i][j] = Math.max(p1, Math.max(p2, p3));
			}
		}
		return dp[N - 1][M - 1];
	}
	
	@Test
	void longestPalindromeSubsequenceRecursive() {
		for (int i = 0; i < 4; i++) {
			String s = StringGenerator.getRandomLengthLowerCaseString(20);
			int i1 = longestPalindromeSubsequence(s);
			int i2 = SubsequencesSolution.longestPalindromeSubsequenceRecursive(s);
			Assertions.assertEquals(i1, i2);
		}
	}
	
	public static int longestPalindromeSubsequence(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		char[] str = s.toCharArray();
		int N = str.length;
		int[][] dp = new int[N][N];
		dp[N - 1][N - 1] = 1;
		for (int i = 0; i < N - 1; i++) {
			dp[i][i] = 1;
			dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
		}
		for (int i = N - 3; i >= 0; i--) {
			for (int j = i + 2; j < N; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				if (str[i] == str[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
				}
			}
		}
		return dp[0][N - 1];
	}
	
	@Test
	void longestPalindromeSubsequenceDp() {
		for (int i = 0; i < epoch; i++) {
			String s = StringGenerator.getRandomLengthLowerCaseString(1000);
			int i1 = longestPalindromeSubsequence(s);
			int i2 = SubsequencesSolution.longestPalindromeSubsequenceDp(s);
			Assertions.assertEquals(i1,i2);
		}
	}
}