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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author pineapple-man
 * @date 2022-05-05 12:16
 */
@Slf4j
class ArrayGeneratorTest {
	private static int epoch;
	
	@BeforeAll
	private static void init() {
		epoch = NumericalGenerator.getLittleRandomPositiveInt();
	}
	
	@Test
	void lengthFixed1dIntArray() {
		for (int i = 0; i < epoch; i++) {
			int length = NumericalGenerator.getRandomPositiveInt(20);
			int[] arr = ArrayGenerator.lengthFixed1dIntArray(length);
			log.info(Arrays.toString(arr));
		}
	}
}