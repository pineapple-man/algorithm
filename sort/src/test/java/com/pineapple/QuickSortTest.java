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
 * @date 2022/9/22 15:38
 */

class QuickSortTest {
	private static final int EPOCH = 20;
	
	@Test
	void sort() {
		for (int i = 0; i < EPOCH; i++) {
			int length = NumericalGenerator.getLittleRandomPositiveInt();
			int[] arr = ArrayGenerator.lengthFixed1dIntArray(length);
			int[] a1 = arr.clone();
			int[] a2 = arr.clone();
			Arrays.sort(a1);
			QuickSort.sort(a2);
			Assertions.assertArrayEquals(a1, a2);
			
		}
	}
}