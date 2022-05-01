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

import lombok.extern.slf4j.Slf4j;

/**
 * 汉诺塔问题
 *
 * @author pineapple-man
 * @version 1.0
 * @date 2022/4/28 23:42
 */
@Slf4j
public class Hanoi {
	/**
	 * 汉诺塔移动问题，通过调用这个方法能够确定 n 层汉诺塔，从 start 移动到 target 到步骤
	 *
	 * @param n
	 * 		汉诺塔到层数
	 * @param start
	 * 		一开始所有方块所在到位置
	 * @param auxiliary
	 * 		方块从 start 移动到 target 可以使用到辅助位置
	 * @param target
	 * 		方块最终需要到达到位置
	 */
	public static void hanoiMove(int n, String start, String auxiliary,
	                             String target) {
		if (n == 1) {
			log.info(String.format("第 %d 层从 %s 移动到 %s", n, start, target));
			return;
		}
		hanoiMove(n - 1, start, target, auxiliary);
		log.info(String.format("第 %d 层从 %s 移动到 %s ", n, start, target));
		hanoiMove(n - 1, auxiliary, start, target);
	}
}
