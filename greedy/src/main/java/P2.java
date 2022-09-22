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
 * @date 2022/9/21 14:35
 */

public class P2 {
	/**
	 * 随着左边数组长度的增加，最大值也会随着增加。所以，这个问题转换为：找出一个最大值，
	 * 随后找出左右两个端点的最小值：Math.min(arr[0],arr[N])，结果就是 AllMax -
	 * Math.min(arr[0],arr[N])
	 */
	public static int solution(int[] arr) {
		int max = 0;
		int min = Math.min(arr[0], arr[arr.length - 1]);
		for (int ele : arr) {
			max = Math.max(ele, max);
		}
		return Math.abs(max - min);
	}
}
