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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/21 16:13
 */

public class P2 {
	// 三元组之和
	public static int[][] solution2(int[] arr, int aim) {
		List<int[]> list = new ArrayList<>();
		int[][] find = solution(Arrays.copyOfRange(arr, 1, arr.length), aim - arr[0]);
		if (find != null) {
			for (int[] ints : find) {
				list.add(new int[]{arr[0], ints[0], ints[1]});
			}
		}
		int pre = arr[0];
		for (int i = 1; i < arr.length - 2; i++) {
			if (arr[i] == pre) {
				continue;
			}
			find = solution(Arrays.copyOfRange(arr, i + 1, arr.length), aim - arr[i]);
			pre = arr[i];
			if (find != null) {
				for (int[] ints : find) {
					list.add(new int[]{arr[i], ints[0], ints[1]});
				}
			}
		}
		int[][] ans = new int[list.size()][3];
		for (int i = 0; i < ans.length; i++) {
			int[] ints = list.get(i);
			ans[i][0] = ints[0];
			ans[i][1] = ints[1];
			ans[i][2] = ints[2];
		}
		return ans;
	}
	
	//	两数之和
	public static int[][] solution(int[] arr, int aim) {
		if (arr.length == 0) {
			return null;
		}
		List<int[]> ans = new ArrayList<>();
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			if (arr[left] + arr[right] < aim) {
				left++;
			} else if (arr[left] + arr[right] > aim) {
				right--;
			} else {
				ans.add(new int[]{arr[left], arr[right]});
				int current = arr[left];
				while (left < right && arr[left] == current) {
					left++;
				}
			}
		}
		int[][] res = new int[ans.size()][2];
		for (int i = 0; i < res.length; i++) {
			int[] ints = ans.get(i);
			res[i][0] = ints[0];
			res[i][1] = ints[1];
		}
		return res;
	}
}
