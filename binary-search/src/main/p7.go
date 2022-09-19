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

func findNumberIn2DArray(matrix [][]int, target int) bool {
	rowLength := len(matrix)
	if rowLength == 0 {
		return false
	}
	colLength := len(matrix[0])
	if colLength == 0 {
		return false
	}
	if target < matrix[0][0] || target > matrix[rowLength-1][colLength-1] {
		return false
	}
	i := 0
	j := colLength - 1
	for i >= 0 && i < rowLength && j < colLength && j >= 0 {
		if matrix[i][j] > target {
			j--
		} else if matrix[i][j] < target {
			i++
		} else {
			return true
		}
	}
	return false
}
func main() {
	arr := [][]int{
		{1, 4, 7, 11, 15},
		{2, 5, 8, 12, 19},
		{3, 6, 9, 16, 22},
		{10, 13, 14, 17, 24},
		{18, 21, 23, 26, 30}}
	target := 5
	findNumberIn2DArray(arr, target)
}
