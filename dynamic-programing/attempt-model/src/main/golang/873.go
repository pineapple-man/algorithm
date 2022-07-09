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

package main

func lenLongestFibSubseq(arr []int) (ans int) {
	n := len(arr)
	indices := make(map[int]int, n)
	for i, x := range arr {
		indices[x] = i
	}
	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	for i, x := range arr {
		for j := n - 1; j >= 0 && arr[j]*2 > x; j-- {
			if k, ok := indices[x-arr[j]]; ok {
				dp[j][i] = max(dp[k][j]+1, 3)
				ans = max(ans, dp[j][i])
			}
		}
	}
	return
}

func max(a, b int) int {
	if b > a {
		return b
	}
	return a
}
