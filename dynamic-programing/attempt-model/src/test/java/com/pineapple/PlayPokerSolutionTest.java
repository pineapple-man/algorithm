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
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/2 00:17
 */

@Slf4j
class PlayPokerSolutionTest {
	private static final String[] method = {"dp", "ms", "recursive"};
	
	@Test
	void winScore() {
		int epoch = NumericalGenerator.getRandomPositiveInt(20);
		for (int i = 0; i < epoch; i++) {
			int[] arr = ArrayGenerator.lengthFixed1dIntervalIntArray(20, -100, 100);
			int i1 = win3(arr);
			log.debug(String.valueOf(i1));
			for (String s : method) {
				int i2 = PlayPokerSolution.winScoreChoose(arr, s);
				Assertions.assertEquals(i1, i2);
				
			}
		}
		log.info("test success!");
	}
	
	public static int win3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int N = arr.length;
		int[][] fmap = new int[N][N];
		int[][] gmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			fmap[i][i] = arr[i];
		}
		for (int startCol = 1; startCol < N; startCol++) {
			int L = 0;
			int R = startCol;
			while (R < N) {
				fmap[L][R] = Math.max(arr[L] + gmap[L + 1][R], arr[R] + gmap[L][R - 1]);
				gmap[L][R] = Math.min(fmap[L + 1][R], fmap[L][R - 1]);
				L++;
				R++;
			}
		}
		return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
	}
}