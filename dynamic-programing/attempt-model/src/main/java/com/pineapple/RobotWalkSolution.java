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


/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/4/30 15:18
 */

public class RobotWalkSolution {
	public static int robotWalkChooseSolution(int n, int m, int k, int p, String solution) {
		if (n < 2 || m < 1 || m > n || p < 1 || p > n || k < 1) {
			return -1;
		}
		int ans = 0;
		switch (solution) {
			case "dp":
				ans = DynamicProgramming.process(n, m, k, p);
				break;
			case "ms":
				int[][] cache = new int[n + 1][k + 1];
				for (int i = 0; i < n + 1; i++) {
					for (int j = 0; j < k + 1; j++) {
						cache[i][j] = -1;
					}
				}
				ans = MemorySearch.process(n, m, k, p, cache);
				break;
			case "recursive":
				ans = robotWalk(n, m, k, p);
				break;
			default:
				ans = -1;
		}
		return ans;
	}
	
	/**
	 * 机器人随机走动问题
	 *
	 * @param n
	 * 		代表机器人一共可以走动的最大范围
	 * @param m
	 * 		代表机器人最开始的起始位置
	 * @param k
	 * 		代表机器人可以行走的步数
	 * @param p
	 * 		代表机器人想要去往的地方
	 * @return 根据以上四个参数机器人能够走动的方法数目, 如果以上参数不满足条件，则返回 -1
	 */
	public static int robotWalk(int n, int m, int k, int p) {
		if (n < 2 || m < 1 || p < 1 || m > n || p > n || k < 1) {
			return -1;
		}
		return Recursive.process(n, m, k, p);
	}
	
	private static class DynamicProgramming {
		static int process(int n, int current, int step, int end) {
			assert current <= n;
			int[][] dp = new int[n + 1][step + 1];
			dp[end][0] = 1;
			for (int col = 1; col < step + 1; col++) {
				dp[1][col] = dp[2][col - 1];
				for (int row = 2; row < n; row++) {
					dp[row][col] = dp[row - 1][col - 1] + dp[row + 1][col - 1];
				}
				dp[n][col] = dp[n - 1][col - 1];
			}
			return dp[current][step];
		}
	}
	
	private static class MemorySearch {
		static int process(int n, int current, int step, int end, int[][] cache) {
			if (cache[current][step] != -1) {
				return cache[current][step];
			}
			if (step == 0) {
				cache[current][step] = current == end ? 1 : 0;
				return cache[current][step];
			}
			int ans = 0;
			if (current == 1) {
				ans = process(n, current + 1, step - 1, end, cache);
			} else if (current == n) {
				ans = process(n, current - 1, step - 1, end, cache);
			} else {
				ans = process(n, current - 1, step - 1, end, cache)
						+ process(n, current + 1, step - 1, end, cache);
			}
			cache[current][step] = ans;
			return cache[current][step];
		}
	}
	
	private static class Recursive {
		
		static int process(int n, int current, int step, int end) {
			if (step == 0) {
				return current == end ? 1 : 0;
			}
			int ans = 0;
			if (current == 1) {
				ans = process(n, current + 1, step - 1, end);
			} else if (current == n) {
				ans = process(n, current - 1, step - 1, end);
			} else {
				ans = process(n, current - 1, step - 1, end) + process(n, current + 1, step - 1, end);
			}
			return ans;
		}
	}
}
