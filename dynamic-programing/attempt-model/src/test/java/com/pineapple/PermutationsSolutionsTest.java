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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/1 21:26
 */

@Slf4j
class PermutationsSolutionsTest {
	private final String string = "1233";
	
	public static List<String> permutation1(String s) {
		List<String> ans = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ans;
		}
		char[] str = s.toCharArray();
		ArrayList<Character> rest = new ArrayList<>();
		for (char cha : str) {
			rest.add(cha);
		}
		String path = "";
		f(rest, path, ans);
		return ans;
	}
	
	public static void f(ArrayList<Character> rest, String path, List<String> ans) {
		if (rest.isEmpty()) {
			ans.add(path);
		} else {
			int N = rest.size();
			for (int i = 0; i < N; i++) {
				char cur = rest.get(i);
				rest.remove(i);
				f(rest, path + cur, ans);
				rest.add(i, cur);
			}
		}
	}
	
	public static List<String> permutation2(String s) {
		List<String> ans = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ans;
		}
		char[] str = s.toCharArray();
		g1(str, 0, ans);
		return ans;
	}
	
	public static void g1(char[] str, int index, List<String> ans) {
		if (index == str.length) {
			ans.add(String.valueOf(str));
		} else {
			for (int i = index; i < str.length; i++) {
				swap(str, index, i);
				g1(str, index + 1, ans);
				swap(str, index, i);
			}
		}
	}
	
	public static List<String> permutation3(String s) {
		List<String> ans = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ans;
		}
		char[] str = s.toCharArray();
		g2(str, 0, ans);
		return ans;
	}
	
	public static void g2(char[] str, int index, List<String> ans) {
		if (index == str.length) {
			ans.add(String.valueOf(str));
		} else {
			boolean[] visited = new boolean[256];
			for (int i = index; i < str.length; i++) {
				if (!visited[str[i]]) {
					visited[str[i]] = true;
					swap(str, index, i);
					g2(str, index + 1, ans);
					swap(str, index, i);
				}
			}
		}
	}
	
	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	
	@Test
	void permutations() {
		List<String> l1 = PermutationsSolutions.permutations(string);
		List<String> l2 = PermutationsSolutionsTest.permutation2(string);
		l1.sort(String::compareTo);
		l2.sort(String::compareTo);
		Assertions.assertEquals(l1.size(), l2.size());
		int length = l1.size();
		for (int i = 0; i < length; i++) {
			Assertions.assertEquals(l1.get(i), l2.get(i));
		}
		log.info("method success!");
		
	}
	
	@Test
	void uniquePermutations() {
		List<String> l1 =
				PermutationsSolutions.uniquePermutations(string);
		List<String> l2 = PermutationsSolutionsTest.permutation3(string);
		l1.sort(String::compareTo);
		l2.sort(String::compareTo);
		Assertions.assertEquals(l1.size(), l2.size());
		int length = l1.size();
		for (int i = 0; i < length; i++) {
			Assertions.assertEquals(l1.get(i), l2.get(i));
		}
		log.info("method success!");
	}
	
}