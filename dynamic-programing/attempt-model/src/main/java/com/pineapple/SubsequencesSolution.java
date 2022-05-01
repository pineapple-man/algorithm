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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 子序列问题合集 子序列与子串是不连续的，子序列是可以不连续的，而子串是必须连续的
 *
 * @author pineapple -man
 * @version 1.0
 * @date 2022 /5/1 17:53
 */
public class SubsequencesSolution {
	/**
	 * 计算出 sequences 所有的子序列
	 *
	 * @param str
	 * 		原始字符串
	 * @return java.util.List<java.lang.String>  返回子序列的集合
	 *
	 * @author pineapple -man
	 * @date 2022 /5/1
	 */
	public static List<String> printAllSubsequences(String str) {
		List<String> ans = new ArrayList<>();
		Deque<Character> deque = new ArrayDeque<>();
		attempt(str.toCharArray(), 0, ans, deque);
		return ans;
	}
	
	public static List<String> printNoRepeatAllSubsequences(String str) {
		String path = "";
		Set<String> set = new HashSet<>();
		uniqueSubsequenceAttempt(str.toCharArray(), 0, path, set);
		return new ArrayList<>(set);
	}
	
	/**
	 * 查找不含邮重复元素的子序列递归尝试
	 *
	 * @param chars
	 * 		输入的字符数组
	 * @param index
	 * 		当前决策位置
	 * @param path
	 * 		之前决策保存的位置
	 * @param set
	 * 		最终无重复元素保存的结果
	 */
	private static void uniqueSubsequenceAttempt(char[] chars, int index,
	                                             String path, Set<String> set) {
		if (index == chars.length) {
			set.add(path);
			return;
		}
		uniqueSubsequenceAttempt(chars, index + 1, path, set);
		uniqueSubsequenceAttempt(chars, index + 1, path + chars[index], set);
	}
	
	/**
	 * 暴力递归尝试，在 index 位置决定是否需要这个解决， 来到 str[index] 字符，index 是位置，str[0...index-1]位置上的字符已经走过！ 之前的是否要保留当前字符的决定都在双端队列 deque
	 * 中，最终所有的子序列都放在了ans中
	 *
	 * @param chars
	 * 		原始输入字符串的字符数组形式
	 * @param index
	 * 		当前需要考虑的索引
	 * @param ans
	 * 		保存最终所有子序列的结果
	 * @param deque
	 * 		之前决策造成的影响
	 */
	private static void attempt(char[] chars, int index, List<String> ans, Deque<Character> deque) {
		if (index == chars.length) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Character character : deque) {
				stringBuilder.append(character);
			}
			ans.add(stringBuilder.toString());
			return;
		}
		// 没有使用这个字符构成子序列
		attempt(chars, index + 1, ans, deque);
		//使用了当前这个字符构成子序列
		deque.addLast(chars[index]);
		attempt(chars, index + 1, ans, deque);
		deque.removeLast();
	}
}
