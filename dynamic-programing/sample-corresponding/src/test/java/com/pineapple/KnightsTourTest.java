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
 * 马踏棋盘问题
 *
 * @author pineapple-man
 * @date 2022-05-07 13:08
 */
class KnightsTourTest {
	/**
	 * 以(0,0)作为马运动的起点，一共可以跳 k步，马能够跳到 (a,b) 的次数。<br/> 一个象棋的棋盘最多只有 8 行 7 列
	 *
	 * @param a
	 * 		目标点 x
	 * @param b
	 * 		目标点 y
	 * @param k
	 * 		马一共可以运动的步数
	 * @return 马可以到达目标位置的方法数目
	 */
	public static int jump(int a, int b, int k) {
		return process(0, 0, a, b, k);
	}
	
	public static int process(int x, int y, int a, int b, int step) {
		if (x < 0 || x > 9 || y < 0 || y > 8) {
			return 0;
		}
		if (x == a && y == b && step == 0) {
			return 1;
		}
		int ans = 0;
		ans += process(x - 2, y + 1, a, b, step - 1);
		ans += process(x - 2, y - 1, a, b, step - 1);
		ans += process(x - 1, y + 2, a, b, step - 1);
		ans += process(x - 1, y - 2, a, b, step - 1);
		ans += process(x + 1, y - 2, a, b, step - 1);
		ans += process(x + 1, y + 2, a, b, step - 1);
		ans += process(x + 2, y - 1, a, b, step - 1);
		ans += process(x + 1, y + 1, a, b, step - 1);
		return ans;
	}
}