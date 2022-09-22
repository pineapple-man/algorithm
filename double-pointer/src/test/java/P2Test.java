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

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/21 16:14
 */

class P2Test {
	
	@Test
	void solution() {
		int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 5, 6, 6, 6, 7, 7, 8, 8, 10, 30};
		int aim = 9;
		int[][] ans = P2.solution(arr, aim);
		assert ans != null;
		Arrays.sort(ans, Comparator.comparingInt(o -> o[0]));
		int[][] expect = new int[][]{{1, 8}, {2, 7}, {3, 6}};
		Assertions.assertArrayEquals(expect, ans);
	}
	
	@Test
	void solution2() {
		int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 5, 6, 6, 6, 7, 7, 8, 8, 10, 30};
		int aim = 12;
		int[][] ans = P2.solution2(arr, aim);
		Arrays.sort(ans, Comparator.comparingInt(o -> o[0]));
		int[][] expect = new int[][]{{1, 1, 10}, {1, 3, 8}, {1, 5, 6}, {2, 2, 8}, {2, 3, 7}
				, {3, 3, 6},};
		Assertions.assertArrayEquals(expect, ans);
	}
}