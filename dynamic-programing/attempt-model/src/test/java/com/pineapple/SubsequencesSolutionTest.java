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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/1 18:04
 */

@Slf4j
class SubsequencesSolutionTest {
	
	@Test
	void printAllSubsequences() {
		String str = "abc";
		List<String> strings = SubsequencesSolution.printAllSubsequences(str);
		log.debug(String.format("all %s subsequence string is: ", str));
		log.debug(Arrays.toString(strings.toArray()));
	}
	
	@Test
	void printNoRepeatAllSubsequences() {
		String str = "accc";
		List<String> strings = SubsequencesSolution.printNoRepeatAllSubsequences(str);
		log.debug(String.format("all %s unique subsequence is:", str));
		log.debug(Arrays.toString(strings.toArray()));
	}
}