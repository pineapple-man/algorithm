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

import com.pineapple.util.Utils;

/**
 * @author pineapple-man
 * @date 2022-05-05 13:09
 */
public class DutchFlagSolution {
	
	/**
	 * 荷兰国旗问题（基础版本）
	 *
	 * @param arr
	 * 		输入数组
	 * @return 划分后的数组
	 */
	public static int[] dutchFlagBasic(int[] arr, int target) {
		int left = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] < target) {
				Utils.swap(arr, left, i);
				left++;
			}
		}
		return arr;
	}
	
	/**
	 * 荷兰国旗进阶版本
	 *
	 * @param arr
	 * 		输入数组
	 * @param target
	 * 		目标数
	 * @return 划分后的数组
	 */
	public static int[] dutchFlagAdvance(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		int n = arr.length;
		int i = 0;
		while (i < right) {
			if (arr[i] < target) {
				Utils.swap(arr, i, left);
				left++;
				i++;
			} else if (arr[i] > target) {
				Utils.swap(arr, i, right);
				right--;
			} else {
				i++;
			}
		}
		return arr;
	}
	
	/**
	 * 荷兰国旗另一种版本，target 默认选择数组的最后一个元素
	 *
	 * @param arr
	 * 		输入数组
	 * @return 划分后的数组
	 */
	public static int[] partition(int[] arr, int l, int r) {
		if (l < 0 || r > arr.length) {
			return null;
		}
		if (l >= r) {
			return arr;
		}
		int less = l - 1;
		int more = r;
		int target = arr[more];
		while (l < more) {
			if (arr[l] < target) {
				Utils.swap(arr, ++less, l++);
			} else if (arr[l] > target) {
				Utils.swap(arr, --more, l);
			} else {
				l++;
			}
		}
		Utils.swap(arr, target, l);
		return arr;
	}
}
