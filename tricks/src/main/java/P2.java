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
 * @date 2022/9/16 16:03
 */

public class P2 {
	public static int solution(int[][] arr) {
		int[][] rightOneCount = new int[arr.length + 1][arr[0].length + 1];
		int[][] downOneCount = new int[arr.length + 1][arr[0].length + 1];
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[0].length - 2; j >= 0; j--) {
				if (arr[i][j] != 0) {
					rightOneCount[i][j] =
							rightOneCount[i][j + 1] + (arr[i][j + 1] == 1 ?
									1 : 0);
				}
			}
		}
		
		for (int j = arr[0].length - 1; j >= 0; j--) {
			for (int i = arr.length - 2; i >= 0; i--) {
				if (arr[i][j] != 0) {
					downOneCount[i][j] += downOneCount[i + 1][j] + (arr[i + 1][j] == 1 ? 1 : 0);
					
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					int row = rightOneCount[i][j];
					int col = downOneCount[i][j];
					int side = Math.min(row, col);
					if (side > 0 && arr[i + side][j] == 1 && arr[i][j + side] == 1
							&& arr[i + side][j] == 1) {
						ans = Math.max(ans, side);
					}
				}
			}
		}
		return ans + 1;
	}
}
