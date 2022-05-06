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
 * @date 2022/5/3 16:08
 */

public class SegmentTree<T> {
	/**
	 * 线段数，0 位置不保存任何数值
	 */
	int maxLength;
	T[] data;
	T[] lazyCache;
	T[] sum;
	T[] change;
	boolean[] update;
	
	public SegmentTree() {
	}
	
	public SegmentTree(T[] data) {
		this.data = data;
		int length = data.length;
		maxLength = length * 4;
	}
	
	void add(int L, int R, int value, int l, int r, int root) {
	
	}
	
	void update(int L, int R, int value, int l, int r, int root) {
	
	}
	
	void query(int L, int R, int root) {
	
	}
}
