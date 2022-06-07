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
	"testing"
)

func Test_minEatingSpeed(t *testing.T) {
	type args struct {
		piles []int
		h     int
	}
	tests := []struct {
		name    string
		args    args
		wantRes int
	}{
		{name: "1", args: args{piles: []int{312884470}, h: 312884469}, wantRes: 2},
		{name: "2", args: args{piles: []int{3, 6, 7, 11}, h: 8}, wantRes: 4},
		{name: "3", args: args{piles: []int{30, 11, 23, 4, 20}, h: 5}, wantRes: 30},
		{name: "4", args: args{piles: []int{30, 11, 23, 4, 20}, h: 6}, wantRes: 23},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if gotRes := minEatingSpeed(tt.args.piles, tt.args.h); gotRes != tt.wantRes {
				t.Errorf("minEatingSpeed() = %v, want %v", gotRes, tt.wantRes)
			}
		})
	}
}
