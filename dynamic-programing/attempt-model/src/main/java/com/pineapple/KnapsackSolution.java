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
 * @date 2022/5/2 23:59
 */

public class KnapsackSolution {
	
	
	/**
	 * 所有的货，和，都在w和v数组里,为了方便，其中没有负数
	 *
	 * @param w
	 * 		重量
	 * @param v
	 * 		价值
	 * @param bag
	 * 		背包容量，不能超过这个载重
	 * @return 背包可以携带的最大价值
	 */
	public static int maxValue(int[] w, int[] v, int bag) {
		if (w == null || v == null || w.length != v.length || w.length == 0) {
			return 0;
		}
		// 尝试函数！
		return recursiveMethod(w, v, 0, bag);
	}
	
	private static int recursiveMethod(int[] w, int[] v, int index, int rest) {
		if (rest < 0) {
			return -1;
		}
		if (index == w.length) {
			return 0;
		}
		int p1 = recursiveMethod(w, v, index + 1, rest);
		int p2 = recursiveMethod(w, v, index + 1, rest - w[index]);
		if (p2 != -1) {
			p2 += v[index];
		}
		return Math.max(p1, p2);
	}
	
	public static int maxValueDp(int[] w, int[] v, int bag) {
		if (w == null || v == null || w.length != v.length || w.length == 0) {
			return 0;
		}
		int[][] dp = new int[w.length + 1][bag + 1];
		for (int index = w.length - 1; index >= 0; index--) {
			for (int rest = 0; rest <= bag; rest++) {
				int p1 = dp[index + 1][rest];
				int p2;
				if (rest - w[index] < 0) {
					p2 = -1;
				} else {
					p2 = dp[index + 1][rest - w[index]] + v[index];
					
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}
		return dp[0][bag];
	}
}
