package com.pineapple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author pineapple-man
 */
public class LetterCombinationsOfAPhoneNumber {
	char[][] map = new char[][]{
			{}, //0
			{},//1
			{'a', 'b', 'c'},//2
			{'d', 'e', 'f'},//3
			{'g', 'h', 'i'},//4
			{'j', 'k', 'l'},//5
			{'m', 'n', 'o'},//6
			{'p', 'q', 'r', 's'},//7
			{'t', 'u', 'v'},//8
			{'w', 'x', 'y', 'z'},//9
	};
	
	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return new ArrayList<>();
		}
		List<String> ans = new ArrayList<>();
		f(digits.toCharArray(), 0, new ArrayDeque<>(), ans);
		return ans;
	}
	
	public void f(char[] chars, int index, Deque<Character> path, List<String> ans) {
		if (index == chars.length) {
			StringBuilder s = new StringBuilder();
			for (Character character : path) {
				s.append(character);
			}
			ans.add(s.toString());
			return;
		}
		int i = Integer.parseInt(String.valueOf(chars[index]));
		for (int j = 0; j < map[i].length; j++) {
			path.addLast(map[i][j]);
			f(chars, index + 1, path, ans);
			path.removeLast();
		}
	}
	
}
