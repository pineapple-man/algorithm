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

import com.pineapple.generator.ArrayGenerator;
import com.pineapple.generator.NumericalGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.pineapple.util.Utils.swap;

/**
 * @author pineapple-man
 * @date 2022-05-05 13:11
 */
class DutchFlagSolutionTest {
	private static final int EPOCH = NumericalGenerator.getLittleRandomPositiveInt();
	
	public static int[] netherlandsFlag(int[] arr, int L, int R) {
		if (L > R) { // L...R L>R
			return new int[]{-1, -1};
		}
		if (L == R) {
			return new int[]{L, R};
		}
		int less = L - 1; // < 区 右边界
		int more = R; // > 区 左边界
		int index = L;
		while (index < more) { // 当前位置，不能和 >区的左边界撞上
			if (arr[index] == arr[R]) {
				index++;
			} else if (arr[index] < arr[R]) {
				swap(arr, index++, ++less);
			} else { // >
				swap(arr, index, --more);
			}
		}
		swap(arr, more, R); // <[R]   =[R]   >[R]
		return new int[]{less + 1, more};
	}
	
	@Test
	void dutchFlagBasic() {
		for (int i = 0; i < EPOCH; i++) {
			int[] arr = ArrayGenerator.lengthFixed1dIntArray(100);
			int target = NumericalGenerator.getLittleRandomPositiveInt();
			int[] ans = DutchFlagSolution.dutchFlagBasic(arr, target);
			boolean lessAreaPass = false;
			for (int an : ans) {
				if (an < target) {
					Assertions.assertFalse(lessAreaPass);
				} else if (an == target) {
					lessAreaPass = true;
				} else {
					if (!lessAreaPass) {
						lessAreaPass = true;
					}
				}
			}
		}
	}
	
	@Test
	void dutchFlagAdvance() {
		for (int i = 0; i < EPOCH; i++) {
			int[] arr = ArrayGenerator.lengthFixed1dIntArray(20);
			int target = NumericalGenerator.getLittleRandomPositiveInt();
			int[] ans = DutchFlagSolution.dutchFlagAdvance(arr, target);
		}
	}
}