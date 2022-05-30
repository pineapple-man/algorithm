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

func sumRootToLeaf(root *TreeNode) int {
	return getSum(root, 0)
}
func getSum(root *TreeNode, pre int) int {
	if root != nil {
		leftSum := getSum(root.Left, pre<<1+root.Val)
		rightSum := getSum(root.Right, pre<<1+root.Val)
		if root.Left == nil && root.Right == nil {
			return root.Val + pre<<1
		}
		return leftSum + rightSum
	}
	return 0
}
