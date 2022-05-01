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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/1 22:32
 */

@Slf4j
class ReverseStackSolutionTest {
	public static Stack<Integer> stack = new Stack<>();
	
	@BeforeAll
	public static void initStack() {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
	}
	
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = f(stack);
		reverse(stack);
		stack.push(i);
	}
	
	public static int f(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = f(stack);
			stack.push(result);
			return last;
		}
	}
	
	@Test
	void reverse() {
		Stack<Integer> stack1 = (Stack<Integer>) stack.clone();
		Stack<Integer> stack2 = (Stack<Integer>) stack.clone();
		reverse(stack1);
		ReverseStackSolution.reverse(stack2);
		Assertions.assertEquals(stack2.size(), stack1.size());
		int length = stack1.size();
		for (int i = 0; i < length; i++) {
			Assertions.assertEquals(stack1.pop(), stack2.pop());
		}
		log.info("test success!");
	}
}