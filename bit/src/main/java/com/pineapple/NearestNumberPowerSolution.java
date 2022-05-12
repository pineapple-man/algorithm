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
 * @date 2022/5/2 21:53
 */

public class NearestNumberPowerSolution {
	/**
	 * 返回大于等于 num 最近的 2 的某次方
	 *
	 * @param num
	 * 		非负整数
	 * @return 大于等于 num 最近的 2 的某次方
	 */
	public static int nearest(int num) {
		num--;
		num |= num >>> 1;
		num |= num >>> 2;
		num |= num >>> 4;
		num |= num >>> 8;
		num |= num >>> 16;
		return (num < 0) ? 1 : num + 1;
	}
	
	/**
	 * 找到 arr >= num 且 arr 是 target 倍数的最小数,target 必须是 2 的幂。
	 */
	public static int nearest(int num, int target) {
		if (num + target < 0) {
			return 0;
		}
		return (num + target - 1) & (-target);
	}
}
