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
 * @date 2022/9/19 16:27
 */

public class MaxPathSumSolutions {
	// 1.1 从头结点开始到叶节点结束，找到最大到路径和
	public static int solution(BinaryTree root) {
		if (root.left == null && root.right == null) {
			return root.value;
		}
		int sum = Integer.MIN_VALUE;
		if (root.left != null) {
			sum = Math.max(sum, solution(root.left));
		}
		if (root.right != null) {
			sum = Math.max(sum, solution(root.right));
		}
		return sum;
	}
	
	//	必须从上面点到下面到点，但是对于开始和结束的点没有定义
	public static int solution2(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		return f(root).allTreeMaxSum;
	}
	
	//	与 x 无关 ： 1） 左树上的最大路径和 2）右树上的最大路径和
//	与 x 有关 ： 3） x 自己 4）从 x 开始向左 5） 从 x 开始向右
	public static Info f(BinaryTree root) {
		if (root == null) {
			return null;
		}
		Info left = f(root.left);
		Info right = f(root.right);
		int p1 = Integer.MIN_VALUE;
		int p2 = Integer.MIN_VALUE;
		int p3 = root.value;
		int p4 = Integer.MIN_VALUE;
		int p5 = Integer.MIN_VALUE;
		if (left != null) {
			p1 = left.allTreeMaxSum;
			p4 = left.fromHeadSum + root.value;
		}
		if (right != null) {
			p2 = right.allTreeMaxSum;
			p5 = right.fromHeadSum + root.value;
		}
		int fromHeadSum = Math.max(
				Math.max(p3, p4),
				p5);
		int allTreeMaxSum = Math.max(
				Math.max(p1, p2),
				fromHeadSum);
		return new Info(allTreeMaxSum, fromHeadSum);
	}
	
	//	从树中的任何一个节点出发到另一个节点的最大路径和（每个节点只可以遍历一次）
	// 和 root  有关:  1） root 自己 2） x 向左边走得到 3）root 向右走得到 4）即往左，也往右
	//	和 root 无关:  4） 左边最大 5） 右边最大
	public static int solution3(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		return g(root).allTreeMaxSum;
	}
	
	public static Info g(BinaryTree root) {
		if (root == null) {
			return null;
		}
		Info left = g(root.left);
		Info right = g(root.right);
		int p1 = root.value;
		int p2 = Integer.MIN_VALUE;
		int p3 = Integer.MIN_VALUE;
		int p4 = Integer.MIN_VALUE;
		int p5 = Integer.MIN_VALUE;
		int p6 = Integer.MIN_VALUE;
		if (left != null) {
			p2 = Math.max(p2, left.fromHeadSum + root.value);
			p5 = Math.max(p5, left.allTreeMaxSum);
		}
		if (right != null) {
			p3 = Math.max(p3, right.fromHeadSum + root.value);
			p6 = Math.max(p6, right.allTreeMaxSum);
		}
		if (left != null && right != null) {
			p4 = Math.max(p4, left.fromHeadSum + root.value + right.fromHeadSum);
		}
		int fromHeadSum = Math.max(
				Math.max(p1, p2), Math.max(p3, p4)
		);
		int allTreeSum = Math.max(Math.max(p5, p6), fromHeadSum);
		return new Info(allTreeSum, fromHeadSum);
	}
	
	public static class Info {
		public int allTreeMaxSum;
		public int fromHeadSum;
		
		public Info(int allTreeMaxSum, int fromHeadSum) {
			this.allTreeMaxSum = allTreeMaxSum;
			this.fromHeadSum = fromHeadSum;
		}
	}
}
