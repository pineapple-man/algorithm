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

import com.pineapple.generator.ArrayGenerator;
import com.pineapple.generator.NumericalGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/3 00:02
 */

class KnapsackSolutionTest {
	
	@Test
	void maxValue() {
		int epoch = NumericalGenerator.getRandomPositiveInt(20);
		for (int i = 0; i < epoch; i++) {
			int length = NumericalGenerator.getLittleRandomPositiveInt();
			int bag = NumericalGenerator.getLittleRandomPositiveInt();
			int[] w = ArrayGenerator.lengthFixed1dIntervalIntArray(length, 0, bag);
			int[] v = ArrayGenerator.lengthFixed1dIntervalIntArray(length, 0, bag);
			int i1 = dp(w, v, bag);
			int i2 = KnapsackSolution.maxValue(w, v, bag);
			Assertions.assertEquals(i1, i2);
			
		}
	}
	
	public static int dp(int[] w, int[] v, int bag) {
		if (w == null || v == null || w.length != v.length || w.length == 0) {
			return 0;
		}
		int N = w.length;
		int[][] dp = new int[N + 1][bag + 1];
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 0; rest <= bag; rest++) {
				int p1 = dp[index + 1][rest];
				int p2 = 0;
				int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
				if (next != -1) {
					p2 = v[index] + next;
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}
		return dp[0][bag];
	}
}