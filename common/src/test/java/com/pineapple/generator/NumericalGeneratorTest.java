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
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/2 00:23
 */

@Slf4j
class NumericalGeneratorTest {
	
	@Test
	void getRandomPositiveInt() {
		for (int i = 0; i < 100; i++) {
			int randomPositiveInt = NumericalGenerator.getRandomPositiveInt();
			assert randomPositiveInt > 0;
		}
	}
	
	@Test
	void getRandomIntervalInt() {
		int lowerBoundCount = 0;
		int upperBoundCount = 0;
		int lowerBound = 0;
		int upperBound = 3;
		for (int i = 0; i < 100; i++) {
			int i1 = NumericalGenerator.getRandomIntervalInt(lowerBound, upperBound);
			log.debug(String.valueOf(i1));
			if (i1 == lowerBound) {
				lowerBoundCount++;
			} else if (i1 == upperBound) {
				upperBoundCount++;
			}
		}
		log.debug(String.valueOf(lowerBoundCount));
		log.debug(String.valueOf(upperBoundCount));
	}
}