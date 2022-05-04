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
 * @date 2022/5/5 00:51
 */

class SubSequenceSolutionTest {
	
	private static int epoch;
	
	@BeforeAll
	public static void init() {
		epoch = NumericalGenerator.getLittleRandomPositiveInt();
	}
	
	@Test
	void longestPalindromeSubsequenceDp() {
		for (int i = 0; i < epoch; i++) {
			String s = StringGenerator.getRandomLengthLowerCaseString(1000);
			int i1 = longestPalindromeSubsequence(s);
			int i2 = SubSequenceSolution.longestPalindromeSubsequenceDp(s);
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
	void longestPalindromeSubsequenceRecursive() {
		for (int i = 0; i < 4; i++) {
			String s = StringGenerator.getRandomLengthLowerCaseString(20);
			int i1 = longestPalindromeSubsequence(s);
			int i2 = SubSequenceSolution.longestPalindromeSubsequenceRecursive(s);
			Assertions.assertEquals(i1, i2);
		}
	}
}