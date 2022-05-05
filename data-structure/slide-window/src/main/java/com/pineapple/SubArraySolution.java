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
 * @date 2022/5/5 23:05
 */

public class SubArraySolution {
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int n = nums.length, ans = 0;
		int multiply = 1, left = 0;
		for (int right = 0; right < n; right++) {
			multiply *= nums[right];
			while (left <= right && multiply >= k) {
				multiply /= nums[left];
				left++;
			}
			ans += right - left + 1;
		}
		return ans;
	}
	
}
