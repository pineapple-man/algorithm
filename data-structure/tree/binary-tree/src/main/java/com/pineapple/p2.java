package com.pineapple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author pineapple-man
 */
public class p2 {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		if (root == null) {
			return null;
		}
		Map<TreeNode, TreeNode> map = new HashMap<>();
		createParentMap(root, map);
		Deque<TreeNode> deque = new ArrayDeque<>();
		Set<TreeNode> visited = new HashSet<>();
		deque.addLast(target);
		List<Integer> ans = new LinkedList<>();
		int curLevel = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			while (size-- > 0) {
				TreeNode cur = deque.pollFirst();
				if (cur == null || visited.contains(cur)) {
					continue;
				}
				TreeNode parent = map.get(cur);
				if (curLevel == k) {
					ans.add(cur.val);
				}
				if (!visited.contains(cur.left) && cur.left != null) {
					deque.addLast(cur.left);
				}
				if (!visited.contains(cur.right) && cur.right != null) {
					deque.addLast(cur.right);
				}
				if (parent != null && !visited.contains(parent)) {
					deque.addLast(parent);
				}
				visited.add(cur);
				
			}
			curLevel++;
			if (curLevel > k) {
				break;
			}
		}
		return ans;
	}
	
	public void createParentMap(TreeNode current,
	                            Map<TreeNode, TreeNode> map) {
		if (current == null) {
			return;
		}
		if (current.left != null) {
			map.put(current.left, current);
			createParentMap(current.left, map);
		}
		if (current.right != null) {
			map.put(current.right, current);
			createParentMap(current.right, map);
		}
	}
}
