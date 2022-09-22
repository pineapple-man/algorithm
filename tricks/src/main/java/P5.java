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

import com.pineapple.util.Utils;

import java.util.Arrays;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/22 00:27
 */

public class P5 {
	public static int[] solution(int[] arr, int k) {
		Arrays.sort(arr);
		int[] ans = new int[2];
		int n = arr.length;
		ans[0] = arr[(k - 1) / n];
		int lessThanNumber = 0;
		int equalThanNumber = 0;
		for (int j : arr) {
			if (j < ans[0]) {
				lessThanNumber++;
			} else if (j == ans[0]) {
				equalThanNumber++;
			} else {
				break;
			}
		}
		
		ans[1] = arr[(k - lessThanNumber * n - 1) / equalThanNumber];
		return ans;
	}
	
	/*
	 * 题目本身并不需要排序，需要的仅仅是去寻找第 (k-1)/n 小的数，最简洁的就是使用修改后的快排
	 * 或者 bfprt 算法
	 * */
	public static int[] solution2(int[] arr, int k) {
		int n = arr.length;
		if (n == 0 || k > n * n) {
			return null;
		}
		int[] ans = new int[2];
		ans[0] = getMinKth(arr, (k - 1) / n);
		int lessThanNumber = 0;
		int equalThanNumber = 0;
		for (int j : arr) {
			if (j < ans[0]) {
				lessThanNumber++;
			} else if (j == ans[0]) {
				equalThanNumber++;
			} else {
				break;
			}
		}
		
		ans[1] = getMinKth(arr, (k - lessThanNumber * n - 1) / equalThanNumber);
		return ans;
	}
	
	//	改写快排，时间复杂度O(N)
	//	在无序数组 arr 中找到，如果排序，arr[index]的数是什么？
	public static int getMinKth(int[] arr, int index) {
		int l = 0;
		int r = arr.length - 1;
		int pivot = 0;
		int[] range = null;
		while (l < r) {
			pivot = arr[l + (int) (Math.random() * (r - l + 1))];
			range = partition(arr, l, r, pivot);
			if (index < range[0]) {
				r = range[0] - 1;
			} else if (index > range[1]) {
				l = range[1] + 1;
			} else {
				return pivot;
			}
		}
		return arr[l];
	}
	
	private static int[] partition(int[] arr, int left, int right, int pivot) {
		if (left > right) {
			return new int[]{-1, -1};
		}
		if (left == right) {
			return new int[]{left, right};
		}
		int less = left - 1;
		int more = right + 1;
		int cur = left;
		while (cur < more) {
			if (arr[cur] == pivot) {
				cur++;
			} else if (arr[cur] < pivot) {
				Utils.swap(arr, cur++, ++less);
			} else {
				Utils.swap(arr, cur, --more);
			}
		}
		return new int[]{less + 1, more - 1};
	}
}
