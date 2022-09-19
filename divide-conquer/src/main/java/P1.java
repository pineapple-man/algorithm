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
 * @date 2022/9/19 15:31
 */

public class P1 {
	public static int[] solution(int size) {
		if (size == 1) {
			return new int[]{1};
		}
		int halfSize = (size + 1) / 2;
		int[] base = solution(halfSize);
		int[] ans = new int[size];
		int index = 0;
		for (; index < halfSize; index++) {
			ans[index] = base[index] * 2 - 1;
		}
		for (int i = 0; index < size; index++, i++) {
			ans[index] = base[i] * 2;
		}
		return ans;
	}
}
