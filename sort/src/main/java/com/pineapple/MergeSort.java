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
		arr = merge(arr, l, mid, r);
	}
	
	private static int[] merge(int[] arr, int l, int mid, int r) {
		int[] ans = new int[r - l + 1];
		int index = 0;
		int leftLength = mid;
		while (l < leftLength && mid < r) {
			ans[index++] = arr[l] < arr[mid] ? arr[l++] : arr[mid++];
		}
		while (l < leftLength) {
			ans[index++] = arr[l++];
		}
		while (mid < r) {
			ans[index++] = arr[mid++];
		}
		
		return ans;
	}
}
