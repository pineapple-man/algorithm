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

import (
	"testing"
)

func TestPing(t *testing.T) {
	tests := []struct {
		args int
		want int
	}{
		{1, 1},
		{100, 2},
		{3001, 3},
		{3002, 3},
	}
	c := RecentCounter{}
	for _, tt := range tests {
		if got := c.Ping(tt.args); got != tt.want {
			t.Errorf("Ping got=%v ,want %v\n", got, tt.want)
		}
	}
}
