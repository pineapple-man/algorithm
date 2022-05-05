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

package com.pineapple.generator;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/4/30 15:19
 */

public class ArrayGenerator {
	public static int[] lengthRandom1dPositiveIntArray() {
		int length = NumericalGenerator.getLittleRandomPositiveInt();
		return lengthFixed1dPositiveIntArray(length);
	}
	
	public static int[] lengthFixed1dPositiveIntArray(int length) {
		int upperBound = NumericalGenerator.getRandomPositiveInt();
		return lengthFixed1dIntervalIntArray(length, 0, upperBound);
	}
	
	public static int[] lengthFixed1dIntervalIntArray(int length, int lowerBound, int upperBound) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = NumericalGenerator.getRandomIntervalInt(lowerBound, upperBound);
		}
		return arr;
	}
	
	public static int[] lengthFixed1dIntArray(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = NumericalGenerator.getRandomInt();
		}
		return arr;
	}
}
