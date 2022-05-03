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
 * @date 2022/5/3 10:55
 */

public class ConvertSolution {
	/**
	 * 有下面一张转换表(1->a,2->b,...,26->z),那么一个数字字符串<br/> 比如：111，就可以转化为AAA, KA 和 AK，给定一个只有数字字符组成的字符串 string ,<br/> 返回有多少种转化结果
	 *
	 * @param str
	 * 		需要转换的字符串
	 * @return 可以转换的方法数
	 */
	public static int convertToLetterString(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char[] chars = str.toCharArray();
		return recursive(chars, 0);
	}
	
	public static int convertToLetterStringDp(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char[] chars = str.toCharArray();
		int[] dp = new int[chars.length + 1];
		dp[chars.length] = 1;
		for (int index = chars.length - 1; index >= 0; index--) {
			if (chars[index] != '0') {
				dp[index] = dp[index + 1];
				if (index + 1 < chars.length && Integer.parseInt(String.valueOf(chars, index, 2)) <= 26) {
					dp[index] += dp[index + 2];
				}
			}
		}
		return dp[0];
	}
	
	private static int recursive(char[] chars, int index) {
		if (index == chars.length) {
			return 1;
		}
		if (chars[index] == '0') {
			return 0;
		}
		int count = 0;
		if (index + 1 < chars.length && Integer.parseInt(String.valueOf(chars, index, 2)) <= 26) {
			count += recursive(chars, index + 2);
		}
		count += recursive(chars, index + 1);
		return count;
	}
}
