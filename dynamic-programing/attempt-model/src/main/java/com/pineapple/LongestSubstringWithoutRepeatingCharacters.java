package com.pineapple;

import java.util.Arrays;

/**
 * @author pineapple-man
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] array = s.toCharArray();
		int[] map = new int[256];
		Arrays.fill(map, -1);
		int ans = 0;
		// PreBound 表示 i-1位置结尾的情况下，向左推，推不动的是那个边界是哪里
		int preBound = -1;
		for (int i = 0; i < array.length; i++) {
			preBound = Math.max(preBound, map[array[i]]);
			ans = Math.max(ans, i - preBound);
			map[array[i]] = i;
		}
		return ans;
	}
	
}
