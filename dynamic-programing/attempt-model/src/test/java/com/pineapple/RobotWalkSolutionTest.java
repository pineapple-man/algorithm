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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/1 23:02
 */

@Slf4j
class RobotWalkSolutionTest {
	
	private static final String[] method = {"dp", "ms", "recursive"};
	
	@Test
	void robotWalk() {
		int epoch = NumericalGenerator.getRandomPositiveInt(100);
		for (int i = 0; i < epoch; i++) {
			final int n = NumericalGenerator.getRandomPositiveInt(100);
			final int m = NumericalGenerator.getRandomPositiveInt(n);
			final int k = NumericalGenerator.getRandomPositiveInt(20);
			final int p = NumericalGenerator.getRandomPositiveInt(n);
			int i2 = ways3(n, m, p, k);
			for (String s : method) {
				if (s.equals("dp")) {
					log.debug(String.valueOf(n));
					log.debug(String.valueOf(m));
					log.debug(String.valueOf(k));
					log.debug(String.valueOf(p));
				}
				int i1 = RobotWalkSolution.robotWalkChooseSolution(n, m, k, p, s);
				Assertions.assertEquals(i1, i2);
				
			}
		}
		log.info("test success!");
	}
	
	public static int ways3(int N, int start, int aim, int K) {
		if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
			return -1;
		}
		int[][] dp = new int[N + 1][K + 1];
		dp[aim][0] = 1;
		for (int rest = 1; rest <= K; rest++) {
			dp[1][rest] = dp[2][rest - 1];
			for (int cur = 2; cur < N; cur++) {
				dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
			}
			dp[N][rest] = dp[N - 1][rest - 1];
		}
		return dp[start][K];
	}
}