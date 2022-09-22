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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/22 00:31
 */

class P5Test {
	
	@Test
	void solution() {
		int[] ints = {1, 1, 2, 2, 3, 3, 3, 4, 5, 5};
		int k = 56;
		int[] ans = P5.solution(ints, k);
		int[] expect = {3, 3};
		Assertions.assertArrayEquals(ans, expect);
		ans = P5.solution2(ints, k);
		Assertions.assertArrayEquals(expect, ans);
	}
}