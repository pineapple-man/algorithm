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

func removeOuterParentheses(s string) string {
	var ans []byte
	var temp []byte
	length := 0
	for i := range s {
		if s[i] == '(' {
			length++
		} else if s[i] == ')' {
			length--
		}
		temp = append(temp, s[i])
		if length == 0 {
			temp = temp[1:]
			temp = temp[:len(temp)-1]
			ans = append(ans, temp...)
			temp = temp[:0]
		}
	}
	return string(ans)
}
func main() {
	s := "(()())(())"
	print(removeOuterParentheses(s))
}
