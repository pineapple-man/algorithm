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
 * @date 2022/9/16 12:48
 */

public class P4 {
	/**
	 * Slide Window solution
	 */
	public static int Solution(int[] arr, int k) {
		int maxOverlapping = 0;
		int left = 0;
		int right = 0;
		for (left = 0; left < arr.length; left++) {
			int sum = 0;
			while (right < arr.length && arr[right] - arr[left] <= k) {
				right++;
			}
			maxOverlapping = Math.max(maxOverlapping, right - left);
		}
		return maxOverlapping;
	}
}
