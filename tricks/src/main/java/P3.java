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
 * @date 2022/9/21 14:46
 */

public class P3 {
	
	//使用预处理技巧
	public static int solution1(int[] arr) {
		int[] leftToRightMax = new int[arr.length];
		int[] rightToLeftMax = new int[arr.length];
		leftToRightMax[0] = arr[0];
		rightToLeftMax[arr.length - 1] = arr[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			leftToRightMax[i] = Math.max(leftToRightMax[i - 1], arr[i]);
		}
		for (int i = arr.length - 2; i >= 0; i--) {
			rightToLeftMax[i] = Math.max(rightToLeftMax[i + 1], arr[i]);
		}
		int water = 0;
		for (int i = 0; i < arr.length; i++) {
			int threshold = Math.min(leftToRightMax[i], rightToLeftMax[i]);
			water += Math.max(0, threshold - arr[i]);
		}
		return water;
	}
	
	//使用双指针方法
	public static int solution2(int[] arr) {
		int water = 0;
		int left = 1;
		int maxLeft = arr[0];
		int right = arr.length - 2;
		int maxRight = arr[arr.length - 1];
		while (left <= right) {
			if (maxLeft <= maxRight) {
				water += Math.max(0, maxLeft - arr[left]);
				maxLeft = Math.max(maxLeft, arr[left++]);
			} else {
				water += Math.max(0, maxRight - arr[right]);
				maxRight = Math.max(maxRight, arr[right--]);
			}
		}
		return water;
	}
}
