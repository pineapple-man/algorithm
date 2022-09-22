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
 * @date 2022-05-05 12:39
 */
public class QuickSort {
	public static void sort(int[] arr) {
		process(arr, 0, arr.length - 1);
	}
	
	public static void process(int[] arr, int l, int r) {
		if (l > r) {
			return;
		}
		int pivot = arr[l + (int) (Math.random() * (r - l + 1))];
		int[] ans = partition(arr, l, r, pivot);
		process(arr, l, ans[0] - 1);
		process(arr, ans[1] + 1, r);
	}
	
	public static int[] partition(int[] arr, int left, int right, int pivot) {
		if (left > right) {
			return new int[]{-1, -1};
		}
		if (left == right) {
			return new int[]{left, right};
		}
		int less = left - 1;
		int more = right + 1;
		int index = left;
		while (index < more) {
			if (arr[index] == pivot) {
				index++;
			} else if (arr[index] < pivot) {
				Utils.swap(arr, index++, ++less);
			} else {
				Utils.swap(arr, index, --more);
			}
		}
		return new int[]{less + 1, more - 1};
	}
}
