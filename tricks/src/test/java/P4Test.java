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
 * @date 2022/9/21 15:07
 */

class P4Test {
	
	@Test
	void solution() {
		int[][] heightMap = {
				{3, 3, 3, 3, 3},
				{3, 2, 2, 2, 3},
				{3, 2, 1, 2, 3},
				{3, 2, 2, 2, 3},
				{3, 3, 3, 3, 3}};
		int ans = P4.solution(heightMap);
		Assertions.assertEquals(10, ans);
		heightMap = new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
		ans = P4.solution(heightMap);
		Assertions.assertEquals(4, ans);
	}
	
}