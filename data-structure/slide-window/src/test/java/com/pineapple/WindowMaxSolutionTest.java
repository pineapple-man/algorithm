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
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/4 13:51
 */

@Slf4j
class WindowMaxSolutionTest {
	private static int epoch;
	
	@BeforeAll
	public static void init() {
		epoch = NumericalGenerator.getLittleRandomPositiveInt();
	}
	
	// 暴力的对数器方法
	public static int[] rightor(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		int N = arr.length;
		int[] res = new int[N - w + 1];
		int index = 0;
		int L = 0;
		int R = w - 1;
		while (R < N) {
			int max = arr[L];
			for (int i = L + 1; i <= R; i++) {
				max = Math.max(max, arr[i]);
				
			}
			res[index++] = max;
			L++;
			R++;
		}
		return res;
	}
}