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

import com.pineapple.generator.NumericalGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/2 21:56
 */

@Slf4j
class NearestNumberPowerSolutionTest {
	
	@Test
	void nearest() {
		int epoch = NumericalGenerator.getRandomPositiveInt(100);
		for (int i = 0; i < epoch; i++) {
			int num = NumericalGenerator.getRandomPositiveInt();
			int i1 = getNearest(num);
			int i2 = NearestNumberPowerSolution.nearest(num);
			log.debug(String.format("nums: %d nearest power is %d %d", num, i2, i1));
			Assertions.assertEquals(i1, i2);
		}
	}
	
	/**
	 * 存在上溢出的情况，也就是说一个整型数大于 1<<31 那么求解出来的值是 -2147483647 的情况
	 *
	 * @param num
	 * 		需要求解的数
	 * @return 最接近的 2 的幂
	 */
	public static int getNearest(int num) {
		int ans = 1 << 31;
		int powers;
		for (int i = 0; i < 32; i++) {
			powers = 1 << i;
			if (powers == num) {
				ans = num;
				break;
			} else if (powers > num) {
				ans = powers;
				break;
			}
		}
		return ans;
	}
}