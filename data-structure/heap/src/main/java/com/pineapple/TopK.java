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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/10/19 11:37
 */

public class TopK {
	public static void main(String[] args) {
		String[] strings = {"the", "day", "is", "sunny", "the", "the", "the", "sunny"
				, "is", "is"};
		TopK k = new TopK();
		List<String> list = k.topKFrequent(strings, 2);
		System.out.println(list.toString());
	}
	
	public List<String> topKFrequent(String[] str, int k) {
		PriorityQueue<node> heap =
				new PriorityQueue<>((o1, o2) -> {
					if (o1.times == o2.times) {
						return o1.str.compareTo(o2.str);
					}
					return o2.times - o1.times;
				});
		HashMap<String, Integer> map = new HashMap<>();
		for (String s : str) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			heap.add(new node(entry.getKey(), entry.getValue()));
		}
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(heap.poll().str);
		}
		return ans;
	}
	
	static class node {
		String str;
		int times;
		
		public node(String str, int times) {
			this.str = str;
			this.times = times;
		}
	}
}
