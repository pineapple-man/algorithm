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

import (
	"sort"
)

func findRightInterval(intervals [][]int) []int {
	data := sortedData{}
	for i := range intervals {
		data = append(data, node{data: intervals[i], index: i})
	}
	sort.Sort(data)
	ans := make([]int, len(intervals))
	for _, v := range data {
		endValue := v.data[1]
		ans[v.index] = binarySearch(data, 0, len(intervals)-1, endValue)
	}
	return ans
}

type node struct {
	data  []int
	index int
}
type sortedData []node

func (d sortedData) Len() int {
	return len(d)
}
func (d sortedData) Swap(i, j int) {
	d[i].data, d[j].data = d[j].data, d[i].data
	d[i].index, d[j].index = d[j].index, d[i].index
}
func (d sortedData) Less(i, j int) bool {
	return d[i].data[0] < d[j].data[0]
}
func binarySearch(data sortedData, start, end, value int) int {
	ans := -1
	for start <= end {
		mid := (end-start)/2 + start
		if data[mid].data[0] < value {
			start = mid + 1
		} else {
			ans = data[mid].index
			end = mid - 1
		}
	}
	return ans
}
func main() {
	interval := [][]int{{3, 4}, {2, 3}, {1, 2}}
	rightInterval := findRightInterval(interval)
	println(rightInterval)
}
