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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/3 11:21
 */

@Slf4j
class StringGeneratorTest {
	private static int epoch;
	
	@BeforeAll
	static void init() {
		epoch = NumericalGenerator.getLittleRandomPositiveInt();
	}
	
	@Test
	void getIntString() {
		for (int i = 0; i < epoch; i++) {
			String s = StringGenerator.getIntString();
			log.debug(s);
		}
	}
	
	@Test
	void getLengthFixedIntString() {
		for (int i = 0; i < epoch; i++) {
			int n = NumericalGenerator.getLittleRandomPositiveInt();
			String s = StringGenerator.getLengthFixedIntString(n);
			log.debug(s);
			Assertions.assertEquals(s.length(), n);
		}
	}
}