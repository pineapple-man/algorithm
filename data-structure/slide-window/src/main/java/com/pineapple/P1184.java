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
 * @date 2022/7/24 23:02
 */

public class P1184 {
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int first = Math.min(start, destination);
		int second = Math.max(start, destination);
		int clock = 0;
		for (int i = first + 1; i < second; i++) {
			clock += distance[i];
		}
		int reClock = 0;
		for (int i = second + 1; i % distance.length != first; i++) {
			reClock += distance[i % distance.length];
		}
		
		return Math.min(reClock, clock);
	}
}
