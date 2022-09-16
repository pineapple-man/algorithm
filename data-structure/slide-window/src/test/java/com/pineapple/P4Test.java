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

import java.util.Arrays;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/16 12:49
 */

class P4Test {
	private static final int EPOCH =
			NumericalGenerator.getRandomPositiveInt(20);
	
	@Test
	void solution() {
		for (int i = 0; i < EPOCH; i++) {
			int length = NumericalGenerator.getRandomIntervalInt(1, 1000);
			int[] arr = ArrayGenerator.lengthFixed1dPositiveIntArray(length);
			Arrays.sort(arr);
			int k = NumericalGenerator.getRandomPositiveInt(1000);
			int i1 = Solution(arr, k);
			int i2 = P4.Solution(arr, k);
			int i3 = Solution2(arr, k);
			Assertions.assertEquals(i1, i2);
			Assertions.assertEquals(i1, i3);
		}
	}
	
	/**
	 * O(N^2)
	 */
	public static int Solution(int[] arr, int k) {
		int maxOverlapping = 0;
		int overlapping = 0;
		for (int i = 0; i < arr.length; i++) {
			overlapping = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] - arr[i] <= k) {
					overlapping++;
				} else {
					break;
				}
			}
			maxOverlapping = Math.max(maxOverlapping, overlapping);
		}
		return maxOverlapping;
	}
	
	/**
	 * 使用二分法快速查找右边界
	 *
	 * @date 2022/9/16
	 */
	public static int Solution2(int[] arr, int k) {
		int maxOverlapping = 0;
		for (int i = 0; i < arr.length; i++) {
			int rightIndex = nearestIndex(arr, i, arr[i] - k);
			maxOverlapping = Math.max(maxOverlapping, i - rightIndex + 1);
		}
		return maxOverlapping;
	}
	
	public static int nearestIndex(int[] arr, int right, int target) {
		int left = 0;
		int rightIndex = right;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				rightIndex = mid;
				right = mid - 1;
			}
		}
		return rightIndex;
	}
}