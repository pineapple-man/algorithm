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

import com.pineapple.generator.NumericalGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/19 23:18
 */

class P7Test {
	@Test
	void solution() {
		int rowLength = NumericalGenerator.getRandomPositiveInt(10);
		int colLength = NumericalGenerator.getRandomPositiveInt(10);
		int[][] arr = new int[rowLength][colLength];
		arr[0][0] = NumericalGenerator.getRandomPositiveInt();
		int pre = arr[0][0];
		for (int i = 1; i < colLength; i++) {
			int temp;
			while ((temp = NumericalGenerator.getRandomPositiveInt()) < pre) {
			
			}
			arr[0][i] = temp;
		}
		for (int i = 1; i < rowLength; i++) {
			for (int j = 1; j < colLength; j++) {
				int rowPre = arr[i - 1][j];
				int colPre = arr[i][j - 1];
				int temp;
				while ((temp = NumericalGenerator.getRandomPositiveInt()) < rowPre || (temp < colPre)) {
				
				}
				arr[i][j] = temp;
			}
		}
		
		int element = NumericalGenerator.getRandomInt();
		boolean ans = P7.solution(arr, element);
		Assertions.assertEquals(f(arr, element), ans);
	}
	
	public static boolean f(int[][] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == element) {
					return true;
				}
			}
		}
		return false;
	}
}