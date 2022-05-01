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

import java.util.Random;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/1 23:41
 */

public class NumericalGenerator {
	private static final Random RANDOM = new Random();
	
	public static int getRandomInt() {
		return RANDOM.nextInt();
	}
	
	public static double getRandomDouble(int lowerBound, int upperbound) {
		return Math.random() * (upperbound - lowerBound) + lowerBound;
	}
	
	public static int getLittleRandomPositiveInt() {
		return getRandomPositiveInt(100);
	}
	
	public static int getRandomPositiveInt(int upperBound) {
		return getRandomIntervalInt(1, upperBound);
	}
	
	public static int getRandomIntervalInt(int lowerBound, int upperBound) {
		return (int) (1 + Math.random() * (upperBound - lowerBound + 1));
	}
	
	public static int getRandomPositiveInt() {
		return RANDOM.nextInt(Integer.MAX_VALUE);
	}
}
