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

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/10/21 19:21
 */

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int done = 1;
		int j = 1;
		while (j < nums.length) {
			if (nums[j] != nums[j - 1]) {
				nums[done] = nums[j];
				done++;
			}
			j++;
		}
		return done;
	}
}
