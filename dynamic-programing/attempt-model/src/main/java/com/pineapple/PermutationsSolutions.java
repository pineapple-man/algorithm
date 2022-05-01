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

import java.util.ArrayList;
import java.util.List;

/**
 * 排列问题相关题解
 *
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/1 18:31
 */

public class PermutationsSolutions {
	/**
	 * 获取字符串 str 的全排列
	 *
	 * @param str
	 * 		输入字符串
	 * @return java.util.List<java.lang.String>
	 *
	 * @author pineapple-man
	 * @date 2022/5/1
	 */
	public static List<String> permutations(String str) {
		List<String> ans = new ArrayList<>();
		attempt(str.toCharArray(), 0, ans);
		return ans;
	}
	
	public static List<String> uniquePermutations(String str) {
		List<String> ans = new ArrayList<>();
		uniqueAttempt(str.toCharArray(), 0, ans);
		return ans;
	}
	
	private static void uniqueAttempt(char[] chars, int index, List<String> ans) {
		if (index == chars.length) {
			ans.add(String.valueOf(chars));
			return;
		}
		boolean[] visited = new boolean[256];
		for (int i = index; i < chars.length; i++) {
			if (!visited[chars[i]]) {
				visited[chars[i]] = true;
				swap(chars, i, index);
				uniqueAttempt(chars, index + 1, ans);
				swap(chars, i, index);
			}
		}
	}
	
	private static void attempt(char[] chars, int index, List<String> ans) {
		if (index == chars.length) {
			ans.add(String.valueOf(chars));
			return;
		}
		for (int i = index; i < chars.length; i++) {
			//将对应的字符与最开始的字符交换
			swap(chars, i, index);
			attempt(chars, index + 1, ans);
			swap(chars, i, index);
		}
	}
	
	private static void swap(char[] chars, int a, int b) {
		char temp = chars[a];
		chars[a] = chars[b];
		chars[b] = temp;
	}
	
}
