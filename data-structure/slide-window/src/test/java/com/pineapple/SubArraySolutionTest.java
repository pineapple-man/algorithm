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

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/5 23:05
 */

class SubArraySolutionTest {
	private static final int EPOCH = NumericalGenerator.getRandomPositiveInt(1000);
	
	@Test
	void numSubarrayProductLessThanK() {
		for (int i = 0; i < EPOCH; i++) {
			int length = NumericalGenerator.getRandomIntervalInt(1, (int) (3 * Math.pow(10, 4)));
			int[] arr = ArrayGenerator.lengthFixed1dIntervalIntArray(length, 1, 1000);
			int k = NumericalGenerator.getRandomPositiveInt((int) Math.pow(10, 6));
			int i1 = numSubarrayProductLessThanK(arr, k);
			int i2 = SubArraySolution.numSubarrayProductLessThanK(arr, k);
			Assertions.assertEquals(i1, i2);
		}
	}
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			int mul = 1;
			for (int j = i; j < nums.length; j++) {
				mul *= nums[j];
				if (mul < k) {
					ans++;
				} else {
					break;
				}
			}
		}
		return ans;
	}
}