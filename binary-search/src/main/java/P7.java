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
 * @date 2022/9/19 23:10
 */

public class P7 {
	public static boolean solution(int[][] arr, int target) {
		int row = arr.length - 1;
		int col = arr[0].length - 1;
		int i, j;
		i = 0;
		j = col;
		if (row == 0 || col == 0) {
			return false;
		}
		if (target < arr[0][0] || target > arr[row - 1][col - 1]) {
			return false;
		}
		while (i <= row && j <= col) {
			if (target > arr[i][j]) {
				i++;
			} else if (target < arr[i][j]) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}
}
