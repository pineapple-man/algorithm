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
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/3 11:47
 */

@Slf4j
class MinStickersSolutionTest {
	public static int minStickers(String[] stickers, String target) {
		int N = stickers.length;
		int[][] counts = new int[N][26];
		for (int i = 0; i < N; i++) {
			char[] str = stickers[i].toCharArray();
			for (char cha : str) {
				counts[i][cha - 'a']++;
			}
		}
		HashMap<String, Integer> dp = new HashMap<>();
		dp.put("", 0);
		int ans = process3(counts, target, dp);
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
	
	public static int process3(int[][] stickers, String t, HashMap<String, Integer> dp) {
		if (dp.containsKey(t)) {
			return dp.get(t);
		}
		char[] target = t.toCharArray();
		int[] tcounts = new int[26];
		for (char cha : target) {
			tcounts[cha - 'a']++;
		}
		int N = stickers.length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int[] sticker = stickers[i];
			if (sticker[target[0] - 'a'] > 0) {
				StringBuilder builder = new StringBuilder();
				for (int j = 0; j < 26; j++) {
					if (tcounts[j] > 0) {
						int nums = tcounts[j] - sticker[j];
						for (int k = 0; k < nums; k++) {
							builder.append((char) (j + 'a'));
						}
					}
				}
				String rest = builder.toString();
				min = Math.min(min, process3(stickers, rest, dp));
			}
		}
		int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
		dp.put(t, ans);
		return ans;
	}
	
	@Test
	void minStickers() {
		int epoch = NumericalGenerator.getRandomPositiveInt(20);
		for (int i = 0; i < epoch; i++) {
			int n = NumericalGenerator.getRandomPositiveInt(10);
			String[] sticker = new String[n];
			for (int j = 0; j < n; j++) {
				int length = NumericalGenerator.getRandomPositiveInt(10);
				sticker[j] = StringGenerator.getLengthFixedLowerCaseString(length);
			}
			String target = StringGenerator.getRandomLengthLowerCaseString(15);
			int i1 = minStickers(sticker, target);
			int i2 = MinStickersSolution.minStickers(sticker, target);
			int i3 = MinStickersSolution.minStickersSaveMemory(sticker, target);
			int i4 = MinStickersSolution.minStickersMemorySearch(sticker, target);
			Assertions.assertEquals(i1, i2);
			Assertions.assertEquals(i1, i3);
			Assertions.assertEquals(i1, i4);
		}
	}
}