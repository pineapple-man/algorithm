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
	
	/**
	 * 随机范围上的整数
	 *
	 * @return 生成一个在 [-2^31, 2^31-1] 区间上的整数
	 */
	public static int getRandomInt() {
		return RANDOM.nextInt();
	}
	
	/**
	 * 生成[lower,upper] 区间上的随机浮点数
	 *
	 * @param lowerBound
	 * 		下界
	 * @param upperbound
	 * 		上界
	 * @return 随机数
	 */
	public static double getRandomDouble(int lowerBound, int upperbound) {
		return Math.random() * (upperbound - lowerBound + 1) + lowerBound;
	}
	
	/**
	 * 生成一个 [0,100] 范围上的随机数
	 *
	 * @return 生成的随机数
	 */
	public static int getLittleRandomPositiveInt() {
		return getRandomPositiveInt(100);
	}
	
	/**
	 * 生成一个[1,upper]区间上的随机数
	 *
	 * @param upperBound
	 * 		正数上界
	 * @return 随机数
	 */
	public static int getRandomPositiveInt(int upperBound) {
		assert upperBound > 0;
		return getRandomIntervalInt(1, upperBound);
	}
	
	/**
	 * 生成[lower,high]区间上的随机数
	 *
	 * @param lowerBound
	 * 		随机数的下界
	 * @param upperBound
	 * 		随机数的上界
	 * @return 在区间[lowerBound, upperBound] 上的数
	 */
	public static int getRandomIntervalInt(int lowerBound, int upperBound) {
		return lowerBound + (int) (Math.random() * (upperBound - lowerBound + 1));
	}
	
	public static int getRandomPositiveInt() {
		return RANDOM.nextInt(Integer.MAX_VALUE);
	}
}
