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

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findBottomLeftValue(root *TreeNode) int {
	queue := []*TreeNode{}
	queue = append(queue, root)
	nextRightNode := root
	currentRightNode := root
	res := 0
	for len(queue) > 0 {
		temp := queue[0]
		queue = queue[1:]
		if temp.Right != nil {
			queue = append(queue, temp.Right)
			nextRightNode = temp.Right
		}
		if temp.Left != nil {
			queue = append(queue, temp.Left)
			nextRightNode = temp.Left
		}
		if temp == currentRightNode {
			currentRightNode = nextRightNode
			res = temp.Val
		}
	}
	return res
}
