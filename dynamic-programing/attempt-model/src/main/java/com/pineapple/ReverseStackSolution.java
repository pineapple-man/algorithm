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

import java.util.Stack;

/**
 * 逆序一个栈
 *
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/1 21:52
 */

public class ReverseStackSolution {
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int bottomElement = getBottomElement(stack);
		reverse(stack);
		stack.push(bottomElement);
	}
	
	/**
	 * 移除当前栈顶元素，并将上面的元素盖下来，返回移除掉的栈底部元素
	 *
	 * @param stack
	 * 		需要进行操作的栈
	 * @return 栈底元素
	 */
	private static int getBottomElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getBottomElement(stack);
			stack.push(result);
			return last;
		}
	}
}
