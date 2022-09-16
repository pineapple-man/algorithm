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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/16 14:36
 */

class BracketEffectiveMatchingTest {
	
	@Test
	void solution() {
		String str = "()())(";
		int i = BracketEffectiveMatching.Solution(str);
		Assertions.assertEquals(i, 4);
	}
	
	@Test
	void solution2() {
		String strs = "(())()()";
		int ans = BracketEffectiveMatching.Solution2(strs);
		Assertions.assertEquals(2, ans);
		strs = "(((()))()()()())";
		ans = BracketEffectiveMatching.Solution2(strs);
		Assertions.assertEquals(4, ans);
		
	}
}