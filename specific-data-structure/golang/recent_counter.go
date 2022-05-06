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

package golang

type RecentCounter struct {
	window []int
}

func Constructor() RecentCounter {
	return RecentCounter{
		window: []int{},
	}
}

func (c *RecentCounter) Ping(t int) int {
	if len(c.window) == 0 {
		c.window = append(c.window, t)
	} else {
		c.window = append(c.window, t)
		for c.window[0] < t-3000 {
			c.window = c.window[1:]
		}
	}
	return len(c.window)
}
