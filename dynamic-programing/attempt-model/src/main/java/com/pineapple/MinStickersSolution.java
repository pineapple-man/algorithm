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

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/3 11:44
 */

public class MinStickersSolution {
	public static int minStickers(String[] stickers, String target) {
		int ans = recursive(stickers, target);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
	
	public static int minStickersSaveMemory(String[] stickers, String target) {
		int[][] stick = wordFrequency(stickers);
		int ans = recursiveSaveMemory(stick, target);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
	
	public static int minStickersMemorySearch(String[] stickers, String target) {
		HashMap<String, Integer> cache = new HashMap<>();
		int[][] frequency = wordFrequency(stickers);
		cache.put("", 0);
		int ans = memorySearch(frequency, target, cache);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
	
	@NotNull
	private static int[][] wordFrequency(String[] stickers) {
		int[][] stick = new int[stickers.length][26];
		for (int i = 0; i < stickers.length; i++) {
			for (int j = 0; j < stickers[i].length(); j++) {
				stick[i][stickers[i].charAt(j) - 'a']++;
			}
		}
		return stick;
	}
	
	private static int memorySearch(int[][] stickers, String target, HashMap<String, Integer> cache) {
		if (cache.containsKey(target)) {
			return cache.get(target);
		}
		int[] freq = new int[26];
		for (int i = 0; i < target.length(); i++) {
			freq[target.charAt(i) - 'a']++;
		}
		int min = Integer.MAX_VALUE;
		for (int[] sticker : stickers) {
			if (sticker[target.charAt(0) - 'a'] > 0) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 26; i++) {
					int nums = freq[i] - sticker[i];
					for (int i1 = 0; i1 < nums; i1++) {
						sb.append((char) (i + 'a'));
					}
				}
				String res = sb.toString();
				min = Math.min(min, memorySearch(stickers, res, cache));
			}
		}
		cache.put(target, min + (min == Integer.MAX_VALUE ? 0 : 1));
		return cache.get(target);
	}
	
	/**
	 * 可变参数由于是字符串，找不到对应的范围，所以最多优化到记忆化搜索，严格表结构是找不到的
	 */
	private static int recursiveSaveMemory(int[][] stickers, String target) {
		if (target.length() == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		//target 进行词频统计
		int[] freq = new int[26];
		for (int i = 0; i < target.length(); i++) {
			freq[target.charAt(i) - 'a']++;
		}
		for (int[] sticker : stickers) {
			//尝试第一张贴纸是谁
			// 剪枝，每次只要查找包含 target 第一个字符的剪纸
			if (sticker[target.charAt(0) - 'a'] > 0) {
				// 生成新的 target
				StringBuilder stringBuilder = new StringBuilder();
				for (int j = 0; j < 26; j++) {
					if (freq[j] > 0) {
						int nums = freq[j] - sticker[j];
						for (int k = 0; k < nums; k++) {
							stringBuilder.append((char) (j + 'a'));
						}
					}
				}
				String res = stringBuilder.toString();
				min = Math.min(min, recursiveSaveMemory(stickers, res));
			}
			
		}
		return min + (min == Integer.MAX_VALUE ? 0 : 1);
	}
	
	/**
	 * 非常耗时
	 *
	 * @param stickers
	 * 		贴纸
	 * @param target
	 * 		最终目标拼接而成的字符串
	 * @return 需要几张贴纸
	 */
	private static int recursive(String[] stickers, String target) {
		if (target.length() == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (String sticker : stickers) {
			String res = minus(sticker, target);
			if (res.length() != target.length()) {
				min = Math.min(min, recursive(stickers, res));
			}
		}
		return min + (min == Integer.MAX_VALUE ? 0 : 1);
	}
	
	private static String minus(String sticker, String target) {
		int[] freq = new int[26];
		for (int i = 0; i < target.length(); i++) {
			freq[target.charAt(i) - 'a']++;
		}
		for (int i = 0; i < sticker.length(); i++) {
			freq[sticker.charAt(i) - 'a']--;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				for (int j = 0; j < freq[i]; j++) {
					char ch = (char) ('a' + i);
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
}
