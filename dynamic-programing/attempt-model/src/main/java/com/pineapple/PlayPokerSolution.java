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
 * @author pineapple-man
 * @version 1.0
 * @date 2022/4/30 15:50
 */

public class PlayPokerSolution {
	public static int winScoreChoose(int[] arr, String solution) {
		int ans;
		switch (solution) {
			case "dp":
				ans = DynamicProgramingSolution.winScore(arr);
				break;
			case "ms":
				int[][] fMap = new int[arr.length][arr.length];
				int[][] gMap = new int[arr.length][arr.length];
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						fMap[i][j] = -1;
						gMap[i][j] = -1;
					}
				}
				int a = MemorySearchSolution.f(arr, 0, arr.length - 1, fMap, gMap);
				int b = MemorySearchSolution.g(arr, 0, arr.length - 1, fMap, gMap);
				ans = Math.max(a, b);
				break;
			case "recursive":
				ans = winScore(arr);
				break;
			default:
				ans = -1;
		}
		return ans;
		
	}
	
	/**
	 * 返回最终获胜者的分数
	 *
	 * @param arr
	 * 		纸牌的分数
	 * @return 获胜者的分数
	 */
	public static int winScore(int[] arr) {
		int aScore = ViolenceRecursiveSearchSolution.f(arr, 0, arr.length - 1);
		int bScore = ViolenceRecursiveSearchSolution.g(arr, 0, arr.length - 1);
		return Math.max(aScore, bScore);
		
	}
	
	static class ViolenceRecursiveSearchSolution {
		/**
		 * 先手函数
		 *
		 * @param arr
		 * 		纸牌
		 * @param left
		 * 		拿取纸牌的左边界
		 * @param right
		 * 		拿取纸牌的右边界
		 * @return int 如果玩家先手，能够获取到的的最大分数
		 *
		 * @author pineapple -man
		 * @date 2022 /5/2
		 */
		public static int f(int[] arr, int left, int right) {
			if (left == right) {
				return arr[left];
			}
			//拿最左边的牌，能够最终能够获取的分数
			int p1 = g(arr, left + 1, right) + arr[left];
			//拿最右边的牌，最终能够获取的分数
			int p2 = g(arr, left, right - 1) + arr[right];
			return Math.max(p1, p2);
		}
		
		/**
		 * 后手函数
		 *
		 * @param arr
		 * 		纸牌数组
		 * @param left
		 * 		数组左边界
		 * @param right
		 * 		数组右边界
		 * @return int 后手能够在 left 和 right 上获取的最好数
		 *
		 * @author pineapple-man
		 * @date 2022/4/30
		 */
		public static int g(int[] arr, int left, int right) {
			if (left == right) {
				return 0;
			}
			int p1 = f(arr, left + 1, right);
			int p2 = f(arr, left, right - 1);
			return Math.min(p1, p2);
		}
	}
	
	static class MemorySearchSolution {
		/**
		 * 后手函数
		 *
		 * @param arr
		 * 		纸牌数组
		 * @param left
		 * 		数组左边界
		 * @param right
		 * 		数组右边界
		 * @return int 后手能够在 left 和 right 上获取的最好数
		 *
		 * @author pineapple-man
		 * @date 2022/4/30
		 */
		public static int g(int[] arr, int left, int right, int[][] fMap,
		                    int[][] gMap) {
			if (gMap[left][right] != -1) {
				return gMap[left][right];
			}
			if (left == right) {
				gMap[left][right] = 0;
				return 0;
			}
			int p1 = f(arr, left + 1, right, fMap, gMap);
			int p2 = f(arr, left, right - 1, fMap, gMap);
			gMap[left][right] = Math.min(p1, p2);
			return gMap[left][right];
		}
		
		/**
		 * 先手函数
		 *
		 * @param arr
		 * 		纸牌
		 * @param left
		 * 		拿取纸牌的左边界
		 * @param right
		 * 		拿取纸牌的右边界
		 * @return int 如果玩家先手，能够获取到的的最大分数
		 *
		 * @author pineapple -man
		 * @date 2022 /5/2
		 */
		public static int f(int[] arr, int left, int right, int[][] fMap, int[][] gMap) {
			if (fMap[left][right] != -1) {
				return fMap[left][right];
			}
			if (left == right) {
				fMap[left][right] = arr[left];
				return arr[left];
			}
			//拿最左边的牌，能够最终能够获取的分数
			int p1 = g(arr, left + 1, right, fMap, gMap) + arr[left];
			//拿最右边的牌，最终能够获取的分数
			int p2 = g(arr, left, right - 1, fMap, gMap) + arr[right];
			fMap[left][right] = Math.max(p1, p2);
			return fMap[left][right];
		}
	}
	
	static class DynamicProgramingSolution {
		public static int winScore(int[] arr) {
			int[][] fDp = new int[arr.length][arr.length];
			int[][] gDp = new int[arr.length][arr.length];
			for (int i = 0; i < arr.length; i++) {
				fDp[i][i] = arr[i];
			}
			for (int statCol = 1; statCol < arr.length; statCol++) {
				int l = 0;
				int r = statCol;
				while (r < arr.length) {
					gDp[l][r] = Math.min(fDp[l + 1][r], fDp[l][r - 1]);
					fDp[l][r] = Math.max(arr[l] + gDp[l + 1][r], arr[r] + gDp[l][r - 1]);
					l++;
					r++;
				}
			}
			return Math.max(fDp[0][arr.length - 1], gDp[0][arr.length - 1]);
		}
	}
}
