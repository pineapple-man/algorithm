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

func diStringMatch(s string) []int {
	n := len(s)
	ans := make([]int, n+1)
	index := 0
	left, right := 0, n
	for i := range s {
		if s[i] == 'I' {
			ans[index] = left
			index++
			left++
		} else {
			ans[index] = right
			right--
			index++
		}
	}
	ans[index] = left
	return ans
}
func main() {
	s := "IDID"
	diStringMatch(s)
}
