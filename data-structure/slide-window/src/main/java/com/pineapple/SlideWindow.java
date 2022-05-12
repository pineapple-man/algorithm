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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/4 13:45
 */

public class SlideWindow<T extends Comparator<T>> {
	/**
	 * 双端队列，内部元素遵守从大到小的事实。<br/> 使用双端队列的含义是：如果此时，依次让窗口缩小的话，那些值将会成为窗口内的最大值
	 */
	private final ArrayDeque<Integer> deque;
	private final List<Integer> arr;
	int left;
	int right;
	
	public SlideWindow() {
		deque = new ArrayDeque<>();
		arr = new ArrayList<>();
		left = 0;
		right = 0;
	}
	
	/**
	 * 向窗口中增加一个元素
	 *
	 * @param value
	 * 		增加的元素
	 */
	public void add(Integer value) {
		if (deque.isEmpty()) {
			arr.add(value);
			deque.addLast(arr.size() - 1);
		} else {
			while (true) {
				assert !deque.isEmpty();
				Integer currentLastValue = arr.get(deque.peekLast());
				if (currentLastValue > value) {
					arr.add(value);
					deque.addLast(arr.size() - 1);
					break;
				} else {
					deque.pollLast();
				}
			}
		}
		right++;
	}
	
	/**
	 * 删除当前元素
	 */
	public void pollFirst() {
		assert !deque.isEmpty();
		if (deque.peekFirst() == left) {
			deque.pollFirst();
		}
		left++;
	}
	
	public Integer getMax() {
		assert !deque.isEmpty();
		return arr.get(deque.peek());
	}
	
	
}
