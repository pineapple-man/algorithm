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

/**
 * 归并排序的实现
 *
 * @author pineapple-man
 * @date 2022-05-05 12:39
 */
public class MergeSort {
	public static int[] sort(int[] arr) {
		if (arr == null || arr.length == 1) {
			return arr;
		}
		mergeSort(arr, 0, arr.length - 1);
		return arr;
	}
	
	private static void mergeSort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = (r - l) / 2 + l;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}
	
	private static void merge(int[] arr, int l, int mid, int r) {
		int[] ans = new int[r - l + 1];
		int left = l;
		int index = 0;
		int leftLength = mid;
		mid++;
		while (l <= leftLength && mid <= r) {
			ans[index++] = arr[l] < arr[mid] ? arr[l++] : arr[mid++];
		}
		while (l <= leftLength) {
			ans[index++] = arr[l++];
		}
		while (mid <= r) {
			ans[index++] = arr[mid++];
		}
		for (int i = 0; i < ans.length; i++) {
			arr[left++] = ans[i];
		}
	}
}
